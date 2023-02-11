

package telran.measure;

public class Length implements Comparable<Length>{
	private float amount;
	private LengthUnit lengthUnit;
	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}
	@Override
	/**
	 * equals two Length objects according to LengthUnit and amount
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Length) {
			result = compareTo((Length) obj) == 0;
		}
		return result;
	}

	@Override
	/**
	 * 
	 * @param o
	 * @return < 0 "this" object less than "o" object,
	 *  > 0 "this" object greater than "o" object,
	 *  == 0 "this" object equals "o" object,
	 */
	public int compareTo(Length o) {		
		return Float.compare(amount * lengthUnit.getValue(), o.amount * o.lengthUnit.getValue());
	}
	
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * example, convert(LengthUnit.M) returns Length in meters 
	 */
	public Length convert(LengthUnit unit) {		
		return new Length(amount * lengthUnit.getValue() / unit.getValue(), unit);
	}
	
	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20.0M (string expression of Length object presenting 20 meters)
	 */
	public String toString() {
		return String.format("%.1f%s", amount, lengthUnit);
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}
	
	
}