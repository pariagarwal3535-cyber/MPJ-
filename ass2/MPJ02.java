import java.util.Scanner;

class Employee {
    String name;
    double salary;

    void displaySalary() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary before hike: " + salary);
    }
}

class FullTimeEmployee extends Employee {

    void calculateSalary() {
        salary = salary + (salary * 0.50);
        System.out.println("Salary after 50% hike: " + salary);
    }
}

class InternEmployee extends Employee {

    void calculateSalary() {
        salary = salary + (salary * 0.25);
        System.out.println("Salary after 25% hike: " + salary);
    }
}

public class MPJ02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.print("Enter Employee Name: ");
            String name = sc.next();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            System.out.println("1. Full Time Employee");
            System.out.println("2. Intern Employee");
            System.out.print("Enter choice: ");
            int type = sc.nextInt();

            System.out.println();

            if (type == 1) {
                FullTimeEmployee f = new FullTimeEmployee();
                f.name = name;
                f.salary = salary;
                f.displaySalary();
                f.calculateSalary();
            } 
            else if (type == 2) {
                InternEmployee i = new InternEmployee();
                i.name = name;
                i.salary = salary;
                i.displaySalary();
                i.calculateSalary();
            } 
            else {
                System.out.println("Invalid choice");
            }

            System.out.println();
            System.out.print("Enter 1 to continue, 0 to stop: ");
            choice = sc.nextInt();
            System.out.println();

        } while (choice == 1);

        sc.close();
    }
}