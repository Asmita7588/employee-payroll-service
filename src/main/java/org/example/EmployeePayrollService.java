package org.example;

import java.io.*;
import java.util.List;

public class EmployeePayrollService {

    public void createDirectory(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Directory created: " + path);
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }


    public void createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("File created: " + path);
        } else {
            System.out.println("File already exists: " + path);
        }
    }

    public void writeEmployeePayrollToFile(List<Employee> employees, String file_Path) throws IOException {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(file_Path))){
            for (Employee employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
            }
        }
        System.out.println("Employee Payroll written on file.");
    }

    public void readEmployeePayrollFromFile(String file_Path) throws IOException ,InterruptedIOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(file_Path))){
            System.out.println("Employee Payroll Data: ");
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }

    }

    public void fileOperations(String directoryPath) throws IOException {
        String file_Path = "filetocheck.txt";
        createFile("filetocheck.txt");
         File file = new File(file_Path);
         System.out.println("File Exists: " +file.exists());

         // Delete file and check existence
        if (file.exists()) {
            file.delete();
            System.out.println("File deleted.");
        }
        System.out.println("File exists after deletion: " + file.exists());

        //list files in directory
        File directory = new File(directoryPath);
        System.out.println("Listing files and directories:");
        for (String name : directory.list()) {
            System.out.println(name);
        }

    }
}
