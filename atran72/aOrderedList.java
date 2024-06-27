/*
 * <Makes an aOrderedList object>
 * 
 * CSC 1351 Programming Project No.1  Part A
 * 
 * Section 2
 * 
 * @ author Amy Tran
 * @ since 3/17/2024
 * 
 */


import java.util.ArrayList;
import java.util.Arrays;

public class aOrderedList {

	final int SIZEINCREMENTS = 20;
	private Comparable[] oList;
	private int listSize;
	private int numObjects;
	private int curr;
	static Car lastElement; // used for the remove method
	

	/*
	 * aOrderedList  - makes aOrderList object using an constructor
	 *
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public aOrderedList() {
		this.numObjects = 0;
		this.listSize = SIZEINCREMENTS;
		this.oList = new Comparable[SIZEINCREMENTS];
	}
	
	/*
	 * add  - adds a car in the sorted array.
	 * @param Car newCar - the car that needs to be added to the array
	 * 
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public void add(Car newCar) {
	   
	    if (numObjects >= listSize) {
	        Comparable[] newoList = Arrays.copyOf(this.oList, 2 * this.oList.length);
	        this.oList = newoList;
	        this.listSize = this.oList.length;
	    }

	    
	    if (this.oList == null || numObjects == 0) {
	        this.oList = new Comparable[SIZEINCREMENTS];
	        this.oList[0] = newCar;
	    } else {
	        int i;
	        for (i = numObjects - 1; i >= 0; i--) {
	            if (this.oList[i].compareTo(newCar) <= 0) {
	                break;
	            }
	            this.oList[i + 1] = this.oList[i];
	        }
	        this.oList[i + 1] = newCar;
	    }
	    numObjects++;
	}
	
	/*
	 * toString  -  makes a string of the car's make, year, and price
	 * @param Car car- the car object
	 * @return String 
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public String toString(Car car) {
		return "[Make:" + car.getMake()+",Year:" + car.getYear()+ "+ Price:" + car.getPrice();
	}
	
	/*
	 * size  -  gets the size of the list
	 * @return oList.length
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public int size() {
		return oList.length;	
	}
	
	/*
	 * get  -  gets the car at the given index
	 * @param int index - the index you want to find the car at.
	 * @return Car 
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public Car get(int index) {
		return (Car) oList[index];
	}
	
	/*
	 * set  -  sets a car at a given index.
	 * @param Car car - the car object
	 * @param int index - the index where you want to place the car object.
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public void set(Car car, int index) {
		this.oList[index]= car;
	}
	/*
	 * isEmpty  -  checks if a list is empty.
	 * @return boolean
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public boolean isEmpty() {
		if(oList.length > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/*
	 * hasNext  -  checks if there a next element
	 * @return boolean
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public boolean hasNext() {
		try {
			if(oList[curr+1] == null || curr+1 >= oList.length) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}return true;
	}
	
	/*
	 * next  -  returns the next element
	 * @return Comparable 
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public Comparable next() {
		curr++;
		lastElement = (Car) oList[curr];
		return lastElement;
		
	}
	
	/*
	 * reset  -  returns the curr value.
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public void reset() {
		curr = 0;
		
	}
	
	/*
	 * remove  - removes the element called by the next method.
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public void remove() {
		int index = linearSearch (lastElement);
		for(int i = index; i < this.oList.length; i++) {
			if(i == this.oList.length -1) {
				break;
			}else {
			this.oList[i]= this.oList[i+1];
			}
		}
		numObjects--;
	}
		
	/*
	 * remove -  removes the object at the given index.
	 * @param int index- the index where you want to remove the object
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public void remove(int index) {
		for(int i = index; i < this.oList.length; i++) {
			if(i == this.oList.length -1) {
				break;
			}else {
			this.oList[i]= this.oList[i+1];
			}
		}
		numObjects--;
	}
	
	/*
	 * getNumObjects  -  gets the number of objects in the list.
	 * @return numObjects
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public int getNumObjects() {
		return this.numObjects;
	}
	
	/*
	 * linearSearch  - searches for an object in the aOrderedList.
	 * @param Car lastElement - the last element used in the remove method.
	 * @ return index as an int.
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public int linearSearch(Car lastElement) {
		for(int i = 0; i < this.oList.length;i++) {
			if(this.oList[i]== null) {
				break;
			}
			else if(((Car) this.oList[i]).getMake().equals(lastElement.getMake())) {
				if(((Car) this.oList[i]).getYear() == lastElement.getYear()) {
					return i;
			}
			}
		
		}return -1;
		}
	}


