public class DigitReduction{
	
	int input, iteration;
	String reduction = "";
	
	public DigitReduction(int i0, int i1, String reducer){
		input = i0;
		iteration = i1;
		reduction = reducer;
		if(reduction.equals("AND"))
		{
			rSystem.out.println(Integer.toString(reductionAnd(i0*i1)));
		}
		else if(reduction.equals("OR"))
		{
			System.out.println(Integer.toString(reductionOr(i0*i1)));
		}
		else{
			System.out.println("Invalid Input");
		}
		
	}
	
	public int reductionAnd(int i2){
		int output = 0;
		int i3 = Integer.toString(i2).length();
		if(i3>1)
		{
			for(int i=0; i<=i3; i++){
				output+=Integer.toString(i2).charAt(i);
			}
			reductionAnd(output);
		}
		return output;
	}
	
	public int reductionOr(int i2){
		int output = 0;
		int i3 = Integer.toString(i2).length();
		if(i3>1)
		{
			for(int i=0; i<=i3; i++){
				if(Integer.toString(i2).charAt(i)!='0'){
				output*=Integer.toString(i2).charAt(i);
				}
			}
			reductionOr(output);
		}
		return output;
	}
}