package ds.fruit;

import java.util.Objects;

public class Fruit implements java.lang.Comparable<Fruit> {

	public enum TYPE {

		APPLE, PEAR, BANANA, GRAPE
	}
	
	private TYPE type;

	private double weight;
	private double ripeness;

	public Fruit(final TYPE myType, final double weight, final double ripeness) throws InvalidFruitWeightException, InvalidFruitRipenessException {

		this.type = myType;
		if (weight <= 0) {
			throw new InvalidFruitWeightException("Invalid weight: " + weight + ". Weight must be positive");
		} else {
			this.weight = weight;
		}

		if (ripeness < 0 || ripeness > 1) {
			throw new InvalidFruitRipenessException("Invalid ripeness: " + ripeness + ". Ripeness must be between 0 and 1");
		} else {
			this.ripeness = ripeness;
		}

	}

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
	
	

	/**
	 * @return the type
	 */
	public TYPE getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TYPE type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ripeness, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		return Double.doubleToLongBits(ripeness) == Double.doubleToLongBits(other.ripeness)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	final double DELTA_DIFF = 0.05;
	
	@Override
	public int compareTo(Fruit o) {
		if (getType() == TYPE.PEAR) {
			if (o.getType() == TYPE.PEAR) {
				if (Math.abs(getRipeness() - o.getRipeness()) <= DELTA_DIFF ) {
					return 0;
				}else if (getRipeness() > o.getRipeness()) {
					return 1;
				}
				else {
					return -1;
				}
			}
			return 1;
		}
		
		
		return 0;
	}
	
	

}