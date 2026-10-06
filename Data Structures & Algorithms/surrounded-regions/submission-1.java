public class Solution {
    private int ROWS, COLS;
    private int[][] directions = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        capture(board);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if ((r == 0 || r == ROWS - 1 ||
                    c == 0 || c == COLS - 1) &&
                    board[r][c] == 'O') {
                    q.offer(new int[]{r, c});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            if (board[r][c] == 'O') {
                board[r][c] = 'T';
                for (int[] direction : directions) {
                    int nr = r + direction[0], nc = c + direction[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS) {
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}