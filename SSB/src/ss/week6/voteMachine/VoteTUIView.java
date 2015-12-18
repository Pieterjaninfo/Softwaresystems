package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer, VoteView{
	
	private VoteMachine control;
	
	public VoteTUIView(VoteMachine voteMachine) {
		control = voteMachine;
	}
	
	/*public static void main(String[] args) {
		
		showHelp();
	}*/
	
	public void start() {
		Scanner input = new Scanner(System.in);
		while (true) {

			System.out.print("command: ");
			String command = input.nextLine();
			
			if (command.startsWith("VOTE ")) {
				control.addVote(command.replaceFirst("VOTE ", ""));
			} else if (command.startsWith("ADD PARTY")) {
				control.addParty(command.replaceFirst("ADD PARTY ", ""));
			} else if (command.equals("VOTES")) {
				control.getVotes();
			} else if (command.equals("PARTIES")) {
				control.getParties();
			} else if (command.equals("EXIT")) {
				break;
			} else if (command.equals("HELP")) {
				showHelp();
			} else {
				System.out.println("Incorrect command type 'HELP' for more information");
			}
		}
		input.close();
	}
	
	public void showVotes(Map<String, Integer> map) {
		for (String key: map.keySet()) {
			System.out.printf("Party %s has %d votes.\n", key, map.get(key));
		}
	}
	
	public void showParties(List<String> list) {
		System.out.println("Parties:");
		for (String party: list) {
			System.out.printf("\t%s\n", party);
		}
	}

	public void showHelp() {
		String addVote = "VOTE [party], Add a vote for a party.";
		String addParty = "PARTY [party], Adds the party to the party list.";
		String votes = "VOTES, Show all votes";
		String parties = "PARTIES, Show all parties";
		String exit = "EXIT, exitst application.";
		System.out.printf("Commands:\n%s\n%s\n%s\n%s\n%s\n", addVote, addParty, votes, parties, exit);
	}
	
    public void showError(String message) {
    	System.out.println(message);
    }
    
    public void update(Observable o, Object arg) {
    	System.out.println(arg);
    }

}