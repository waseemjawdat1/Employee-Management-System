package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HourlyEmployee extends Employee {
	private short hours;
	private float rate;
	public HourlyEmployee (String first_name , String last_name , String date_of_birth , Address address , String phoneNumber , String email , String nationality , String designation , String education , Image employeePhoto ,short hours , float rate) throws MyException {
		super(first_name, last_name, date_of_birth, address, phoneNumber, email, nationality, designation, education, employeePhoto);
		setHours(hours);
		setRate(rate);
		this.setPayy(pay());
	}
	public static boolean validRate (float rate) {
		return rate<=6 && rate >=2.5;
	}
	public static boolean validHours(short hours) {
		return hours <=288 && hours>=1;
	}
	
	public short getHours() {
		return hours;
	}
	public void setHours(short hours) throws MyException {
		if (validHours(hours))
		this.hours = hours;
		else throw new MyException("Hours");
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) throws MyException {
		if (validRate(rate))
		this.rate = rate;
		else throw new MyException("Rate");
	}
	@Override
	public double pay() {
		if (hours > 140) return Math.round((((140*rate) + ((hours-140)*(rate*1.7))))); 
		return (Math.round(hours*rate));
	}
	public static double pay1(short hours, float rate) {
		if (hours > 140) return Math.round((((140*rate) + ((hours-140)*(rate*1.7))))); 
		return (Math.round(hours*rate));
	}
	@Override
	public String toFile () {
		return "Hourly Employee,"+super.toFile() + ","+ hours + "," +rate;
	}
	@Override
	public String toString() {
		return "HourlyEmployee [ " + super.toString()  + " , hours=" + hours + ", rate=" + rate + ", toString()=" + "]";
	}
	
	
}
