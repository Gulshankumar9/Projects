package com.example.featureutility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
public class FeatureUtilityApplication {

    public static void main(String[] args) throws Exception {
        // Create a new workbook and sheet
        var workbook = new XSSFWorkbook();
        var sheet = workbook.createSheet("Annotations");

        // Create the header row (match the image exactly)
        var headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Class");
        headerRow.createCell(1).setCellValue("Method");
        headerRow.createCell(2).setCellValue("Class Annotations");
        headerRow.createCell(3).setCellValue("Method Annotations");
        headerRow.createCell(4).setCellValue("Annotation Details (Class)");
        headerRow.createCell(5).setCellValue("Annotation Details (Method)");
        headerRow.createCell(6).setCellValue("Parameters");
        headerRow.createCell(7).setCellValue("Parameter Annotations");
        headerRow.createCell(8).setCellValue("Return Type");

        // Load the class
        var cls = Class.forName("com.example.featureutility.controller");

        // Get class annotations
        var classAnnotations = cls.getAnnotations();
        int rowNum = 1;
        for (var method : cls.getDeclaredMethods()) {
            var row = sheet.createRow(rowNum++);

            // Class Name
            row.createCell(0).setCellValue(cls.getSimpleName());

            // Method Name
            row.createCell(1).setCellValue(method.getName());

            // Class Annotations
            var classAnnoBuilder = Arrays.stream(classAnnotations)
                                         .map(annotation -> annotation.annotationType().getSimpleName())
                                         .collect(Collectors.joining(" "));
            row.createCell(2).setCellValue(classAnnoBuilder);

            // Method Annotations
            var methodAnnoBuilder = Arrays.stream(method.getAnnotations())
                                          .map(annotation -> annotation.annotationType().getSimpleName())
                                          .collect(Collectors.joining(" "));
            row.createCell(3).setCellValue(methodAnnoBuilder);

            // Class Annotation Details
            var classAnnoDetailsBuilder = Arrays.stream(classAnnotations).flatMap(annotation -> Arrays
                    .stream(annotation.annotationType().getDeclaredMethods()).map(m -> {
                        Object value;
                        try {
                            value = m.invoke(annotation);
                        } catch (Exception e) {
                            value = "N/A"; // Handle potential exceptions during invocation
                        }
                        return m.getName() + ": " + value;
                    })).collect(Collectors.joining(", "));
            row.createCell(4).setCellValue(classAnnoDetailsBuilder);

            // Method Annotation Details
            var methodAnnoDetailsBuilder = Arrays.stream(method.getAnnotations()).flatMap(annotation -> Arrays
                    .stream(annotation.annotationType().getDeclaredMethods()).map(m -> {
                        Object value;
                        try {
                            value = m.invoke(annotation);
                        } catch (Exception e) {
                            value = "N/A"; // Handle potential exceptions during invocation
                        }
                        return m.getName() + ": " + value;
                    })).collect(Collectors.joining(", "));
            row.createCell(5).setCellValue(methodAnnoDetailsBuilder);

            // Get parameters
            var paramBuilder = Arrays.stream(method.getParameters()).map(Parameter::getType).map(Class::getSimpleName)
                                     .collect(Collectors.joining(" "));
            row.createCell(6).setCellValue(paramBuilder);

            // Get parameter annotations
            var paramAnnoBuilder = Arrays.stream(method.getParameterAnnotations()).map(Arrays::toString)
                                         .collect(Collectors.joining(" ")).replaceAll("[\\[\\]]", "")
                                         .replaceAll(",", " "); // Combine annotations for each parameter
            row.createCell(7).setCellValue(paramAnnoBuilder);
        }

        // Write the output to a file
        try (var fileOut = new FileOutputStream("annotations.xlsx")) {
            workbook.write(fileOut);
        }

        workbook.close();
    }
}