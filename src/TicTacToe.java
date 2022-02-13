public class TicTacToe {

    public static final int PLAYING = 0;
    public static final int X_WINS = 1;
    public static final int O_WINS = 2;
    public static final int CAT = 3;

    public static char board[][] = {{' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' '}};


    public TicTacToe() {

    }

    public void draw() {
        System.out.println("    0   1   2   3   4");
        for (int r = 0; r < board.length; r++) {
            System.out.print(r + " ");
            System.out.print("|");
            for (int c = 0; c < board[0].length; c++) {

                if (board[r][c] == ' ') {
                    System.out.print("   ");
                    System.out.print("|");
                } else if (board[r][c] == 'X') {
                    System.out.print(" X ");
                    System.out.print("|");
                } else if (board[r][c] == 'O') {
                    System.out.print(" O ");
                    System.out.print("|");
                }
            }
            System.out.println("\n  ---------------------");
        }
    }

    public int status() {
        boolean win = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char current = board[r][c];
                if (current == 'X' || current == 'O') {
                    // check for vertical wins
                    if (r <= 1) {
                        if (board[r + 1][c] == current && board[r + 2][c] == current && board[r + 3][c] == current)
                            win = true;
                    }
                    // check for horizontal wins
                    if (c <= 1) {
                        if (board[r][c + 1] == current && board[r][c + 2] == current && board[r][c+3] == current)
                            win = true;
                    }
                    // check for diagonal \ wins
                    if (r <= 1 && c <= 1) {
                        if (board[r + 1][c + 1] == current && board[r + 2][c + 2] == current && board[r + 3][c + 3] == current)
                            win = true;
                    }
                    // check for diagonal / wins
                    if (r <=1 && c >= 3) {
                        if (board[r][c] == current && board[r + 1][c - 1] == current && board[r + 2][c - 2] == current && board[r + 3][c - 3] == current)
                            win = true;
                    }
                    if (win) {
                        if (current == 'X')
                            return X_WINS;
                        if (current == 'O')
                            return O_WINS;
                    }
                }
            }
        }
        boolean full = true;
        for(int r=0;r<board.length;r++){
            for(int c =0; c<board.length; c++){
                if(board[r][c]==' ')
                    full=false;
            }
        }
    if(full)
        return CAT;
    else
        return PLAYING;
    }


    public void move(char player, int row, int col) {
        board[row][col] = player;
    }

    public boolean isMoveValid(int row, int col){
        if(row>=0&&row<=5&&col>=0&&col<=5&&board[row][col]==' ')
            return true;
        else
            return false;
    }

    public void ai() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char current = board[r][c];
                if (current == 'X') {
                    // check for vertical 3's
                    if (r <= 1) {
                        if (board[r + 1][c] == current && board[r + 2][c] == current)
                            if (isMoveValid(r + 3, c)) {
                                move('O', r + 3, c);
                                return;
                            }
                    }
                    // check for horizontal 3's
                    if (c <= 1) {
                        if (board[r][c + 1] == current && board[r][c + 2] == current)
                            if (isMoveValid(r, c + 3)) {
                                System.out.println("1");
                                move('O', r, c + 3);
                                return;
                            }
                    }
                    // check for diagonal \ 3's
                   if (r <= 1 && c <= 1) {
                        if (board[r + 1][c + 1] == current && board[r + 2][c + 2] == current)
                            if (isMoveValid(r + 3, c + 3)) {
                                System.out.println("2");

                                move('O', r + 3, c + 3);
                                return;
                            }
                    }
                    // check for diagonal / 3's
                    if (r <= 1 && c >= 3) {
                        if (board[r][c] == current && board[r + 1][c - 1] == current && board[r + 2][c - 2] == current)
                            if (isMoveValid(r + 3, c - 3)) {
                                System.out.println("3");

                                move('O', r + 3, c - 3);
                                return;
                            }
                    }





                }
            }
        }
        while(true) {
            int comp_row = (int) (Math.random() * 4);
            int comp_col = (int) (Math.random() * 4);
            if(isMoveValid(comp_row,comp_col)) {
                System.out.print("4");
                move('O', comp_row, comp_col);
                break;
            }
        }

    }
}






