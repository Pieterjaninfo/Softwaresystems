package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;

public class VoteList {
	
	private static Map<String, Integer> votes = new HashMap<String, Integer>();
	
	/**
	 * Add a vote to a given party, returns true if successful, false if not.
	 * @param Party The party that is voted for.
	 * @return
	 */
	public static boolean addVote(String party) {
		if (party == null) {
			return false;
		}
		if (votes.containsKey(party)) {
			Integer numberOfVotes = votes.get(party);
			votes.put(party, ++numberOfVotes);
			return true;
		} else if (PartyList.hasParty(party)) {
			votes.put(party, 0);
			return true;
		}
		return false;
	}
	
	public static Map<String, Integer> getVotes() {
		return votes;
	}
}
