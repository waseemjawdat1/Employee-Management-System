package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ReadButton {
FileChooser chooseFile;
public ReadButton (Button read , Stage s) {
	chooseFile = new FileChooser();
	chooseFile.setTitle("Select text file to raed it  ");
	chooseFile.getExtensionFilters().add(new ExtensionFilter("Only Text Files", "*.txt"));
	read.setOnAction(e->{
		File textFile = chooseFile.showOpenDialog(s);
		if (textFile != null) {
				readFromFile(textFile);
				Alert done  = new Alert (AlertType.INFORMATION);
				done.setTitle("File Read");
				done.setHeaderText(null);
				done.setContentText("");
				done.showAndWait();
			}
	});
	
}
public void readFromFile (File f) {
	ArrayList <Employee> readList = new ArrayList <>();
	try (Scanner in = new Scanner(f)){
		while (in.hasNextLine()) {
			try {
			String line = in.nextLine();	
			String data[] = line.split(",");
			String first_name = data[1].trim();
			String last_name = data[2].trim();
			String date = data[3].trim();
			String address1 = data[4].trim();
			String addressData[] = address1.split("-");
			String street  = addressData[0].trim();
			String city = addressData[1].trim();
			String country = addressData[2].trim();
			Address address = new Address(country, city, street);
			String phoneNumber = data[5].trim();
			String email  = data[6].trim();
			String nationallity = data[7].trim();
			String designation  =data[8].trim();
			String education  = data[9].trim();
			String path = data[10].trim();
			path = path.replace("\\", "/");
			if (!path.startsWith("file:/"))
			path = "file:/"+path;
			Image photo = null;
			try {
			 photo = new Image(path);
			}catch (Exception e) {}
			if (data[0].trim().equalsIgnoreCase("Hourly Employee")) {
				short hours = Short.parseShort(data[11].trim());
				float rate = Float.parseFloat(data[12].trim());
				HourlyEmployee h = new HourlyEmployee(first_name, last_name, date, address, phoneNumber, email, nationallity, designation, education, photo, hours, rate);
				readList.add(h);
			}
			else if (data[0].trim().equalsIgnoreCase("Salaried Employee")) {
				double annualSalary = Double.parseDouble(data[11].trim());
				SalariedEmployee s = new SalariedEmployee(first_name, last_name, date, address, phoneNumber, email, nationallity, designation, education, photo, annualSalary);
				readList.add(s);
			}
			else if (data[0].trim().equalsIgnoreCase("Commession Employee")) {
				double soldItemsPerMonth = Double.parseDouble(data[11].trim());
				CommessionEmployee c = new CommessionEmployee(first_name, last_name, date, address, phoneNumber, email, nationallity, designation, education, photo, soldItemsPerMonth);
				readList.add(c);
			}
			else if (data[0].trim().equalsIgnoreCase("Employee Based Commession")) {
				double soldItemsPerMonth = Double.parseDouble(data[11].trim());
				double basedOnSalary = Double.parseDouble(data[12].trim());
				EmployeeBasedCommession ee = new EmployeeBasedCommession(first_name, last_name, date, address, phoneNumber, email, nationallity, designation, education, photo, soldItemsPerMonth, basedOnSalary);
				readList.add(ee);
			}

			}
			catch (MyException e) {
				
			}
			catch (Exception e) {
			}
		}
		
	}catch (Exception e) {
		
	}
}

}
