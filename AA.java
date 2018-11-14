import java.util.Random;
import java.util.Arrays;

public class AA {
	
	int number_A;
	int number_D;
	int number_T;
	int number_S;
	
	int[] randomized_Algorithms;
	int[][] randomized_Devices;
	int[] randomized_Times;
	int[] randomized_Spaces;
	
	Object[] algorithms;
	Object[][] devices;
	Object[] times;
	Object[] spaces;

	Random generator = new Random();
	
	//constructors
	
	public AA(int algs, int devs, int times, int spaces){		
		number_A = algs;
		number_D = devs;
		number_T = times;
		number_S = spaces;
		
		randomized_Algorithms = new int[number_A];
		randomized_Devices = new int[number_D][5];
		randomized_Times = new int[number_T];
		randomized_Spaces = new int[number_S];		
	}
	
	public AA(){		
		number_A = 7;
		number_D = 21;
		number_T = 14;
		number_S = 7;
		
		randomized_Algorithms = new int[number_A];
		randomized_Devices = new int[number_D][5];
		randomized_Times = new int[number_T];
		randomized_Spaces = new int[number_S];
		
		//randomized_Algorithms = randomizer(randomized_Algorithms);
		randomized_Devices = randomizer(randomized_Devices);
		//randomized_Times = randomizer(randomized_Times);
		//randomized_Spaces = randomizer(randomized_Spaces);
		
	}	
	
	//randomize everything
	//check on algorithm for making a hashmap or array with no duplicates -- complexity could be greater with duplicates
	
	public int[] randomizer(int[] input)
	{
		for(int i=0; i<input.length; i++)
		{
			input[i] = generator.nextInt(input.length) + 1;
		}
		return input;
	}	
	
	public int[][] randomizer(int[][] input)
	{
		for(int i=0; i<input.length; i++)
		{
			input[i][0] = i+1;
			input[i][1] = generator.nextInt(input.length) + 1;
			input[i][2]=generator.nextInt(number_A)+1;
			input[i][3]=generator.nextInt(number_T)+1;
			input[i][4]=generator.nextInt(number_S)+1;
		}
		return input;
	}
	
	public String toString()
	{
		return "Devices)\t " + Arrays.deepToString(randomized_Devices);// + "\nDevices)\t " + Arrays.deepToString(randomized_Devices) + "\nSpaces)\t\t " + Arrays.toString(randomized_Spaces) + "\nTimes)\t\t " + Arrays.toString(randomized_Times);
	}
	
	public static void main(String[] args)
	{
		AA ex = new AA();
		System.out.println(ex.toString());
	}
	
	
}