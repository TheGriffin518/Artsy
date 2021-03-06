package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.application.Platform;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

    public class AppMenuBar extends MenuBar {

	/**
	 * The constuctor takes in the viewPanes so the MenuItems are able to affect the 
	 * viewPanes images
	 *
	 *@param view1 is a ViewPane object with its own data
	 *@param view2 is a ViewPane object with its own data
	 *@param view3 is a ViewPane object with its own data
	 **/



	public AppMenuBar(ViewPane view1, ViewPane view2, ViewPane view3) {
	    super();
	    Menu file = new Menu("File");
	    Menu open = new Menu("Open Image");
	    MenuItem exit = new MenuItem("Exit");
	    MenuItem openImage1 = new MenuItem("Open Image 1");
	    MenuItem openImage2 = new MenuItem("Open Image 2");
	    MenuItem saveAs = new MenuItem("Save Image As");


	    getMenus().add(file);
	    open.getItems().addAll(openImage1, openImage2);
	    file.getItems().addAll(open, saveAs, exit);
	    
	    //defines the actions for these MenuItems
	    exit.setOnAction(event -> Platform.exit());
	    openImage1.setOnAction(event -> view1.chooseImage());
	    openImage2.setOnAction(event -> view2.chooseImage());
	    saveAs.setOnAction(event -> view3.saveImage());

    }
}
