package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VoteTUIView {
	
	private Controller control = new Controller();
	
public static void main(String[] args) {
		
		showHelp();
	}
	
	public void start() {
		Scanner input = new Scanner(System.in);
		while (true) {

			System.out.print("command: ");
			String command = input.nextLine();
			
			if (command.startsWith("VOTE")) {
				control.addVote(command.replaceFirst("VOTE ", ""));
			} else if (command.startsWith("ADD PARTY")) {
				control.addParty(command.replaceFirst("ADD PARTY ", ""));
			} else if (command.equals("VOTES")) {
				control.showVotes();
			} else if (command.equals("PARTIES")) {
				control.showParties();
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
	
	public static void showVotes(Map<String, Integer> map) {
		for (String key: map.keySet()) {
			System.out.printf("Party %s has %d votes.\n", key, map.get(key));
		}
	}
	
	public static void showParties(List<String> list) {
		System.out.println("Parties:");
		for (String party: list) {
			System.out.printf("%s\n", party);
		}
	}

	public static void showHelp() {
		String addVote = "VOTE [party], Add a vote for a party.";
		String addParty = "PARTY [party], Adds the party to the party list.";
		String votes = "VOTES, Show all votes";
		String parties = "PARTIES, Show all parties";
		String exit = "EXIT, exitst application.";
		System.out.printf("Commands:\n%s\n%s\n%s\n%s\n%s\n", addVote, addParty, votes, parties, exit);
	}
}