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

    // places a move in the game board
    public void move(char player, int row, int col) {
        board[row][col] = player;
    }

    // checks if the move is valid
    public boolean isMoveValid(int row, int col){
        if(row>=0&&row<=4&&col>=0&&col<=4&&board[row][col]!='X'&&board[row][col]!='O')
            return true;
        else
            return false;
    }

    // displays the game board
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

    // checks for wins and draws, returns the status of the game
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
                    // if someone wins, check who won
                    if (win) {
                        if (current == 'X')
                            return X_WINS;
                        if (current == 'O')
                            return O_WINS;
                    }
                }
            }
        }
        // check for a draw (game board is full but no one has won)
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

    // computer bot
    public void compMove() {
        // blocks if there are 3 X's in a row
        for (int r = 1; r < board.length; r++) {
            for (int c = 1; c < board[0].length; c++) {
                char current = board[r][c];
                if (current == 'X') {
                    // check for vertical 3's
                    if (r == 1) {
                        if (board[r + 1][c] == current && board[r + 2][c] == current)
                            if (isMoveValid(r + 3, c)) {
                                move('O', r + 3, c);
                                return;
                            }
                        else if(isMoveValid(r-1,c)){
                            move('O',r-1,c);
                            return;
                            }
                    }
                    // check for horizontal 3's
                    if (c == 1) {
                        if (board[r][c + 1] == current && board[r][c + 2] == current)
                            if (isMoveValid(r, c + 3)) {
                                move('O', r, c + 3);
                                return;
                            }
                            else if(isMoveValid(r,c-1)){
                                move('O',r,c-1);
                                return;
                            }
                    }
                    // check for diagonal \ 3's
                   if (r == 1 && c == 1) {
                        if (board[r + 1][c + 1] == current && board[r + 2][c + 2] == current)
                            if (isMoveValid(r + 3, c + 3)) {
                                move('O', r + 3, c + 3);
                                return;
                            }
                            else if(isMoveValid(r-1,c)){
                                move('O',r-1,c-1);
                                return;
                            }
                    }
                    // check for diagonal / 3's
                    if (r <= 1 && c >= 3) {
                        if (board[r][c] == current && board[r + 1][c - 1] == current && board[r + 2][c - 2] == current)
                            if (isMoveValid(r + 3, c - 3)) {
                                move('O', r + 3, c - 3);
                                return;
                            }
                            else if(isMoveValid(r-1,c)){
                                move('O',r-1,c);
                                return;
                            }
                    }
                }
            }
        }

        // if there are no 3 X's in a row to block, move randomly
        while(status()==PLAYING) {
            int comp_row = (int) (Math.random() * 5);
            int comp_col = (int) (Math.random() * 5);
            if(isMoveValid(comp_row,comp_col)) {
                move('O', comp_row, comp_col);
                break;
            }
        }

    }
}






