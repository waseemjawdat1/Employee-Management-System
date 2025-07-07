package application;

import java.io.File;
import java.io.PrintWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class SaveButton {
FileChooser save;
public SaveButton (Button saveToFile , Stage s) {
	this.save = new FileChooser();
	save.setTitle("Choose File to save");
	save.getExtensionFilters().add(new ExtensionFilter("Only Text Files", "*.txt"));
	
	saveToFile.setOnAction(e->{
		File toSave = save.showOpenDialog(s);
		if (toSave != null) {
			Alert a  = new Alert (AlertType.CONFIRMATION);
			a.setTitle("Save to File");
			a.setHeaderText(null);
			a.setContentText(MyTableView.empList.size() +  "will added to your file\n Add it ? " );
			ButtonType res = a.showAndWait().orElse(ButtonType.CANCEL);
			if (res == ButtonType.OK) {
				try (PrintWriter p = new PrintWriter (toSave)){
					for (int i =0; i < MyTableView.empList.size(); i++) {
						p.println(MyTableView.empList.get(i).toFile());
					}
				}catch (Exception ee) {
					
				}
				Alert done  = new Alert (AlertType.INFORMATION);
				done.setTitle("File Saved");
				done.setHeaderText(null);
				done.setContentText(MyTableView.empList.size() + " added to you File");
				done.showAndWait();
			}
		
		}
	});
}
}
