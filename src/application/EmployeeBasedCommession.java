package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EmployeeBasedCommession extends CommessionEmployee {
	private double basedOnSalary;
	public EmployeeBasedCommession() {}
	public EmployeeBasedCommession(String first_name , String last_name , String date_of_birth , Address address , String phoneNumber , String email , String nationality , String designation , String education , Image employeePhoto ,double soldItemPerMonth , double basedOnSalary) throws MyException {
		super(first_name, last_name, date_of_birth, address, phoneNumber, email, nationality, designation, education, employeePhoto, soldItemPerMonth);
		setBasedOnSalary(basedOnSalary);
		this.setPayy(pay());
	}
	public double getBasedOnSalary() {
		return basedOnSalary;
	}
	public void setBasedOnSalary(double basedOnSalary) throws MyException {
		if (checkBased(basedOnSalary))
		this.basedOnSalary = basedOnSalary;
		else throw new MyException("Based");
	}
	public static boolean checkBased(double basedOnSalary) {
		return basedOnSalary>=0;
	}
	@Override
	public String toFile () {
		return "Employee Based Commession,"+super.toFile() + "," + super.getSoldItemsPerMonth()  + "," + basedOnSalary;
	}
	@Override
	public double pay() {
		return  (Math.round(super.pay() + basedOnSalary));
	}
	public static double pay1(double basedOnSalary , double soldItemsPerMonth) {
		return  (Math.round(CommessionEmployee.pay1(soldItemsPerMonth) + basedOnSalary));
	}
	
}
