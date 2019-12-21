package application;



import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	String cherry="",cookies="",almond="",rockey="";
	public void start(Stage primaryStage) {
		try {
			FlowPane root = new FlowPane();
			FlowPane CheckBox = new FlowPane();

			root.setVgap(30);
			root.setAlignment(Pos.CENTER);
			root.setOrientation(Orientation.VERTICAL);
			root.setStyle("-fx-background-color: rgb(255, 51, 153)");


			CheckBox Cherry = new CheckBox();
			Cherry.setText("Cherry Jubilee");
			Cherry.setStyle("-fx-font-size: 18");

			CheckBox Cookies = new CheckBox();
			Cookies.setText("Cookies and cream");
			Cookies.setStyle("-fx-font-size: 18");

			CheckBox Almond = new CheckBox();
			Almond.setText("Jamoca	Almond Fudge");
			Almond.setStyle("-fx-font-size: 18");

			CheckBox Rockey = new CheckBox();
			Rockey.setText("Rocky Road");
			Rockey.setStyle("-fx-font-size:18");

			FlowPane Button = new FlowPane();
			Button.setOrientation(Orientation.HORIZONTAL);
			Button.setAlignment(Pos.BOTTOM_CENTER);
			Button.setHgap(15);
			Button ok = new Button();
			ok.setText("OK");
			ok.setPrefSize(100, 30);
			Button exit= new Button();
			exit.setText("Exit");
			exit.setPrefSize(100, 30);
			Button clear= new Button();
			clear.setText("Clear");
			clear.setPrefSize(100, 30);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			ok.setOnAction(e->{
				cherry="";cookies="";almond="";rockey="";
				alert.setHeaderText(null);
				alert.setTitle("Order Confirmation");
				if (Cherry.isSelected())
				{
					cherry="Cherry Jubilee";							
				}
				if (Cookies.isSelected())
				{
					cookies = "Cookies 'n Cream";
				}
				if (Almond.isSelected())
				{
					almond = "Jamoca Almond Fudge";
				}
				if (Rockey.isSelected())
				{
					rockey = "Rocky Road";
				}
				alert.setContentText("You have ordered the following flavors\n\n" + (cherry+"\n") + (cookies+"\n") + (almond+"\n") + (rockey+"\n")  + "\n\n Is this Correct?");
				alert.getButtonTypes().clear();
				alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
				Optional<ButtonType> result = alert.showAndWait(); 
				if (result .get() == ButtonType.YES)
				{
					alert.setTitle("Goodbye");
					alert.setContentText("Thank you for visiting basking robins");
					alert.getButtonTypes().clear();
					alert.getButtonTypes().add(ButtonType.OK);
					System.exit(1);
				}
				else 
				{
					alert.setTitle("Error");
					alert.setContentText("You have not made a selection!\nPlease select a flavour.");
					alert.getButtonTypes().clear();
					alert.setAlertType(AlertType.ERROR);
					alert.getButtonTypes().addAll(ButtonType.OK);
				}
				alert.showAndWait();


			});
			
			exit.setOnAction(e->{
				alert.setTitle("Basking Robins");
				alert.setContentText("Are you sure you want to exit");
				alert.getButtonTypes().clear();
				alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
				Optional<ButtonType> result = alert.showAndWait(); 
				if (result.get()== ButtonType.YES)
				{
					alert.setTitle("Goodbye");
					alert.setContentText("Thank you for visiting basking robins");
					alert.setAlertType(AlertType.INFORMATION);
					alert.showAndWait();
					System.exit(1);
				}
				else
				{
					
				}
			});
			
			clear.setOnAction(e->{
				Cherry.setSelected(false);
				Almond.setSelected(false);
				Cookies.setSelected(false);
				Rockey.setSelected(false);
			});

			Label picture = new Label();
			Image BaskinRobins = new Image("file:Baskin_Robbins.gif"); 
		picture.setGraphic(new ImageView(BaskinRobins)); 
		



			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Button.getChildren().addAll(ok,exit,clear);
			root.getChildren().addAll(picture,Cherry, Cookies, Almond, Rockey,Button);


			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
