/*
 * <Prog01_aOrderedList has the main method with the methods linearSearch, GetInputFile, readFile, printOutput& GetOutputFile>
 * 
 * CSC 1351 Programming Project No.1  Part A
 * 
 * Section 2
 * 
 * @ author Amy Tran
 * @ since 3/17/2024
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class Prog01_aOrderedList {
	static aOrderedList CarList;
	
	public static void main(String [] args) throws FileNotFoundException {
		
		Scanner UserPrompt = new Scanner(System.in);
		CarList = new aOrderedList();
		System.out.println("Enter input filename: ");
		
		Scanner input = GetInputFile(UserPrompt);
		
		boolean isNull = false;
		boolean hasMake =true; 
		
		try {
			if(input == null) {
				isNull = true; // checks if the Scanner that was return is null. Happens when user chooses to not enter a file.
			}
		}
		catch (Exception e) {
				isNull = true; // catches exceptions
			}
			if(isNull == false) {
				readFile(input); // if the Scanner is not null, it processes the input.
			try {
				Car car = (Car) CarList.get(0); 
				if( car.getMake()== null) { // checks if the first value of the array is null.
					hasMake = false;
				}
			}
			catch(Exception e ) { // catches exceptions
				hasMake = false;
				}
		
			if (hasMake == true) { // if the array is not null, it asks for the output file. 
				System.out.println("Enter output filename:");
				PrintWriter outputFile = GetOutputFile(UserPrompt);
				printOutput(outputFile);
			}
		}	
	}
		
	/*
	 * GetInputFile  - gets an input file and makes Car objects sorted them into an array of the aOrderedList class.
	 * @ param Scanner UserPrompt - gets an input file from the user to read. 
	 * @ return aOrderedList
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	
	public static Scanner GetInputFile(Scanner UserPrompt)throws FileNotFoundException{
			String fileName = UserPrompt.next();
			File inputFile = new File(fileName);
			String answer; 
			
			if(!inputFile.exists()) {
				System.out.printf("File specified %s does not exist. Would you like to continue? <Y/N>",fileName);
				answer= UserPrompt.next();
				
				if(answer.toUpperCase().contains("Y")){
					System.out.println("Enter input filename: ");
					return GetInputFile(UserPrompt);
					}
				
				else if(answer.toUpperCase().contains("N")){
					System.out.println("Program was terminated.");
					UserPrompt.close();
					throw new FileNotFoundException() ;
					}
				else {
					System.out.println("Answer given was not Y or N.");
					return GetInputFile(UserPrompt);
				}
			}
			if(inputFile.exists()) {
				Scanner scanInput = new Scanner(inputFile);
				return scanInput;
				
			}
			
			return null;

	}

	/*
	 * GetOutputFile  - gets an output file and prints the aOrderedList onto the output file.
	 * @ param aOrderedList carList- gets the aOrderedList from the input file.
	 * @ param Scanner UserPrompt - gets an output file from the user to output the data. 
	 * @ return File
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
		
	public static PrintWriter GetOutputFile (Scanner UserPrompt) throws FileNotFoundException{
		String fileOutput = UserPrompt.next();
		File outputFile = new File(fileOutput);

		
		while(!outputFile.exists()) {
			System.out.printf("File specified %s does not exist. Would you like to continue? <Y/N>",fileOutput);
			String answer= UserPrompt.next();
			
			if(answer.toUpperCase().contains("Y")){
				System.out.println("Enter output filename: ");
					return GetOutputFile(UserPrompt);
				}
			
			else if(answer.toUpperCase().contains("N")){
				System.out.println("Program was terminated.");
				UserPrompt.close();
				throw new FileNotFoundException();	
			}
			else {
				System.out.println("Answer given was not Y or N.");
				return GetOutputFile(UserPrompt);
			}
		}
		
		if(outputFile.exists()) {
			PrintWriter newFile = new PrintWriter(fileOutput);
			return newFile;
		}
		return null;

	}
	
	/*
	 * readFile  - reads an scanner object and make car objects from the file
	 * @ param Scanner file - takes a scanner object
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	
	public static void readFile (Scanner file ) throws FileNotFoundException{
		boolean isInt;
		while(file.hasNext()) {
		String carLine = file.nextLine();
		String []carInput = carLine.split(",");
		
		if(carInput[0].contains("A")){
		
		String make = carInput[1];
		int year = Integer.valueOf(carInput[2]);
		int price = Integer.valueOf(carInput[3]);
		
		Car newCar = new Car(make,year,price);
		
		CarList.add(newCar);
		}
		
		if(carInput[0].contains("D")){
			   try {
			        Integer.parseInt( carInput[1] );
			         isInt = true;
			    }
			    catch(NumberFormatException e ) {
			        isInt = false;
			    }
			   if (isInt == true) {
			 
				   int index = Integer.valueOf(carInput[1]);
				   CarList.remove(index);
			   }
			   else {
				   int year = Integer.valueOf(carInput[2]);
				   int indexa = linearSearch(CarList, carInput[1], year);
		
				   if(indexa != -1) {
					   CarList.remove(indexa);		
				   }
				   else {
			
				   }
			   }	
		}
	}System.out.println("Array was succesfully compiled.");
	}
	
	/*
	 * printOutput  - takes a PrintWriter and prints out the car Objects
	 * @ param Scanner file - takes a PrintWriter
	 * 
	 * CSC 1351 Programming Project No.1  Part A
	 * 
	 * Section 2
	 * 
	 * @ author Amy Tran
	 * @ since 3/17/2024
	 * 
	 */
	
	public static void printOutput (PrintWriter file) {
		file.println("Number of cars:\t " + CarList.getNumObjects()+"\n");
		for(int i =0; i< CarList.size(); i++) {
			if(CarList.get(i)==null) {
				
			}else {
			Car car = (Car) CarList.get(i); 
			file.printf("Make: %10s\nYear: %10d\nPrice:$ %,8d\n\n",car.getMake(),car.getYear(),car.getPrice());
			}
		}
		System.out.println("Output file successfully printed.");
		file.close();
	}
	

	/*
	 * linearSearch  - searches for an object in the aOrderedList.
	 * @param aOrderedList carList - the aOrderedList you want to search
	 * @param String make - the make of the car as a string.
	 * @ param int year - the year of the car as an int. 
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

	public static int linearSearch(aOrderedList carList, String make, int year){
	
	for(int i = 0; i < carList.size();i++) {
		Car car = (Car) carList.get(i); 
		if(carList.get(i)== null) {
			break;
		}
		else if(car.getMake().equals(make)) {
			if(car.getYear() == year) {
				return i;
			}
		}
	
		}return -1;
	}
	

}

