package com.example.testframeworkwi2020c;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class CodeRunner {

    public static void main(String[] args) {
        String zipFilePath = "C:\\Users\\alisi\\Documents\\Paul\\Uebungen_Java\\X-I_unfair_dice\\Loesungen\\wuerfel2.zip";

        try (ZipFile zipFile = new ZipFile(zipFilePath)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            List<ZipEntry> javaEntries = new ArrayList<>();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (!entry.isDirectory() && entry.getName().endsWith(".java")) {
                    javaEntries.add(entry);
                }
            }

            // Sortieren der Einträge nach Dateinamen
            javaEntries.sort(Comparator.comparing(ZipEntry::getName));

            // Verarbeiten der Interfaces zuerst
            for (ZipEntry entry : javaEntries) {
                if (entry.getName().startsWith("I")) {
                    String interfaceCode = readJavaFile(zipFile, entry);

                    // Verarbeiten der Klassen mit dem Interface-Code
                    for (ZipEntry classEntry : javaEntries) {
                        if (!classEntry.getName().startsWith("I")) {
                            String classCode = readJavaFile(zipFile, classEntry);
                            compileAndRunCode(classCode, interfaceCode);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readJavaFile(ZipFile zipFile, ZipEntry entry) throws IOException {
        InputStream inputStream = zipFile.getInputStream(entry);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }

        reader.close();
        return stringBuilder.toString();
    }

    private static void compileAndRunCode(String classCode, String interfaceCode) throws IOException {
        // Extrahieren des Klassennamens aus dem Code
        String className = extractClassName(classCode);

        // Temporäres Verzeichnis für die .java-Dateien
        String tempDir = System.getProperty("java.io.tmpdir");

        // Temporäre .java-Datei erstellen
        File tempFile = new File(tempDir, className + ".java");

        // Code in die temporäre Datei schreiben
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.print(interfaceCode);
            writer.print(classCode);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Compiler-Tool abrufen
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // Kompilieren des Codes mit dem richtigen Klassennamen
        int compilationResult = compiler.run(null, null, null, "-d", tempFile.getParent(), tempFile.getPath());
        if (compilationResult == 0) {
            // Erfolgreiche Kompilierung

            // Klassen-URL hinzufügen, um die Klassen zur Laufzeit zu laden
            try (URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{tempFile.getParentFile().toURI().toURL()})) {

                try {
                    // Klasse dynamisch laden
                    Class<?> loadedClass = classLoader.loadClass(className);

                    // Beispiel: Instanz der Klasse erstellen und eine Methode aufrufen
                    Object instance = loadedClass.getDeclaredConstructor().newInstance();
                    loadedClass.getMethod("rollDice").invoke(instance);
                    System.out.println(loadedClass.getMethod("getScore").invoke(instance));


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Kompilierung fehlgeschlagen
            System.out.println("Kompilierung fehlgeschlagen!");
        }
    }



    private static String extractClassName(String code) {
        String className = null;
        Pattern classPattern = Pattern.compile("class\\s+(\\w+)");
        Pattern interfacePattern = Pattern.compile("interface\\s+(\\w+)");

        Matcher classMatcher = classPattern.matcher(code);
        Matcher interfaceMatcher = interfacePattern.matcher(code);

        if (classMatcher.find()) {
            className = classMatcher.group(1);
        } else if (interfaceMatcher.find()) {
            className = interfaceMatcher.group(1);
        }

        return className;
    }

}

