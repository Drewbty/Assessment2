package ds.sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ds.fruit.Fruit;
import ds.fruit.Fruit.TYPE;

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
		Comparator<Fruit> comparator = new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {
				String o1Type = o1.getType().name();
				String o2Type = o2.getType().name();
				return o1Type.compareTo(o2Type);
			}
			
		};
		list.sort(comparator);
		
		return list;
	}
	
	
	/**
	 * This method must sort the fruit by their ripeness value, from 100% ripe to 0% ripe. 
	 * The type and weight of the fruit should not be considered. 
	 * 
	 * @param list The fruit to sort
	 * @return	   A sorted list. 
	 */
	public static List<Fruit> sortByRipeness(List<Fruit> list) {
		list.sort(new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {
				double o1Ripe = o1.getRipeness();
				double o2Ripe = o2.getRipeness();
				if (o1Ripe < o2Ripe) {
					return -1;
				} else if 
					(o1Ripe > o2Ripe) {
						return 1;
					} else {
						return 0;
					}
				}

		});
		
		return list;
	}
}
