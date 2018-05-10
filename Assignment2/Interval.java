/****************
 * Interval Class.
 * This class holds the data associated with the intervals.
 *
 * <br>
 * Used by: {@link CreateIntervals CreateIntervals}
 * 
 * @see CreateIntervals
 *
 * @author Leo Stevens
 ***************/
public class Interval {
	
	/*******
	 * Variables
	 ******/
	
	private int	start;				//The start time of the interval
	private int end;				//The end time of the interval
	

	/******
	 * Constructors
	 ******/

	/********
	 * Sets all fields to null.
	 *******/
	public Interval() { }

	/******
	 * This constructor build the complete object.
	 * @param start			The start time of the interval.
	 * @param end			The end time of the interval.
	 *****/
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}


	/*******
	 * Getters
	 ******/

	/******
	 * This method returns the start time of the interval.
	 * @return				The start time of the interval.
	 *****/
	public int getStart() {
		return start;
	}

	/******
	 * This method returns the end time of the interval.
	 * @return				The end time of the interval.
	 *****/
	public int getEnd() {
		return end;
	}

	/******
	 * Overridden Methods.
	 *****/

	/*****
	 * This method returns a formatted string when the interval is printed.
	 *
	 * @return				A string holding the start and end times.
	 *****/
	@Override
	public String toString() {
		return "Start: " + start + " End: " + end;
	}
}

	
