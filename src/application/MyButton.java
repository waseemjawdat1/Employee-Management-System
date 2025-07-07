package application;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class MyButton extends Button{
	
	Button b1;
	public MyButton (String text) {
		b1 = new Button(text);
		b1.setMinWidth(300);
		b1.setMinHeight(100);
		b1.setStyle(
			    "-fx-font-size: 20px;" +
			    "-fx-font-family: 'Times New Roman';" +
			    "-fx-font-weight: bold;" +
			    "-fx-text-base-color: #5A00B5;"+
			    "-fx-text-fill: #5A00B5;" +
			    "-fx-background-color: linear-gradient(to bottom, #B97DFF, #FFB28C);" +
			    "-fx-background-radius: 5px;" +
			    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 5);" +
			    "-fx-cursor: hand;"
			);

			b1.setOnMouseEntered(e -> {
			    b1.setStyle(
			        "-fx-font-size: 20px;" +
			        "-fx-font-family: 'Times New Roman';" +
			        "-fx-font-weight: bold;" +
			        "" +
			        "-fx-text-fill: #5A00B5;" +
			        "-fx-background-color: linear-gradient(to bottom, #9A64FF, #FF9F6A);" +
			        "-fx-background-radius: 5px;" +
			        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 12, 0, 0, 6);" +
			        "-fx-cursor: hand;"
			    );
			});


		b1.setOnMouseExited(e -> {
		    b1.setStyle(
		        "-fx-font-size: 20px;" +
		        "-fx-font-family: 'Times New Roman';" +
		        "-fx-font-weight: bold;" +
		        "-fx-text-base-color: #5A00B5;"+
		        "-fx-text-fill: #5A00B5;" +
		        "-fx-background-color: linear-gradient(to bottom, #B97DFF, #FFB28C);" +
		        "-fx-background-radius: 5px;" +
		        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 5);" +
		        "-fx-cursor: hand;"
		    );
		});
	}
	public MyButton (String text, int i) {
		b1 = new Button(text);
		b1.setMinWidth(100);
		b1.setMinHeight(80);
		b1.setStyle(
			    "-fx-font-size: 20px;" +
			    "-fx-font-family: 'Times New Roman';" +
			    "-fx-font-weight: bold;" +
			    "-fx-text-base-color: #5A00B5;"+
			    "-fx-text-fill: #5A00B5;" +
			    "-fx-background-color: linear-gradient(to bottom, #B97DFF, #FFB28C);" +
			    "-fx-background-radius: 5px;" +
			    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 5);" +
			    "-fx-cursor: hand;"
			);

			b1.setOnMouseEntered(e -> {
			    b1.setStyle(
			        "-fx-font-size: 20px;" +
			        "-fx-font-family: 'Times New Roman';" +
			        "-fx-font-weight: bold;" +
			        "" +
			        "-fx-text-fill: #5A00B5;" +
			        "-fx-background-color: linear-gradient(to bottom, #9A64FF, #FF9F6A);" +
			        "-fx-background-radius: 5px;" +
			        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 12, 0, 0, 6);" +
			        "-fx-cursor: hand;"
			    );
			});


		b1.setOnMouseExited(e -> {
		    b1.setStyle(
		        "-fx-font-size: 20px;" +
		        "-fx-font-family: 'Times New Roman';" +
		        "-fx-font-weight: bold;" +
		        "-fx-text-base-color: #5A00B5;"+
		        "-fx-text-fill: #5A00B5;" +
		        "-fx-background-color: linear-gradient(to bottom, #B97DFF, #FFB28C);" +
		        "-fx-background-radius: 5px;" +
		        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 5);" +
		        "-fx-cursor: hand;"
		    );
		});
	}
	public MyButton (Image i) {
		ImageView icon  = new ImageView(i);
		icon.setFitHeight(50);
		icon.setFitWidth(50);
		b1 = new Button(null , icon);
		b1.setMinWidth(300);
		b1.setMinHeight(100);
		
		b1.setStyle("-fx-background-color: linear-gradient(to bottom, #B97DFF, #FFB28C); -fx-background-radius: 5px;-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 5);-fx-cursor: hand;");
		b1.setOnMouseEntered(e-> {
			b1.setStyle("-fx-background-color: linear-gradient(to bottom, #9A64FF, #FF9F6A);-fx-font-size: 14px;-fx-background-radius: 5px;-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 12, 0, 0, 6);-fx-cursor: hand;");
		});
		b1.setOnMouseExited(e->{
			b1.setStyle("-fx-background-color: linear-gradient(to bottom, #B97DFF, #FFB28C);-fx-font-size: 14px;-fx-background-radius: 5px;-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 5);-fx-cursor: hand;");
		});
	}
	public MyButton (Image i , int a) {
		ImageView icon  = new ImageView(i);
		icon.setFitHeight(50);
		icon.setFitWidth(50);
		b1 = new Button(null , icon);
		b1.setMinWidth(100);
		b1.setMinHeight(80);
	b1.setStyle("-fx-background-color: linear-gradient(to bottom, #B97DFF, #FFB28C); -fx-background-radius: 5px;-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 5);-fx-cursor: hand;");
		b1.setOnMouseEntered(e-> {
			b1.setStyle("-fx-background-color: linear-gradient(to bottom, #9A64FF, #FF9F6A); -fx-font-size: 14px;-fx-background-radius: 5px;-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 12, 0, 0, 6);-fx-cursor: hand;");
		});
   	b1.setOnMouseExited(e->{
		b1.setStyle("-fx-background-color: linear-gradient(to bottom, #B97DFF, #FFB28C); -fx-font-size: 14px;-fx-background-radius: 5px;-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 5);-fx-cursor: hand;");
		});
	}
	public Button getB1() {
		return b1;
	}
	
}
