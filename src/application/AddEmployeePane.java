package application;

import javafx.collections.ObservableList;

import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddEmployeePane {
	Label empNo , firstName , lastName , dateOfBirth , designation , email , phoneNo , address , street , city , country , education , employeeType;
	static TextField empNo1;
	static TextField firstName1, lastName1,dateOfBirth1,designation1, email1 , phoneNo1, street1, city1, country1;
	RadioButton phD , master , b_a, secondarySchool , primarySchool;
	static Button  add , clear , back , addPhoto;
	static ObservableList<String> forCombo;
	static ComboBox<String> employeeType1;
	VBox overAll , aboveRight;
	GridPane info;
	static ToggleGroup g;
	static DatePicker date;
	static ImageView i;
	HBox above,address1,educationButtons,empType,bottomButtons;
	HBox s , c, co;
	public AddEmployeePane() {
		empNo = new StandardLabel("Employee No : ").getL();
		firstName = new StandardLabel("First Name : ").getL();
		lastName = new StandardLabel("Last Name : ").getL();
		dateOfBirth = new StandardLabel("Date Of Birth : ").getL();
		designation =  new StandardLabel("Designation : ").getL();
		email = new StandardLabel("Email : ").getL();
		phoneNo = new StandardLabel("Phone Number :" ).getL();
		address = new StandardLabel("Address : ").getL();
		street = new StandardLabel("Street : ").getL();
		city = new StandardLabel("City : ").getL();
		country = new StandardLabel("Country : ").getL();
		education = new StandardLabel("Education : ").getL();
		employeeType = new StandardLabel("Employee Type : ").getL();
		empNo1 = new MyTextField().getT();
		empNo1.setText(Employee.getEmpno1()+"");
		empNo1.setEditable(false);
		firstName1 = new MyTextField().getT();
		firstName1.setPromptText("First Name");
		lastName1 = new MyTextField().getT();
		lastName1.setPromptText("Last Name");
		dateOfBirth1 =new MyTextField().getT();
		designation1 = new MyTextField().getT();
		designation1.setPromptText( "Designation");
		email1 = new MyTextField().getT();
		email1.setPromptText("Email");
		phoneNo1 = new MyTextField().getT();
		phoneNo1.setPromptText("Phone Number");
		street1 = new MyTextField().getT();
		street1.setPromptText("Street");
		city1=  new MyTextField().getT();
		city1.setPromptText("City");
		country1 = new MyTextField().getT();
		country1.setPromptText("Country");
		date = new DatePicker();
		date.setStyle(
			    "-fx-background-color: white;" +
			    "-fx-background-radius: 6px;" +
			    "-fx-border-radius: 6px;" +
			    "-fx-border-color: #e5b8ff;" +
			    "-fx-border-width: 1px;" +
			    "-fx-font-size: 13px;"
			);
		gridInfo();
		s= new HBox();
		s.getChildren().addAll(street , street1);
		c = new HBox();
		c.getChildren().addAll(city , city1);
		co = new HBox ();
		co.getChildren().addAll(country , country1);
		address1 = new HBox (20);
		address1.getChildren().addAll(address , s , c , co);
		address1.setPadding(new Insets(0,0,0,100));
		String radiost = "-fx-font-size: 14px; -fx-padding: 5 10; -fx-cursor: hand;";
		 g = new ToggleGroup();
		phD = new RadioButton("PhD");
		phD.setToggleGroup(g);
		phD.setStyle(radiost);
		master = new RadioButton("Master");
		master.setStyle(radiost);
		master.setToggleGroup(g);
		b_a = new RadioButton("B. A");
		b_a.setStyle(radiost);
		b_a.setToggleGroup(g);
		secondarySchool = new RadioButton("Secondary School");
		secondarySchool.setStyle(radiost);
		secondarySchool.setToggleGroup(g);
		primarySchool = new RadioButton("Primary School");
		primarySchool.setStyle(radiost);
		primarySchool.setToggleGroup(g);
		educationButtons  =new HBox (20);
		educationButtons.getChildren().addAll(education , phD , master , b_a , secondarySchool  ,primarySchool);
		educationButtons.setPadding(new Insets(0,0,0,100));
		forCombo = FXCollections.observableArrayList("Hourly Employee", "Salaried Employee", "Commession Employee" , "Employee Based Commession");
		employeeType1 = new ComboBox<>(forCombo);
		String comboBoxSt = "-fx-font-size: 14px;-fx-padding: 5 10; -fx-background-color: white;-fx-border-color: #4CAF50;-fx-border-radius: 20;-fx-background-radius: 20;-fx-cursor: hand;";
		employeeType1.setStyle(comboBoxSt);
		employeeType1.setPromptText("Select Employee Type");
		//employeeType1.setValue("Hourly Employee");
		empType = new HBox ();
		empType.getChildren().addAll(employeeType , employeeType1);
		empType.setPadding(new Insets(0,0,0,100));
		add = new MyButton(new Image("AddEmployee.png"),1).getB1();
		clear = new MyButton(new Image("clear.png"),1).getB1();
		back = new MyButton(new Image("back.png"),1).getB1();
		bottomButtons = new HBox (100);
		bottomButtons.getChildren().addAll(add, clear , back);
		bottomButtons.setAlignment(Pos.CENTER);
		bottomButtons.setPadding(new Insets(0,0,0,100));
		 i = new ImageView (new Image ("standardEmployee.png"));
		  i.setFitWidth(300); 
	        i.setFitHeight(300);
		addPhoto = new MyButton(new Image("addphoto.png"),1).getB1();
		addPhoto.setAlignment(Pos.CENTER);
		addPhoto.setPrefWidth(300);
		aboveRight = new VBox (20);
		aboveRight.getChildren().addAll(i  ,addPhoto);
		aboveRight.setAlignment(Pos.TOP_RIGHT);
		overAll = new VBox (40);
		above = new HBox (500);
		above.setPadding(new Insets(0,0,0,100));
		above.getChildren().addAll(info , aboveRight);
	//	above.setAlignment(Pos.CENTER);
		overAll.getChildren().addAll(above , address1 , educationButtons , empType , bottomButtons);
		overAll.setPadding(new Insets(20));
		
	}
	public void gridInfo () {
		info = new GridPane();
		info.add(empNo, 0, 0);
		info.add(empNo1, 1, 0);
		info.add(firstName, 0, 1);
		info.add(firstName1, 1, 1);
		info.add(lastName, 0, 2);
		info.add(lastName1, 1, 2);
		info.add(dateOfBirth, 0, 3);
		info.add(date, 1,3);
		info.add(designation, 0, 4);
		info.add(designation1, 1,4);
		info.add(email, 0, 5);
		info.add(email1, 1, 5);
		info.add(phoneNo, 0, 6);
		info.add(phoneNo1, 1, 6);
		info.setVgap(20);
		info.setHgap(20);
		info.setPadding(new Insets(20));
		info.setAlignment(Pos.TOP_LEFT);
	}
	public static void clear () {
		firstName1.setText("");
		lastName1.setText("");
		dateOfBirth1.setText("");
		designation1.setText("");
		email1.setText("");
		phoneNo1.setText("");
		street1.setText("");
		city1.setText("");
		country1.setText("");
		g.selectToggle(null);
		i.setImage(new Image("standardEmployee.png"));
		date.setValue(null);
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
	public Label getDesignation() {
		return designation;
	}
	public Label getEmail() {
		return email;
	}
	public Label getPhoneNo() {
		return phoneNo;
	}
	public Label getAddress() {
		return address;
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
	public Label getEducation() {
		return education;
	}
	public Label getEmployeeType() {
		return employeeType;
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
	public TextField getDesignation1() {
		return designation1;
	}
	public TextField getEmail1() {
		return email1;
	}
	public TextField getPhoneNo1() {
		return phoneNo1;
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
	public RadioButton getPhD() {
		return phD;
	}
	public RadioButton getmaster() {
		return master;
	}
	public RadioButton getB_a() {
		return b_a;
	}
	public RadioButton getSecondarySchool() {
		return secondarySchool;
	}
	public RadioButton getPrimarySchool() {
		return primarySchool;
	}
	public static Button getAdd() {
		return add;
	}
	public static Button getClear() {
		return clear;
	}
	public static Button getBack() {
		return back;
	}
	public static Button getAddPhoto() {
		return addPhoto;
	}
	public ObservableList<String> getForCombo() {
		return forCombo;
	}
	public ComboBox<String> getEmployeeType1() {
		return employeeType1;
	}
	public VBox getOverAll() {
		return overAll;
	}
	public VBox getAboveRight() {
		return aboveRight;
	}
	public GridPane getInfo() {
		return info;
	}
	public ToggleGroup getG() {
		return g;
	}
	public HBox getAbove() {
		return above;
	}
	public HBox getAddress1() {
		return address1;
	}
	public HBox getEducationButtons() {
		return educationButtons;
	}
	public HBox getEmpType() {
		return empType;
	}
	public HBox getBottomButtons() {
		return bottomButtons;
	}
	public HBox getS() {
		return s;
	}
	public HBox getC() {
		return c;
	}
	public HBox getCo() {
		return co;
	}
	public static String checkNull () {
		StringBuilder res = new StringBuilder();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date1 = "";
		if (date.getValue()!=null)
		  date1 = date.getValue().format(format);
		
		 if (firstName1.getText() == null || !Employee.validNames(firstName1.getText())) res.append("First Name must be only characters\n");
		 if (lastName1.getText() == null|| !Employee.validNames(lastName1.getText()))res.append("First Name must be only characters\n");
		 if (date.getValue() == null || !Employee.validDate(date1))  res.append("employee must be at least 16 years old\n");
		 if (designation1.getText().isEmpty()) res.append("Desination cant be null\n");
		 if (email1.getText() == null || !Employee.validEmail(email1.getText())) res.append("Email must be like should be like ahmad12@server.domain\n");
		 if (phoneNo1.getText() == null || !Employee.validPhoneNumber(phoneNo1.getText()))res.append("Phone Number Must be only 9 digits\n");
		 if (street1.getText() == null || !Address.validate(street1.getText())) res.append("Street accepts be only characters or digits\n");
		 if (city1.getText() == null || !Address.validate(city1.getText())) res.append("City accepts be only characters or digits\n");
		 if (country1.getText() == null || !Address.validate(country1.getText())) res.append("Country accepts be only characters or digits\n");
		 if (g.getSelectedToggle() == null) res.append("Must select education\n");
		 if (employeeType1.getValue() == null)res.append("Must select the employee type\n");
		return res.toString();
	}
	public static Employee getObj () throws MyException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 String date1 = date.getValue().format(format);
		if (employeeType1.getValue().equals("Hourly Employee")) {
			HourlyEmployee h = new HourlyEmployee(firstName1.getText(), lastName1.getText(), date1, new Address(country1.getText(), city1.getText(), street1.getText()), phoneNo1.getText(), email1.getText(), "", designation1.getText(), ((RadioButton)(g.getSelectedToggle())).getText(), i.getImage(), (short)1, (short)2.5);
			return h;
		}
		else if (employeeType1.getValue().equals("Salaried Employee")) {
			SalariedEmployee s = new SalariedEmployee(firstName1.getText(), lastName1.getText(), date1, new Address(country1.getText(), city1.getText(), street1.getText()), phoneNo1.getText(), email1.getText(), "", designation1.getText(), ((RadioButton)(g.getSelectedToggle())).getText(), i.getImage(), 4075);
			return s;
		}
		else if (employeeType1.getValue().equals("Commession Employee")) {
			CommessionEmployee c = new CommessionEmployee(firstName1.getText(), lastName1.getText(), date1, new Address(country1.getText(), city1.getText(), street1.getText()), phoneNo1.getText(), email1.getText(), "", designation1.getText(), ((RadioButton)(g.getSelectedToggle())).getText(), i.getImage(), 0);
			return c;
		}
		else if (employeeType1.getValue().equals("Employee Based Commession")) {
			EmployeeBasedCommession e = new EmployeeBasedCommession(firstName1.getText(), lastName1.getText(), date1, new Address(country1.getText(), city1.getText(), street1.getText()), phoneNo1.getText(), email1.getText(), "", designation1.getText(), ((RadioButton)(g.getSelectedToggle())).getText(), i.getImage(), 0, 0);
			return e;
		}
		return null;
	}
}
