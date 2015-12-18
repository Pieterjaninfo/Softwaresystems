package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {

	private static List<String> parties = new ArrayList<String>();
	
	/**
	 * Add a party. Returns true if successful otherwise false.
	 * @param party Patry to be added.
	 * @return
	 */
	public void addParty(String party) {
		if (!parties.contains(party)) {
			parties.add(party);
			//VoteList.addVote(party);
			setChanged();
			notifyObservers("party " + party + " added.");
		}
	}
	
	public static List<String> getParties() {
		return parties;
	}
	
	public static boolean hasParty(String party) {
		return parties.contains(party);
	}
	
}
