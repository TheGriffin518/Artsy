package cs1302.p2;

import cs1302.effects.Artsy;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import java.lang.Math;
import java.lang.IndexOutOfBoundsException;

public class MyArtsy implements Artsy {
    /**
     *Places checkers using image one and image two as its sources.
     *It places the resulting image into the ViewPane named Result.
     *@param src1 is the image from ViewPane 1
     *@param src2 is the image from ViewPane 2
     *@return image that is then passed into ViewPane 3
     */
    @Override
    public Image doCheckers(Image src1, Image src2, int size) {

	int row = size;
	int col = size;

	WritableImage ret = new WritableImage(300,300);
	
	PixelReader pr1 = src1.getPixelReader();
	PixelReader pr2 = src2.getPixelReader();
	PixelReader prRet = ret.getPixelReader();

	PixelWriter pw = ret.getPixelWriter();

	//sets ret to all of src1
	for(int x = 0; x < 300; ++x){
	    for(int y = 0; y < 300; ++y){

		pw.setArgb(x, y, pr1.getArgb(x,y));
	    }
	   
	}
	
	//places horizontal stripes
	do{
	    for(int x = 0; x < size; ++x){
		for(int y = 0; y < 300; ++y){
		    pw.setArgb(y, col, pr2.getArgb(y, col));
		}
		col++;
	    }
	    col += size;

	}while(col < 300);
	
	//places vertical stripes by flipping which image the pixel got its color from. Creates checkered pattern
	do{
	    for(int x = 0; x < size; ++x){
		for(int y = 0; y < 300; ++y){
		    if(prRet.getArgb(row,y) ==  pr1.getArgb(row,y)){
		    pw.setArgb(row, y, pr2.getArgb(row, y));
		    }
		    else pw.setArgb(row, y, pr1.getArgb(row,y));
		}
		row++;
	    }
	    row += size;
	}while(row < 300);
	 
	    return ret;
	

    } // doCheckers


    /**
     *Places vertical stripes using the images from ViewPane 1 and ViewPane 2 
     *as sources. Places the image into ViewPane 3
     *
     *@param src1 is the image from ViewPane 1
     *@param src2 is the image from ViewPane 2
     *@return the result image and passes it to ViewPane 3
     */
    @Override
    public Image doVerticalStripes(Image src1, Image src2, int width) {
	
	int row = width;
	
	WritableImage ret = new WritableImage(300,300);
	
	PixelReader pr1 = src1.getPixelReader();
	PixelReader pr2 = src2.getPixelReader();

	PixelWriter pw = ret.getPixelWriter();

	//sets image ret to src1
	for(int x = 0; x < 300; ++x){
	    for(int y = 0; y < 300; ++y){

		pw.setArgb(x, y, pr1.getArgb(x,y));
	    }
	}

	//adds stripes that are src2 over src1 in image ret
	do{
	    for(int x = 0; x < width; ++x){
		for(int y = 0; y < 300; ++y){
		    pw.setArgb(row, y, pr2.getArgb(row, y));
		}
		row++;
	    }
	    row += width;
	}while(row < 300);
	 
	    return ret;
	    
    } // doVerticalStripes

    /**
     * Rotates the image from the ViewPane in which the button was pressed.
     *Takes in degrees form the user.
     *
     *@param src is the image from the ViewPane in which the rotate button was pressed
     *@param degrees is what the user passes in 
     *@return returns the roated image to the same ViewPane in which the src originated from.
     */
    @Override
    public Image doRotate(Image src, double degrees) {

	int xI, yI;
	//converts the degrees that are passed into radians for Math.cos and Math.sin to use
	double rad = (degrees * Math.PI) / 180;
	
	WritableImage ret = new WritableImage(300,300);
	PixelReader pr = src.getPixelReader();
	PixelWriter pw = ret.getPixelWriter();

	for(int y = 0; y < 300; ++y){
	    for(int x = 0; x < 300; ++x){
		
		//formula for matrix rotation. Uses the values to determine where the pixelreader should grab the color information from
		xI = (int)(((x - src.getWidth() / 2) * Math.cos(-rad)) - ((y - src.getHeight() / 2) * Math.sin(-rad)) + src.getWidth() / 2);
		yI = (int)(((x - src.getWidth() / 2) * Math.sin(-rad)) + ((y - src.getHeight() / 2) * Math.cos(-rad)) + src.getWidth() / 2);

		try{
		    //grabs the color information from where the image will end up being rotated to
		    //is a form of interpolation that helps with the loss of pixels as image is rotated
		    pw.setArgb(x, y, pr.getArgb(xI,yI));
		
		}catch(IndexOutOfBoundsException e){
		    continue;
		}
		
	    }
	}

	return ret;

    } // doRotate


    /**
     *Places horizontal stripes onto the image using the images from ViewPane 1 and 2. 
     * It places the resulting image into ViewPane 3
     *@param src1 is the image from ViewPane 1
     *@param src2 is the image from ViewPane 2
     *@return returns the resulting image and passes the result off to ViewPane 3
     */
    @Override
    public Image doHorizontalStripes(Image src1, Image src2, int height) {

	int col = height;

	WritableImage ret = new WritableImage(300,300);
	
	PixelReader pr1 = src1.getPixelReader();
	PixelReader pr2 = src2.getPixelReader();

	PixelWriter pw = ret.getPixelWriter();

	//sets the WritableImage ret to the first image
	for(int x = 0; x < 300; ++x){
	    for(int y = 0; y < 300; ++y){

		pw.setArgb(x, y, pr1.getArgb(x,y));
	    }
	}

	//goes through and adds stripes of src2 to the WritableImage
	do{
	    for(int x = 0; x < height; ++x){
		for(int y = 0; y < 300; ++y){
		    pw.setArgb(y, col,  pr2.getArgb(y, col));
		}
		col++;
	    }
	    col += height;

	}while(col < 300);
	 
	    return ret;

    } // doHorizontalStripes

} // MyArtsy


