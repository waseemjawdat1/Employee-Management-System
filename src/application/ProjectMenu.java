package application;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class ProjectMenu {

    public static MenuBar projectMenuBar = new MenuBar();

    private Menu employeeRecordMenu;
    private Menu employeeReportMenu;
    private Menu closeMenu;

    private MenuItem addEmployeeItem;
    private MenuItem viewEmployeeItem;
    private MenuItem readFromFileItem;
    private MenuItem saveToFileItem;

    private Menu sortAsMenu;
    private MenuItem sortByFirstNameItem;
    private MenuItem sortByLastNameItem;
    private MenuItem sortByEducationItem;
    private MenuItem sortBySalaryItem;
    private MenuItem maxSalaries;

    private MenuItem closeProgramItem;

    public ProjectMenu(MyTabPane t , Stage s) {
        employeeRecordMenu = new Menu("Employee Record");
        addEmployeeItem = new MenuItem("Add Employee");
        viewEmployeeItem = new MenuItem("View Employee");
        readFromFileItem = new MenuItem("Read From File");
        saveToFileItem = new MenuItem("Save To File");
        employeeRecordMenu.getItems().addAll(addEmployeeItem, viewEmployeeItem, readFromFileItem, saveToFileItem);

        employeeReportMenu = new Menu("Employee Report");

        sortAsMenu = new Menu("Sort As");

        sortByFirstNameItem = new MenuItem("Sort By First Name");
        sortByLastNameItem = new MenuItem("Sort By Last Name");
        sortByEducationItem = new MenuItem("Sort By Education");
        sortBySalaryItem = new MenuItem("Sort By Salary");
        sortAsMenu.getItems().addAll(sortByFirstNameItem, sortByLastNameItem, sortByEducationItem, sortBySalaryItem);
        maxSalaries = new MenuItem("Max Salaries");

        employeeReportMenu.getItems().addAll(sortAsMenu , maxSalaries);
    
        closeMenu = new Menu("Close");

        closeProgramItem = new MenuItem("Close Program");
        closeMenu.getItems().add(closeProgramItem);
        projectMenuBar.getMenus().addAll(employeeRecordMenu, employeeReportMenu, closeMenu);

      addEmployeeItem.setOnAction(e->{
    	 t.t.add.fire();
      });
      viewEmployeeItem.setOnAction(e->{
    	 t.t.view.fire();
      });
      readFromFileItem.setOnAction(e->{
    	  t.t.read.fire();
      });
      saveToFileItem.setOnAction(e->{
    	  t.t.save.fire();
      });
      sortByFirstNameItem.setOnAction(e->{
    	  t.tt.firstName.fire();
      });
      sortByLastNameItem.setOnAction(e->{
    	  t.tt.lastName.fire();
      });
      sortByEducationItem.setOnAction(e->{
    	  t.tt.education.fire();
      });
      sortBySalaryItem.setOnAction(e->{
    	  t.tt.salary.fire();
      });
      maxSalaries.setOnAction(e->{
    	  t.tt.maxSalary.fire();
      });
      closeProgramItem.setOnAction(e->{
    	  s.close();
      });
      addEmployeeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
      viewEmployeeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
      readFromFileItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
      saveToFileItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
      sortByFirstNameItem.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
      sortByLastNameItem.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
      sortByEducationItem.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
      sortBySalaryItem.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
      maxSalaries.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
    }

    public MenuBar getMenuBar() {
        return projectMenuBar;
    }
}
