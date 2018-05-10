import java.util.ArrayList;
/*****************
 * This class counts the number of inversions that exist in an ArrayList containing comparable items.
 * The class has one public method, count, which returns the number of inversions.
 * Count calls countRec which divides the arraylist into two parts, calls itself on each part, then calls countInversions on the whole.
 * This class operates similar to MergeSort and has a time complexity of O(n logn)
 *
 * @author Leo Stevens
 ***************/
@SuppressWarnings({"unchecked", "rawtypes"})
public class InversionCounter<E extends Comparable> {

	private ArrayList<E> array;					//The ArrayList to count the inversions in

	/********
	 * This constructor takes the ArrayList to count the inversions of as a parameter.
	 *
	 * @param array				The ArrayList to count the inversions in
	 *******/
	public InversionCounter(ArrayList<E> array) {
		this.array = array;
	}

	/********
	 * This method is the public method to count the number of inversions that exist in an ArrayList.
	 * The method calls the recursive method countRec which divides the array and counts the inversions.
	 *
	 * @return					The number of inversions that exist in the ArrayList
	 *******/
	public int count() {
		return countRec(0, array.size() - 1);	
	}

	/********
	 * This method divides the arraylist into halves and counts the number of inversions.
	 * 
	 * @param low				The index of the lowest element of the array.
	 * @param high				The index of the highest element of the array.
	 *
	 * @return					The number of inversions.
	 ********/
	private int countRec(int low, int high) {
		int inversions = 0;
		if (high > low) {
			int mid = (low + high) / 2;
			inversions = countRec(low, mid);
			inversions += countRec(mid + 1, high);
			inversions += countInversions(low, mid + 1, high);			
		}
		return inversions;
	}

	/********
	 * This method counts the number of inversions that exist in the section of the ArrayList.
	 *
	 * @param low				The index of the lowest element of the array.
	 * @param mid				The index of the middle element of the array.
	 * @param high				The index of the highest element of the array.
	 *
	 * @return					The number of inversions.
	 ********/
	private int countInversions(int low, int mid, int high) {
		int i = low, j = mid;
		int inversions = 0;
		while (( i <= mid - 1) && (j <= high)) {
			//If element is in place then advance k and i
			if(array.get(i).compareTo(array.get(j)) <= 0) {
				i++;
			}
			//Else advance k and j and count the inversions
			else {
				j++;
				inversions = inversions + (mid - i);
			}
		}
	return inversions;
	}
}
