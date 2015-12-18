package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
	
	private static Map<String, Integer> votes = new HashMap<String, Integer>();
	
	/**
	 * Add a vote to a given party, returns true if successful, false if not.
	 * @param Party The party that is voted for.
	 * @return
	 */
	public void addVote(String party) {
		if (party == null) {
			return;
		}
		if (votes.containsKey(party)) {
			Integer numberOfVotes = votes.get(party);
			votes.put(party, ++numberOfVotes);
			setChanged();
			notifyObservers("vote added for " + party + ".");
		} else if (PartyList.hasParty(party)) {
			votes.put(party, 1);
			setChanged();
			notifyObservers("vote added for " + party + ".");
		}
	}
	
	public static Map<String, Integer> getVotes() {
		return votes;
	}
}
