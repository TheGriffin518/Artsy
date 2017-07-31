package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.PixelReader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.io.File;
import javafx.scene.control.Label;

public class ViewPane extends VBox {

    ImageView imgView = new ImageView();
    Button rotate = new Button("Rotate");
    Button reset = new Button("Reset");
    ImageSelect selectImage = new ImageSelect();
    Image src;
    Image image1 = new Image("file:resources/default.png",300,300,false,false);
    MyArtsy artsy = new MyArtsy();
    TextBox textBox = new TextBox();
    Label fileName, imageNum;
    String initialLabel;

    
    public ViewPane() {
	super();
	fileName = new Label();
	src = image1;
	imageSet(image1);
	setSpacing(5);
	getChildren().addAll(fileName,imgView, rotate, reset);
	rotate.setOnAction(event -> rotate());
    }

    /**
     *prompts the user to rotate the image that is located within this viewPane
     *
     */
    public void rotate() {
	Image rot;
	double degrees = textBox.rotate();
	rot = artsy.doRotate(getImage(), degrees);
	imgView.setImage(rot);
    }

    /**
     *opens up a FileChooser to let the user select an image
     */
    public void chooseImage() {
	src = selectImage.select();
	imgView.setImage(src);
	fileName.setText(initialLabel + selectImage.getImageName());
    }

    /**
     *takes the image that the user uses selects and displays it into the ImageView
     */

    public void imageSet(Image image) {
	imgView.setImage(image);
    }

    /**
     *gets the image from the ImageView and returns that image
     *@return Image that is currently in the ImageView
     */
    public Image getImage() {
	return imgView.getImage();
    }

    /**
     *sets the image of the ImageView to what the default image was
     */
    public void resetImage() {
	imgView.setImage(image1);
    }

    /**
     *opens up a FileChooser that allows the user to select where they would like to save their image
     *
     */
    public void saveImage() {
	selectImage.saveImage(imgView.getImage());
    }
}