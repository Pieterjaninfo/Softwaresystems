package ss.week6.voteMachine;

public class VoteMachine {
	
	private PartyList parties;
	private VoteList votes;
	
	public VoteMachine() {
		parties = new PartyList();
		votes = new VoteList();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		VoteMachine voteMachine = new VoteMachine();
		VoteTUIView voteTUIView = new VoteTUIView(voteMachine);
		voteMachine.start();
	}
	
	public void start() {
		VoteTUIView.start();
	}
	
	public void addParty(String party) {
		parties.addParty(party);
	}

	public void addVote(String party) {
		votes.addVote(party);
	}
	
	public void getVotes() {
		VoteTUIView.showVotes(VoteList.getVotes());		
	}
	
	public void getParties() {
		VoteTUIView.showParties(PartyList.getParties());
	}
}
