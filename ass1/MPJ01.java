class Student {
    private String name;
    private int rollNo;
    private int m1, m2, m3, m4, m5;
    private float average;
    private char grade;

    // Constructor
    public Student(String name, int rollNo, int m1, int m2, int m3, int m4, int m5) {
        this.name = name;
        this.rollNo = rollNo;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
    }

    // Calculate avg and grade
    public void calculateResult() {
        average = (m1 + m2 + m3 + m4 + m5) / 5.0f;

        if (average >= 75)
            grade = 'A';
        else if (average >= 60)
            grade = 'B';
        else
            grade = 'C';
    }

    // Display result
    public void display() {
        System.out.println("Name    : " + name);
        System.out.println("Roll No : " + rollNo);
        System.out.println("Average : " + average);
        System.out.println("Grade   : " + grade);
    }
}

public class MPJ01 {

    public static void main(String[] args) {
        Student s1 = new Student("Pari", 16, 80, 65, 42, 87, 90);
        s1.calculateResult();
        s1.display();
    }
}