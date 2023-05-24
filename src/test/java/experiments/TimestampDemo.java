//(https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s    1:10 min mark)


package experiments;

import java.util.Date;


public class TimestampDemo {

	
	public static void main(String[] args) {
		
		
		Date date = new Date();
	
	/*	
		//How to write normal code to remove colon and spaces (Method 1)
		String dateText = date.toString();
		String dateTextWithoutSpaces = dateText.replace(" ", "-");
		String dateTextWithoutSpacesAndColon = dateTextWithoutSpaces.replace(" ","-");
		
		System.out.println(dateTextWithoutSpacesAndColon);
		
	*/	
		
		
		
		//How to write with method casing, same code as lines 15-18... This is called Method Chain (https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s    1:10 min mark)
		System.out.println(date.toString().replace(" ","-").replace(":","-"));
		
		
		
		
	}
}
