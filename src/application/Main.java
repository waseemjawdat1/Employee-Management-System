package application;
	
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	public static Scene main;
	public static Scene add;
	public static Scene view;
	public static Scene search;
	public static Scene remove;
	public static Scene update;
	public static Scene sorted;
	public static ArrayList <Employee> empList = new ArrayList <>();
	@Override
	public void start(Stage primaryStage) throws MyException {
	
		try {
			 MyTabPane p =  new MyTabPane();
			 ProjectMenu projMenu = new ProjectMenu(p,primaryStage);
			 Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
			 main = new Scene(p.getAll(), screenBounds.getWidth() , screenBounds.getHeight());
			 add  =new Scene (new AddEmployeePane().getOverAll() , screenBounds.getWidth() , screenBounds.getHeight());
		     view = new Scene (new ViewEmployeePane().getOverall() , screenBounds.getWidth() , screenBounds.getHeight());
		     main.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			 RemoveEmployeePane removePane = new RemoveEmployeePane(0, primaryStage);
			 UpdateEmployeePane updatePane = new UpdateEmployeePane(0, primaryStage);
			 remove = new Scene (removePane.getAll() , screenBounds.getWidth() , screenBounds.getHeight());
			 update  =new Scene (updatePane.getAll() , screenBounds.getWidth() , screenBounds.getHeight());
			 SortedTableView sortedd = new SortedTableView(primaryStage);
			
			 sorted  =new Scene (sortedd.getAll(), screenBounds.getWidth() , screenBounds.getHeight());
			
			 ReadButton readAction = new ReadButton(p.getT().read, primaryStage);
			 SaveButton saveAction = new SaveButton(p.getT().save, primaryStage);
		
			primaryStage.setScene(main);
			primaryStage.setMaximized(true);
			primaryStage.show();
			primaryStage.setTitle("Employee Management System");
			primaryStage.getIcons().add(new Image ("WaseemIcon.png"));
			SortEvents sss = new SortEvents(primaryStage, sortedd);
			p.getTt().firstName.setOnAction(sss);
			p.getTt().lastName.setOnAction(sss);
			p.getTt().education.setOnAction(sss);
			p.getTt().salary.setOnAction(sss);
			p.getTt().maxSalary.setOnAction(sss);
		
			ViewEmployeePane.remove.setOnAction(e->{
				if (ViewEmployeePane.empNo.getText()!=null && !ViewEmployeePane.empNo.getText().isEmpty()) {
					int index = ViewEmployeePane.getByIdIndex(ViewEmployeePane.empNo.getText());
					
					if (index == -1) {
						Alert a =  new Alert(AlertType.ERROR);
						a.setTitle("Not Valid Input");
						a.setContentText("No Employee with this id" );
						a.setHeaderText(null);
						a.showAndWait();
					}
					else {
						removePane.setIndex(index);
						primaryStage.setScene(remove);
					}
				}
				else {
				if (MyTableView.empList.size() > 0) {
				if (ViewEmployeePane.table.getSelectionModel().getSelectedIndex() != -1) {
					removePane.setIndex(ViewEmployeePane.table.getSelectionModel().getSelectedIndex());
				}
				else removePane.setIndex(0);
				
				 primaryStage.setScene(remove);
				}
			else {
				Alert a =  new Alert(AlertType.ERROR);
				a.setTitle("Error");
				a.setContentText("No Employees");
				a.setHeaderText(null);
				ImageView i  = new ImageView(new Image("removeEmployee.png"));
				i.setFitHeight(50);
				i.setFitWidth(50);
				a.setGraphic(i);
				a.showAndWait();
			}
				}
			});
			ViewEmployeePane.update.setOnAction(e->{
				if (ViewEmployeePane.empNo.getText() !=null &&!ViewEmployeePane.empNo.getText().isEmpty()) {
					int index = ViewEmployeePane.getByIdIndex(ViewEmployeePane.empNo.getText());
					
					if (index == -1) {
						Alert a =  new Alert(AlertType.ERROR);
						a.setTitle("Not Valid Input");
						a.setContentText("No Employee with this id" );
						a.setHeaderText(null);
						ImageView i  = new ImageView(new Image("update.png"));
						i.setFitHeight(50);
						i.setFitWidth(50);
						a.setGraphic(i);
						a.showAndWait();
					}
					else {
						updatePane.setIndex(index);
						primaryStage.setScene(update);
					}
				}
				else {
				if (MyTableView.empList.size() > 0) {
				if (ViewEmployeePane.table.getSelectionModel().getSelectedIndex() != -1) {
					updatePane.setIndex(ViewEmployeePane.table.getSelectionModel().getSelectedIndex());
				}
				else updatePane.setIndex(0);
				
				 primaryStage.setScene(update);
				}
			else {
				Alert a =  new Alert(AlertType.ERROR);
				a.setTitle("Error");
				a.setContentText("No Employees");
				a.setHeaderText(null);
				ImageView i  = new ImageView(new Image("update.png"));
				i.setFitHeight(50);
				i.setFitWidth(50);
				a.setGraphic(i);
				a.showAndWait();
			}
				}
			});
			removePane.getBack().setOnAction(e->{
				primaryStage.setScene(view);
			});
			p.getT().add.setOnAction(e->{
				AddEmployeePane.empNo1.setText(Employee.getEmpno1()+"");
				primaryStage.setScene(add);
			});
			p.getT().view.setOnAction(e->{
				primaryStage.setScene(view);
			});
			AddEmployeePane.getBack().setOnAction(e-> {
				AddEmployeePane.clear();
				Alert a= new Alert (AlertType.CONFIRMATION);
				a.setTitle("Back to main");
				a.setHeaderText(null);
				a.setContentText("Are you sure you want back to the main ?\n*if you dont save your data all data will be cleared ");
				ImageView i  = new ImageView ("back.png");
				i.setFitHeight(50);
				i.setFitWidth(50);
				a.setGraphic(i);
				ButtonType res=  a.showAndWait().orElse(ButtonType.CANCEL);
				if (res == ButtonType.OK) {
				primaryStage.setScene(main);
				}
			});
			ViewEmployeePane.back.setOnAction(e->{
				ViewEmployeePane.forBackButton();
				primaryStage.setScene(main);
			});
			AddEmployeePane.getClear().setOnAction(e->{
				AddEmployeePane.clear();
				Alert a = new Alert(AlertType.INFORMATION);
				a.setHeaderText(null);
				a.setTitle("clear data");
				a.setContentText("All Data Cleared");
				ImageView i  = new ImageView(new Image("clear.png"));
				i.setFitHeight(50);
				i.setFitWidth(50);
				a.setGraphic(i);
				a.showAndWait();
				
			});
			AddEmployeePane.addPhoto.setOnAction(e->{
				FileChooser pickPhoto = new FileChooser();
				pickPhoto.setTitle("Select Employee Photo");
				pickPhoto.getExtensionFilters().add(new ExtensionFilter("Only Images", "*.png" , "*.jpg"));
				File photo = pickPhoto.showOpenDialog(primaryStage);
				if (photo != null) {
					String path = photo.toURI().toString();
					Image empImage= new Image (path);
					AddEmployeePane.i.setImage(empImage);
				}
			});
			
			AddEmployeePane.add.setOnAction(e->{
				if (AddEmployeePane.checkNull().isEmpty()) {
					Employee obj = null;
					try {
						obj = AddEmployeePane.getObj();
					} catch (MyException e1) {
						System.out.println(e1.getMessage());
					}
					if (obj != null) {
					empList.add(obj);
					ViewEmployeePane.table.getItems().add(obj);
					}
					//note check null alert
					Alert a =  new Alert(AlertType.INFORMATION);
					a.setTitle("Employee Added");
					a.setContentText("Employee was added successfully");
					a.setHeaderText(null);
					ImageView i  = new ImageView(new Image("addEmployee.png"));
					i.setFitHeight(50);
					i.setFitWidth(50);
					a.setGraphic(i);
					a.showAndWait();
					primaryStage.setScene(main);
					AddEmployeePane.clear();
				}
				else {
					Alert a =  getAlert(AddEmployeePane.checkNull());
					a.showAndWait();
				}
				
			});
			
		}
		 catch(Exception e) {
		}
		
	}
	
	public Alert getAlert(String b) {
		Alert a =  new Alert(AlertType.ERROR);
		a.setTitle("Not Valid Input");
		a.setContentText(b);
		a.setHeaderText(null);
		ImageView i  = new ImageView(new Image("addEmployee.png"));
		i.setFitHeight(50);
		i.setFitWidth(50);
		a.setGraphic(i);
		return a;
	}
	public static void main(String[] args) {
		launch(args);
	}

	
}
