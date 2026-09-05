import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 7.0 && codingScore >= 60;
    }

    @Override
    public int compareTo(Candidate c) {
        if (this.codingScore != c.codingScore) {
            return Integer.compare(c.codingScore, this.codingScore);
        }

        return Double.compare(c.cgpa, this.cgpa);
    }

    @Override
    public String toString() {
        return name + " - CGPA: " + cgpa + " - Coding Score: " + codingScore;
    }
}

public class CandidateShortlisting {
    static void shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (int i = 0; i < candidates.length; i++) {
            if (Candidate.isEligible(candidates[i].cgpa, candidates[i].codingScore)) {
                shortlisted[count] = candidates[i];
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted);

        for (int i = 0; i < shortlisted.length; i++) {
            System.out.println((i + 1) + ". " + shortlisted[i]);
        }
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 80)
        };

        shortlistAndRank(candidates);
    }
}