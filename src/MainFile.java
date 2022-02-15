import java.util.Scanner;

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

        // while no win or draw, alternate turns between user and computer
        while(game.status()==TicTacToe.PLAYING){
            int row;
            int col;
            // user makes a move
            while(true) {
                System.out.print("X, enter a row for your move: ");
                row = kb.nextInt();
                System.out.print("X, enter a column for your move: ");
                col = kb.nextInt();
                // checks for invalid inputs
                if(game.isMoveValid(row,col)) {
                    game.move('X',row,col);
                    break;
                }
                else{
                    System.out.println("Invalid move. Try again. ");
                }
            }
            game.draw();
            System.out.println("You moved to row "+row+", column "+col);

            // computer makes a move
            game.compMove();
            game.draw();
        }

        // win messages
        if(game.status()==TicTacToe.X_WINS)
            System.out.print("X wins!");
        else if(game.status()==TicTacToe.O_WINS)
            System.out.print("O wins!");
        else if(game.status()==TicTacToe.CAT)
            System.out.print("CAT - draw!");
    }

}