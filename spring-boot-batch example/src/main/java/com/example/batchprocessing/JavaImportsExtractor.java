package com.example.batchprocessing;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
public class JavaImportsExtractor {

    public static void main(String[] args) {
        // Specify the directory containing all Maven modules
        String modulesDirectory = "C:/Users/Gulshan/Desktop/work";

        // Specify the output Excel file
        String excelFile = "java_imports_output_java.xlsx";

        try {
            extractJavaImports(modulesDirectory, excelFile);
            System.out.println("Data extraction completed. Excel file created: " + excelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractJavaImports(String modulesDirectory, String excelFile) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Java Imports");

        // Write header to the Excel sheet
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Module");
        headerRow.createCell(1).setCellValue("Class Name");
        headerRow.createCell(2).setCellValue("Import");

        // Walk through each module in the specified directory
        Files.walk(Paths.get(modulesDirectory))
                .filter(Files::isDirectory)
                .forEach(modulePath -> processModule(modulePath.toFile(), sheet));

        // Save the Excel workbook
        try (FileOutputStream fileOut = new FileOutputStream(excelFile)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    */
/*private static void processModule(File modulePath, Sheet sheet) {
        // Walk through each Java file in the module
        try {
            Files.walk(Paths.get(modulePath.getPath(), "src/main/java"))
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(filePath -> processJavaFile(modulePath.getName(), filePath.toFile(), sheet));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*//*


    private static void processModule(File modulePath, Sheet sheet) {
        // Construct the path to src/main/java
        Path srcMainJavaPath = Paths.get(modulePath.getPath(), "src/main/java");

        // Check if the src/main/java directory exists
        if (Files.exists(srcMainJavaPath) && Files.isDirectory(srcMainJavaPath)) {
            // Walk through each Java file in the module
            try {
                Files.walk(srcMainJavaPath)
                        .filter(p -> p.toString().endsWith(".java"))
                        .forEach(filePath -> processJavaFile(modulePath.getName(), filePath.toFile(), sheet));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void processJavaFile(String moduleName, File file, Sheet sheet) {
        try {
            String content = new String(Files.readAllBytes(file.toPath()));

            // Extract package and class name
            Pattern packagePattern = Pattern.compile("package (.*?);");
            Matcher packageMatcher = packagePattern.matcher(content);

            Pattern classPattern = Pattern.compile("class (\\w+)");
            Matcher classMatcher = classPattern.matcher(content);

            if (packageMatcher.find() && classMatcher.find()) {
                String packageName = packageMatcher.group(1);
                String className = classMatcher.group(1);

                // Extract and write imports to the Excel sheet
                Pattern importPattern = Pattern.compile("import javax\\..*?;");
                Matcher importMatcher = importPattern.matcher(content);

                while (importMatcher.find()) {
                    String importStatement = importMatcher.group();
                    Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
                    row.createCell(0).setCellValue(moduleName);
                    row.createCell(1).setCellValue(packageName + "." + className);
                    row.createCell(2).setCellValue(importStatement);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/



/*
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
public class JavaImportsExtractor {

    public static void main(String[] args) {
        // Specify the directory containing all Maven modules
        String modulesDirectory = "C:/Users/Gulshan/Desktop/work";

        // Specify the output Excel file
        String excelFile = "java_imports_output_java.xlsx";

        try {
            extractJavaImports(modulesDirectory, excelFile);
            System.out.println("Data extraction completed. Excel file created: " + excelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractJavaImports(String modulesDirectory, String excelFile) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Java Imports");

        // Write header to the Excel sheet
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Module");
        headerRow.createCell(1).setCellValue("Class Name");
        headerRow.createCell(2).setCellValue("Import");
        headerRow.createCell(3).setCellValue("Dependency");

        // Walk through each module in the specified directory
        Files.walk(Paths.get(modulesDirectory))
                .filter(Files::isDirectory)
                .forEach(modulePath -> processModule(modulePath.toFile(), sheet));

        // Save the Excel workbook
        try (FileOutputStream fileOut = new FileOutputStream(excelFile)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    private static void processModule(File modulePath, Sheet sheet) {
        // Construct the path to src/main/java
        Path srcMainJavaPath = Paths.get(modulePath.getPath(), "src/main/java");

        // Check if the src/main/java directory exists
        if (Files.exists(srcMainJavaPath) && Files.isDirectory(srcMainJavaPath)) {
            // Walk through each file in src/main/java and its subdirectories
            try {
                Files.walk(srcMainJavaPath, FileVisitOption.FOLLOW_LINKS)
                        .filter(p -> p.toString().endsWith(".java"))
                        .forEach(filePath -> processJavaFile(modulePath, filePath.toFile(), sheet));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void processJavaFile(File modulePath, File file, Sheet sheet) {
        try {
            String content = new String(Files.readAllBytes(file.toPath()));

            // Extract package and class name
            Pattern packagePattern = Pattern.compile("package (.*?);");
            Matcher packageMatcher = packagePattern.matcher(content);

            Pattern classPattern = Pattern.compile("class (\\w+)");
            Matcher classMatcher = classPattern.matcher(content);

            if (packageMatcher.find() && classMatcher.find()) {
                String packageName = packageMatcher.group(1);
                String className = classMatcher.group(1);

                // Extract and write imports to the Excel sheet
                Pattern importPattern = Pattern.compile("import javax\\..*?;");
                Matcher importMatcher = importPattern.matcher(content);

                while (importMatcher.find()) {
                    String importStatement = importMatcher.group();
                    String dependency = extractMavenDependency(modulePath, modulePath.getName(), file.getName());

                    Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
                    row.createCell(0).setCellValue(modulePath.getName());
                    row.createCell(1).setCellValue(packageName + "." + className);
                    row.createCell(2).setCellValue(importStatement);
                    row.createCell(3).setCellValue(dependency);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractMavenDependency(File modulePath, String moduleName, String fileName) {
        try {
            // Extract the group ID and artifact ID from the pom.xml file
            File pomFile = new File(modulePath, "pom.xml");

            if (pomFile.exists()) {
                String pomContent = new String(Files.readAllBytes(pomFile.toPath()), StandardCharsets.UTF_8);
                Pattern dependencyPattern = Pattern.compile("<dependency>\\s*<groupId>(.*?)</groupId>\\s*<artifactId>(.*?)</artifactId>\\s*</dependency>");
                Matcher matcher = dependencyPattern.matcher(pomContent);

                while (matcher.find()) {
                    String groupId = matcher.group(1);
                    String artifactId = matcher.group(2);
                    return groupId + ":" + artifactId;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Dependency not found";
    }
}*/


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FilenameUtils;
public class JavaImportsExtractor {

    public static void main(String[] args) {
        // Specify the directory containing all Maven modules
        String modulesDirectory = "C:/Users/Gulshan/Desktop/work";

        // Specify the output Excel file
        String excelFile = "java_imports_output.xlsx";

        try {
            extractJavaImports(modulesDirectory, excelFile);
            System.out.println("Data extraction completed. Excel file created: " + excelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractJavaImports(String modulesDirectory, String excelFile) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Java Imports");

        // Write header to the Excel sheet
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Module");
        headerRow.createCell(1).setCellValue("Class Name");
        headerRow.createCell(2).setCellValue("Import");
        headerRow.createCell(3).setCellValue("Dependency");

        // Walk through each module in the specified directory
        Files.walk(Paths.get(modulesDirectory))
                .filter(Files::isDirectory)
                .forEach(modulePath -> processModule(modulePath.toFile(), sheet));

        // Save the Excel workbook
        try (FileOutputStream fileOut = new FileOutputStream(excelFile)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    private static void processModule(File modulePath, Sheet sheet) {
        // Construct the path to src/main/java
        Path srcMainJavaPath = Paths.get(modulePath.getPath(), "src/main/java");

        // Check if the src/main/java directory exists
        if (Files.exists(srcMainJavaPath) && Files.isDirectory(srcMainJavaPath)) {
            // Walk through each file in src/main/java and its subdirectories
            try {
                Files.walk(srcMainJavaPath)
                        .filter(p -> p.toString().endsWith(".java"))
                        .forEach(filePath -> processJavaFile(modulePath.getName(), filePath.toFile(), sheet));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void processJavaFile(String moduleName, File file, Sheet sheet) {
        try {
            String content = new String(Files.readAllBytes(file.toPath()));

            // Extract package and class name
            Pattern packagePattern = Pattern.compile("package (.*?);");
            Matcher packageMatcher = packagePattern.matcher(content);

            Pattern classPattern = Pattern.compile("class (\\w+)");
            Matcher classMatcher = classPattern.matcher(content);

            if (packageMatcher.find() && classMatcher.find()) {
                String packageName = packageMatcher.group(1);
                String className = classMatcher.group(1);

                // Extract and write imports to the Excel sheet
                Pattern importPattern = Pattern.compile("import javax\\..*?;");
                Matcher importMatcher = importPattern.matcher(content);

                while (importMatcher.find()) {
                    String importStatement = importMatcher.group();

                    // Resolve Maven dependency path
                    String dependencyPath = resolveMavenDependencyPath(importStatement);

                    Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
                    row.createCell(0).setCellValue(moduleName);
                    row.createCell(1).setCellValue(packageName + "." + className);
                    row.createCell(2).setCellValue(importStatement);
                    row.createCell(3).setCellValue(dependencyPath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String resolveMavenDependencyPath(String importStatement) {

            // Extract the artifactId from the import statement
            String artifactId = importStatement.split("\\.")[2].replaceAll(";$", "");

            try {
                Process process = new ProcessBuilder("C:\\Users\\Gulshan\\Downloads\\apache-maven-3.8.6-bin\\apache-maven-3.8.6\\bin\\mvn.cmd", "dependency:resolve", "-Dartifact=" + artifactId).directory(new File(System.getProperty("user.dir"))).redirectErrorStream(true).start();

                // Print Maven output
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                process.waitFor();

                // Read the output of the Maven process
                String[] outputLines = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8).split("\\n");

                // Check if there is at least one line in the output
                if (outputLines.length > 1) {
                    // Extract the path from the output
                    String path = outputLines[1].trim();

                    // Remove the leading "Resolved" and normalize the path
                    path = path.replace("Resolved", "").trim();

                    // If it's a JAR file, convert it to an absolute path
                    if (FilenameUtils.getExtension(path).equalsIgnoreCase("jar")) {
                        path = new File(path).getAbsolutePath();
                    }

                    return path;
                } else {
                    // Handle the case where there is no output or the expected information is not present
                    System.err.println("Error: Maven output does not contain the expected information.");
                    return "Error resolving dependency path";
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return "Error resolving dependency path";
            }
        }
}