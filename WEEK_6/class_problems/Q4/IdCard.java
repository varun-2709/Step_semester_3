public class IdCard {
    String studentName;
    int idNumber;

    IdCard(String studentName, int idNumber) {
        this.studentName = studentName;
        this.idNumber = idNumber;
    }

    public static void main(String[] args) {
        IdCard card1 = new IdCard("Aisha", 101);
        IdCard card2 = card1;
        IdCard card3 = new IdCard("Aisha", 101);

        System.out.println(card1 == card2);
        System.out.println(card1 == card3);
    }
}