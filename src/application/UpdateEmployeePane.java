package application;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class UpdateEmployeePane {
	int index = 0;
	Label empNo, firstName, lastName, dateOfBirth, street, city, country, email, designation, phoneNumber, education,empType, type1, type2 , salary;
	ImageView empPhoto;
	TextField empNo1, firstName1, lastName1, street1, city1, country1, email1, designation1, phoneNumber1, education1,type11, type22 ,salary1;
	DatePicker dateOfBirth1;
	RadioButton phD, master, bA, secondarySchool, primarySchool;
	ToggleGroup radios;
	Button next, prev, update, back, addPhoto;
	GridPane aboveLeft, combo;
	HBox above, educations, arrows, actionsButton, center;
	VBox aboveRight, all, ss , ch;
	Stage s;
	ObservableList<String> forCombo;
	String hours, rate, annual_salary, basedOnSalary, soldPerMonth;
	ComboBox<String> employeeType1;

	public UpdateEmployeePane(int i, Stage s) throws Exception {
		dateOfBirth1 = new DatePicker();
		dateOfBirth1.setStyle(
			    "-fx-background-color: white;" +
			    "-fx-background-radius: 6px;" +
			    "-fx-border-radius: 6px;" +
			    "-fx-border-color: #e5b8ff;" +
			    "-fx-border-width: 1px;" +
			    "-fx-font-size: 13px;"
			);
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
		backAction();
		index = i;
		if (index == 0) {
			prev.setVisible(false);
		}
		if (index == MyTableView.empList.size() - 1)
			next.setVisible(false);
		if (MyTableView.empList.size() != 0)
			setText();
		prevAction();
		nextAction();
		updateAction();
		comboAction();
		addPhotoAction();
	}

	private Employee getObj() throws NumberFormatException, MyException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date1 = dateOfBirth1.getValue().format(format);
		if (employeeType1.getValue().equals("Hourly Employee")) {
			HourlyEmployee h = new HourlyEmployee(firstName1.getText(), lastName1.getText(), date1,new Address(country1.getText(), city1.getText(), street1.getText()), phoneNumber1.getText(),email1.getText(), "", designation1.getText(),((RadioButton) (radios.getSelectedToggle())).getText(), empPhoto.getImage(), Short.parseShort(type11.getText()),Float.parseFloat(type22.getText()));
			return h;
		} else if (employeeType1.getValue().equals("Salaried Employee")) {
			SalariedEmployee s = new SalariedEmployee(firstName1.getText(), lastName1.getText(), date1,new Address(country1.getText(), city1.getText(), street1.getText()), phoneNumber1.getText(),email1.getText(), "", designation1.getText(),((RadioButton) (radios.getSelectedToggle())).getText(), empPhoto.getImage(),Double.parseDouble(type11.getText()));
			return s;
		} else if (employeeType1.getValue().equals("Commession Employee")) {
			CommessionEmployee c = new CommessionEmployee(firstName1.getText(), lastName1.getText(), date1,new Address(country1.getText(), city1.getText(), street1.getText()), phoneNumber1.getText(),email1.getText(), "", designation1.getText(),((RadioButton) (radios.getSelectedToggle())).getText(), empPhoto.getImage(), Double.parseDouble(type11.getText()));
			return c;
		} else if (employeeType1.getValue().equals("Employee Based Commession")) {
			EmployeeBasedCommession e = new EmployeeBasedCommession(firstName1.getText(), lastName1.getText(), date1,new Address(country1.getText(), city1.getText(), street1.getText()), phoneNumber1.getText(),email1.getText(), "", designation1.getText(),((RadioButton) (radios.getSelectedToggle())).getText(), empPhoto.getImage(),Double.parseDouble(type11.getText()),Double.parseDouble(type22.getText()));
			return e;
		}
		return null;
	}

	private void addPhotoAction() {
		addPhoto.setOnAction(e -> {
			FileChooser pickPhoto = new FileChooser();
			pickPhoto.setTitle("Select Employee Photo");
			pickPhoto.getExtensionFilters().add(new ExtensionFilter("Only Images", "*.png", "*.jpg"));
			File photo = pickPhoto.showOpenDialog(s);
			if (photo != null) {
				String path = photo.toURI().toString();
				Image i = new Image(path);
				empPhoto.setImage(i);
			}
		});
	}

	public String checkNull() {
		StringBuilder res = new StringBuilder();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date1 = "";
		if (dateOfBirth1.getValue() != null)
			date1 = dateOfBirth1.getValue().format(format);

		if (firstName1.getText() == null || !Employee.validNames(firstName1.getText()))res.append("First Name must be only characters\n");
		if (lastName1.getText() == null || !Employee.validNames(lastName1.getText()))res.append("First Name must be only characters\n");
		if (dateOfBirth1.getValue() == null || !Employee.validDate(date1))res.append("employee must be at least 16 years old\n");
		if (designation1.getText() == null)res.append("Desination cant be null\n");
		if (email1.getText() == null || !Employee.validEmail(email1.getText()))res.append("Email must be like should be like ahmad12@server.domain\n");
		if (phoneNumber1.getText() == null || !Employee.validPhoneNumber(phoneNumber1.getText()))res.append("Phone Number Must be only 9 digits\n");
		if (street1.getText() == null || !Address.validate(street1.getText()))res.append("Street accepts be only characters or digits\n");
		if (city1.getText() == null || !Address.validate(city1.getText()))res.append("City accepts be only characters or digits\n");
		if (country1.getText() == null || !Address.validate(country1.getText()))res.append("Country accepts be only characters or digits\n");
		if (radios.getSelectedToggle() == null)res.append("Must select education\n");
		if (employeeType1.getValue() == null)res.append("Must select the employee type\n");
		if (employeeType1.getValue().equals("Hourly Employee")) {
			try {
			if (type11.getText() == null || !HourlyEmployee.validHours(Short.parseShort(type11.getText()))) res.append("Hours must be between 1 and 288\n");
			}catch (Exception ee) { res.append("Hours is not valid , only numbers bewtween 1 and 288\n");}
			try {
			if (type22.getText() == null || !HourlyEmployee.validRate(Float.parseFloat(type22.getText()))) res.append("Rate must be between 2.5 and 6\n");}
			catch (Exception ee) {res.append("Not valid rate , must be numbers between 2.5 and 6\n");}
		} else if (employeeType1.getValue().equals("Salaried Employee")) {
			try {
			if (type11.getText() == null || !SalariedEmployee.validAnnual(Double.parseDouble(type11.getText()))) res.append("Annual Salary must be between 4075 and 25000\n");}
			catch (Exception ee) {res.append("not Valid annual Salary , must be numbers between 4075 and 25000\n");}
		} else if (employeeType1.getValue().equals("Commession Employee")) {
			try {
			if (type11.getText() == null || Double.parseDouble(type11.getText())< 0) res.append("Sold Per month must be greater than or equal 0\n");}
			catch (Exception ee) { res.append("Not valid sold per month , must be numbers greater than or equal zero\n");}
		} else if (employeeType1.getValue().equals("Employee Based Commession")) {
			try {
			if (type11.getText() == null || Double.parseDouble(type11.getText())< 0) res.append("Sold Per month must be greater than or equal 0\n");}
			catch (Exception ee) { res.append("Not valid sold per month , must be numbers greater than or equal zero\n");}
			try {
			if (type22.getText() == null || Double.parseDouble(type22.getText()) < 0) res.append("Based on salary must be greater than or equal 0\n");}
			catch (Exception ee) { res.append("Not valid based on salary , must be numbers greater than or equal 0\n");}
		}
		return res.toString();
	}

	private void comboAction() {
		employeeType1.setOnAction(e -> {
			String type = employeeType1.getValue();
			if (type.equalsIgnoreCase("Hourly Employee")) {
				type11.setOnKeyTyped(null);
				type22.setOnKeyTyped(null);
				type11.setOnKeyTyped(ee->{
					try {
						if (HourlyEmployee.validHours(Short.parseShort(type11.getText()))&&HourlyEmployee.validRate(Float.parseFloat(type22.getText())) )
						salary1.setText(HourlyEmployee.pay1(Short.parseShort(type11.getText()) , Float.parseFloat(type22.getText()))+"");
						else salary1.setText("Not valid");
					}catch (Exception eee) {salary1.setText("Not Valid");}
				});
				type22.setOnKeyTyped(ee->{
					try {
						if (HourlyEmployee.validHours(Short.parseShort(type11.getText())) && HourlyEmployee.validRate(Float.parseFloat(type22.getText())) )
						salary1.setText(HourlyEmployee.pay1(Short.parseShort(type11.getText()) , Float.parseFloat(type22.getText()))+"");
						else salary1.setText("Not valid");
					}catch (Exception eee) {salary1.setText("Not Valid");}
				});
				type2.setVisible(true);
				type22.setVisible(true);
				type1.setText("Hours : ");
				type2.setText("Rate : ");
				type11.setText(hours);
				type22.setText(rate);
			} else if (type.equalsIgnoreCase("Salaried Employee")) {
				type11.setOnKeyTyped(null);
				type22.setOnKeyTyped(null);
				type11.setOnKeyTyped(ee->{
					try {
						if (SalariedEmployee.validAnnual(Double.parseDouble(type11.getText())))
						salary1.setText(SalariedEmployee.pay1(Double.parseDouble(type11.getText()))+"");
						else salary1.setText("Not valid");
					}catch (Exception eee) {salary1.setText("Not Valid");}
				});
				type1.setText("Annual Salary : ");
				type11.setText(annual_salary);
				type2.setVisible(false);
				type22.setVisible(false);

			} else if (type.equalsIgnoreCase("Employee Based Commession")) {
				type11.setOnKeyTyped(null);
				type22.setOnKeyTyped(null);
				type11.setOnKeyTyped(ee->{
					try {
						if (Double.parseDouble(type11.getText()) >=0 && Double.parseDouble(type22.getText()) >=0)
						salary1.setText(EmployeeBasedCommession.pay1(Double.parseDouble(type11.getText()) , Double.parseDouble(type22.getText()))+"");
						else salary1.setText("Not valid");
					}catch (Exception eee) {salary1.setText("Not Valid");}
				});
				type22.setOnKeyTyped(ee->{
					try {
						if (Double.parseDouble(type11.getText()) >=0 && Double.parseDouble(type22.getText()) >=0)
						salary1.setText(EmployeeBasedCommession.pay1(Double.parseDouble(type11.getText()) , Double.parseDouble(type22.getText()))+"");
						else salary1.setText("Not valid");
					}catch (Exception eee) {salary1.setText("Not Valid");}
				});
				type2.setVisible(true);
				type22.setVisible(true);
				type1.setText("Sold/Month : ");
				type2.setText("Based On Salary : ");
				type11.setText(soldPerMonth);
				type22.setText(basedOnSalary);
			} else if (type.equalsIgnoreCase("Commession Employee")) {
				type11.setOnKeyTyped(null);
				type22.setOnKeyTyped(null);
				type11.setOnKeyTyped(ee->{
					try {
						if (Double.parseDouble(type11.getText()) >=0)
						salary1.setText(CommessionEmployee.pay1(Double.parseDouble(type11.getText()))+"");
						else salary1.setText("Not valid");
					}catch (Exception eee) {salary1.setText("Not Valid"); }
				});
				type1.setText("Sold/Month : ");
				type11.setText(soldPerMonth);
				type2.setVisible(false);
				type22.setVisible(false);

			}
		});
	}

	private void defineLabels() {
		empNo = new StandardLabel("Employee No : ").getL();
		firstName = new StandardLabel("First Name : ").getL();
		lastName = new StandardLabel("Last Name : ").getL();
		dateOfBirth = new StandardLabel("Date Of Birth : ").getL();
		street = new StandardLabel("Street : ").getL();
		city = new StandardLabel("City : ").getL();
		country = new StandardLabel("Country : ").getL();
		email = new StandardLabel("Email : ").getL();
		designation = new StandardLabel("Designation : ").getL();
		phoneNumber = new StandardLabel("Phone Number : ").getL();
		education = new StandardLabel("Education : ").getL();
		empType = new StandardLabel("Employee Type : ").getL();
		type1 = new StandardLabel("Hours  : ").getL();
		type2 = new StandardLabel("Rate : ").getL();
		salary = new StandardLabel("Salary : ").getL();
	}

	private void defineTextFields() {
		forCombo = FXCollections.observableArrayList("Hourly Employee", "Salaried Employee", "Commession Employee",
				"Employee Based Commession");
		employeeType1 = new ComboBox<>(forCombo);
		String comboBoxSt = "-fx-font-size: 14px;-fx-padding: 5 10; -fx-background-color: white;-fx-border-color: #4CAF50;-fx-border-radius: 20;-fx-background-radius: 20;-fx-cursor: hand;";
		employeeType1.setStyle(comboBoxSt);
		empNo1 = MyTextField.getTForRmove();
		firstName1 = new MyTextField().getT();
		lastName1 = new MyTextField().getT();
		street1 = new MyTextField().getT();
		city1 = new MyTextField().getT();
		country1 = new MyTextField().getT();
		email1 = new MyTextField().getT();
		designation1 = new MyTextField().getT();
		phoneNumber1 = new MyTextField().getT();
		education1 = new MyTextField().getT();
		type11 = new MyTextField().getT();
		type22 = new MyTextField().getT();
		salary1 = MyTextField.getTForRmove();

	}

	private void defineRadioButtons() {
		String radiost = "-fx-font-size: 14px; -fx-padding: 5 10; -fx-cursor: hand;";
		radios = new ToggleGroup();
		phD = new RadioButton("PhD");
		phD.setStyle(radiost);
		phD.setToggleGroup(radios);
		master = new RadioButton("Master");
		master.setStyle(radiost);
		master.setToggleGroup(radios);
		bA = new RadioButton("B. A");
		bA.setToggleGroup(radios);
		bA.setStyle(radiost);
		secondarySchool = new RadioButton("Secondary School");
		secondarySchool.setStyle(radiost);
		secondarySchool.setToggleGroup(radios);
		primarySchool = new RadioButton("Primary School");
		primarySchool.setStyle(radiost);
		primarySchool.setToggleGroup(radios);
	}

	private void defineButtons() {
		next = new MyButton(new Image("next.png"), 1).getB1();
		addPhoto = new MyButton(new Image("addphoto.png"), 1).getB1();
		addPhoto.setMinWidth(250);
		next.setMinWidth(50);
		next.setMinHeight(50);
		prev = new MyButton(new Image("prev.png"), 1).getB1();
		prev.setMinWidth(50);
		prev.setMinHeight(50);
		update = new MyButton(new Image("update.png"), 1).getB1();
		back = new MyButton(new Image("back.png"), 1).getB1();

	}

	private void backAction() {
		this.back.setOnAction(e -> {
			this.s.setScene(Main.view);
		});
	}

	private void makeGridPane() {
		aboveLeft = new GridPane();
		aboveLeft.add(empNo, 0, 0);
		aboveLeft.add(empNo1, 1, 0);
		aboveLeft.add(firstName, 0, 1);
		aboveLeft.add(firstName1, 1, 1);
		aboveLeft.add(lastName, 0, 2);
		aboveLeft.add(lastName1, 1, 2);
		aboveLeft.add(dateOfBirth, 0, 3);
		aboveLeft.add(dateOfBirth1, 1, 3);
		aboveLeft.add(phoneNumber, 0, 4);
		aboveLeft.add(phoneNumber1, 1, 4);
		aboveLeft.add(email, 0, 5);
		aboveLeft.add(email1, 1, 5);
		aboveLeft.add(designation, 0, 6);
		aboveLeft.add(designation1, 1, 6);
		aboveLeft.add(street, 0, 7);
		aboveLeft.add(street1, 1, 7);
		aboveLeft.add(city, 2, 7);
		aboveLeft.add(city1, 3, 7);
		aboveLeft.add(country, 4, 7);
		aboveLeft.add(country1, 5, 7);
		aboveLeft.setPadding(new Insets(50));
		aboveLeft.setHgap(10);
		aboveLeft.setVgap(20);
	}

	private void makeVBoxLeft() {
		empPhoto = new ImageView(new Image("standardEmployee.png"));
		empPhoto.setFitHeight(250);
		empPhoto.setFitWidth(250);
		ss = new VBox(10);
		ss.getChildren().addAll(empPhoto, addPhoto);
		ss.setAlignment(Pos.CENTER);
		combo = new GridPane();
		type11.setMaxWidth(70);
		type22.setMaxWidth(70);
		salary1.setMaxWidth(150);
		HBox h = new HBox (10);
		h.getChildren().addAll(empType , employeeType1);
		combo.add(type1, 0, 0);
		combo.add(type11, 1, 0);
		combo.add(type2, 2, 0);
		combo.add(type22, 3, 0);
		combo.add(salary, 4, 00);
		combo.add(salary1, 5, 0);
		ch = new VBox (10);
		ch.getChildren().addAll(h,combo);
		// aboveRight = new VBox (100);
//	aboveRight.getChildren().addAll(s , combo);
		// aboveRight.setPadding(new Insets(20));
	}

	private void makeAbove() {
		above = new HBox(150);
		above.getChildren().addAll(aboveLeft, ss);
	}

	private void makeEducation() {
		educations = new HBox(5);
		educations.getChildren().addAll(education, phD, master, bA, secondarySchool, primarySchool);
		educations.setPadding(new Insets(50));
		center = new HBox(10);
		center.getChildren().addAll(educations, ch);

	}

	private void doneIt() {
		arrows = new HBox(30);
		arrows.setAlignment(Pos.CENTER);
		arrows.getChildren().addAll(prev, next);
		actionsButton = new HBox(800);
		actionsButton.getChildren().addAll(update, back);
		actionsButton.setAlignment(Pos.CENTER);
		all = new VBox(10);
		all.getChildren().addAll(above, center, arrows, actionsButton);
	}

	private void nextAction() {
		next.setOnAction(e -> {
			if (index < MyTableView.empList.size()) {
				index++;
				setText();
			}
			if (index >= MyTableView.empList.size() - 1) {
				next.setVisible(false);
			}
			if (index >= 1) {
				prev.setVisible(true);
			}
		});

	}

	private void prevAction() {
		prev.setOnAction(e -> {
			if (index >= 1) {
				index--;
				setText();
			}
			if (index < MyTableView.empList.size() - 1) {
				next.setVisible(true);
			}
			if (index == 0) {
				prev.setVisible(false);
			}
		});

	}

	private void setText() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate datee = LocalDate.parse(MyTableView.empList.get(index).getDate_of_birth(), formatter);
		empNo1.setText(MyTableView.empList.get(index).getEmpno());
		firstName1.setText(MyTableView.empList.get(index).getFirst_name());
		lastName1.setText(MyTableView.empList.get(index).getLast_name());
		dateOfBirth1.setValue(datee);
		email1.setText(MyTableView.empList.get(index).getEmail());
		designation1.setText(MyTableView.empList.get(index).getDesignation());
		phoneNumber1.setText(MyTableView.empList.get(index).getPhoneNumber());
		street1.setText(MyTableView.empList.get(index).getAddress().getStreet());
		city1.setText(MyTableView.empList.get(index).getAddress().getCity());
		country1.setText(MyTableView.empList.get(index).getAddress().getCountry());
		if (MyTableView.empList.get(index).getEmployeePhoto() != null) {
			this.empPhoto.setImage(MyTableView.empList.get(index).getEmployeePhoto());
		} else
			this.empPhoto.setImage(new Image("standardEmployee.png"));
		if (MyTableView.empList.get(index) instanceof HourlyEmployee) {
			HourlyEmployee temp = (HourlyEmployee) MyTableView.empList.get(index);
			employeeType1.setValue("Hourly Employee");
			type2.setVisible(true);
			type22.setVisible(true);
			type1.setText("Hours : ");
			type2.setText("Rate : ");
			type11.setText(temp.getHours() + "");
			type22.setText(temp.getRate() + "");
			hours = type11.getText();
			rate = type22.getText();
			annual_salary = "";
			basedOnSalary = "";
			soldPerMonth = "";
			salary1.setText(temp.pay()+"");
		} else if (MyTableView.empList.get(index) instanceof SalariedEmployee) {
			SalariedEmployee temp = (SalariedEmployee) MyTableView.empList.get(index);
			employeeType1.setValue("Salaried Employee");
			type1.setText("Annual Salary : ");
			type11.setText(temp.getAnnualSalary() + "");
			type2.setVisible(false);
			type22.setVisible(false);
			hours = "";
			rate = "";
			annual_salary = type11.getText();
			basedOnSalary = "";
			soldPerMonth = "";
			salary1.setText(temp.pay()+"");	
		} else if (MyTableView.empList.get(index) instanceof EmployeeBasedCommession) {
			EmployeeBasedCommession temp = (EmployeeBasedCommession) MyTableView.empList.get(index);
			employeeType1.setValue("Employee Based Commession");
			type2.setVisible(true);
			type22.setVisible(true);
			type1.setText("Sold/Month : ");
			type2.setText("Based On Salary : ");
			type11.setText(temp.getSoldItemsPerMonth() + "");
			type22.setText(temp.getBasedOnSalary() + "");
			hours = "";
			rate = "";
			annual_salary = "";
			basedOnSalary = type22.getText();
			soldPerMonth = type11.getText();
			salary1.setText(temp.pay()+"");

		} else if (MyTableView.empList.get(index) instanceof CommessionEmployee) {
			CommessionEmployee temp = (CommessionEmployee) MyTableView.empList.get(index);
			employeeType1.setValue("Commession Employee");
			type1.setText("Sold/Month : ");
			type11.setText(temp.getSoldItemsPerMonth() + "");
			type2.setVisible(false);
			type22.setVisible(false);
			hours = "";
			rate = "";
			annual_salary = "";
			basedOnSalary = "";
			soldPerMonth = type11.getText();
			salary1.setText(temp.pay()+"");


		}

		if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(bA.getText())) {
			bA.setSelected(true);
		} else if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(master.getText())) {
			master.setSelected(true);
		} else if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(phD.getText())) {
			phD.setSelected(true);
		} else if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(secondarySchool.getText())) {
			secondarySchool.setSelected(true);
		} else if (MyTableView.empList.get(index).getEducation().equalsIgnoreCase(primarySchool.getText())) {
			primarySchool.setSelected(true);
		}

	}

	public void setIndex(int index) {
		this.index = index;
		setText();
		if (index == 0) {
			prev.setVisible(false);
		}
		if (index >= 1)
			prev.setVisible(true);
		if (index < MyTableView.empList.size() - 1)
			next.setVisible(true);
		if (index == MyTableView.empList.size() - 1)
			next.setVisible(false);
	}

	private void updateAction() throws Exception {
		this.update.setOnAction(e -> {
			if (checkNull().isEmpty()) {
				Alert a = new Alert(AlertType.CONFIRMATION);
				a.setTitle("Update Employee");
				a.setHeaderText(null);
				a.setContentText("Are you sure you want to update employee with id : "
						+ MyTableView.empList.get(index).getEmpno());
				ImageView temp = new ImageView(new Image("update.png"));
				temp.setFitHeight(50);
				temp.setFitWidth(50);
				a.setGraphic(temp);
				ButtonType res = a.showAndWait().orElse(ButtonType.CANCEL);
				if (res == ButtonType.OK) {
					//MyTableView.empList.remove(index);
					//Main.empList.remove(index);
					Alert aa = new Alert(AlertType.INFORMATION);
					aa.setTitle("Employee Updated");
					aa.setHeaderText(null);
					aa.setContentText("Employee Updated Successfully");
					aa.setGraphic(temp);
					aa.showAndWait();
					Employee toUpdate = null;
					try {
						toUpdate = getObj();
					} catch (NumberFormatException e1) {
					} catch (MyException e1) {
					}
					String num = MyTableView.empList.get(index).getEmpno();
					MyTableView.empList.set(index, toUpdate);
					Main.empList.set(index, toUpdate);
					toUpdate.setEmpno(num);
					setText();
				}
			}
				else {
					Alert aa =  new Alert(AlertType.ERROR);
					aa.setTitle("Not Valid Input");
					aa.setContentText(checkNull());
					aa.setHeaderText(null);
					ImageView i  = new ImageView(new Image("update.png"));
					i.setFitHeight(50);
					i.setFitWidth(50);
					aa.setGraphic(i);
					aa.showAndWait();
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

	public int getIndex() {
		return index;
	}

	public Label getStreet() {
		return street;
	}

	public Label getCity() {
		return city;
	}

	public Label getCountry() {
		return country;
	}

	public TextField getStreet1() {
		return street1;
	}

	public TextField getCity1() {
		return city1;
	}

	public TextField getCountry1() {
		return country1;
	}

	public DatePicker getDateOfBirth1() {
		return dateOfBirth1;
	}

	public Button getAddPhoto() {
		return addPhoto;
	}

	public HBox getCenter() {
		return center;
	}

	public VBox getSs() {
		return ss;
	}

	public Stage getS() {
		return s;
	}

	public ObservableList<String> getForCombo() {
		return forCombo;
	}

	public String getHours() {
		return hours;
	}

	public String getRate() {
		return rate;
	}

	public String getAnnual_salary() {
		return annual_salary;
	}

	public String getBasedOnSalary() {
		return basedOnSalary;
	}

	public String getSoldPerMonth() {
		return soldPerMonth;
	}

	public ComboBox<String> getEmployeeType1() {
		return employeeType1;
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

	public Button getUpdate() {
		return update;
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
