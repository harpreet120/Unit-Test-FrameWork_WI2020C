package com.example.testframeworkwi2020c;

import org.codehaus.janino.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class DynamicMethodInvocationExample {
    public static void main(String[] args) {
        String zipFilePath = "C:\\Users\\harpr\\Documents\\Dokumente DHBW\\TestRechner\\newsrc.zip";
        String javaFilePath = "C:\\Users\\harpr\\Documents\\Dokumente DHBW\\TestRechner\\newsrc.zip\\TestAmberImplet.Java";
        String className = "TestAmberImplet";
        String methodName = "add";

        try {
            Object instance = createInstanceFromZipJavaFile(zipFilePath, javaFilePath, className);

            if (instance != null) {
                // Aufruf der Methode mit Parametern
                Object result = invokeMethod(instance, methodName, 1, 1);

                // Nutzen des Rückgabewerts
                if (result != null) {
                    System.out.println("Ergebnis: " + result);
                }
            } else {
                System.out.println("Die Klasse wurde nicht in der ZIP-Datei gefunden.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object createInstanceFromZipJavaFile(String zipFilePath, String javaFilePath, String className) throws Exception {
        try (ZipFile zipFile = new ZipFile(zipFilePath)) {
            javaFilePath = className.replace(".", "/") + ".java";
            ZipEntry entry = zipFile.getEntry(javaFilePath);
            if (entry != null) {
                try (InputStream inputStream = zipFile.getInputStream(entry);
                     ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] javaBytes = outputStream.toByteArray();

                    // Kompilieren des Java-Quellcodes
                    Class<?> compiledClass = compileJavaClass(className, javaBytes);

                    // Instanziierung der Klasse
                    return compiledClass.newInstance();
                }
            }
        }

        return null; // Klasse nicht gefunden
    }

    public static Class<?> compileJavaClass(String className, byte[] javaBytes) throws Exception {
        SimpleCompiler compiler = new SimpleCompiler();
        compiler.cook(new ByteArrayInputStream(javaBytes));
        return compiler.getClassLoader().loadClass(className);
    }

    public static Object invokeMethod(Object instance, String methodName, Object... arguments) throws Exception {
        Class<?> clazz = instance.getClass();
        Class<?>[] parameterTypes = new Class<?>[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            parameterTypes[i] = arguments[i].getClass();
        }

        Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true); // Zugriff auf private Methoden erlauben

        // Aufruf der Methode auf der Instanz
        return method.invoke(instance, arguments);
    }
}
