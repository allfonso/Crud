package net.yustinus.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CrudUtility {
	
	private static SimpleDateFormat sortDateSdf = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat longDateSdf = new SimpleDateFormat("dd MMMM yyyy");
	private static SimpleDateFormat mysqlDateSdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String sortDateFormat(Date date) {
		return sortDateSdf.format(date);
	}
	
	public static String logDateFormat(Date date) {
		return longDateSdf.format(date);
	}
	
	public static String mysqlDateFormat(Date date) {
		return mysqlDateSdf.format(date);
	}
	
	public static void main(String args[]) {
		Date date = new Date();
		System.out.println(mysqlDateSdf.format(date));
	}

}
