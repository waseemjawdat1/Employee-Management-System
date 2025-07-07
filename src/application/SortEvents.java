package application;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SortEvents implements EventHandler <ActionEvent> {
	private Stage s;
	private SortedTableView mtp;

	public SortEvents (Stage s , SortedTableView mtp) {
		this.s = s;
		this.mtp = mtp;
	}
	
	
	@Override
	public void handle(ActionEvent r) {
		Object obj = r.getSource();
		if (obj instanceof Button) {
			Button e = (Button)obj;
		if (MyTableView.empList.size()!=0) {
		if (e.getId().equals("first")) {
			mtp.setItemsFirst();
			s.setScene(Main.sorted);
		}
		else if (e.getId().equals("last")) {
			mtp.setItemsLast();
			s.setScene(Main.sorted);
		}
		else if (e.getId().equals("education")) {
			mtp.setItemsEducation();
			s.setScene(Main.sorted);
		}
		else if (e.getId().equals("salary")) {
				mtp.setItemsSalary();
				s.setScene(Main.sorted);
		}
		else if (e.getId().equals("max")) {
				mtp.setItemsMax();
				s.setScene(Main.sorted);
		}
		}
		else {
			Alert1();
		}
		}
	}
	public void Alert1() {
		Alert listNull = new Alert(AlertType.ERROR);
		listNull.setTitle("No Employees");
		listNull.setHeaderText(null);
		listNull.setContentText("No Employees in you System");
		listNull.showAndWait();
	}
}
