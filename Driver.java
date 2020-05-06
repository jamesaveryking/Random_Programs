import java.util.Scanner;

public class Driver{
	
	
	public static void main(String[] args){
		int number, iterations = 0;
		String reductive_operator = "";
			try{
			Scanner scan = new Scanner(System.in);
			System.out.println("What is the number?\n");
			number = scan.nextInt();
			System.out.println("What number of iterations?\n");
			iterations = scan.nextInt();
			System.out.println("Reduce by AND or OR? (Please Capitalize)");
			reductive_operator = scan.next();
			DigitReduction dgr = new DigitReduction(number, iterations, reductive_operator);
			}
			catch(Exception e)
			{
				System.out.println("Please give a valid input. Program will restart if input inputted improperly.\n");
			}
		}
}