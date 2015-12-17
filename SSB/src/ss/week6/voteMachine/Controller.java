package ss.week6.voteMachine;

public class Controller {
	
	private PartyList parties;
	private VoteList votes;
	
	public Controller() {
		parties = new PartyList();
		votes = new VoteList();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		VoteMachine voteMachine = new VoteMachine();
		voteMachine.start();	
	}
	
	public void addParty(String party) {
		parties.addParty(party);
	}

	public void addVote(String party) {
		votes.addVote(party);
	}
	
	public void showVotes() {
		VoteTUIView.showVotes(VoteList.getVotes());
	}
	
	public void showParties() {
		VoteTUIView.showParties(PartyList.getParties());
	}
}
