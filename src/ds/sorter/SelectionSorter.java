package ds.sorter;

import java.util.Arrays;
import java.util.List;

public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		Object[] items = input.toArray();
		int n = items.length;
		 
        // Move outer boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find minimum element in unsorted array
            int minimum = i;
            for (int j = i+1; j < n; j++)
                if (((E)items[j]).compareTo((E) items[minimum]) <= 0) {
                	minimum = j;        	
                }
 
            // Swap the found minimum element with the first element of the outer boundary
            Object temp = items[minimum];
            items[minimum] = items[i];
            items[i] = temp;
        }
        
        //cast back as list
        return (List<E>) Arrays.asList(items);
   	}
	
	

}
