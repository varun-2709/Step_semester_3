public class Course {
    String courseName;
    int credits;
    String instructor;
    boolean labIncluded;

    Course(String courseName, int credits, String instructor, boolean labIncluded) {
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.labIncluded = labIncluded;
    }

    Course(String courseName, int credits, String instructor) {
        this(courseName, credits, instructor, false);
    }

    void printDetails() {
        System.out.println(courseName + " - " + credits + " Credits - " + instructor + " - Lab: " + labIncluded);
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 4, "Dr. Kumar", true);
        Course c2 = new Course("Data Structures", 3, "Dr. Ravi");

        c1.printDetails();
        c2.printDetails();
    }
}