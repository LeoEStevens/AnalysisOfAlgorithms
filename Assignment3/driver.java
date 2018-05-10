import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***************
 * This class handles input, output, and instantiates/initializes the InversionCounter class.
 * The elements of the ArrayList are created using java.util.Random.
 *
 * @author Leo Stevens
 **************/

@SuppressWarnings({"unchecked", "rawtypes"})
public class driver {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		Random rand = new Random();
		int arraySize = 0;
		//Try-Catch for IOException
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			boolean error = false;
			//Do-While to validate user input
			do {
				System.out.print("Please enter the size of the array to create: ");
				String input = reader.readLine();
				try {
					arraySize = Integer.parseInt(input);
					if(arraySize <= 0) {
						System.out.println("Error! Please enter a valid number... \nPress <Enter> to continue.");
						reader.readLine();
						error = true;
					} else {
						error = false;
					}
				} catch(NumberFormatException e) {
					System.out.println("Error! Please enter a valid number... \nPress <Enter> to continue.");
					reader.readLine();
					error = true;
				}
			} while(error);
			//Create the elements of the ArrayList
			for(int i = 0; i < arraySize; i++) {
				array.add(rand.nextInt(arraySize * 10));
			}
			//Print out initial array
			System.out.print("Initial Array: {");
			for(int i = 0; i < array.size(); i++) {
				if(i == array.size() - 1) {
					System.out.println(array.get(i) + "}");
				} else {
					System.out.print(array.get(i) +", ");
				}
			}
			//Count the number of inversions
			InversionCounter count = new InversionCounter(array);
			System.out.println("Number of inversions found: " + count.count());	
		} catch (IOException e) {
			System.out.println("Error! Unable to open IO stream!");
			System.out.println(e);
		}
	}
}
