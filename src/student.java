public class student {
    private String ngalan;
    private int edad;
    private String course;
    private double grado1;
    private double grado2;
    private double grado3;

    public student(String ngalan, int edad, String course, double grado1, double grado2, double grado3) {
        this.ngalan = ngalan;
        this.edad = edad;
        this.course = course;
        this.grado1= grado1;
        this.grado2 = grado2;
        this.grado3 = grado3;
    }

    public void displayInfo() {
        System.out.println("Student Details:");
        System.out.println("  Name: " + ngalan);
        System.out.println("  Age: " + edad);
        System.out.println("  Course: " + course);
        System.out.println("  Grades: " + grado1 + ", " + grado2 + ", " + grado3);
    }

    public double calculateAverage() {
        return (grado1 + grado2 + grado3) / 3.0;
    }

    public String getLetterGrade() {
        double average = calculateAverage();
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public boolean isPassing() {
        return calculateAverage() >= 70;
    }

}
