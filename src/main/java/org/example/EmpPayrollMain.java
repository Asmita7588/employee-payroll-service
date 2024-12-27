package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpPayrollMain
{

    public static void main( String[] args ) throws IOException, InterruptedException {

        System.out.println( "Welcome to Employee Payroll service" );

         final String DIRECTORY_PATH = "EmployeePayroll";
         final String FILE_PATH = DIRECTORY_PATH + "/EmployeePayroll.txt";

         EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        // employeePayrollService.createDirectory(DIRECTORY_PATH);
        // employeePayrollService.createFile(FILE_PATH);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Asmita",35000));
        employeeList.add(new Employee(2, "Chetan",45000));
        employeeList.add(new Employee(3, "Ankita",40000));
        employeeList.add(new Employee(4, "Akshita",38000));
        employeeList.add(new Employee(5, "Pranay",38000));
        employeeList.add(new Employee(6,"Asmitaaa",234783));


        // Method to read From file
        employeePayrollService.writeEmployeePayrollToFile(employeeList,FILE_PATH);

        //Method to read from file to console
        employeePayrollService.readEmployeePayrollFromFile(FILE_PATH);
        String directoryPath = "Employee";
        employeePayrollService.createDirectory(directoryPath);
        employeePayrollService.fileOperations(directoryPath);
        System.out.println( "Count of Entries int file: " +employeePayrollService.countEntriesInFile(FILE_PATH));
        employeePayrollService.printEmployeePayrollFile(FILE_PATH);
        employeePayrollService.watchServiceToMonitorDirectory(DIRECTORY_PATH);


    }

}