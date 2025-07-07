package application;

import com.sun.prism.paint.Color;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class MyTabPane {
	TabPane mainTaps;
	Tab record;
	Tab report;
	EmployeeRecordTab t = new EmployeeRecordTab();
	EmployeeReportTab tt = new EmployeeReportTab();
	VBox all;
	public MyTabPane() {
		all = new VBox ();
		mainTaps = new TabPane();
		mainTaps.setStyle("-fx-background-color: #ffffff;");
		record = new Tab("Employee Record");
		record.setId("tab1");
		record.setContent(t.getAll());
		record.setClosable(false);
		report = new Tab("Statiscal Report");
		report.setId("tab2");
		report.setClosable(false);
		record.setOnSelectionChanged(e->{
			if (record.isSelected()) {
				tt.totalSalaryreport1.setSelected(false);
				tt.totalSalaryreport.setVisible(false);
			}
		});
		mainTaps.getTabs().addAll(record, report);
		report.setContent(tt.getAll());
		all.getChildren().addAll(ProjectMenu.projectMenuBar , mainTaps);
	}
	public TabPane getMainTaps() {
		return mainTaps;
	}
	public Tab getRecord() {
		return record;
	}
	public Tab getReport() {
		return report;
	}
	public EmployeeRecordTab getT() {
		return t;
	}
	public EmployeeReportTab getTt() {
		return tt;
	}
	public VBox getAll() {
		return all;
	}
	
	
	
}
