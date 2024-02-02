import java.io.IOException;

/**
 * FallingSand
 */
public class FallingSand {

    public static void Display(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    // public static int[][] nextGen(int[][] grid) {
    // int[][] newGrid = new int[grid.length][grid[0].length];

    // for (int i = 0; i < grid.length - 1; i++) {
    // for (int j = 0; j < grid[i].length; j++) {
    // if (grid[i][j] == 1) {
    // if (i + 1 < grid.length && grid[i + 1][j] == 0) {
    // newGrid[i][j] = 0;
    // newGrid[i + 1][j] = 1;
    // } else if (j + 1 < grid[i].length && grid[i][j + 1] == 0) {
    // newGrid[i][j] = 0;
    // newGrid[i][j + 1] = 1;
    // } else if (i + 1 < grid.length && j + 1 < grid[i].length && grid[i + 1][j +
    // 1] == 0) {
    // newGrid[i][j] = 0;
    // newGrid[i + 1][j + 1] = 1;
    // } else if (i - 1 >= 0 && grid[i - 1][j] == 0) {
    // newGrid[i][j] = 0;
    // newGrid[i - 1][j] = 1;
    // } else {
    // newGrid[i][j] = 1;
    // }
    // }
    // }
    // }

    // // Copy the last row as it is (no sand falling below the last row)
    // for (int j = 0; j < grid[0].length; j++) {
    // newGrid[grid.length - 1][j] = grid[grid.length - 1][j];
    // }

    // return newGrid;
    // }

    public static int[][] nextGen(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {

                    if (i + 1 < grid.length && grid[i + 1][j] == 0) {
                        newGrid[i][j] = 0;
                        newGrid[i + 1][j] = 1;
                    } else {
                        newGrid[i][j] = 1;
                    }
                }
            }
        }

        return newGrid;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        {

            int[][] grid = new int[30][30];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = 0;
                }
            }
            grid[0][22] = 1;
            grid[5][22] = 1;
            while (grid[grid.length - 1][9] == 0) {
                grid = nextGen(grid);
                Display(grid);

                // Wait for 1 second (1000 milliseconds)
                Thread.sleep(100);

                // Clear the console (may not work in all environments)
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }

        }
    }
}