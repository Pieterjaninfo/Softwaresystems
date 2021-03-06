package ss.week5.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class NaiveStrategy implements Strategy {
	
	private Set<Integer> emptyFields = new HashSet<Integer>();
	
	public String getName() {
		return "Naive";
	}
	
	public int determineMove(Board b, Mark m) {
		emptyFields.clear();
		for (int i = 0; b.isField(i); i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(i);
			}
		}
		int randomField = (int) Math.round(Math.random() * emptyFields.size());
		int i = 0;
		for (int field: emptyFields) {
			if (i == randomField) {
				return field;
			}
			i++;
		}
		return -1;
	}
}
