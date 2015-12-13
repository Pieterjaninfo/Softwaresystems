package ss.week5.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class SmartStrategy implements Strategy {
	
	private Set<Integer> emptyFields = new HashSet<Integer>();

	public String getName() {
		return "Smart";
	}
	
	public int determineMove(Board b, Mark m) {
		emptyFields.clear();
		for (int i = 0; b.isField(i); i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(i);
			}
		}
		int mid = Board.DIM / 2;
		if (b.isEmptyField(mid, mid)) {
			return b.index(mid, mid);
		}
		for (int field: emptyFields) {
			Board testBoard = b.deepCopy();
			testBoard.setField(field, m);
			if (testBoard.isWinner(m)) {
				return field;
			}
		}
		for (int field: emptyFields) {
			Board testBoard = b.deepCopy();
			testBoard.setField(field, m.other());
			if (testBoard.hasWinner()) {
				return field;
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
