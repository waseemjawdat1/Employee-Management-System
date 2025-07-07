package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortedTableView {
	TableView <Employee> sortedTable;
	TableColumn<Employee, String>firstName;
	TableColumn<Employee, String>lastName;
	TableColumn<Employee, String> email;
	TableColumn<Employee, String> designation;
	TableColumn<Employee, String> dateOfBirth;
	TableColumn<Employee, String> education;
	TableColumn<Employee, String> phoneNumber;
	TableColumn<Employee, String> address;
	TableColumn<Employee, String> type;
	TableColumn<Employee, Double> salary;
	ObservableList<Employee> sorted;

	
	Label first , last ,education1 , salary1 , max;
	Button back;
	StackPane stack1 , stack2;
	VBox all;
	HBox above;
	int i = 0;
	public SortedTableView(Stage stage) {
		String style = "-fx-background-color: #E5D9F2;-fx-border-color: #A294F9; -fx-text-fill: black;-fx-font-family: 'Montserrat'; ";
		back =  new MyButton(new Image("back.png") , 1).getB1();
		back.setOnAction(e->{
			stage.setScene(Main.main);
		});
		stack2 = new StackPane();
		stack2.getChildren().add(back);
		stack2.setAlignment(Pos.CENTER_RIGHT);
		above = new HBox ();
		sortedTable = new TableView <>();
		firstName = new TableColumn<Employee, String>("First Name");
		lastName = new TableColumn<Employee, String> ("Last Name");
		firstName.setCellValueFactory(new PropertyValueFactory<Employee, String>("first_name"));
		lastName.setCellValueFactory(new PropertyValueFactory<Employee, String>("last_name"));
		email = new TableColumn<Employee, String>("Email");
		designation = new TableColumn<Employee, String>("Designation");
		dateOfBirth = new TableColumn<Employee, String>("Date Of Birth");
		education = new TableColumn<Employee, String>("Education");
		phoneNumber = new TableColumn<Employee, String>("Phone Number");
		address = new TableColumn<Employee, String>("Address");
		type = new TableColumn<Employee, String>("Employee Type");
		salary = new TableColumn<Employee, Double>("Salary");
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
		dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
		education.setCellValueFactory(new PropertyValueFactory<>("education"));
		phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		address.setCellValueFactory(new PropertyValueFactory<>("address1"));
		type.setCellValueFactory(new PropertyValueFactory<>("typee"));
		salary.setCellValueFactory(new PropertyValueFactory<>("payy"));
		sortedTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		sortedTable.setMinHeight(700);
		sortedTable.setMaxWidth(1500);
		StackPane stack3 = new StackPane(sortedTable);
		stack3.setAlignment(Pos.CENTER);
		sortedTable.getColumns().addAll(firstName , lastName , email , designation , dateOfBirth , education , phoneNumber , address, type , salary);
		for (int i = 0 ; i < sortedTable.getColumns().size(); i++) {
			sortedTable.getColumns().get(i).setStyle(style);
			sortedTable.getColumns().get(i).setSortable(false);
		}
		first = new StandardLabel("Sort By First Name" ,1).getL();
		last = new StandardLabel("Sort By Last Name",1).getL();
		education1 =  new StandardLabel("Sort By Education",1).getL();
		salary1 =  new StandardLabel("Sort By Salary",1).getL();
		max = new StandardLabel("Max Salary",1).getL();
		stack1 = new StackPane();
		stack1.getChildren().addAll(first, last ,education1 , salary1 , max);
		stack1.setAlignment(Pos.CENTER);
		above.getChildren().addAll(stack1, stack2);
		above.setHgrow(stack1, Priority.ALWAYS);
		above.setHgrow(stack2, Priority.NEVER);
		all = new VBox (50);
		all.getChildren().addAll(above , stack3);
	}
	public void setItemsFirst() {
		sorted = FXCollections.observableArrayList(MyTableView.empList);

		Collections.sort(sorted , new SortAsFirst());
		first.setVisible(true);
		last.setVisible(false);
		education1.setVisible(false);
		salary1.setVisible(false);
		max.setVisible(false);
		sortedTable.setItems(sorted);
	}
	public void setItemsLast() {
		sorted = FXCollections.observableArrayList(MyTableView.empList);
		Collections.sort(sorted , new SortAsLast());
		sortedTable.setItems(sorted);
		first.setVisible(false);
		last.setVisible(true);
		education1.setVisible(false);
		salary1.setVisible(false);
		max.setVisible(false);
		sortedTable.setItems(sorted);
	}
		

	public void setItemsEducation () {
		sorted = FXCollections.observableArrayList(MyTableView.empList);
		Collections.sort(sorted , new SortAsEducation());
		sortedTable.setItems(sorted);
		first.setVisible(false);
		last.setVisible(false);
		education1.setVisible(true);
		salary1.setVisible(false);
		max.setVisible(false);
		sortedTable.setItems(sorted);
		
	}

	public void setItemsSalary() {
		sorted = FXCollections.observableArrayList(MyTableView.empList);
			Collections.sort(sorted , new SortAsSalary());
			sortedTable.setItems(sorted);
			first.setVisible(false);
			last.setVisible(false);
			education1.setVisible(false);
			salary1.setVisible(true);
			max.setVisible(false);
			sortedTable.setItems(sorted);
	}

	public void setItemsMax() {
		sorted = FXCollections.observableArrayList(MyTableView.empList);
		first.setVisible(false);
		last.setVisible(false);
		education1.setVisible(false);
		salary1.setVisible(false);
		max.setVisible(true);
		int []maxSalaries = new int [] {0,0,0,0};
		boolean [] changed = new boolean [] {false , false, false, false};
		double [] max = new double [] {0,0,0,0};
		for (int i  = 0 ; i < MyTableView.empList.size(); i++) {
			Employee emp = MyTableView.empList.get(i);
			if (emp instanceof HourlyEmployee) {
				if (emp.pay() > max[0]) {
					max[0] = emp.pay();
					changed[0] = true;
					maxSalaries[0] = i;
				}
			}
			else if (emp instanceof SalariedEmployee) {
				if (emp.pay() > max[1]) {
					max[1] = emp.pay();
					changed[1] = true;
					maxSalaries[1] = i;
				}
			}
			else if (emp instanceof EmployeeBasedCommession) {
				if (emp.pay() > max[2]) {
					max[2] = emp.pay();
					changed[2] = true;
					maxSalaries[2] = i;
				}
			}
			else if (emp instanceof CommessionEmployee) {
				if (emp.pay() > max[3]) {
					max[3] = emp.pay();
					changed[3] = true;
					maxSalaries[3] = i;
				}
			}
		}
		sorted = FXCollections.observableArrayList();
		for (int i = 0; i < maxSalaries.length; i++) {
			if (changed[i] ==true) {
				sorted.add(MyTableView.empList.get(maxSalaries[i]));
			}
		}
		sortedTable.setItems(sorted);
	}
	public TableView<Employee> getSortedTable() {
		return sortedTable;
	}
	public TableColumn<Employee, String> getFirstName() {
		return firstName;
	}
	public TableColumn<Employee, String> getLastName() {
		return lastName;
	}
	public Label getFirst() {
		return first;
	}
	public Label getLast() {
		return last;
	}
	public Label getEducation() {
		return education1;
	}
	public Label getSalary() {
		return salary1;
	}
	public StackPane getStack1() {
		return stack1;
	}
	public VBox getAll() {
		return all;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	

}
