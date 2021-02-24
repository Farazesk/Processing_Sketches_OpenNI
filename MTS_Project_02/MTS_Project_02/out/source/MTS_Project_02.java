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

public class MTS_Project_02 extends PApplet {



SimpleOpenNI kinect;

public void setup() {
    
    kinect = new SimpleOpenNI(this);

    kinect.enableDepth();
    kinect.enableRGB();
}

public void draw() {
    kinect.update();

    PImage depthImage = kinect.depthImage();
    PImage rgbImage = kinect.rgbImage();

    image(depthImage, 0, 0);
    image(rgbImage, 640, 0);
}
  public void settings() {  size(1280, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MTS_Project_02" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
