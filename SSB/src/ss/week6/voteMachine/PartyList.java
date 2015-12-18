package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;

public class PartyList {

	private static List<String> parties = new ArrayList<String>();
	
	/**
	 * Add a party. Returns true if successful otherwise false.
	 * @param party Patry to be added.
	 * @return
	 */
	public boolean addParty(String party) {
		if (!parties.contains(party)) {
			parties.add(party);
			VoteList.addVote(party);
			return true;
		}
		return false;
	}
	
	public static List<String> getParties() {
		return parties;
	}
	
	public static boolean hasParty(String party) {
		return parties.contains(party);
	}
	
}
