package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {
	
	private PartyList parties;
	private VoteList votes;
	private static VoteView voteView;
	
	public VoteMachine() {
		parties = new PartyList();
		votes = new VoteList();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		VoteMachine voteMachine = new VoteMachine();
		voteView = new VoteGUIView(voteMachine);
		voteMachine.start();
	}
	
	public void start() {
		parties.addObserver(voteView);
		votes.addObserver(voteView);
		voteView.start();
	}
	
	public void addParty(String party) {
		parties.addParty(party);
	}

	public void addVote(String party) {
		votes.addVote(party);
	}
	
	public void getVotes() {
		voteView.showVotes(VoteList.getVotes());		
	}
	
	public void getParties() {
		voteView.showParties(PartyList.getParties());
	}
}
