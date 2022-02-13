import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainFile {
    public static void main(String[]args){
        TicTacToe game = new TicTacToe();
        Scanner kb = new Scanner(System.in);

        System.out.println("---5x5 Tic Tac Toe---");
        System.out.println("You (X) and the computer (O) will take turns placing X's and O's on a 5x5 grid.");
        System.out.println("The goal is to get 4 in a row to win.");
        System.out.println("Be careful, the computer will try to block you whenever you get 3 in a row!");
        System.out.println("Have fun!\n");

        game.draw();

        while(game.status()==game.PLAYING){
            int row=-1;
            int col=-1;
            while(true) {
                System.out.print("X, enter a row for your move: ");
                row = kb.nextInt();
                System.out.print("X, enter a column for your move: ");
                col = kb.nextInt();
                if(game.isMoveValid(row,col)) {
                    game.board[row][col] = 'X';
                    break;
                }
                else{
                    System.out.println("Invalid move. Try again. ");
                }


            }

            game.draw();
            System.out.println("You moved to row "+row+", column "+col);

            game.ai();
            game.draw();

            //System.out.println("Opponent moved to row "+game.comp_row+", column "+game.comp_col);

        }

        // win messages
        if(game.status()==game.X_WINS)
            System.out.print("X wins!");
        else if(game.status()==game.O_WINS)
            System.out.print("O wins!");
        else if(game.status()==game.CAT)
            System.out.print("CAT - draw!");
    }



}