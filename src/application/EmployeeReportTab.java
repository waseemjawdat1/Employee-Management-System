package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EmployeeReportTab {
	CheckBox totalSalaryreport1;
	TextField totalSalaryreport;
	Button firstName,lastName,education, salary , maxSalary;
	HBox above , buttons;
	VBox all;
	public EmployeeReportTab() {
		totalSalaryreport1 = new CheckBox("Show Total Salary");
		totalSalaryreport1.setStyle(
	                "-fx-font-size: 16px;" + 
	                "-fx-text-fill: #333333;" + 
	                "-fx-padding: 5 10 5 10;" + 
	                "-fx-border-color: #0078D7;" + 
	                "-fx-border-radius: 5;" +
	                "-fx-background-color: #f0f8ff;" +
	                "-fx-background-radius: 5;" + 
	                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 5, 0, 2, 2);" // Shadow effect
	        );

		totalSalaryreport1.setOnMouseEntered(e -> totalSalaryreport1.setStyle(
	                "-fx-font-size: 16px;" +
	                "-fx-text-fill: #0078D7;" + 
	                "-fx-padding: 5 10 5 10;" +
	                "-fx-border-color: #0053ba;" + 
	                "-fx-border-radius: 5;" +
	                "-fx-background-color: #e6f4ff;" + 
	                "-fx-background-radius: 5;" +
	                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 2, 2);"
	        ));
		totalSalaryreport1.setOnMouseExited(e -> totalSalaryreport1.setStyle(
	                "-fx-font-size: 16px;" +
	                "-fx-text-fill: #333333;" +
	                "-fx-padding: 5 10 5 10;" +
	                "-fx-border-color: #0078D7;" +
	                "-fx-border-radius: 5;" +
	                "-fx-background-color: #f0f8ff;" +
	                "-fx-background-radius: 5;" +
	                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 5, 0, 2, 2);"
	        ));
	        totalSalaryreport =MyTextField.getTForRmove();
		
		totalSalaryreport.setVisible(false);
		firstName = new MyButton("First Name").getB1();
		firstName.setId("first");
		lastName = new MyButton("Last Name").getB1();
		lastName.setId("last");
		education = new MyButton("Educatiom").getB1();
		education.setId("education");
		salary = new MyButton("Salary").getB1();
		salary.setId("salary");
		above = new HBox (30);
		above.getChildren().addAll(totalSalaryreport1 , totalSalaryreport);
		above.setAlignment(Pos.CENTER);
		buttons = new HBox (20);
		buttons.getChildren().addAll(firstName , lastName , education, salary);
		buttons.setAlignment(Pos.CENTER);
		maxSalary = new MyButton("Max Salary").getB1();
		maxSalary.setId("max");
		all = new VBox (100);
		all.getChildren().addAll(above ,maxSalary, buttons);
		all.setAlignment(Pos.CENTER);
		avgAction();
	}
	private void avgAction () {
		totalSalaryreport1.setOnAction(e->{
			if (totalSalaryreport1.isSelected()) {
				double totalSalary = 0;
				for (int i = 0 ;  i < MyTableView.empList.size(); i++) {
					totalSalary+= MyTableView.empList.get(i).pay();
				}
				totalSalaryreport.setText(totalSalary+"");
				totalSalaryreport.setVisible(true);
				}
			else totalSalaryreport.setVisible(false);
		});
	}
	public CheckBox getTotal() {
		return totalSalaryreport1;
	}
	public TextField getSalAvg() {
		return totalSalaryreport;
	}
	public Button getFirstName() {
		return firstName;
	}
	public Button getLastName() {
		return lastName;
	}
	public Button getEducation() {
		return education;
	}
	public Button getSalary() {
		return salary;
	}
	public HBox getAbove() {
		return above;
	}
	public HBox getButtons() {
		return buttons;
	}
	public VBox getAll() {
		return all;
	}
	
}
