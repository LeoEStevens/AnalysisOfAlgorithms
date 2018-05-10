import java.util.ArrayList;
import java.util.Comparator;

/**********
 * This class schedules the intervals into an ArrayList.
 * The class takes an ArrayList as a parameter in a constructor, sorts the list, and then gets the largest set of mutually compatable intervals.
 *
 * <br>
 * Used by: {@link Menu Menu}
 *
 * @see <a href="https://docs.oracle.com/javase/9/docs/api/java/util/Comparator.html">Comparator</a>
 * @see Interval
 * @see Menu
 *
 * @author Leo Stevens
 *********/

public class IntervalSchedule {

	/******
	 * Variables.
	 *****/

	private ArrayList<Interval> intervalList;				//The list of intervals to schedule

	/******
	 * Constructors.
	 *****/

	/*****
	 * Default Constuctor.
	 * Sets all fields to null
	 ****/
	public IntervalSchedule() { }

	/*****
	 * Overloaded Constuctor.
	 * @param intervalList				The list of intervals to create the schedule from
	 *****/
	public IntervalSchedule(ArrayList<Interval> intervalList) {
		this.intervalList = intervalList;
	}

	/*****
	 * Methods.
	 *****/

	/******
	 * This method sorts the list of intervals by end time, then interates over the list to find the compatable intervals.
	 * The method uses Comparator to sort the list of intervals.
	 * Then the method iterates over the intervals adding them to the list if their end time is greater or equal to the last item in the list.
	 * Once the schedule is created, the method prints the number of intervals in the list and the list of intervals.
	 *****/
	public void schedule() {
		System.out.println("------Interval Scheduling------");
		//Sort the list of intervals
		intervalList.sort(Comparator.comparing(Interval::getEnd));
		//Create a new arraylist to hold the schedule
		ArrayList<Interval> schedule = new ArrayList<>();
		//Iterate over the list of intervals
		for(Interval i : intervalList) {
			//If the schedule is empty, add the interval and end the loop
			if(schedule.size() == 0) {
				schedule.add(i);
			}
			//Else-If the interval is compatable with the last item in the schedule so add it
			else if(schedule.get(schedule.size() - 1).getEnd() <= i.getStart()) {
				schedule.add(i);
			}
		}
		//Print the size of the list
		System.out.println("\n" + schedule.size() + " mutually compatable intervals.\n");
		//Print the list of intervals
		for(Interval i : schedule) {
			System.out.println(i);
		}
		System.out.println("-------------------------------\n");
	}
}
