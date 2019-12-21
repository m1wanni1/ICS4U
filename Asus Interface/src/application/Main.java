package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	double value = 799.99;
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setPadding(new Insets(10,10,10,10));
			root.setVgap(30);
			Label picture = new Label();
			Image Asus1 = new Image("file:asus_logo.png"); 
			picture.setGraphic(new ImageView(Asus1)); 
			root.add(picture, 1,0);
			
//			Label picture1 = new Label();
//			Image Asus12 = new Image("file:laptop.png"); 
//			picture.setGraphic(new ImageView(Asus12)); 
//			root.add(picture1, 1,3);
			
			Label text = new Label();
			text.setText("Select from the following options:");
			root.add(text, 2, 1);
			
			Label gTotal = new Label();
			gTotal.setText("GRAND TOTAL:");
			root.add(gTotal,1,6);
			
		
			
			CheckBox chk1 = new CheckBox();
			chk1.setText("9-Cell Lithium-Ion Battery ($179.99)");
			root.add(chk1, 2, 2);
			chk1.setFocusTraversable(true);
			
			CheckBox chk2 = new CheckBox();
			chk2.setText("Microsoft office 2016 ($119.00)");
			root.add(chk2, 2, 3);
			
			CheckBox chk3 = new CheckBox();
			chk3.setText("Mcafee Security Center ($79.00)");
			root.add(chk3, 2, 4);
			
			CheckBox chk4 = new CheckBox();
			chk4.setText("2-year extended warranty ($85.00)");
			root.add(chk4, 2, 5);
			
			TextField total = new TextField();
			root.add(total, 2, 6);
			total.setText(""+ value);
			
			chk1.setOnAction(e->{
				if (chk1.isSelected())
				{
				value+=179.99;
				}
				else 
				{
					value-=179.99;
				}
				total.setText(""+ value);
			});
			
			chk2.setOnAction(e->{
				if (chk2.isSelected())
				value+=119.00;
				else
					value-=119.00;
				total.setText(""+ value);
			});
			
			chk3.setOnAction(e->{
				if (chk3.isSelected())
				value+=79.00;
				else
					value-=79.00;
				total.setText(""+ value);
			});
			chk4.setOnAction(e->{
				if (chk4.isSelected()) {
					value+=85.00;
				}
				else
					value-=85.00;
				total.setText(""+ value);
			});
			Alert alert = new Alert(null);
	
			
			Button checkout = new Button();
			checkout.setText("Checkout");
			checkout.setPrefSize(100, 30);
			Button clear = new Button();
			clear.setPrefSize(100, 30);
			clear.setText("Clear");
			root.add(checkout,1,7);
			root.add(clear, 2, 7);
			alert.setHeaderText(null);
			
			checkout.setOnAction(e->{
				alert.setAlertType(AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				Image image2 = new Image("file:asus_icon.png");
				ImageView imageView = new ImageView(image2);
				alert.setGraphic(imageView);
				alert.setTitle("CheckOut");
				alert.getButtonTypes().clear();
				alert.getButtonTypes().addAll(ButtonType.YES,ButtonType.NO);
				alert.setContentText("Your Grand Total is: " + value +"\nIs this correct?");
				Optional<ButtonType> result = alert.showAndWait(); 
				if(result.get()==ButtonType.YES)
				{
					System.exit(1);
				}
			});
			
			clear.setOnAction(e->{
				chk1.setSelected(false);
				chk2.setSelected(false);
				chk3.setSelected(false);
				chk4.setSelected(false);
			});
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		          public void handle(WindowEvent we) {
		              alert.setTitle("ASUS Online Store");
		              alert.setAlertType(AlertType.CONFIRMATION);
		              alert.setHeaderText(null);
		              alert.getButtonTypes().clear();
		              alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
		              alert.setContentText("Are you sure you want to exit?");
		              Optional<ButtonType> result = alert.showAndWait(); 
		              if (result.get()==ButtonType.YES)
		              {
		            	  System.exit(1);
		              }
		          }
		      });   
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("ASUS Online Store");
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
