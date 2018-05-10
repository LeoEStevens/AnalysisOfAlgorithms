/**********
 * This class starts the Interval Partition/Scheduling program.
 * The class instantiates and initializes the Menu object.
 * Then the class calls the showMenu method which handles ass user input and calls CreateInterval, IntervalPartition, and IntervalSchedule.
 *
 * <br>
 * Uses: {@link Menu Menu}
 *
 * @see Menu
 *
 * @author Leo Stevens
 ********/

public class Driver {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.showMenu();
	}
}
