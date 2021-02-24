import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import SimpleOpenNI.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MTS_Project_05 extends PApplet {


SimpleOpenNI kinect;

int clossetValue;
int closestX;
int closestY;

public void setup() {
    
    kinect = new SimpleOpenNI(this);
    kinect.enableDepth();
}

public void draw() {
    clossetValue = 8000;

    kinect.update();

    // get the depth arrat from the kinect
    int[] depthValues = kinect.depthMap();

    // For each row in the depth image
    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
            //pull out the corresponding value from the depth array
            int i = x  + y * width;
            int currentDepthValue = depthValues[i];

            //if that pixel is the closest one we've seen so far
            if (currentDepthValue > 0 && currentDepthValue < clossetValue) {
                //save its value
                clossetValue = currentDepthValue;

                //and save its position (both X and Y coordinates)
                closestX = x;
                closestY = y;
            }
        }
    }

    //draw the depth image on the screen
    image(kinect.depthImage(), 0, 0);

    /* draw a red circle over it
        positioned at the X and Y coordinates
        we saved of closest pixel.
    */
    fill(255, 0, 0);
    ellipse(closestX, closestY, 50, 50);


}

  public void settings() {  size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MTS_Project_05" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
