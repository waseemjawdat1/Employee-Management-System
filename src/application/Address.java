package application;

public class Address {
private String country;
private String city;
private String street;
public Address() {}
public Address(String country , String city, String street) {
	this.country = country;
	this.city = city;
	this.street = street;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public static boolean validate (String a) {
	if (a.isEmpty()) return false;
	for (int i = 0 ; i < a.length();i++) {
		if (!Character.isLetterOrDigit(a.charAt(i))) return false;
	}
	return true;
}
public String toFile () {
	return street+ "-" + city + "-" + country;
}
@Override
public String toString() {
	return (street + "/" + city + "/" + country);
}

}
