import java.util.ArrayList;
import java.util.Comparator;

/**********
 * This class partitions the intervals into ArrayLists.
 * The class takes an ArrayList as a parameter in a constructor, sorts the list, and then partitions the ArrayList into mutually compatable lists.
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

public class IntervalPartition {

	/******
	 * Variables.
	 *****/
	private ArrayList<Interval> intervalList;					//The list of intervals to partition

	/******
	 * Constructors.
	 *****/

	/*****
	 * Default Costructor.
	 * Sets all fields to null.
	 ****/
	public IntervalPartition() { }

	/*****
	 * Overloaded Constructor.
	 * @param intervalList				The ArrayList of intervals to partition.
	 ****/
	public IntervalPartition(ArrayList<Interval> intervalList) {
		this.intervalList = intervalList;
	}

	/*****
	 * Methods.
	 ****/

	/*****
	 * This method creates the ArrayList of ArrayLists of Intervals.
	 * The outer most ArrayList represents the list of classrooms, while each ArrayList inside it holds the intervals that are compatable.
	 * The method sorts the list of intervals by the start time using Comparator.
	 * Then the data is iterated over and placed into the first classroom that it is compatable with.
	 * Once the data has been parsed, the number of classrooms created is printed followed by a list of the classrooms with their intervals.
	 *****/
	public void partition() {
		System.out.println("-----Interval Partitioning-----");
		//Sort the list
		intervalList.sort(Comparator.comparing(Interval::getStart));
		//Create an arraylist of arraylists to hold the classrooms
		ArrayList<ArrayList<Interval>> partition = new ArrayList<>();
		//Create the first interval
		ArrayList<Interval> firstInterval = new ArrayList<>();
		//Add the first interval to the classrooms
		partition.add(firstInterval);
		//Iterate over the interval list
		for(Interval i : intervalList) {
			//Check each classroom for compatability with the current interval
			for(ArrayList<Interval> al : partition) {
				//If the classroom is empty, add the interval and end the loop
				if(al.size() == 0) {
					al.add(i);
					break;
				}
				//Else-If check if the current interval is compatable with the last item in the classroom
				//If it is, then add it to the classroom and end the loop
				else if(i.getStart() >= al.get(al.size() - 1).getEnd()) {
					al.add(i);
					break;
				}
				//Else-If we reached the last classroom and it is not compatable
				//So create a new classroom and add the interval to it
				else if (al.equals(partition.get(partition.size() - 1))) {
					ArrayList<Interval> newInterval = new ArrayList<>();
					newInterval.add(i);
					partition.add(newInterval);
					break;
				}
			}
		}
		//Print out the number of classrooms created
		System.out.println("\n" + partition.size() + " classrooms needed.\n");
		//Print out the list of classrooms and the intervals that belong to that class room
		for(int i = 0; i < partition.size(); i++) {
			System.out.println("Classroom " + (i + 1));
			for(Interval interval : partition.get(i)) {
				System.out.println(interval);
			}
			if(!(i == partition.size() - 1)) {
				System.out.println();
			}
		}
		System.out.println("-------------------------------\n");
	}
}
