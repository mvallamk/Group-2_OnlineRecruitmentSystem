package com.cg.orms.util;

import java.sql.Date;

public class DateUtility {
	
	public  static Date parseDate(Date dateFromPage)
	{
		Date modifiedDate = new Date(dateFromPage.getYear(),
				dateFromPage.getMonth(), dateFromPage.getDate());
		return modifiedDate;
	}

}
