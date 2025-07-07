package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyTableView {
	TableView<Employee> empTable;
	TableColumn<Employee, String> firstName;
	TableColumn<Employee, String> lastName;
	TableColumn<Employee, String> email;
	TableColumn<Employee, String> designation;
	TableColumn<Employee, String> dateOfBirth;
	TableColumn<Employee, String> education;
	TableColumn<Employee, String> phoneNumber;
	TableColumn<Employee, String> address;
	TableColumn<Employee, String> type;
	TableColumn<Employee, Double> salary;
	static ObservableList<Employee>empList;
	
	public MyTableView () {
		
		String style = "-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ";
		empTable = new TableView<>();
		firstName = new TableColumn<Employee, String>("First Name");
		lastName = new TableColumn<Employee, String>("Last Name");
		email = new TableColumn<Employee, String>("Email");
		designation = new TableColumn<Employee, String>("Designation");
		dateOfBirth = new TableColumn<Employee, String>("Date Of Birth");
		education = new TableColumn<Employee, String>("Education");
		phoneNumber = new TableColumn<Employee, String>("Phone Number");
		address = new TableColumn<Employee, String>("Address");
		type = new TableColumn<Employee, String>("Employee Type");
		salary = new TableColumn<Employee, Double>("Salary");
		empList = FXCollections.observableArrayList(Main.empList);
		firstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
		dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
		education.setCellValueFactory(new PropertyValueFactory<>("education"));
		phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		address.setCellValueFactory(new PropertyValueFactory<>("address1"));
		type.setCellValueFactory(new PropertyValueFactory<>("typee"));
		salary.setCellValueFactory(new PropertyValueFactory<>("payy"));
		empTable.getColumns().addAll(firstName , lastName, email , designation , dateOfBirth , education , phoneNumber , address , type , salary);
		for (int i = 0 ; i < empTable.getColumns().size(); i++) {
			empTable.getColumns().get(i).setStyle(style);
			empTable.getColumns().get(i).setSortable(false);
		}
			empTable.setItems(empList);
		 	empTable.setMinHeight(625);
		 	empTable.setMaxWidth(1500);
	        empTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}

	public TableView<Employee> getEmpTable() {
		return empTable;
	}

	public void setEmpTable(TableView<Employee> empTable) {
		this.empTable = empTable;
	}
	
}