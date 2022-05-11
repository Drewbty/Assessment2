package ds.sorter;

import java.util.Arrays;
import java.util.List;

public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		Object [] items = input.toArray();
		// Separate the merge algorithm from the external call because we are using arrays for efficiency
		mergeSort(items, items.length);
		// At this point, we have the items array sorted. We just need to return it.
		return (List<E>) Arrays.asList(items);
	}

	public void mergeSort(Object[] a, int n) {
		// we are in the base case, we only have 1 elements
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		Object[] l = new Object[mid];
		Object[] r = new Object[n - mid];

		//. we cut the array in half.
		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		// sort left
		mergeSort(l, mid);
		// sort right
		mergeSort(r, n - mid);

		// merge them
		merge(a, l, r, mid, n - mid);
	}

	public void merge(Object[] a, Object[] l, Object[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			E leftElement = (E) l[i]; // we know they are comparable, so we cast them back.
			E rightElement = (E) r[i];
			if (leftElement.compareTo(rightElement) <= 0) {
				// if the left element is smaller, then we add it.
				a[k++] = l[i++];
			} else {
				// or we add the right one if smaller.
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			// some remaining items in the left, we add them
			a[k++] = l[i++];
		}
		while (j < right) {
			// in case there were remainers in the right, we add them.
			a[k++] = r[j++];
		}
	}

}
