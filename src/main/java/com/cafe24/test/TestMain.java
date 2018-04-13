package com.cafe24.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestMain {
	public static void main(String[] args) {
		String day = "19991212";
		/*DateTime date = DateTime.parse(
				day, DateTimeFormat.forPattern("yyyyMMdd"));*/
		/*DateTimeFormatter fm =DateTimeFormat.forPattern("yyyyMMdd");
		DateTime date = fm.parseDateTime("19991212");*/
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			cal.setTime(sdf.parse(day));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		int y = date.getYear();
		System.out.println(sdf.format(cal.getTime()));
	}
}
