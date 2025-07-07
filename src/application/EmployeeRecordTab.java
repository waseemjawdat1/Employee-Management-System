package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeeRecordTab{
	HBox all;
	VBox buttons;
	ImageView mainPhoto;
	Button add;
	Button view;
	Button read;
	Button save;
	public EmployeeRecordTab() {
		all = new HBox (100);
		buttons = new VBox (20);
		mainPhoto = new ImageView(new Image ("waseeem-jawadat.png"));
		mainPhoto.setFitHeight(500);
		mainPhoto.setFitWidth(700);
		add = new MyButton(new Image ("AddEmployee.png")).getB1();
		view = new MyButton(new Image ("viewEmployee.png")).getB1();
		read =  new MyButton(new Image ("readFromFile.png")).getB1();
		save = new MyButton(new Image ("saveToFile.png")).getB1();
		buttons.getChildren().addAll(add,view,read,save);
		all.getChildren().addAll(buttons,mainPhoto);
		buttons.setAlignment(Pos.CENTER);
		all.setAlignment(Pos.CENTER);
		all.setPadding(new Insets(100));
	}
	public HBox getAll() {
		return all;
	}
	public VBox getButtons() {
		return buttons;
	}
	public ImageView getMainPhoto() {
		return mainPhoto;
	}
	public Button getAdd() {
		return add;
	}

	public Button getView() {
		return view;
	}

	public Button getRead() {
		return read;
	}

	public Button getSave() {
		return save;
	}
		
	}
	
