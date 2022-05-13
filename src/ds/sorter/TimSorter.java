package ds.sorter;

import java.util.Arrays;
import java.util.List;

public class TimSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		Object [] items = input.toArray();
		timSort(items, items.length);
		// At this point, we have the items array sorted. We just need to return it.
		return (List<E>) Arrays.asList(items);
   	}
	
	int MIN_RUN_SIZE = 64;
 
    // Classic insertion sort.
    public void insertionSort(Object[] items, int left,
                                     int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            E temp = (E) items[i];
            int j = i - 1;
            // we insert the element in the correct position
            while (j >= left && ((E)items[j]).compareTo(temp) > 0)
            {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = temp;
        }
    }
 
    public void timSort(Object[] item, int n)
    {
    	// We create this instance to call the merge method.
    	MergeSorter<E> mergeSortInstance = new MergeSorter<>();
    	
        // Let's sort the small parts first with insertion sort
        for (int i = 0; i < n; i += MIN_RUN_SIZE)
        {
            insertionSort(item, i, Math.min((i + MIN_RUN_SIZE - 1), (n - 1)));
        }
 
        for (int size = MIN_RUN_SIZE; size < n; size = 2 * size)
        {
        	// Let's merge the subsorted smaller arrays.
            for (int left = 0; left < n; left += 2 * size)
            {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),(n - 1));
 
                  if(mid < right) {
                	  Object[] leftArray = new Object[mid - left + 1];
                      Object[] rightArray = new Object[right - mid];
                      for (int x = 0; x < leftArray.length; x++)
                      {
                    	  leftArray[x] = item[left + x];
                      }
                      for (int x = 0; x < rightArray.length; x++)
                      {
                    	  rightArray[x] = item[mid + 1 + x];
                      }
                      // Lets put them into a temporary array, so we can use the previous merge we created.
                      Object [] merged = new Object[leftArray.length+rightArray.length];
                      
                      mergeSortInstance.merge(merged, leftArray, rightArray);
                      
                      for (int i = 0; i < merged.length; i++) {
                    	  item[i + left] = merged[i];
                      }
                  }
            }
        }
    }
}

