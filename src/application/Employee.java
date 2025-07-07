package application;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Employee {
private static int empno1 = 1;
private SimpleStringProperty empno;
private SimpleStringProperty first_name;
private SimpleStringProperty last_name;
private SimpleStringProperty date_of_birth;
private Address address;
private SimpleStringProperty phoneNumber;
private SimpleStringProperty email;
private SimpleStringProperty nationality;
private SimpleStringProperty designation;
private SimpleStringProperty education;
private Image employeePhoto;
private SimpleDoubleProperty payy;
private SimpleStringProperty address1;
private SimpleStringProperty typee;
public Employee () {
	empno = new SimpleStringProperty(empno1+"");
	empno1++;
}
public Employee (String first_name , String last_name , String date_of_birth , Address address , String phoneNumber , String email , String nationality , String designation , String education , Image employeePhoto) throws MyException {
	setFirst_name(first_name);
	setLast_name(last_name);
	setDate_of_birth(date_of_birth);
	setAddress(address);
	setPhoneNumber(phoneNumber);
	setEmail(email);
	setNationality(nationality);
	setDesignation(designation);
	setEducation(education);
	setEmployeePhoto(employeePhoto);
	empno = new SimpleStringProperty(empno1+"");
	empno1++;
	this.typee = new SimpleStringProperty(this.getClass().getSimpleName());
	this.address1 =  new SimpleStringProperty(address.getCity() + "/" + address.getCity() + "/" + address.getStreet());
}

public double getPayy() {
	return (double) (payy.getValue());
}
public void setPayy(double payy) {
	this.payy = new SimpleDoubleProperty(pay());
}
public String getAddress1() {
	return address1.getValue();
}
public String getTypee() {
	return typee.getValue();
}
public  String getEmpno() {
	return empno.getValue();
}
public  void setEmpno(String empno) {
	this.empno = new SimpleStringProperty(empno);
}
public String getFirst_name() {
	return first_name.getValue();
}
public void setFirst_name(String first_name) throws MyException {
	if (validNames(first_name))
	this.first_name = new SimpleStringProperty(first_name);
	else throw new MyException("First Name");
}
public String getLast_name() {
	return last_name.getValue();
}
public void setLast_name(String last_name) throws MyException {
	if (validNames(last_name))
	this.last_name = new SimpleStringProperty(last_name);
	else throw new MyException("Last Name");
}
public String getDate_of_birth() {
	return date_of_birth.getValue();
}
public void setDate_of_birth(String date_of_birth) throws MyException {
	if (validDate(date_of_birth))
	this.date_of_birth = new SimpleStringProperty(date_of_birth);
	else throw new MyException("Date");
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) throws MyException {
	if (validAddress(address))
	this.address = address;
	else throw new MyException("Address");
}
public String getPhoneNumber() {
	return phoneNumber.getValue();
}
public void setPhoneNumber(String phoneNumber) throws MyException {
	if (validPhoneNumber(phoneNumber))
	this.phoneNumber = new SimpleStringProperty(phoneNumber);
	else throw new MyException("Phone Number");
}
public String getEmail() {
	return email.getValue();
}
public void setEmail(String email) throws MyException {
	if (validEmail(email))
	this.email = new SimpleStringProperty(email);
	else throw new MyException("Email");
}
public String getNationality() {
	return nationality.getValue();
}
public void setNationality(String nationality) {
	this.nationality = new SimpleStringProperty(nationality);
}
public String getDesignation() {
	return designation.getValue();
}
public void setDesignation(String designation) {
	if (designation!=null)
	this.designation = new SimpleStringProperty(designation);
}
public String getEducation() {
	return education.getValue();
}
public void setEducation(String education) throws MyException {
	if (education.equalsIgnoreCase("B. A") || education.equalsIgnoreCase("Primary School") || education.equalsIgnoreCase("Secondary School") || education.equalsIgnoreCase("Master") || education.equalsIgnoreCase("PhD"))
	this.education = new SimpleStringProperty(education);
	else {
	throw new MyException("Education");
	}
	}

public Image getEmployeePhoto() {
	return employeePhoto;
}
public void setEmployeePhoto(Image employeePhoto) throws MyException {
	if (employeePhoto != null)
	this.employeePhoto = employeePhoto;
	else this.employeePhoto = new Image("standardEmployee.png");
}

public static int getEmpno1() {
	return empno1;
}
public static void setEmpno1(int empno1) {
	Employee.empno1 = empno1;
}
public static boolean validAddress(Address address) {
	if (Address.validate(address.getCity()) && Address.validate(address.getCountry()) && Address.validate(address.getStreet())) return true;
	else return false;
}
public static boolean validNames (String name) {
	if (name.isEmpty()) return false;
	for (int i = 0 ; i <name.length(); i++) {
		if (!Character.isLetter(name.charAt(i))) return false;
	}
	return true;
}
public static boolean validDate (String date) {
	if (date.isEmpty()) return false;
	Calendar now = new GregorianCalendar();
	String date_array[] = date.split("/");
	if (date_array.length != 3) return false;
	int day, month , year;
	try {
		 day = Integer.parseInt(date_array[0]);
		 month = Integer.parseInt(date_array[1]);
		 year = Integer.parseInt(date_array[2]);
		 
	}catch (Exception e) {
		
		return false;
	}
	Calendar userDate = new GregorianCalendar(year, month-1, day);
	if (userDate.after(now)) return false;
	int yearsOld = now.get(Calendar.YEAR) - userDate.get(Calendar.YEAR);
	if (yearsOld < 16) return false;
	if (now.get(Calendar.MONTH) < userDate.get(Calendar.MONTH))yearsOld--;
	else if (now.get(Calendar.MONTH) == userDate.get(Calendar.MONTH)) {
		if (now.get(Calendar.DATE) > userDate.get(Calendar.DATE)) yearsOld--;
	}
	
	return yearsOld >=16;
}
public static boolean validPhoneNumber (String phoneNumber) {
	if (phoneNumber.length() != 9 ) return false;
	if (!phoneNumber.startsWith("056") && !phoneNumber.startsWith("059")) return false;
	for (int i = 3 ; i < phoneNumber.length(); i++) {
		if (!Character.isDigit(phoneNumber.charAt(i))) return false;
	}
	return true;
}
public static boolean validEmail(String email) {
	if (email.isEmpty())return false;
	if (!email.contains("@")) return false;
	String array[] = email.split("@");
	if (!Character.isLetter(array[0].charAt(0))) return false;
	for (int i = 1; i < array[0].length(); i++) {
		if (!Character.isLetterOrDigit(array[0].charAt(i))) return false;
	}
	if (!array[1].equals("gmail.com")&& !array[1].equals("@outlook.com")&&!array[1].equals("yahoo.com") &&!array[1].equals("hotmail.com")) return false;
	return true;
}
public String toFile () {
	return first_name.get() +"," + last_name.get() + "," + date_of_birth.get() +"," + address.toFile() + "," + phoneNumber.get() + "," + email.get() + "," + nationality.get() + "," + designation.get() + "," + education.get() + "," + employeePhoto.getUrl();
}
public abstract double pay();


}
