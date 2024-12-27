package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
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

    public void readEmployeePayrollFromFile(String file_Path) throws IOException {
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

    public int countEntriesInFile(String file_Path) throws FileNotFoundException , IOException {
        int count = 0;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file_Path))){
            while (bufferedReader.readLine() != null){
                count++;
            }
        }
        return  count;
    }

    public void watchServiceToMonitorDirectory(String path) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path directoryPath = Paths.get(path);
        directoryPath.register(watchService,StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        System.out.println("Monitor directory Path For Changes: ");

        while (true) {
            WatchKey key = watchService.take();
            for(WatchEvent<?> event : key.pollEvents()){
                System.out.println("Event Kind " +event.kind() + "File affected " + event.context());
            }
            if(!key.reset()){
                break;
            }
        }

    }

    public void printEmployeePayrollFile(String file_Path) throws IOException {
        System.out.println("\nEmployee Payroll File Contents:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file_Path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}
