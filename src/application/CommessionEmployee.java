package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CommessionEmployee extends Employee {
private double soldItemsPerMonth;
public CommessionEmployee() {}
public CommessionEmployee(String first_name , String last_name , String date_of_birth , Address address , String phoneNumber , String email , String nationality , String designation , String education , Image employeePhoto ,double soldItemPerMonth) throws MyException {
	super(first_name, last_name, date_of_birth, address, phoneNumber, email, nationality, designation, education, employeePhoto);
	setSoldItemsPerMonth(soldItemPerMonth);
	this.setPayy(pay());
}

public double getSoldItemsPerMonth() {
	return soldItemsPerMonth;
}

public void setSoldItemsPerMonth(double soldItemsPerMonth) throws MyException {
	if (validateSalary(soldItemsPerMonth))
	this.soldItemsPerMonth = soldItemsPerMonth;
	else throw new MyException("Per Month");
}
public static boolean validateSalary (double soldItem) {
	return soldItem >=0;
}
@Override
public String toFile () {
	return "Commession Employee,"+super.toFile() + "," + soldItemsPerMonth;
}
@Override
public double pay() {
	if (soldItemsPerMonth >=2800 && soldItemsPerMonth <= 3755) return Math.round((soldItemsPerMonth*0.03));
	else if (soldItemsPerMonth>3755) return Math.round((soldItemsPerMonth*0.05));
	else return Math.round((soldItemsPerMonth*0.015));
}
public static double pay1(double soldItemsPerMonth) {
	if (soldItemsPerMonth >=2800 && soldItemsPerMonth <= 3755) return Math.round((soldItemsPerMonth*0.03));
	else if (soldItemsPerMonth>3755) return Math.round((soldItemsPerMonth*0.05));
	else return Math.round((soldItemsPerMonth*0.015));
}
}