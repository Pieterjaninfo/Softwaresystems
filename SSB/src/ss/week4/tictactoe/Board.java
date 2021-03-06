package ss.week4.tictactoe;

/**
 * Game student for the Tic Tac Toe game. Module 2 lab assignment.
 *
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Board {
    public static final int DIM = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
        " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";

    /**
     * The DIM by DIM fields of the Tic Tac Toe student. See NUMBERING for the
     * coding of the fields.
     */
    //@ private invariant fields.length == DIM*DIM;
    /*@ invariant (\forall int i; 0 <= i & i < DIM*DIM;
        getField(i) == Mark.EMPTY || getField(i) == Mark.XX || getField(i) == Mark.OO); */
    private Mark[] fields;

    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty student.
     */
    //@ ensures (\forall int i; 0 <= i & i < DIM * DIM; this.getField(i) == Mark.EMPTY);
    public Board() {
    	fields = new Mark[DIM * DIM];
    	reset();
    }

    /**
     * Creates a deep copy of this field.
     */
    /*@ ensures \result != this;
        ensures (\forall int i; 0 <= i & i < DIM * DIM;
                                \result.getField(i) == this.getField(i));
      @*/
    public Board deepCopy() {
    	// TODO: implement, see exercise P-4.18
    	Board newBoard = new Board();
    	for (int i = 0; isField(i); i++) {
    		newBoard.fields[i] = this.getField(i);
    	}
        return newBoard;
    }

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @return the index belonging to the (row,col)-field
     */
    //@ requires 0 <= row & row < DIM;
    //@ requires 0 <= col & col < DIM;
    /*@pure*/
    public int index(int row, int col) {
    	// TODO: implement, see exercise P-4.18
    	assert isField(row, col);
    	return (DIM * row) + col;
    	/* too large and not scalable
    	if (row == 0) {
    		return col;
    	} else if (row == 1) {
    		return col + 3;
    	} else {
    		return col + 6;
    	}*/
    }

    /**
     * Returns true if ix is a valid index of a field on the student.
     * @return true if 0 <= index < DIM*DIM
     */
    //@ ensures \result == (0 <= index && index < DIM * DIM);
    /*@pure*/
    public boolean isField(int index) {
    	return 0 <= index && index < DIM * DIM;
    }
    
    /**
     * Returns true of the (row,col) pair refers to a valid field on the student.
     *
     * @return true if 0 <= row < DIM && 0 <= col < DIM
     */
    //@ ensures \result == (0 <= row && row < DIM && 0 <= col && col < DIM);
    /*@pure*/
    public boolean isField(int row, int col) {
    	return 0 <= row && row < DIM && 0 <= col && col < DIM;
    }
    
    /**
     * Returns the content of the field i.
     *
     * @param i
     *            the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    //@ requires this.isField(i);
    //@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
    /*@pure*/
    public Mark getField(int i) {
    	assert isField(i);
        return fields[i];
    }

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     *
     * @param row
     *            the row of the field
     * @param col
     *            the column of the field
     * @return the mark on the field
     */
    //@ requires this.isField(row,col);
    //@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
    /*@pure*/
    public Mark getField(int row, int col) {
    	assert isField(row, col);
    	return fields[index(row, col)];
    }

    /**
     * Returns true if the field i is empty.
     *
     * @param i
     *            the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    //@ requires this.isField(i);
    //@ ensures \result == (this.getField(i) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int i) {
    	assert isField(i);
    	return getField(i) == Mark.EMPTY;
    }

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     *
     * @param row
     *            the row of the field
     * @param col
     *            the column of the field
     * @return true if the field is empty
     */
    //@ requires this.isField(row,col);
    //@ ensures \result == (this.getField(row,col) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int row, int col) {
    	assert isField(row, col);
    	return getField(row, col) == Mark.EMPTY;
    }

    /**
     * Tests if the whole student is full.
     *
     * @return true if all fields are occupied
     */
    //@ ensures \result == (\forall int i; i <= 0 & i < DIM * DIM; this.getField(i) != Mark.EMPTY);
    /*@pure*/
    public boolean isFull() {
    	for (int i = 0; isField(i); i++) {
    		if (isEmptyField(i)) {
    			return false;
    		}
    	}
        return true;
    }

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole student is full.
     *
     * @return true if the game is over
     */
    //@ ensures \result == this.isFull() || this.hasWinner();
    /*@pure*/
    public boolean gameOver() {
        return isFull() || hasWinner();
    }

    /**
     * Checks whether there is a row which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a row controlled by m
     */
    /*@ pure */
    public boolean hasRow(Mark m) {
    	int i = 0;
    	int j = 0;
    	while (j < DIM && i < DIM) {
    		if (getField(i, j) == m && j == DIM - 1) {
    			return true;
    		} else if (getField(i, j) == m) {
    			j++;
    		} else {
    			j = 0;
    			i++;
    		}
    	}
    	/* not scalable and complicated
    	if (getField(0) == getField(1) && getField(2) == m && getField(2) == getField(0)) {
    		return true;
    	} else if (getField(3) == getField(4) && getField(5) == m && getField(5) == getField(3)) {
    		return true;
    	} else if (getField(6) == getField(7) && getField(8) == m && getField(8) == getField(6)) {
    		return true;
    	}*/
    	return false;
    }

    /**
     * Checks whether there is a column which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a column controlled by m
     */
    /*@ pure */
    public boolean hasColumn(Mark m) {
    	int i = 0;
    	int j = 0;
    	while (j < DIM && i < DIM) {
    		if (getField(j, i) == m && j == DIM - 1) {
    			return true;
    		} else if (getField(j, i) == m) {
    			j++;
    		} else {
    			j = 0;
    			i++;
    		}
    	}
    	
    	/* not scalable and complicated
    	if (getField(0) == getField(3) && getField(6) == m && getField(6) == getField(0)) {
    		return true;
    	} else if (getField(1) == getField(4) && getField(7) == m && getField(7) == getField(1)) {
    		return true;
    	} else if (getField(2) == getField(5) && getField(8) == m && getField(8) == getField(2)) {
    		return true;
    	}*/
    	return false;
    }

    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a diagonal controlled by m
     */
    /*@ pure */
    public boolean hasDiagonal(Mark m) {
    	int i = 0;
    	while (i < DIM) {
    		if (getField(i, i) == m && i == DIM - 1) {
    			return true;
    		} else if (getField(i, i) == m) {
    			i++;
    		} else {
    			i = DIM;
    		}
    	}
    	i = 0;
    	while (i < DIM) {
    		if (getField(i, DIM - i - 1) == m && i == DIM - 1) {
    			return true;
    		} else if (getField(i, DIM - i - 1) == m) {
    			i++;
    		} else {
    			i = DIM;
    		}
    	}
    	
    	/* not scalable and complicated
    	if (getField(4) == m) {
    		if (getField(0) == m && getField(0) == getField(8)) {
    			return true;
    		} else if (getField(6) == m && getField(6) == getField(2)) {
    			return true;
    		}
    	}*/
        return false;
    }

    /**
     * Checks if the mark m has won. A mark wins if it controls at
     * least one row, column or diagonal.
     *
     * @param m
     *            the mark of interest
     * @return true if the mark has won
     */
    //@requires m == Mark.XX | m == Mark.OO;
    //@ ensures \result == this.hasRow(m) || this.hasColumn(m) | this.hasDiagonal(m);
    /*@ pure */
    public boolean isWinner(Mark m) {
    	assert m == Mark.OO || m == Mark.XX;
        return hasRow(m) || hasColumn(m) || hasDiagonal(m);
    }

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     *
     * @return true if the student has a winner.
     */
    //@ ensures \result == isWinner(Mark.XX) | \result == isWinner(Mark.OO);
    /*@pure*/
    public boolean hasWinner() {
        return isWinner(Mark.OO) || isWinner(Mark.XX);
    }

    /**
     * Returns a String representation of this student. In addition to the current
     * situation, the String also shows the numbering of the fields.
     *
     * @return the game situation as String
     */
    public String toString() {
        /* layout gets fucked when move is made.....
    	String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
                row = row + " " + getField(i, j).toString() + " ";
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;*/
    	
    	String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
            	row = String.format("%s %5s ", row, getField(i, j).toString());
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = String.format("%s%s%s%s", s, row, DELIM, NUMBERING[i * 2]);
            if (i < DIM - 1) {
            	String format = "%s\n ----- + ----- + ----- %s%s\n";
            	s = String.format(format, s, DELIM, NUMBERING[i * 2 + 1]);
            }
        }
        return s;
    	
    }

    /**
     * Empties all fields of this student (i.e., let them refer to the value
     * Mark.EMPTY).
     */
    /*@ ensures (\forall int i; 0 <= i & i < DIM * DIM;
                                this.getField(i) == Mark.EMPTY); @*/
    public void reset() {
    	for (int i = 0; isField(i); i++) {
    		fields[i] = Mark.EMPTY;
    	}
    }

    /**
     * Sets the content of field i to the mark m.
     *
     * @param i
     *            the field number (see NUMBERING)
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(i);
    //@ ensures this.getField(i) == m;
    public void setField(int i, Mark m) {
    	assert isField(i);
    	fields[i] = m;
    }

    /**
     * Sets the content of the field represented by the (row,col) pair to the
     * mark m.
     *
     * @param row
     *            the field's row
     * @param col
     *            the field's column
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(row,col);
    //@ ensures this.getField(row,col) == m;
    public void setField(int row, int col, Mark m) {
    	assert isField(row, col);
    	fields[index(row, col)] = m;
    }
}
