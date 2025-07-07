package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SalariedEmployee extends Employee {
private double annualSalary;
public SalariedEmployee() {}
public SalariedEmployee (String first_name , String last_name , String date_of_birth , Address address , String phoneNumber , String email , String nationality , String designation , String education , Image employeePhoto , double annualSalary) throws MyException {
	super(first_name, last_name, date_of_birth, address, phoneNumber, email, nationality, designation, education, employeePhoto);
	setAnnualSalary(annualSalary);
	this.setPayy(pay());
}
public double getAnnualSalary() {
	return annualSalary;
}
public void setAnnualSalary(double annualSalary) throws MyException {
	if (validAnnual(annualSalary))
	this.annualSalary = annualSalary;
	else
	throw new MyException("Annual");
}
public static boolean validAnnual (double annualSalary) throws MyException {
	return annualSalary<=25000 && annualSalary >=4075;
}
@Override
public String toFile () {
	return "Salaried Employee,"+super.toFile() + ","+ annualSalary;
}
@Override
public double pay() {
	return Math.round((annualSalary/12.0)*100.0)/100.0;
}
public static double pay1(double annualSalary) {
	return Math.round((annualSalary/12.0)*100.0)/100.0;
}

}
