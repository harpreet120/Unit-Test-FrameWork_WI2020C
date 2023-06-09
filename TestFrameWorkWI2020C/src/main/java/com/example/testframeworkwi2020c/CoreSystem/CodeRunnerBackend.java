package com.example.testframeworkwi2020c.CoreSystem;

import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CodeRunnerBackend {

    public static List<Pair<String, Object>> jarTest(String jarFilePath) throws Exception {
        List<Pair<String, Object>> objects = new ArrayList<>();

        // Laden der Jar-Datei
        try (JarFile jarFile = new JarFile(jarFilePath)) {
            // Erstellen eines URLClassLoaders mit der Jar-Datei
            URL[] urls = {new URL("jar:file:" + jarFilePath + "!/")};
            ClassLoader classLoader = URLClassLoader.newInstance(urls);
            // Durchsuchen aller Klassen in der Jar-Datei
            jarFile.stream()
                    .filter(entry -> entry.getName().endsWith(".class"))
                    .forEach(entry -> {
                        try {
                            String className = entry.getName().replace("/", ".").replace(".class", "");
                            // Laden der Klasse
                            Class<?> clazz = classLoader.loadClass(className);
                            // Überprüfen, ob die Klasse abstrakt ist
                            if (java.lang.reflect.Modifier.isAbstract(clazz.getModifiers())) {
                                System.out.println("Die Klasse " + className + " ist abstrakt und kann nicht instanziiert werden.");
                                return;
                            }
                            // Erstellen einer Instanz der Klasse
                            Object instance = clazz.getDeclaredConstructor().newInstance();
                            // Hinzufügen des Klassennamens (ohne Paketnamen) und der Instanz zur Liste
                            String simpleClassName = clazz.getSimpleName();
                            objects.add(new Pair<>(simpleClassName, instance));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }

        return objects;
    }

    public static List<Pair<String, Object>> jarTest(String jarFilePath,String classNameParm, Class[] constructorParameterTypes, Object[] constructorParameters) throws Exception {
        // Erstellt eine Liste, um die Objekte zu speichern, die in der Jar-Datei gefunden wurden.
        List<Pair<String, Object>> objects = new ArrayList<>();

        // Laden der Jar-Datei
        try (JarFile jarFile = new JarFile(jarFilePath)) {
            // Erstellen eines URLClassLoaders mit der Jar-Datei
            URL[] urls = {new URL("jar:file:" + jarFilePath + "!/")};
            ClassLoader classLoader = URLClassLoader.newInstance(urls);
            // Durchsuchen aller Klassen in der Jar-Datei
            jarFile.stream()
                    .filter(entry -> entry.getName().endsWith(".class"))
                    .forEach(entry -> {
                        try {
                            String className = entry.getName().replace("/", ".").replace(".class", "");
                            // Laden der Klasse
                            Class<?> clazz = classLoader.loadClass(className);
                            // Überprüfen, ob die Klasse abstrakt ist
                            if (java.lang.reflect.Modifier.isAbstract(clazz.getModifiers())) {
                                System.out.println("Die Klasse " + className + " ist abstrakt und kann nicht instanziiert werden.");
                                return;
                            }
                            // Überprüfen, ob der Konstruktor Parameter hat
                            if (classNameParm.equals(className)) {
                                // Laden des Konstruktors mit den angegebenen Parametertypen
                                Constructor<?> constructor = clazz.getDeclaredConstructor(constructorParameterTypes);
                                constructor.setAccessible(true);
                                // Erstellen einer Instanz der Klasse mit den angegebenen Parametern
                                Object instance = constructor.newInstance(constructorParameters);
                                // Hinzufügen des Klassennamens (ohne Paketnamen) und der Instanz zur Liste
                                String simpleClassName = clazz.getSimpleName();
                                objects.add(new Pair<>(simpleClassName, instance));
                            } else {
                                // Erstellen einer Instanz der Klasse ohne Parameter
                                Object instance = clazz.getDeclaredConstructor().newInstance();
                                // Hinzufügen des Klassennamens (ohne Paketnamen) und der Instanz zur Liste
                                String simpleClassName = clazz.getSimpleName();
                                objects.add(new Pair<>(simpleClassName, instance));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }

        return objects;
    }

    public static Object invokeMethodByName(List<Pair<String, Object>> classObjects, String className, String methodName, Object[] methodArgs, Class<?>[] parameterTypes) {
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                // Hole die entsprechende Methode basierend auf dem Methodennamen und den Parameter-Typen
                Method method = object.getClass().getMethod(methodName, parameterTypes);

                // Rufe die Methode auf dem Objekt mit den übergebenen Argumenten auf
                return method.invoke(object, methodArgs);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Error invoking method " + methodName + " on object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
        return null;
    }

    public static Object invokeMethodByName(List<Pair<String, Object>> classObjects, String className, String methodName, Object... methodArgs) {
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                Class<?>[] parameterTypes = null;
                if (methodArgs != null) {
                    parameterTypes = new Class<?>[methodArgs.length];
                    for (int i = 0; i < methodArgs.length; i++) {
                        parameterTypes[i] = methodArgs[i].getClass();
                    }
                }

                // Hole die entsprechende Methode basierend auf dem Methodennamen und den Parameter-Typen
                Method method = object.getClass().getMethod(methodName, parameterTypes);

                // Rufe die Methode auf dem Objekt mit den übergebenen Argumenten auf
                return method.invoke(object, methodArgs);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Error invoking method " + methodName + " on object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
        return null;
    }

    public static Object getVariableValue(List<Pair<String, Object>> classObjects, String className, String variableName) {
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                Field field = object.getClass().getDeclaredField(variableName);
                field.setAccessible(true);
                return field.get(object);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error accessing variable " + variableName + " in object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
        return null;
    }

    public static void setVariableValue(List<Pair<String, Object>> classObjects, String className, String variableName, Object newValue) {
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                Field field = object.getClass().getDeclaredField(variableName);
                field.setAccessible(true);
                field.set(object, newValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error setting variable " + variableName + " in object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
    }

    public static Object getObjectByClassName(List<Pair<String, Object>> objectList, String className) {
        for (Pair<String, Object> pair : objectList) {
            if (pair.getKey().equals(className)) {
                return pair.getValue();
            }
        }
        return null; // Objekt mit dem angegebenen Klassennamen wurde nicht gefunden
    }

    public static <T> T castObjectToInterface(Object object, String interfaceSimpleName) {
        Class<?> objectClass = object.getClass();
        for (Class<?> interfaceClass : objectClass.getInterfaces()) {
            if (interfaceClass.getSimpleName().equals(interfaceSimpleName)) {
                return (T) interfaceClass.cast(object);
            }
        }
        throw new IllegalArgumentException("Interface not found in the object's interfaces: " + interfaceSimpleName);
    }

    public static List<Class<?>> extractInterfacesFromJar(File jarFile) throws Exception {
        List<Class<?>> interfaces = new ArrayList<>();

        // Erstelle einen URLClassLoader mit der JAR-Datei im Classpath
        URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()});

        // Iteriere über alle Klassen im JAR-Datei
        for (String className : getClassNamesFromJar(jarFile)) {
            // Lade die Klasse zur Laufzeit
            Class<?> loadedClass = classLoader.loadClass(className);

            // Überprüfe, ob die Klasse ein Interface ist
            if (loadedClass.isInterface()) {
                interfaces.add(loadedClass);
            }
        }

        return interfaces;
    }

    public static Class<?> getInterfaceFromList(File jarFile, String interfaceSimpleName) throws Exception {
        List<Class<?>> interfaceList = extractInterfacesFromJar(jarFile);
        for (Class<?> interfaceClass : interfaceList) {
            if (interfaceClass.getSimpleName().equals(interfaceSimpleName)) {
                return interfaceClass;
            }
        }
        throw new IllegalArgumentException("Interface not found in the list: " + interfaceSimpleName);
    }

    private static List<String> getClassNamesFromJar(File jarFile) throws IOException, IOException {
        List<String> classNames = new ArrayList<>();

        try (JarFile jar = new JarFile(jarFile)) {
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                    String className = entry.getName().replace('/', '.');
                    className = className.substring(0, className.length() - ".class".length());
                    classNames.add(className);
                }
            }
        }

        return classNames;
    }


}
