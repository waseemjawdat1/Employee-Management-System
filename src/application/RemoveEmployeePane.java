package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveEmployeePane {
int index =0;
Label empNo , firstName, lastName, dateOfBirth , address , email , designation , phoneNumber ,education , empType , type1,  type2 , salary;
ImageView empPhoto; 
TextField empNo1, firstName1, lastName1 , dateOfBirth1, address1,email1,designation1,phoneNumber1,education1,empType1 , type11 , type22 , salary1;
RadioButton phD , master ,bA , secondarySchool , primarySchool;
ToggleGroup radios;
Button next,prev,remove,back;
GridPane aboveLeft , combo;
HBox above,educations , arrows, actionsButton;
VBox aboveRight , all;
Stage s;
public RemoveEmployeePane(int i , Stage s) {
	this.s = s;
	defineLabels();
	defineTextFields();
	defineRadioButtons();
	defineButtons();
	makeGridPane();
	makeVBoxLeft();
	makeAbove();
	makeEducation();
	doneIt();
	index = i;
	if (index == 0) {
		prev.setVisible(false);
	}
	if (index == MyTableView.empList.size()-1) next.setVisible(false);
	if(MyTableView.empList.size()!=0)
	setText();
	prevAction();
	nextAction();
	removeAction();
	
}

private void defineLabels() {
	empNo = new StandardLabel("Employee No : ").getL();
	firstName = new StandardLabel("First Name : ").getL();
	lastName = new StandardLabel("Last Name : ").getL();
	dateOfBirth = new StandardLabel("Date Of Birth : ").getL();
	address = new StandardLabel("Address : ").getL();
	email = new StandardLabel("Email : ").getL();
	designation = new StandardLabel("Designation : ").getL();
	phoneNumber = new StandardLabel("Phone Number").getL();
	education  = new StandardLabel("Education : ").getL();
	empType = new StandardLabel("Employee Type : ").getL();
	type1 = new StandardLabel("Hours  : ").getL();
	type2 = new StandardLabel("Rate : ").getL();
	salary = new StandardLabel("Salary ; ").getL();
}
private void defineTextFields() {
	empNo1 = MyTextField.getTForRmove();
	firstName1 = MyTextField.getTForRmove();
	lastName1 = MyTextField.getTForRmove();
	dateOfBirth1 = MyTextField.getTForRmove();
	address1 = MyTextField.getTForRmove();
	email1 = MyTextField.getTForRmove();
	designation1 = MyTextField.getTForRmove();
	phoneNumber1 = MyTextField.getTForRmove();
	education1 = MyTextField.getTForRmove();
	empType1 = MyTextField.getTForRmove();
	type11 = MyTextField.getTForRmove();
	type22 = MyTextField.getTForRmove();
	salary1 = MyTextField.getTForRmove();
	
}
private void defineRadioButtons() {
	String radiost = "-fx-font-size: 14px; -fx-padding: 5 10; -fx-cursor: hand;";
	radios = new ToggleGroup();
	phD = new RadioButton("PhD");
	phD.setDisable(true);
	phD.setStyle(radiost);
	phD.setToggleGroup(radios);
	master = new RadioButton("Master");
	master.setDisable(true);
	master.setStyle(radiost);
	master.setToggleGroup(radios);
	bA = new RadioButton("B. A");
	bA.setToggleGroup(radios);
	bA.setStyle(radiost);
	bA.setDisable(true);
	secondarySchool = new RadioButton("Secondary School");
	secondarySchool.setStyle(radiost);
	secondarySchool.setToggleGroup(radios);
	secondarySchool.setDisable(true);
	primarySchool = new RadioButton("Primary School");
	primarySchool.setStyle(radiost);
	primarySchool.setToggleGroup(radios);
	primarySchool.setDisable(true);
}
private void defineButtons() {
	next = new MyButton(new Image ("next.png"), 1).getB1();
	next.setMinWidth(50);
	next.setMinHeight(50);
	prev= new MyButton(new Image ("prev.png"),1).getB1();
	prev.setMinWidth(50);
	prev.setMinHeight(50);
	remove = new MyButton(new Image ("removeEmployee.png"),1).getB1();
	back = new MyButton(new Image ("back.png") ,1).getB1();
	
}

private void makeGridPane () {
	aboveLeft = new GridPane ();
	aboveLeft.add(empNo, 0, 0);
	aboveLeft.add(empNo1, 1, 0);
	aboveLeft.add(firstName, 0, 1);
	aboveLeft.add(firstName1, 1, 1);
	aboveLeft.add(lastName, 0, 2);
	aboveLeft.add(lastName1, 1, 2);
	aboveLeft.add(dateOfBirth, 0, 3);
	aboveLeft.add(dateOfBirth1, 1, 3);
	aboveLeft.add(address, 0,4);
	aboveLeft.add(address1, 1,4);
	aboveLeft.add(email, 0, 5);
	aboveLeft.add(email1, 1, 5);
	aboveLeft.add(designation, 0, 6);
	aboveLeft.add(designation1, 1, 6);
	aboveLeft.add(phoneNumber, 0, 7);
	aboveLeft.add(phoneNumber1, 1, 7);
	aboveLeft.setPadding(new Insets(50));
	aboveLeft.setVgap(20);
}
private void makeVBoxLeft() {
	empPhoto = new ImageView(new Image("standardEmployee.png"));
	empPhoto.setFitHeight(250);
	empPhoto.setFitWidth(250);
	StackPane s = new StackPane (empPhoto);
	s.setAlignment(Pos.CENTER);
	combo = new GridPane();
	type11.setMaxWidth(70);
	type22.setMaxWidth(70);
	salary1.setMaxWidth(70);
	HBox h = new HBox (10);
	h.getChildren().addAll(empType , empType1);
	
	combo.add(type1, 0, 0);
	combo.add(type11, 1, 0);
	combo.add(type2, 2, 0);
	combo.add(type22, 3, 0);
	combo.add(salary, 4, 00);
	combo.add(salary1, 5, 0);
	VBox ch = new VBox (10);
	ch.getChildren().addAll(h,combo);
	
	combo.setVgap(20);
	combo.setHgap(10);
	aboveRight = new VBox (100);
	aboveRight.getChildren().addAll(s , ch);
	aboveRight.setPadding(new Insets(50));
}
private void makeAbove () {
	above = new HBox (300);
	above.getChildren().addAll(aboveLeft , aboveRight);
}
private void makeEducation() {
	educations = new HBox(5);
	educations.getChildren().addAll(education , phD ,master ,bA , secondarySchool,primarySchool );
	educations.setPadding(new Insets(50));
}
private void doneIt() {
	arrows = new HBox (30);
	arrows.setAlignment(Pos.CENTER);
	arrows.getChildren().addAll(prev , next);
	actionsButton = new HBox (800);
	actionsButton.getChildren().addAll(remove , back);
	actionsButton.setAlignment(Pos.CENTER);
	all = new VBox (10);
	all.getChildren().addAll(above , educations , arrows , actionsButton);
}
private void nextAction() {
	next.setOnAction(e->{
		if (index < MyTableView.empList.size()) {
			index++;
			setText();
			}
			if (index >= MyTableView.empList.size()-1) {
				next.setVisible(false);
			}
			if (index >=1) {
				prev.setVisible(true);
			}
	});
	
	
}
private void prevAction() {
	prev.setOnAction(e->{
		if (index >=1) {
			index--;
			setText();
			}
			if (index < MyTableView.empList.size()-1) {
				next.setVisible(true);
			}
			if (index == 0) {
				prev.setVisible(false);
			}
	});
	
	
}
private void setText() {
	empNo1.setText(MyTableView.empList.get(index).getEmpno());
	firstName1.setText(MyTableView.empList.get(index).getFirst_name());
	lastName1.setText(MyTableView.empList.get(index).getLast_name());
	dateOfBirth1.setText(MyTableView.empList.get(index).getDate_of_birth());
	address1.setText(MyTableView.empList.get(index).getAddress().toString());
	email1.setText(MyTableView.empList.get(index).getEmail());
	designation1.setText(MyTableView.empList.get(index).getDesignation());
	phoneNumber1.setText(MyTableView.empList.get(index).getPhoneNumber());
	if (MyTableView.empList.get(index).getEmployeePhoto() != null) {
		this.empPhoto.setImage(MyTableView.empList.get(index).getEmployeePhoto());
	}
	else this.empPhoto.setImage(new Image("standardEmployee.png"));
	salary1.setText(MyTableView.empList.get(index).pay()+"");
	if (MyTableView.empList.get(index) instanceof HourlyEmployee) {
		HourlyEmployee temp = (HourlyEmployee) MyTableView.empList.get(index);
		empType1.setText("Hourly Employee");
		type2.setVisible(true);
		type22.setVisible(true);
		type1.setText("Hours : ");
		type2.setText("Rate : ");
		type11.setText(temp.getHours()+"");
		type22.setText(temp.getRate()+"");
	}
	else if (MyTableView.empList.get(index) instanceof SalariedEmployee) {
		SalariedEmployee temp = (SalariedEmployee) MyTableView.empList.get(index);
		type1.setText("Annual Salary : ");
		empType1.setText("Salaried Employee");
		type11.setText(temp.getAnnualSalary()+"");
		type2.setVisible(false);
		type22.setVisible(false);

	}
	else if (MyTableView.empList.get(index) instanceof EmployeeBasedCommession) {
		EmployeeBasedCommession temp = (EmployeeBasedCommession) MyTableView.empList.get(index);
		empType1.setText("Employee Based Commession");
		type2.setVisible(true);
		type22.setVisible(true);
		type1.setText("Sold/Month : ");
		type2.setText("Basen On Salary : ");
		type11.setText(temp.getSoldItemsPerMonth()+"");
		type22.setText(temp.getBasedOnSalary()+"");
	}
	else if (MyTableView.empList.get(index) instanceof CommessionEmployee) {
		CommessionEmployee temp = (CommessionEmployee) MyTableView.empList.get(index);
		type1.setText("Sold/Month : ");
		empType1.setText("Commession Employee");
		type11.setText(temp.getSoldItemsPerMonth()+"");
		type2.setVisible(false);
		type22.setVisible(false);

	}
	
	primarySchool.setDisable(true);
	secondarySchool.setDisable(true);
	phD.setDisable(true);
	bA.setDisable(true);
	master.setDisable(true);
	
	if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(bA.getText())) {
		bA.setDisable(false);
		bA.setSelected(true);
	}
	else if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(master.getText())) {
		master.setDisable(false);
		master.setSelected(true);
	}
	else if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(phD.getText())) {
		phD.setDisable(false);
		phD.setSelected(true);
	}
	else if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(secondarySchool.getText())) {
		secondarySchool.setDisable(false);
		secondarySchool.setSelected(true);
	}
	else if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(primarySchool.getText())) {
		primarySchool.setDisable(false);
		primarySchool.setSelected(true);
	}
	
}
public void setIndex(int index) {
	this.index = index;
	setText();
	if (index == 0) {
		prev.setVisible(false);
	}
	if (index >=1) prev.setVisible(true);
	if (index < MyTableView.empList.size()-1) next.setVisible(true);
	if (index == MyTableView.empList.size()-1) next.setVisible(false);
}

private void removeAction () {
	this.remove.setOnAction(e-> {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setTitle("Remove Employee");
		a.setHeaderText(null);
		a.setContentText("Are you sure you want to remove employee with id : " + MyTableView.empList.get(index).getEmpno());
		ImageView temp = new ImageView(new Image ("removeEmployee.png"));
		temp.setFitHeight(50);
		temp.setFitWidth(50);
		a.setGraphic(temp);
		ButtonType choosen=  a.showAndWait().orElse(ButtonType.CANCEL);
		if (choosen == ButtonType.OK) {
		    MyTableView.empList.remove(index);
		    Main.empList.remove(index);
			Alert aa  = new Alert(AlertType.INFORMATION);
			aa.setTitle("Employee removed");
			aa.setHeaderText(null);
			aa.setContentText("Employee Removed Successfully");
			aa.setGraphic(temp);
			aa.showAndWait();
			if (MyTableView.empList.size() == 0) s.setScene(Main.view);
			else {
				if (index == MyTableView.empList.size()) index--;
				if (index == 0) {
					prev.setVisible(false);
				}
				if (index == MyTableView.empList.size()-1) next.setVisible(false);
				setText();
			}
		}
	});
	
	}
	

public Label getEmpNo() {
	return empNo;
}

public Label getFirstName() {
	return firstName;
}

public Label getLastName() {
	return lastName;
}

public Label getDateOfBirth() {
	return dateOfBirth;
}

public Label getAddress() {
	return address;
}

public Label getEmail() {
	return email;
}

public Label getDesignation() {
	return designation;
}

public Label getPhoneNumber() {
	return phoneNumber;
}

public Label getEducation() {
	return education;
}

public Label getEmpType() {
	return empType;
}

public Label getType1() {
	return type1;
}

public Label getType2() {
	return type2;
}

public ImageView getEmpPhoto() {
	return empPhoto;
}

public TextField getEmpNo1() {
	return empNo1;
}

public TextField getFirstName1() {
	return firstName1;
}

public TextField getLastName1() {
	return lastName1;
}

public TextField getDateOfBirth1() {
	return dateOfBirth1;
}

public TextField getAddress1() {
	return address1;
}

public TextField getEmail1() {
	return email1;
}

public TextField getDesignation1() {
	return designation1;
}

public TextField getPhoneNumber1() {
	return phoneNumber1;
}

public TextField getEducation1() {
	return education1;
}

public TextField getEmpType1() {
	return empType1;
}

public TextField getType11() {
	return type11;
}

public TextField getType22() {
	return type22;
}

public RadioButton getPhD() {
	return phD;
}

public RadioButton getMaster() {
	return master;
}

public RadioButton getbA() {
	return bA;
}

public RadioButton getSecondarySchool() {
	return secondarySchool;
}

public RadioButton getPrimarySchool() {
	return primarySchool;
}

public ToggleGroup getRadios() {
	return radios;
}

public Button getNext() {
	return next;
}

public Button getPrev() {
	return prev;
}

public Button getRemove() {
	return remove;
}

public Button getBack() {
	return back;
}

public GridPane getAboveLeft() {
	return aboveLeft;
}

public GridPane getCombo() {
	return combo;
}

public HBox getAbove() {
	return above;
}

public HBox getEducations() {
	return educations;
}

public HBox getArrows() {
	return arrows;
}

public HBox getActionsButton() {
	return actionsButton;
}

public VBox getAboveRight() {
	return aboveRight;
}

public VBox getAll() {
	return all;
}


}
