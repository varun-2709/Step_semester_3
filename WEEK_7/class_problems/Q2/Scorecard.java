public class Scorecard {
    private boolean[] results;
    private int recorded;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        recorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recorded < results.length) {
            results[recorded] = correct;
            recorded++;
        }
    }

    public int getScore() {
        int score = 0;

        for (boolean result : results) {
            if (result) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}