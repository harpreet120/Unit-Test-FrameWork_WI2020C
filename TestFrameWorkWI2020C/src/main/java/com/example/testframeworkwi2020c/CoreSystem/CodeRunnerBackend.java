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

    /**
     * Durchsucht eine Jar-Datei nach Klassen und instanziiert diese. Die instanziierten Klassen werden dann in einer Liste zurückgegeben.
     *
     * @param jarFilePath Der Dateipfad zur Jar-Datei.
     * @return Eine Liste von Klassen-Objekt-Paaren.
     * @throws Exception Falls ein Fehler beim Durchsuchen der Jar-Datei oder bei der Instanziierung der Klassen auftritt.
     */
    public static List<Pair<String, Object>> jarTest(String jarFilePath) throws Exception {
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

    /**
     * Lädt Klassen aus einer JAR-Datei und erstellt Instanzen der Klassen.
     * Die Instanzen werden mit dem Klassennamen (ohne Paketnamen) in einer Liste gespeichert.
     *
     * @param jarFilePath                Der Pfad zur JAR-Datei.
     * @param classNameParm              Der Name der Klasse, für die ein spezifischer Konstruktor verwendet werden soll.
     * @param constructorParameterTypes  Die Parametertypen des Konstruktors, falls ein spezifischer Konstruktor verwendet werden soll.
     * @param constructorParameters      Die Parameterwerte des Konstruktors, falls ein spezifischer Konstruktor verwendet werden soll.
     * @return Eine Liste von Paaren, bestehend aus dem Klassennamen (ohne Paketnamen) und der instanziierten Klasse.
     * @throws Exception Wenn ein Fehler beim Laden oder Instanziieren der Klassen auftritt.
     */
    public static List<Pair<String, Object>> jarTest(String jarFilePath, String classNameParm, Class[] constructorParameterTypes, Object[] constructorParameters) throws Exception {
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
                            // Extrahieren des Klassennamens aus dem Dateinamen
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

        // Rückgabe der Liste von Paaren
        return objects;
    }

    /**
     * Ruft eine Methode mit dem angegebenen Namen auf einem Objekt in der Liste von Klassen-Objekt-Paaren auf.
     *
     * @param classObjects  Die Liste von Klassen-Objekt-Paaren.
     * @param className     Der Name der Klasse des Objekts.
     * @param methodName    Der Name der Methode, die aufgerufen werden soll.
     * @param methodArgs    Die Argumente, die der Methode übergeben werden sollen.
     * @param parameterTypes Die Parameter-Typen der Methode.
     * @return Das Ergebnis der aufgerufenen Methode.
     * @throws RuntimeException Falls ein Fehler beim Aufrufen der Methode auftritt.
     */
    public static Object invokeMethodByName(List<Pair<String, Object>> classObjects, String className, String methodName, Object[] methodArgs, Class<?>[] parameterTypes) {
        // Sucht das Objekt mit dem angegebenen Klassennamen in der Liste
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                // Holt die entsprechende Methode basierend auf dem Methodennamen und den Parameter-Typen
                Method method = object.getClass().getMethod(methodName, parameterTypes);

                // Ruft die Methode auf dem Objekt mit den übergebenen Argumenten auf
                return method.invoke(object, methodArgs);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Error invoking method " + methodName + " on object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
        return null;
    }

    /**
     * Ruft eine Methode mit dem angegebenen Namen auf einem Objekt in der Liste von Klassen-Objekt-Paaren auf.
     *
     * @param classObjects Die Liste von Klassen-Objekt-Paaren.
     * @param className    Der Name der Klasse des Objekts.
     * @param methodName   Der Name der Methode, die aufgerufen werden soll.
     * @param methodArgs   Die Argumente, die der Methode übergeben werden sollen.
     * @return Das Ergebnis der aufgerufenen Methode.
     * @throws RuntimeException Falls ein Fehler beim Aufrufen der Methode auftritt.
     */
    public static Object invokeMethodByName(List<Pair<String, Object>> classObjects, String className, String methodName, Object... methodArgs) {
        // Sucht das Objekt mit dem angegebenen Klassennamen in der Liste
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

                // Holt die entsprechende Methode basierend auf dem Methodennamen und den Parameter-Typen
                Method method = object.getClass().getMethod(methodName, parameterTypes);

                // Ruft die Methode auf dem Objekt mit den übergebenen Argumenten auf
                return method.invoke(object, methodArgs);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Error invoking method " + methodName + " on object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
        return null;
    }

    /**
     * Holt den Wert einer Variable aus einem Objekt einer bestimmten Klasse.
     *
     * @param classObjects  Eine Liste von Paaren, bestehend aus dem Klassennamen (ohne Paketnamen) und dem entsprechenden Objekt.
     * @param className     Der Name der Klasse, aus der die Variable geholt werden soll.
     * @param variableName  Der Name der Variable, deren Wert geholt werden soll.
     * @return Der Wert der Variable oder null, wenn das Objekt oder die Variable nicht gefunden wurde.
     * @throws RuntimeException Wenn ein Fehler beim Zugriff auf die Variable auftritt.
     */
    public static Object getVariableValue(List<Pair<String, Object>> classObjects, String className, String variableName) {
        // Sucht das Objekt mit dem angegebenen Klassennamen in der Liste
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                // Holt das Feld (Variable) mit dem angegebenen Namen aus der Klasse
                Field field = object.getClass().getDeclaredField(variableName);
                field.setAccessible(true); // Zugriff auf das private Feld erlauben
                return field.get(object); // Holt den Wert der Variable aus dem Objekt
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Wirft eine RuntimeException, wenn ein Fehler beim Zugriff auf die Variable auftritt
                throw new RuntimeException("Error accessing variable " + variableName + " in object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
        return null;
    }


    /**
     * Setzt den Wert einer Variable in einem Objekt einer bestimmten Klasse.
     *
     * @param classObjects  Eine Liste von Paaren, bestehend aus dem Klassennamen (ohne Paketnamen) und dem entsprechenden Objekt.
     * @param className     Der Name der Klasse, in der die Variable gesetzt werden soll.
     * @param variableName  Der Name der Variable, deren Wert gesetzt werden soll.
     * @param newValue      Der neue Wert, der für die Variable gesetzt werden soll.
     * @throws RuntimeException Wenn ein Fehler beim Setzen des Werts der Variable auftritt.
     */
    public static void setVariableValue(List<Pair<String, Object>> classObjects, String className, String variableName, Object newValue) {
        // Sucht das Objekt mit dem angegebenen Klassennamen in der Liste
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                // Holt das Feld (Variable) mit dem angegebenen Namen aus der Klasse
                Field field = object.getClass().getDeclaredField(variableName);
                field.setAccessible(true); // Zugriff auf das private Feld erlauben
                field.set(object, newValue); // Setzt den Wert der Variable im Objekt auf den neuen Wert
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Wirft eine RuntimeException, wenn ein Fehler beim Setzen des Werts der Variable auftritt
                throw new RuntimeException("Error setting variable " + variableName + " in object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
    }


    /**
     * Gibt das Objekt mit dem angegebenen Klassennamen aus einer Liste von Paaren zurück.
     *
     * @param objectList Die Liste von Paaren, bestehend aus dem Klassennamen (ohne Paketnamen) und dem entsprechenden Objekt.
     * @param className  Der Name der Klasse, nach der gesucht werden soll.
     * @return Das gefundene Objekt mit dem angegebenen Klassennamen oder null, wenn kein passendes Objekt gefunden wurde.
     */
    public static Object getObjectByClassName(List<Pair<String, Object>> objectList, String className) {
        // Durchläuft die Liste von Paaren
        for (Pair<String, Object> pair : objectList) {
            // Überprüft, ob der Klassennamen des Paares mit dem angegebenen Klassennamen übereinstimmt
            if (pair.getKey().equals(className)) {
                return pair.getValue(); // Gibt das entsprechende Objekt zurück
            }
        }
        return null; // Gibt null zurück, wenn kein passendes Objekt gefunden wurde
    }


    /**
     * Wandelt ein Objekt in das angegebene Interface um.
     *
     * @param object                Das Objekt, das umgewandelt werden soll.
     * @param interfaceSimpleName   Der einfache Name des gewünschten Interfaces.
     * @param <T>                   Der Typ des gewünschten Interfaces.
     * @return Das umgewandelte Objekt als das angegebene Interface.
     * @throws IllegalArgumentException Wenn das angegebene Interface im Objekt nicht gefunden wurde.
     */
    public static <T> T castObjectToInterface(Object object, String interfaceSimpleName) {
        // Holt die Klasse des Objekts
        Class<?> objectClass = object.getClass();

        // Durchläuft die Interfaces der Objektklasse
        for (Class<?> interfaceClass : objectClass.getInterfaces()) {
            // Überprüft, ob der einfache Name des Interfaces mit dem angegebenen Namen übereinstimmt
            if (interfaceClass.getSimpleName().equals(interfaceSimpleName)) {
                // Wandelt das Objekt in das gewünschte Interface um
                return (T) interfaceClass.cast(object);
            }
        }

        // Wirft eine Ausnahme, wenn das angegebene Interface im Objekt nicht gefunden wurde
        throw new IllegalArgumentException("Interface not found in the object's interfaces: " + interfaceSimpleName);
    }


    /**
     * Extrahiert alle Interfaces aus einer JAR-Datei.
     *
     * @param jarFile Die JAR-Datei, aus der die Interfaces extrahiert werden sollen.
     * @return Eine Liste aller extrahierten Interfaces.
     * @throws Exception Wenn ein Fehler beim Extrahieren der Interfaces auftritt.
     */
    public static List<Class<?>> extractInterfacesFromJar(File jarFile) throws Exception {
        // Erstellt eine leere Liste, um die extrahierten Interfaces zu speichern
        List<Class<?>> interfaces = new ArrayList<>();

        // Erstellt einen URLClassLoader mit der JAR-Datei im Classpath
        URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()});

        // Iteriert über alle Klassen in der JAR-Datei
        for (String className : getClassNamesFromJar(jarFile)) {
            // Lädt die Klasse zur Laufzeit
            Class<?> loadedClass = classLoader.loadClass(className);

            // Überprüft, ob die Klasse ein Interface ist
            if (loadedClass.isInterface()) {
                interfaces.add(loadedClass);
            }
        }

        // Gibt die Liste der extrahierten Interfaces zurück
        return interfaces;
    }


    /**
     * Sucht ein bestimmtes Interface in einer Liste von Interfaces, die aus einer JAR-Datei extrahiert wurden.
     *
     * @param jarFile              Die JAR-Datei, aus der die Interfaces extrahiert wurden.
     * @param interfaceSimpleName  Der einfache Name des gesuchten Interfaces.
     * @return Das gefundene Interface.
     * @throws Exception Wenn das gesuchte Interface nicht in der Liste gefunden wurde.
     */
    public static Class<?> getInterfaceFromList(File jarFile, String interfaceSimpleName) throws Exception {
        // Extrahiert die Liste der Interfaces aus der JAR-Datei
        List<Class<?>> interfaceList = extractInterfacesFromJar(jarFile);

        // Sucht das gewünschte Interface in der Liste
        for (Class<?> interfaceClass : interfaceList) {
            if (interfaceClass.getSimpleName().equals(interfaceSimpleName)) {
                return interfaceClass;
            }
        }

        // Falls das gesuchte Interface nicht gefunden wurde, wird eine Exception geworfen
        throw new IllegalArgumentException("Interface not found in the list: " + interfaceSimpleName);
    }


    /**
     * Extrahiert die vollqualifizierten Klassennamen aus einer JAR-Datei.
     *
     * @param jarFile Die JAR-Datei, aus der die Klassennamen extrahiert werden sollen.
     * @return Eine Liste der extrahierten Klassennamen.
     * @throws IOException Wenn ein Fehler beim Zugriff auf die JAR-Datei auftritt.
     */
    private static List<String> getClassNamesFromJar(File jarFile) throws IOException {
        // Erstellt eine Liste, um die extrahierten Klassennamen zu speichern
        List<String> classNames = new ArrayList<>();

        // Öffnet die JAR-Datei
        try (JarFile jar = new JarFile(jarFile)) {
            // Durchläuft alle Einträge in der JAR-Datei
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                // Überprüft, ob der Eintrag eine Datei und eine .class-Datei ist
                if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                    // Extrahiert den vollqualifizierten Klassennamen aus dem Eintrag
                    String className = entry.getName().replace('/', '.');
                    className = className.substring(0, className.length() - ".class".length());
                    // Fügt den Klassennamen zur Liste hinzu
                    classNames.add(className);
                }
            }
        }

        // Gibt die Liste der extrahierten Klassennamen zurück
        return classNames;
    }
}
