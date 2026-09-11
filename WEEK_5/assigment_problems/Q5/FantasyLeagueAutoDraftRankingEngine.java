import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    double getFantasyPoints() {
        return battingAverage;
    }

    public int compareTo(Player other) {
        return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
    }

    public String getName() {
        return name;
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftable[count++] = players[i];
            }
        }

        Player[] selected = Arrays.copyOf(draftable, count);
        Arrays.sort(selected);

        String result = "";

        for (int i = 0; i < selected.length; i++) {
            result += (i + 1) + ". " + selected[i].getName();

            if (i < selected.length - 1) {
                result += " | ";
            }
        }

        return result;
    }
}

public class FantasyLeagueAutoDraftRankingEngine {
    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(Player.draftAndRank(players));
    }
}

