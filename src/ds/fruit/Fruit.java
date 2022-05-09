package ds.fruit;

import java.util.Objects;

public class Fruit implements java.lang.Comparable<Fruit> {

	public enum TYPE {

		APPLE, PEAR, BANANA, GRAPE
	}
	
	private TYPE myType;

	private double weight;
	private double ripeness;

	public Fruit(final TYPE myType, final double weight, final double ripeness) throws InvalidFruitWeightException, InvalidFruitRipenessException {

		this.myType = myType;
		if (weight <= 0) {
			throw new InvalidFruitWeightException();
		} else {
			this.weight = weight;
		}

		if (ripeness < 0 || ripeness > 1) {
			throw new InvalidFruitRipenessException();
		} else {
			this.ripeness = ripeness;
		}

	}

	public String toString() {

		return "Fruit name: " + Fruit.TYPE + 
				"\nWeight: " + weight + 
				"\nRipeness: " + ripeness;

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

}
