public class DuplicateTeamFinder {
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[j];
                }
            }
        }

        return "No Duplicate Found";
    }

    public static void main(String[] args) {
        String[] teamNames = {"ByteForce", "CodeCrafters", "ByteForce"};

        System.out.println(findDuplicateTeam(teamNames));
    }
}