/*
 * <Makes a Car object>
 * 
 * CSC 1351 Programming Project No.1  Part A
 * 
 * Section 2
 * 
 * @ author Amy Tran
 * @ since 3/17/2024
 * 
 */


public class Car implements Comparable<Car> {

	private String make;
	private int year;
	private int price;
	
	/*
	 * Car  - creates a car object using a make, year, and price.
	 * @param String Make- the make as a string.
	 * @param int Year - the year as an integer.
	 * @param int Price - the price as an integer.
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public Car (String Make, int Year, int Price)  {
		this.make = Make;
		this.year = Year;
		this.price = Price;
	}
	
	/*
	 * getMake  - gets the make of a car object.
	 * @ return make
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public String getMake() {
		return this.make;
	}
	
	/*
	 * getYear  - gets the year of a car object.
	 * @ return year
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public int getYear() {
		return this.year;
	}
	
	/*
	 * getMake  - gets the price of a car object.
	 * @ return price
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public int getPrice() {
		return this.price;
	}
	
	/*
	 * compareTo  - compares one car object to another car object
	 * @ param Car other - a car object
	 * @ return an interger
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public int compareTo(Car other) {
		if (make.contains(other.make)) {
			return Integer.compare(this.year,other.year);
		}
		else {
			return make.compareTo(other.make);
			}
	
	}
	
	/*
	 * toString  - makes a string of the car's make, year, and price
	 * @ return String
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public String toString() {
		return "Make: " + make + " \nYear: " + year + " \nPrice: " + price;
	}
}
