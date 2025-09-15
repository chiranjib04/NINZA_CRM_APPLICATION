package com.ninza.crm.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	

	public int randomNumberGenerator()
	{
		Random ran=new Random();
		int random = ran.nextInt(1000);
		return random;
	}

	public String getCurrentDate()
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");	
		sim.format(date);

		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 180);
		String expDate = sim.format(cal.getTime());
		System.out.println(expDate);
		return expDate;
	}
}
