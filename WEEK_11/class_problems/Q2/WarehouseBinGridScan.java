import java.util.*;

public class WarehouseBinGridScan {
    static void warehouseSummary(int[][] grid) {
        long total = 0;
        int max = -1, row = -1, col = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("total = " + total);
        System.out.println("maxCoordinate = (" + row + ", " + col + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        warehouseSummary(grid);
    }
}