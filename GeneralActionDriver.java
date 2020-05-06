import java.util.Scanner;
public class GeneralActionDriver{
	
	public static void main(String[] args){
		String continueSequence = "Y";
		while(continueSequence.equals("Y"))
			{
				String serviceName, fileName = "";
			try{
				Scanner scan = new Scanner(System.in);
				System.out.println("What is the AWS Service being used? (lowercase one word : Boto3 compatible formatting)\n");
				serviceName = scan.next();
				System.out.println("What is the AWS Service list used? (Exact file name)\n");
				fileName = scan.next();
				GeneralActionGenerator gg = new GeneralActionGenerator(fileName,serviceName);
				System.out.println("Do you want to continue? (capital Y to continue, anything else to quit)\n");
				continueSequence = scan.next();
			}
			catch(Exception e){e.printStackTrace();}
		}
}}