package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {

    @Override
    public void start(Stage stage) {

	BorderPane root = new BorderPane();
	Scene scene = new Scene(root);

	HBox hbox = new HBox();
	ViewPane view1 = new ViewPane();
	ViewPane view2 = new ViewPane();
	ViewPane view3 = new ViewPane();
	MyArtsy artsy = new MyArtsy();
	TextBox textBox = new TextBox();
	
	TopBox topBox = new TopBox(view1, view2, view3);
	hbox.setSpacing(10);
	hbox.setPadding(new Insets(5));
	hbox.getChildren().addAll(view1, view2, view3);

	//Sets the label variable above the image initially.
	view1.initialLabel = "Image 1: ";
	view2.initialLabel = "Image 2: ";
	view3.initialLabel = "Result ";
	//sets the src image variable to the default image for the reset button
	view3.src = view3.image1;

	//initializes the label, so the user sees the labels on the first start up
	view1.fileName.setText("Image 1: default.png");
	view2.fileName.setText("Image 2: default.png");
	view3.fileName.setText("Result");

	//defines the action for each of the reset buttons and what image to display
	//after completing their action
	view1.reset.setOnAction(event -> view1.imgView.setImage(view1.src));
	view2.reset.setOnAction(event -> view2.imgView.setImage(view2.src));
	view3.reset.setOnAction(event -> view3.imageSet(view3.image1));

	root.setTop(topBox);
	root.setPrefHeight(450);
	root.setPrefWidth(900);
	root.setLeft(hbox);
	
	stage.setScene(scene);
	stage.setTitle("Artsy!");
	stage.sizeToScene();
	stage.show();
	
        
    } // createAndShowGUI

    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
