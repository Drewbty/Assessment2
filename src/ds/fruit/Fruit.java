package ds.fruit;

import java.util.Objects;

/**
 * 
 * @author AndrewORourke
 * Unisa student username: oroaj002
 */

public class Fruit implements java.lang.Comparable<Fruit> {

	public enum TYPE {

		APPLE, PEAR, BANANA, GRAPE
	}
	
	private TYPE type;
	private double weight;
	private double ripeness;

	
	/**
	 * Constructor for FRuit Object
	 * @param myType - type of Fruit
	 * @param weight - weight of Fruit
	 * @param ripeness - ripeness of Fruit
	 * @throws InvalidFruitWeightException
	 * @throws InvalidFruitRipenessException
	 */
	public Fruit(final TYPE myType, final double weight, final double ripeness) throws InvalidFruitWeightException, InvalidFruitRipenessException {

		this.type = myType;
		//if weight is negative
		if (weight <= 0) {
			throw new InvalidFruitWeightException("Invalid weight: " + weight + ". Weight must be positive");
		} else {
			this.weight = weight;
		}

		//if ripeness is not between 0 and 1
		if (ripeness < 0 || ripeness > 1) {
			throw new InvalidFruitRipenessException("Invalid ripeness: " + ripeness + ". Ripeness must be between 0 and 1");
		} else {
			this.ripeness = ripeness;
		}

	}
	/**
	 * ToString method for Fruit object
	 */

	public String toString() {

		return "Fruit name: " + getType() + 
				"\nWeight: " + getWeight() + 
				"\nRipeness: " + getRipeness();

	}

	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getRipeness() {
		return ripeness;
	}


	public void setRipeness(double ripeness) {
		this.ripeness = ripeness;
	}
	
	

	public TYPE getType() {
		return type;
	}


	public void setType(TYPE type) {
		this.type = type;
	}

	/**
	 * Override hashcode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ripeness, weight);
	}

	/**
	 * Override equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (hashCode() != obj.hashCode()) {
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		return Double.doubleToLongBits(ripeness) == Double.doubleToLongBits(other.ripeness)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	//set the minimum difference in weight, whereby the weight is ignored
	final double DELTA_DIFF = 0.05;
	
	@Override
	public int compareTo(Fruit o) {
		//if both pears, compare the ripeness to separate them
		if (getType() == TYPE.PEAR) {
			if (o.getType() == TYPE.PEAR) {
				return compareRipeness(o);
			}
			//otherwise pear is always greater
			return 1;
		}
		
		
		if (getType() == TYPE.BANANA) {
			//if both bananas, compare ripeness to separate them
			if (o.getType() == TYPE.BANANA) {
				return compareRipeness(o);
			}else {
				//otherwise, bananas are always lesser
				return -1;
			}
		}
		if (getType() == TYPE.GRAPE || getType() == TYPE.APPLE) {
			//if grape or apple is compared to pear, they are lesser
			if (o.getType() == TYPE.PEAR) {
				return -1;
				//if grape or apple is compared to banana, they are both greater
			}else if (o.getType() == TYPE.BANANA) {
				return 1;
				
			}else {
				
				//otherwise we are comparing grapes/apples to grapes/apples
				int comparisonWeight = compareWeight(o);
				//we compare the weight, if they're not equal (including DELTA_DIFF)
				if (comparisonWeight != 0) {
					//return the weight
					return comparisonWeight;
				}
				
				//otherwise, compare ripeness to tie break
				return compareRipeness(o);
			}
		}
		
		return 0;
	}

	/**
	 * Method to compare the weight of 2 Fruit Objects. If the objects are within .05kg in weight
	 * They are treated as the same weight for comparison. 
	 * @param o Fruit object to compare to
	 * @return 0 (equal), -1 (lesser), 1 (greater)
	 */
	private int compareWeight(Fruit o) {
		//get absolute difference in weight
		if (Math.abs(getWeight() - o.getWeight()) <= DELTA_DIFF ) {
			return 0;
		}else if (getWeight() > o.getWeight()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Method to compare the ripeness of 2 Fruit Objects.
	 * @param o Fruit object to compare to
	 * @return 0 (equal), -1 (lesser), 1 (greater)
	 */

	private int compareRipeness(Fruit o) {
		if (getRipeness() == o.getRipeness()) {
			return 0;
		}else if (getRipeness() > o.getRipeness()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
