package javaUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class JavaUtilities {
	
	private JavaUtilities()
	{
		
	}
	
	public static String formatedDate()
	{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		return format.format(date);
	}
	
	public static void randomNumber()
	{
		
	}

}
