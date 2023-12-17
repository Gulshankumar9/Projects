import os
import re
from openpyxl import Workbook

def extract_java_imports(modules_directory, excel_file):
    # Create a new Excel workbook
    workbook = Workbook()
    sheet = workbook.active

    # Write header to the Excel sheet
    sheet.append(["Module", "Class Name", "Import"])

    # Walk through each module in the specified directory
    for module_name in os.listdir(modules_directory):
        module_path = os.path.join(modules_directory, module_name)
        if os.path.isdir(module_path):
            process_module(module_path, sheet)

    # Save the Excel workbook
    workbook.save(excel_file)

def process_module(module_path, sheet):
    # Walk through each Java file in the module
    for root, dirs, files in os.walk(os.path.join(module_path, "src/main/java")):
        for file in files:
            if file.endswith(".java"):
                file_path = os.path.join(root, file)
                process_java_file(module_path, file_path, sheet)

def process_java_file(module_path, file_path, sheet):
    with open(file_path, "r") as file:
        content = file.read()

        # Extract package and class name
        package_match = re.search(r'package (.*?);', content)
        class_match = re.search(r'class (\w+)', content)

        if package_match and class_match:
            package = package_match.group(1)
            class_name = class_match.group(1)

            # Extract and write imports to the Excel sheet
            import_matches = re.findall(r'import javax\..*?;', content)
            for imp in import_matches:
                sheet.append([module_path, f"{package}.{class_name}", imp])

if __name__ == "__main__":
    # Specify the directory containing all Maven modules
    modules_directory = "C:/Users/Gulshan/Desktop/work/"

    # Specify the output Excel file
    excel_file = "java_imports_output_python.xlsx"

    extract_java_imports(modules_directory, excel_file)