package screenshot;

import java.time.LocalDateTime;

public class DateAndTime {
public static void main(String[] args) {
	System.out.println("kg"+LocalDateTime.now().toString().replace(':', '-'));
	
	LocalDateTime timeStamp=LocalDateTime.now();
	//'-' is the special Character we
	System.out.println(timeStamp);
	String updatedTimeStamp = timeStamp.toString().replace(':', '-');
	System.out.println(updatedTimeStamp);
}
}