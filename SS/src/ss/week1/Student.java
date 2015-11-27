package ss.week1;

public class Student {

	// ------------------ Instance variables ----------------
	
	public int score;
	public static final int MINSCORE = 70;

	// ------------------ Constructor ------------------------
	
	public Student() {
		score = 50;
		
	}
	
	// ------------------ Queries --------------------------
	
	public boolean passed() {
		if (score >= MINSCORE) {
			return true;
		}
		return false;
		// return score>=MINSCORE;
	}
	
}
