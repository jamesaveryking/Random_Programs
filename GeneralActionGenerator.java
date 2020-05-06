import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GeneralActionGenerator{

	String[] Actions;
	String outputCombinations,actionCombinations,fileName,serviceName;
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Timestamp(System.currentTimeMillis()));
	
	//no parameter default constructor
	public GeneralActionGenerator(String fileN, String serviceN) throws Exception
	{
		fileName = fileN;
		serviceName = serviceN;
		writeOutput();
	}
	
	//reads in file with actions
	public boolean readInput() throws Exception
	{
		boolean inputRead = false;
		try {
            Scanner sc = new Scanner(new File(fileName));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  lines.add(sc.nextLine());
			}
			Actions = lines.toArray(new String[0]);
			inputRead = true;
        } catch (Exception ex) {
			System.err.println(ex);
		}
		return inputRead;
	}
	
	//does a combination of all AWS Actions within Boto3 based on file to create python script
	public String combineAll() throws Exception
	{	
		try{
		if(readInput())
		{
			actionCombinations="";
			for(int a=0;a<Actions.length;a++)
			{
				actionCombinations+="response = client."+Actions[a]+"\n";
			}
			outputCombinations=("import boto3 \nclient = boto3.client('"+serviceName+"') \n" + actionCombinations);	
		}
		else{outputCombinations+="Nothing";}}
		catch(Exception e)
		{
			outputCombinations+=e.toString();
		}
		return outputCombinations;
	}
	
	//outputs to file at specified directory
	public void writeOutput() throws Exception
	{
		try {
            File output = new File("C:/Users/jaking/OneDrive - Capgemini/Desktop/AWS Templates/General/Attempts/" + timeStamp + "_"+serviceName+"_Action_Attempt" + ".py");
            FileOutputStream outputStream = new FileOutputStream(output);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);    
            Writer writer = new BufferedWriter(outputStreamWriter);
            writer.write(combineAll());
            writer.close();
        } catch (Exception ex) {
			System.err.println(ex);
		}
	}
}

//Shiban
//cloud edge platform within Cap 