import java.util.ArrayList;
import java.util.Random;

/*******
 * This class creates the intervals.
 * The intervals are created using the create method which returns an ArrayList.
 * <br>
 * Used by: {@link Menu Menu}
 * <br>
 * Uses: {@link Interval Interval}
 * 
 * @see Interval
 *
 * @author Leo Stevens
 ******/
public class CreateIntervals {

	/******
	 * Constructors
	 *****/

	/******
	 * Default Constructor.
	 * The class has no fields.
	 *****/
	public CreateIntervals() { }

	/******
	 * This method creates intervals and returns them in an ArrayList.
	 * The method creates a new ArrayList to hold the intervals.
	 * Then the intervals are created using Random and then printed.
	 *
	 * @param numOfIntervals				The number of intervals to create
	 * @param start							The minimum start time
	 * @param end							The maximum end time
	 *
	 * @return								The list of intervals created.
	 ******/
	public ArrayList<Interval> create(int numOfIntervals, int start, int end) {
		System.out.println("---------Interval List---------");
		//Create the arraylist to hold the intervals
		ArrayList<Interval> intervalList = new ArrayList<>();
		//Get the range
		int gap = end - start;
		//Loop to create the intervals
		for(int i = 0; i < numOfIntervals; i++) {
			//Create a new random for each interval (reduces chances of duplicate intervals)
			Random rand = new Random();
			//Get a new start time for the interval
			int iStart = rand.nextInt(end - start) + start;
			//Get a new end time for the interval
			int iEnd = rand.nextInt(end - iStart) + iStart + 1;
			//Create the interval and add it to the list
			intervalList.add(new Interval(iStart, iEnd));
		}
		//Print the intervals that were created
		for(Interval i : intervalList) { 
			System.out.println(i);
		}
		System.out.println("-------------------------------\n");
		//Return the intervals
		return intervalList;
	}
}

