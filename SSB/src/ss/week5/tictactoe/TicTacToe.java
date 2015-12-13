package ss.week5.tictactoe;

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
		//System.out.println(3 / 2);
		Player s0;
		Player s1 = null;
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
        
        while (true) {
        	do {
                System.out.printf("Please enter the name of player two.\n" +
                		  "For a ComputerPlayer enter PC-'StrategyName'.");
                try {
                    answer[1] = in.hasNextLine() ? in.nextLine() : null;
                } finally {
                	tester = answer[1].replaceAll("\\s", "");
                }
            } while (answer[1].isEmpty() || tester.isEmpty());
        	            
            if (answer[1].startsWith("PC-")) {
            	String strat = "ss.week5.tictactoe." 
            			  + answer[1].replaceFirst("PC-", "") + "Strategy";
            	try {
            		Class.forName(strat);
            		Strategy strategy = (Strategy) Class.forName(strat).newInstance();
                	s1 = new ComputerPlayer(Mark.XX, strategy);
                	break;
            	} catch (ClassNotFoundException e) {
            		System.out.println("Strategy doesn't exist.");
            	} catch (InstantiationException e) {

				} catch (IllegalAccessException e) {

				}
            } else {
           		s1 = new HumanPlayer(answer[1], Mark.XX);
           		break;
            }
        }
            	
   		s0 = new HumanPlayer(answer[0], Mark.OO);
   		Game game = new Game(s0, s1);
   		game.start();
   		in.close();
    }
}