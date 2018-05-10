
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/*********
 * This class handles all input and instantiates/initializes the CreateInterval, IntervalPartition, and IntervalSchedule classes.
 * The class uses BufferedReader/InputStreamReader to get the data from System.in.
 * The data is cast into an Integer using parseInt and passed to classes through constructors and methods.
 *
 * @see CreateIntervals
 * @see IntervalPartition
 * @see IntervalSchedule
 *
 * @author Leo Stevens
 ********/
public class Menu {

	/******
	 * Constructors
	 *****/

	/*****
	 * Default Constructor.
	 * This class has no fields
	 ****/
	public Menu() { }

	/******
	 * Methods.
	 *****/

	/******
	 * This method prompts the user for input, instantiates/initializes the required classes, and handles all exceptions.
	 * The method first asks the user for the number of intervals to create, then the range for the time for the intervals.
	 * The intervals are created using CreateIntervals which returns the ArrayList of intervals.
	 * Then the list of intervals is passed into the IntervalSchedule and IntervalPartition classes which process the data.
	 *****/
	public void showMenu() {
		//Try-Catch for IOException
		try {	
			//Boolean flag for error checking
			boolean error = false;
			//String for input
			String input;
			//Ints for the data will will get from the user
			int intervals = 0, start = 0, end = 0;
			//Get pipe
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			//Do-While to get the number of intervals
			//Ends when valid input has been received
			do {
				System.out.println("Please enter the number of intervals to create.");
				System.out.print("INPUT> ");
				input = console.readLine();
				//Try to parse input into an integer
				try {
					intervals = Integer.parseInt(input);
					error = false;
				}
				//Catch NumberFormatException if the user entered invalid data
				catch (NumberFormatException e) {
					System.out.println("ERROR! Please enter a valid number of intervals.");
					error = true;
				}
				//If the number is less than 1 it is not valid
				if(intervals < 1) {
					System.out.println("ERROR! Please enter a valid number of intervals.");
					error = true;
				}
			}while(error);
			//Do-While to get start time
			//Ends when valid input has been received
			do {
				System.out.println("Please enter the minimum start time.");
				System.out.print("INPUT> ");
				input = console.readLine();
				//Try to parse input into an integer
				try {
					start = Integer.parseInt(input);
					error = false;
				}
				//Catch NumberFormatException if the user entered invalid data
				catch (NumberFormatException e) {
					System.out.println("ERROR! Please enter a valid start time.");
					error = true;
				}
				//If the start time is lass than zero it is not valid
				if(start < 0) {
					System.out.println("ERROR! Please enter a valid start time.");
					error = true;
				}
			}while(error);
			//Do-While to get end time
			//Ends when valid input has been received
			do {
				System.out.println("Please enter the maximum end time.");
				System.out.print("INPUT> ");
				input = console.readLine();
				//Try to parse input into an integer
				try {
					end = Integer.parseInt(input);
					error = false;
				} 
				//Catch NumberFormatException if the user entered invalid data
				catch (NumberFormatException e) {
					System.out.println("ERROR! Please enter a valid end time.");
					error = true;
				}
				//If the end time is lass than zero or less than or equal to the start time is is invalid
				if(end < 0 || end <= start) {
					System.out.println("ERROR! Please enter a valid end time.");
					error = true;
				}
			}while(error);
			System.out.println();

			//Create the intervals
			CreateIntervals creator = new CreateIntervals();
			ArrayList<Interval> intervalList = creator.create(intervals, start, end);

			//Schedule the intervals
			IntervalSchedule schedule = new IntervalSchedule(intervalList);
			schedule.schedule();

			//Partition the intervals
			IntervalPartition part = new IntervalPartition(intervalList);
			part.partition();
		} catch (IOException e) {
			System.out.println("ERROR! Unable to open IO Stream!\nExiting!");
			System.exit(-1);
		}
	}
}
