package com.example.testframeworkwi2020c;

import javafx.util.Pair;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
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
                            // Hinzufügen des Klassennamens und der Instanz zur Liste
                            objects.add(new Pair<>(className, instance));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }

        return objects;
    }

}
