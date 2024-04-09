package com.example.batchprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MavenDependencyMapper {

    public Map<String, String> mapImportsToDependencies(String javaImports) {
        // Execute Maven command to retrieve dependency tree
        String mavenOutput = executeMavenCommand();

        // Parse Maven output and map imports to dependencies
        return parseMavenOutput(mavenOutput, javaImports);
    }

    private String executeMavenCommand() {
        // Construct Maven command to retrieve dependency tree
        String mavenCommand = "mvn dependency:tree";

        try {
            // Execute Maven command
            Process process = new ProcessBuilder("cmd", "/c", mavenCommand).start();

            // Capture Maven output
            return captureMavenOutput(process);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error executing Maven command.";
        }
    }

    private String captureMavenOutput(Process process) throws IOException {
        // Read output stream of the process
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                // Append each line to the output
                output.append(line).append(System.lineSeparator());
            }
            return output.toString();
        }
    }

    private Map<String, String> parseMavenOutput(String mavenOutput, String javaImports) {
        Map<String, String> importToDependencyMap = new HashMap<>();

        // Split Maven output into lines
        String[] lines = mavenOutput.split(System.lineSeparator());

        // Process each line to find dependencies and imports
        for (String line : lines) {
            // Use regular expression to match dependency information
            Matcher matcher = Pattern.compile("^[|\\-\\s]+([\\w\\.-]+:[\\w\\.-]+:[\\w\\.-]+)").matcher(line);
            if (matcher.find()) {
                String dependency = matcher.group(1);

                // Check if the dependency contains the import statement
                if (javaImports.contains(dependency.replace(":", "."))) {
                    // Extract each import statement from the Java code
                    String[] imports = javaImports.split(";|\\n");
                    for (String anImport : imports) {
                        // Check if the import statement contains the dependency
                        if (anImport.contains(dependency.replace(":", "."))) {
                            // Map the import to the corresponding Maven dependency
                            importToDependencyMap.put(anImport.trim(), dependency);
                        }
                    }
                }
            }
        }

        return importToDependencyMap;
    }

    public static void main(String[] args) {
        // Example usage
        String javaImports = "import org.springframework.boot.SpringApplication;\nimport org.springframework.boot.autoconfigure.SpringBootApplication;";
        MavenDependencyMapper mapper = new MavenDependencyMapper();
        mapper.mapImportsToDependencies(javaImports)
                .forEach((importStatement, dependency) ->
                        System.out.println("Import: " + importStatement + " --> Dependency: " + dependency));
    }
}