class Employee {
    protected String name;
    protected int employeeId;
    protected double baseSalary;
    protected String department;

    public Employee(String name, int employeeId, double baseSalary, String department) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.department = department;
        System.out.println("Employee " + name + " has been hired in " + department + " department");
    }

    public void displayInfo() {
        System.out.println("--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Department: " + department);
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void work() {
        System.out.println(name + " is working on general tasks");
    }
}

class Manager extends Employee {
    private double bonus;
    private int teamSize;

    public Manager(String name, int employeeId, double baseSalary, String department, double bonus, int teamSize) {
        super(name, employeeId, baseSalary, department);
        this.bonus = bonus;
        this.teamSize = teamSize;
        System.out.println(name + " has been promoted to Manager");
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void work() {
        super.work();
        System.out.println(name + " is managing a team of " + teamSize + " employees");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus: $" + bonus);
        System.out.println("Team Size: " + teamSize + " employees");
    }
}

class Developer extends Employee {
    private String programmingLanguage;
    private int projectsCompleted;

    public Developer(String name, int employeeId, double baseSalary, String department, String programmingLanguage, int projectsCompleted) {
        super(name, employeeId, baseSalary, department);
        this.programmingLanguage = programmingLanguage;
        this.projectsCompleted = projectsCompleted;
        System.out.println(name + " joined as a " + programmingLanguage + " Developer");
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (projectsCompleted * 1000);
    }

    @Override
    public void work() {
        System.out.println(name + " is coding in " + programmingLanguage);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Projects Completed: " + projectsCompleted);
    }
}

class Intern extends Employee {
    private String university;
    private boolean isFullTime;

    public Intern(String name, int employeeId, double baseSalary, String department, String university, boolean isFullTime) {
        super(name, employeeId, baseSalary, department);
        this.university = university;
        this.isFullTime = isFullTime;
        System.out.println("Intern " + name + " from " + university + " has started");
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 0.5;
    }

    @Override
    public void work() {
        System.out.println(name + " is learning and assisting with tasks");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("University: " + university);
        System.out.println("Full-time: " + isFullTime);
    }
}

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice Smith", 2001, 80000, "Engineering", 15000, 8);
        Developer developer = new Developer("Bob Johnson", 2002, 70000, "Engineering", "Java", 5);
        Intern intern = new Intern("Charlie Brown", 2003, 30000, "Engineering", "Tech University", true);

        System.out.println();

        // Display and test Manager
        manager.displayInfo();
        manager.work();
        System.out.println("Monthly Salary: $" + manager.calculateSalary());
        System.out.println();

        // Display and test Developer
        developer.displayInfo();
        developer.work();
        System.out.println("Monthly Salary: $" + developer.calculateSalary());
        System.out.println();

        // Display and test Intern
        intern.displayInfo();
        intern.work();
        System.out.println("Monthly Salary: $" + intern.calculateSalary());
    }
}

