package ss.week4.tictactoe;

import java.util.Scanner;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
    	String tester;
    	String[] answer = {null, null};
    	Scanner in = new Scanner(System.in);
        do {
            System.out.print("Please enter the name of player one.");
            try {
                answer[0] = in.hasNextLine() ? in.nextLine() : null;
            } finally {
            	tester = answer[0].replaceAll("\\s", "");
            }
        } while (answer[0].isEmpty() || tester.isEmpty());
       
        //System.out.println(answer[0] + answer[0].contentEquals(""));
        
        do {
            System.out.print("Please enter the name of player two.");
            try {
                answer[1] = in.hasNextLine() ? in.nextLine() : null;
            } finally {
            	tester = answer[1].replaceAll("\\s", "");
            }
        } while (answer[1].isEmpty() || tester.isEmpty());
            	
   		Player s0 = new HumanPlayer(answer[0], Mark.OO);
   		Player s1 = new HumanPlayer(answer[1], Mark.XX);
   		Game game = new Game(s0, s1);
   		game.start();
   		in.close();
    }
}