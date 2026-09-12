public class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " - " + company + " - " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        PlacementRecord[] records = {
            new PlacementRecord("Aisha", "TCS", 6.5),
            new PlacementRecord("Rohit", "Infosys", 7.2),
            new PlacementRecord("Meena", "Wipro", 5.8)
        };

        for (PlacementRecord record : records) {
            record.printRecord(); 
        }
    }
}