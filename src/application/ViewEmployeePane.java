package application;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ViewEmployeePane {
	VBox overall;
	 HBox a1 , a2 ,a3;
	static TableView<Employee> table;
	ObservableList<Employee>searchEmp;
	static Button search , remove , update , back;
	static MyTableView privTable;
	Label emolyeeNo;
	static TextField empNo;
	public ViewEmployeePane() {
		privTable = new MyTableView();
		table = privTable.getEmpTable();
		emolyeeNo = new StandardLabel("Employee No : ").getL();
		empNo = new MyTextField().getT();
		a1=  new HBox(10);
		a1.setAlignment(Pos.CENTER);
		a1.getChildren().addAll(emolyeeNo , empNo);
		search = new MyButton(new Image("search.png"),1).getB1();
		remove = new MyButton(new Image("removeEmployee.png"),1).getB1();
		update = new MyButton(new Image("update.png"),1).getB1();
		back = new MyButton(new Image("back.png"),1).getB1();
		a2 = new HBox (30);
		a2.getChildren().addAll(remove , search , update);
		a3 = new HBox (200);
		a3.getChildren().addAll(a2 , back);
		a3.setAlignment(Pos.CENTER);
		overall = new VBox (20);
		StackPane s = new StackPane();
		s.getChildren().add(table);
		overall.getChildren().addAll(a1,a3,s);
		searchButtonAction();
		
		
	}
	public static void forBackButton() {
		table.setItems(privTable.empList);
		empNo.setText(null);
	}
	public void searchButtonAction () {
		empNo.setOnKeyTyped(e->{
			if (empNo.getText() != null && !empNo.getText().isEmpty()) {
				if (getById(empNo.getText())!= null) {
				searchEmp = FXCollections.observableArrayList(getById(empNo.getText()));
				table.setItems(searchEmp);
				}
				else {
					table.setItems(MyTableView.empList);
				}
			}
			else {
				table.setItems(MyTableView.empList);
			}
		});
		search.setOnAction(e-> {
			if (!empNo.getText().isEmpty()) {
				if (getById(empNo.getText())!= null) {
				searchEmp = FXCollections.observableArrayList(getById(empNo.getText()));
				table.setItems(searchEmp);
				}
				else {
					Alert a =  new Alert(AlertType.ERROR);
					a.setTitle("Not Valid Input");
					a.setContentText("No Employee with this id" );
					a.setHeaderText(null);
					a.showAndWait();
				}
			}
			else {
				Alert a =  new Alert(AlertType.ERROR);
				a.setTitle("Not Valid Input");
				a.setContentText("You must fill employee number");
				a.setHeaderText(null);
				a.showAndWait();
			}
		});
		
	}
	public VBox getOverall() {
		return overall;
	}
	public static Employee getById(String empNo) {
		for (int i  = 0; i  < Main.empList.size(); i++) {
			if (Main.empList.get(i).getEmpno().trim().equals(empNo.trim())) {
				return Main.empList.get(i);
			}
		}
		return null;
	}
	public static int getByIdIndex(String empNo) {
		for (int i  = 0; i  < Main.empList.size(); i++) {
			if (Main.empList.get(i).getEmpno().equals(empNo)) {
				return i;
			}
		}
		return -1;
	}
	public  HBox getA1() {
		return a1;
	}
	public  HBox getA2() {
		return a2;
	}
	public  HBox getA3() {
		return a3;
	}
	public TableView<Employee> getTable() {
		return table;
	}
	public Button getSearch() {
		return search;
	}
	public Button getRemove() {
		return remove;
	}
	public Button getUpdate() {
		return update;
	}
	public Button getBack() {
		return back;
	}
	public Label getEmolyeeNo() {
		return emolyeeNo;
	}
	public TextField getEmpNo() {
		return empNo;
	}
	
}
