package com.example.testframeworkwi2020c;

import org.codehaus.janino.SimpleCompiler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DynamicClassLoader {
    public static Object invokeMethodWithParamsFromZipJavaFile(
            String zipFilePath, String javaFilePath, String className,
            String methodName, Class<?>[] parameterTypes, Object[] arguments) throws Exception {
        try (ZipFile zipFile = new ZipFile(zipFilePath)) {
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

                    // Erstellen einer Instanz der Klasse
                    Object instance = createInstance(compiledClass);

                    // Aufruf der Methode mit Parametern und Rückgabe des Ergebnisses
                    return invokeMethod(instance, compiledClass, methodName, parameterTypes, arguments);
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

    public static Object createInstance(Class<?> clazz) throws Exception {
        if (clazz != null) {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException e) {
                // Übergeordnete Klasse oder Interface instanziieren
                Class<?>[] interfaces = clazz.getInterfaces();
                if (interfaces.length > 0) {
                    return createInstance(interfaces[0]);
                } else {
                    Class<?> superclass = clazz.getSuperclass();
                    if (superclass != null) {
                        return createInstance(superclass);
                    }
                }
            }
        }
        return null;
    }

    public static Object invokeMethod(
            Object instance, Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] arguments) throws Exception {
        Method method = findMethodInClassHierarchy(clazz, methodName, parameterTypes);
        if (method != null) {
            return method.invoke(instance, arguments);
        } else {
            throw new NoSuchMethodException("Die Methode wurde nicht in der Klassenhierarchie gefunden.");
        }
    }

    public static Method findMethodInClassHierarchy(Class<?> clazz, String methodName, Class<?>[] parameterTypes) {
        try {
            return clazz.getDeclaredMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null) {
                return findMethodInClassHierarchy(superclass, methodName, parameterTypes);
            }
        }
        return null;
    }
}
