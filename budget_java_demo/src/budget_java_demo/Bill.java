package budget_java_demo;

import java.math.BigDecimal;
import java.util.Calendar;

public class Bill {
	private String name;
	private Calendar dueDate;
	private BigDecimal paymentAmount;
	
	Bill(String name, Calendar dueDate, BigDecimal paymentAmount){
		name = this.name;
		dueDate = this.dueDate;
		paymentAmount = this.paymentAmount;
	}
	
	public void setName(String name) {
		name = this.name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDueDate(Calendar dueDate) {
		dueDate = this.dueDate;
	}
	
	public Calendar getDueDate() {
		return dueDate;
	}
	
	public void setPaymentAmount(BigDecimal paymentAmount) {
		paymentAmount = this.paymentAmount;
	}
	
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}
}
