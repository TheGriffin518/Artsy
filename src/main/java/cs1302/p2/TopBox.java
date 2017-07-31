package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class TopBox extends VBox {

    Button checkers = new Button("Checkers");
    Button vStripes = new Button("Vertical Stripes");
    Button hStripes = new Button("Horizontal Stripes");
    HBox hbox = new HBox();
    MyArtsy artsy = new MyArtsy();
    TextBox textBox = new TextBox();

    public TopBox(ViewPane view1, ViewPane view2, ViewPane view3) {

	super();
	AppMenuBar menuBar = new AppMenuBar(view1, view2, view3);
	setSpacing(5);
	hbox.setSpacing(5);
	hbox.getChildren().addAll(checkers, vStripes, hStripes);
	getChildren().addAll(menuBar, hbox);

	//sets the action for the button checkers and passes the returned value to MyArtsy
	checkers.setOnAction(event -> {
		int width = textBox.checkers();
		if(width > 0){
		    view3.src = artsy.doCheckers(view1.getImage(), view2.getImage(), width);
		view3.imageSet(view3.src);
		}
	    });

	//sets the action for the button Vertical Stripes and passes the returned value to MyArtsy
	vStripes.setOnAction(event -> {
		int height = textBox.vertical();
		if(height > 0){
		    view3.src = artsy.doVerticalStripes(view1.getImage(), view2.getImage(), height);
		view3.imageSet(view3.src);
		}
	    });

	//sets the action for the button Horizontal Stripes and passes the value to MyArtsy
	hStripes.setOnAction(event -> {
		int width = textBox.horizontal();
		if(width > 0){
		    view3.src = artsy.doHorizontalStripes(view1.getImage(), view2.getImage(), width);
		view3.imageSet(view3.src);
		}
	    });
    }

}