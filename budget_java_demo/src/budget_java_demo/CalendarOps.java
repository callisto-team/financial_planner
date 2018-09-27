package budget_java_demo;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

/*
 * This class was designed by Daniel De Leon to determine various
 * time differences between two Calendar Objects
 */
public class CalendarOps {
	public static int daysTill(Calendar c1, Calendar c2) throws PastDateException {
		//if c2 is a year in the past
		if(c1.get(Calendar.YEAR) > c2.get(Calendar.YEAR)) {
			throw new PastDateException("Error: Past date entered . . .");
		} else {
			return (int)ChronoUnit.DAYS.between(c1.toInstant(), c2.toInstant());
		}
	}
	
	
	public static int monthsTill(Calendar c1, Calendar c2) throws PastDateException {
		//month counter that keeps a running total
		int months = 0;
		
		// when c1 and c2 are in the same year and c2 is in a later month
		if(c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c2.get(Calendar.MONTH) > c1.get(Calendar.MONTH)) {
			int m1 = c1.get(Calendar.MONTH);
			int m2 = c2.get(Calendar.MONTH);
			
			months = m2 - m1;
			
			if(c1.get(Calendar.DAY_OF_MONTH) > c2.get(Calendar.DAY_OF_MONTH)) {
				months--;
			}
			
			return months;
		}
		
		// when c2 is in a past month but in the same year
		else if(c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c2.get(Calendar.MONTH) < c1.get(Calendar.MONTH)) {
			throw new PastDateException("Error: Past date entered . . .");
			}
		
		// when c2 is in another year and also in a further month in the future
		else if(c1.get(Calendar.YEAR) < c2.get(Calendar.YEAR) && c2.get(Calendar.MONTH) > c1.get(Calendar.MONTH)) {
			int yearDif = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			months += yearDif * 12;
			c2.set(Calendar.YEAR, c1.get(Calendar.YEAR));
			months += monthsTill(c1,c2);
			
			return months;
		}
		
		//when c2 is in another year but the same month
		else if(c1.get(Calendar.YEAR) < c2.get(Calendar.YEAR) && c2.get(Calendar.MONTH) == c1.get(Calendar.MONTH)) {
			int yearDif = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			months += yearDif * 12;
			
			if(c1.get(Calendar.DAY_OF_MONTH) > c2.get(Calendar.DAY_OF_MONTH)) {
				months--;
			}
			
			return months;
		}
		
		//when c2 is another year but a month before c1's month
		else if(c1.get(Calendar.YEAR) < c2.get(Calendar.YEAR) && c2.get(Calendar.MONTH) < c1.get(Calendar.MONTH)) {
			int yearDif = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			months += (yearDif - 1) * 12;
			c2.set(Calendar.YEAR, c1.get(Calendar.YEAR));
			
			months += 12 - monthsTill(c2, c1);
			
			if(c1.get(Calendar.DAY_OF_MONTH) > c2.get(Calendar.DAY_OF_MONTH)) {
				months--;
			}
			
			return months;
		}
		
		//when c2 is in a year in the past
		else if(c1.get(Calendar.YEAR) > c2.get(Calendar.YEAR)) {
			throw new PastDateException("Error: Past date entered . . .");
		}
		
		throw new PastDateException("Error: Past date entered . . .");
	}
	
	
	//a weeksTill method to determine the difference in weeks
	public static BigDecimal weeksTill(Calendar c1, Calendar c2) {
		int daysTill = 0; //variable for days
		
		try {
			daysTill += daysTill(c1, c2);
		} catch (PastDateException e) {
			System.err.print("Error: Past date entered . . .");
		} // get days till
		BigDecimal weeksTill = BigDecimal.valueOf((double)daysTill / 7); // set weekstill = daystill / 7
		
		return weeksTill;
	}
	
	
}