import java.util.*;
import java.io.*;

// Main class
public class Main {
    public static void main(String[] args) {
        HRManagementSystem managementSystem = new HRManagementSystem();
        managementSystem.start();
    }
}

// Department class
class Department implements Serializable {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Designation class
class Designation implements Serializable {
    private String title;

    public Designation(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

// Employee class
class Employee implements Serializable {
    private int employeeID;
    private String name;
    private Department department;
    private Designation designation;

    public Employee(int employeeID, String name, Department department, Designation designation) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.designation = designation;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
}

// HRAssistant class
class HRAssistant extends User implements Serializable {
    public HRAssistant(String username) {
        super(username);
    }

    public void searchEmployee(HRManager manager, String department, String name) {
        List<Employee> employees = manager.searchEmployee(department, name);
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeID());
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment().getName());
            System.out.println("Designation: " + employee.getDesignation().getTitle());
        }
    }
}

// HRManager class
class HRManager extends User implements Serializable {
    public HRManager(String username) {
        super(username);
    }

    public void addDepartment(HRManagementSystem system, String name) {
        system.addDepartment(name);
    }

    public void addDesignation(HRManagementSystem system, String title) {
        system.addDesignation(title);
    }

    public void addEmployee(HRManagementSystem system, int employeeID, String name, Department department, Designation designation) {
        system.addEmployee(employeeID, name, department, designation);
    }

    public void searchEmployee(HRManagementSystem system, String department, String name) {
        List<Employee> employees = system.searchEmployee(department, name);
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeID());
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment().getName());
            System.out.println("Designation: " + employee.getDesignation().getTitle());
        }
    }

    public void createHRAssistantAccount(HRManagementSystem system, String username) {
        system.createHRAssistantAccount(username);
    }
}

// User class
abstract class User implements Serializable {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// HRManagementSystem class
class HRManagementSystem implements Serializable {
    private List<Department> departments;
    private List<Designation> designations;
    private List<Employee> employees;
    private List<HRAssistant> hrAssistants;
    private HRManager hrManager;

    public HRManagementSystem() {
        departments = new ArrayList<>();
        designations = new ArrayList<>();
        employees = new ArrayList<>();
        hrAssistants = new ArrayList<>();
        hrManager = new HRManager("Admin");
    }

    public void start() {
        // Main functionality implementation goes here
    }

    public void addDepartment(String name) {
        departments.add(new Department(name));
    }

    public void addDesignation(String title) {
        designations.add(new Designation(title));
    }

    public void addEmployee(int employeeID, String name, Department department, Designation designation) {
        employees.add(new Employee(employeeID, name, department, designation));
    }

    public List<Employee> searchEmployee(String department, String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (department == null || employee.getDepartment().getName().equals(department)) {
                if (name == null || employee.getName().equals(name)) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

    public void createHRAssistantAccount(String username) {
        hrAssistants.add(new HRAssistant(username));
    }
}
