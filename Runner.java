import java.util.Collection;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
* <h1>Number Range Summarizer</h1>
* The program takes a commma separated string of numbers.
* It groups or summarises any sequential portion of the string.
* 
* @author  Tawanda Matsika
* @version 1.0
* @since   2019-09-12
*/
public class Runner implements NumberRangeSummarizer{
	
	/**
	* This method is used to convert the string input to an ArrayList of numbers.
	* 
	* @param input This is a string of comma sepearated integers.
	* @return Collection (ArrayList) returns a list of integers
	*/
	public Collection<Integer> collect(String input){

		ArrayList<Integer> inputList = Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
		return inputList;
	 }

    /**
	* This method is used to summarize the Integer Collection.
	* 
	* @param input This is a string of comma sepearated integers.
	* @return String returns the summary string
	*/
    public String summarizeCollection(Collection<Integer> input){

    	ArrayList<Integer> list = input.stream().collect(Collectors.toCollection(ArrayList::new));
    	String str = "";
    	int i, start = 0;

        for( i = 1; i < list.size(); i++){
			if( list.get(i - 1) + 1 != list.get(i)){

				if(list.get(start)!= list.get(i-1)){
					str = str + list.get(start) + "-"+ list.get(i-1)+ ", ";
				}
				else {
					str = str + list.get(i-1)+ ", ";
				}
               start=i;
            }
        }       
        if(list.get(start) != list.get(i-1)){
        	str =str + list.get(start) + "-" + list.get(i-1);
        }
        else {
        	str =str + list.get(i-1);
        }
        return str;
    }

	public static void main(String [] args){

		Runner obj = new Runner();

		String str = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		System.out.println("Input : " + str);
		System.out.println("Results: " + obj.summarizeCollection(obj.collect(str)) + "\n");

		String str_1 = "1,2,3,6,7,8,12,13,14,15,21,22,23,24,31,32,33,39";
		System.out.println("Input : " + str_1 );
		System.out.println("Results: " + obj.summarizeCollection(obj.collect(str_1))+ "\n");

		String str_2 = "-1,0,1,5";
		System.out.println("Input : " + str_2 );
		System.out.println("Results: " + obj.summarizeCollection(obj.collect(str_2))+ "\n");

	}
}