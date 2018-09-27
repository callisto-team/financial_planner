package budgetExperimentalBuild;

import java.math.BigDecimal;
import java.util.Calendar;

public class Bill {
	private String ID; // bill name, this will help reference
	private Calendar dueDate; // object for due date
	private BigDecimal paymentAmount; // Big Decimal for accuracy
	private int daysTillDue; //used for sorting purposes
	
	public Bill(String ID, Calendar dueDate, BigDecimal paymentAmount) {
		this.ID = ID;
		this.dueDate = dueDate;
		this.paymentAmount = paymentAmount;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
	
	public Calendar getDueDate() {
		return dueDate;
	}
	
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}
	
	public Integer getDaysTillDue() {
		try {
			daysTillDue = CalendarOps.daysTill(Calendar.getInstance(), dueDate);
		} catch (PastDateException e) {
			System.err.println("Error : Past Date entered for " + ID + "'s Due date . . .");
		}
		return daysTillDue;
	}
}
