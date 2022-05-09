package ds.sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ds.fruit.Fruit;

public class CustomSorting {

	
	/**
	 * This method must sort the fruit alphabetically by their type. Fruits must be sorted 
	 *  in the order Apple, Banana, Grape, Pear. The weight and ripeness of a fruit should not
	 *  be considered. 
	 *  
	 * @param list The list to sort. 
	 * @return A sorted list. 
	 */
	public static List<Fruit> sortByType(List<Fruit> list) {
		return null;
		/*
		return list.sort(new Comparator<Fruit>() {
			// Implement your custom compare method here. 
		});
		*/
	}
	
	
	/**
	 * This method must sort the fruit by their ripeness value, from 100% ripe to 0% ripe. 
	 * The type and weight of the fruit should not be considered. 
	 * 
	 * @param list The fruit to sort
	 * @return	   A sorted list. 
	 */
	public static List<Fruit> sortByRipeness(List<Fruit> list) {
		return null;
		/*
		return list.sort(new Comparator<Fruit>() {
			// Implement your custom compare method here. 
		});
		*/
	}
}
