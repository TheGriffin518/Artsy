package cs1302.p2;

import cs1302.effects.Artsy;

import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.lang.NumberFormatException;

public class TextBox extends TextInputDialog {

    TextInputDialog dialog;

    public double rotate() {

	boolean valid = true; 

	dialog = new TextInputDialog("0");
	dialog.setTitle("Rotate Image Options");
	dialog.setContentText("Please enter in your angle, in degress:");
	
	Optional<String> result;
	double value = 0.0;

	while(valid) {

	    result = dialog.showAndWait();

	    if(result.isPresent()){
		
		try{
		    value = Double.parseDouble(result.get());

		    if ((value > 360.0) || (value < 0.0)){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Invalid value");
			alert.showAndWait();
		    }

		    if((value >= 0.0) && (value <= 360.0)) {
			valid = false;
		    }
		}catch(NumberFormatException e) {
		    Alert alert = new Alert(AlertType.ERROR);
		    alert.setTitle("Error");
		    alert.setContentText("Invalid value");
		    alert.showAndWait();

		}

    	    }
	    if(!result.isPresent()) {
		valid = false;
	    }
	}

	    return value;
    }


    public int horizontal() {

	boolean valid = true; 

	dialog = new TextInputDialog("0");
	dialog.setTitle("Horizontal Stripe Options");
	dialog.setContentText("Please enter the desired stripe height, pixels:");

	Optional<String> result;
	int value = 0;

	while(valid) {

	    result = dialog.showAndWait();

	    if(result.isPresent()){
		
		try{
		    value = Integer.parseInt(result.get());

		    if ((value > 300) || (value <= 0)){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Invalid value");
			alert.showAndWait();
		    }

		    if((value > 0) && (value <= 300)) {
			valid = false;
		    }
		}catch(NumberFormatException e) {
		    Alert alert = new Alert(AlertType.ERROR);
		    alert.setTitle("Error");
		    alert.setContentText("Invalid value");
		    alert.showAndWait();

		}

	    }
	    if(!result.isPresent()) {
		valid = false;
	    }
	}
	    return value;
	
    }

    
    public int vertical() {

	boolean valid = true; 

	dialog = new TextInputDialog("0");
	dialog.setTitle("Vertical Stripe Options");
	dialog.setContentText("Please enter the desired width, in pixels:");

	Optional<String> result;
	int value = 0;

	while(valid) {

	    result = dialog.showAndWait();

	    if(result.isPresent()){
		
		try{
		    value = Integer.parseInt(result.get());

		    if ((value > 300) || (value <= 0)){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Invalid value");
			alert.showAndWait();
		    }

		    if((value > 0) && (value <= 300)) {
			valid = false;
		    }
		}catch(NumberFormatException e) {
		    Alert alert = new Alert(AlertType.ERROR);
		    alert.setTitle("Error");
		    alert.setContentText("Invalid value");
		    alert.showAndWait();

		}

	    }
	    if(!result.isPresent()) {
		valid = false;
	    }
	}
	    return value;
	
    }
    public int checkers() {

	boolean valid = true; 

	dialog = new TextInputDialog("0");
	dialog.setTitle("Checkers Options");
	dialog.setContentText("Please enter the desired checker width, in pixels:");

	Optional<String> result;
	int value = 0;

	while(valid) {

	    result = dialog.showAndWait();

	    if(result.isPresent()){
		
		try{
		    value = Integer.parseInt(result.get());

		    if ((value > 300) || (value <= 0)){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Invalid value");
			alert.showAndWait();
		    }

		    if((value > 0) && (value <= 300)) {
			valid = false;
		    }
		}catch(NumberFormatException e) {
		    Alert alert = new Alert(AlertType.ERROR);
		    alert.setTitle("Error");
		    alert.setContentText("Invalid value");
		    alert.showAndWait();

		}

	    }
	    
	    if(!result.isPresent()) {
		valid = false;
	    }

	}
	    return value;
    }

}