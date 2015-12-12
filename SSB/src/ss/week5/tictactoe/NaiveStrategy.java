package ss.week5.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class NaiveStrategy implements Strategy {
	
	private Set<Integer> emptyFields = new HashSet<Integer>();
	
	public String getName() {
		return null;
	}
	
	public int determineMove(Board b, Mark m) {
		emptyFields.clear();
		for (int i = 0; b.isField(i); i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(i);
			}
		}
		while (true) {
			int randomField = (int) (Math.random() * (emptyFields.size() + 1));
			for (int field: emptyFields) {
				if (field == randomField) {
					return field;
				}
			}
		}
	}
}
