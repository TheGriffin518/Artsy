package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import javafx.scene.image.Image;
import javafx.stage.Window;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;


public class ImageSelect {

    String fileName;
    Image image;
    FileChooser fileChooser = new FileChooser();
    File savedImage;

    /**
     * select is a method that opens up a FileChooser dialog that allows the user to 
     * select an image file. 
     * It returns the image that the user selected.
     */
    public Image select() {
	
	try{
	    fileChooser.setTitle("Image Select");
	    fileChooser.getExtensionFilters().addAll(
						     new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.bmp", "*.gif")
						     );
	    File selectedFile = fileChooser.showOpenDialog(null);
	    if(selectedFile != null){
		image = new Image(selectedFile.toURI().toString(), 300, 300, false, false);
		setImageName(selectedFile.getName());
	    }
	}
	catch (Exception e){
	    System.err.println(e);
	}
    
    return image;
    }

    /**
     * saveImage saves the image that is passed to it. It opens up a FileChoooser dialog that
     * allows the user to choose the location and name of the file.
     *@param image is an Image that is then the image that gets saved
     */
    public void saveImage(Image image) {
	try {
	savedImage = fileChooser.showSaveDialog(null);
	BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
	ImageIO.write(bImage, "png", savedImage);
	} catch(Exception e) {
	    System.err.println(e);
	}
    }

    /**
     * sets the name of the image and sets the label's text to that
     *@param name is a String that then sets the label to that string
     */
    public void setImageName(String name) {
	fileName = name;
    }

    /**
     * gets the name of the file. 
     */
    public String getImageName() {
	return fileName;
    }

    /**
     * sets the image to image that is passed to it. 
     *@param image is the image that is passed to it
     */
    public void setImg(Image image){
	this.image = image;
    }

    /**
     * gets the image and returns it to whatever method needs it.
     */
    public Image getImg() {
	return image;
    }
}