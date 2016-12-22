
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.color.CMMException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class MinimizeImages {

	private static int IMG_WIDTH;
	private static int IMG_HEIGHT;
	private static int division;
	private static boolean dontTouch;
	public static void main(String[] args){
		
		try{
			String query = "SELECT pTitle FROM People WHERE peopleId IN (SELECT fkPeopleId FROM moviepeople WHERE fkMovieId='tt0071562')";
			ArrayList<People> list = SqlOperations.getPeople(query);
			for(int i = 0; i < list.size(); i++){
				BufferedImage originalImage;
				
				originalImage = ImageIO.read(new File("C://Workplace//OurIMDb//DB//PeopleOriginalImages//"+ list.get(i).getpTitle() +".jpg"));
				
				int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
				IMG_HEIGHT = originalImage.getHeight();
				IMG_WIDTH = originalImage.getWidth();				
				
				if(IMG_HEIGHT == 200 && IMG_WIDTH == 148){
					dontTouch = true;
				}
				else if(IMG_HEIGHT < 300 || IMG_WIDTH < 300){
					division = 1;
					dontTouch = false;
				}
				else if(IMG_HEIGHT < 600 || IMG_WIDTH < 600){
					division = 2;
					dontTouch = false;
				}
				else{
					division = 3;
					dontTouch = false;
				}
				if(!dontTouch){
					BufferedImage resizeImageJpg = resizeImage(originalImage, type);
					ImageIO.write(resizeImageJpg, "jpg", new File("C://Workplace//OurIMDb//DB//PeopleMinimizedImages//"+ list.get(i).getpTitle() +".jpg"));
				}
				else{
					ImageIO.write(originalImage, "png", new File("C://Workplace//OurIMDb//DB//PeopleMinimizedImages//"+ list.get(i).getpTitle() +".jpg"));
				}
				System.out.println("" + i + " " + list.get(i).getpTitle());
			}
			
			System.out.println("done");
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}

	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type){
	
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH / division, IMG_HEIGHT / division, type);
	   	Graphics2D g = resizedImage.createGraphics();
	   	g.drawImage(originalImage, 0, 0, IMG_WIDTH / division, IMG_HEIGHT / division, null);
	   	g.dispose();

	   	return resizedImage;
    }
		
}