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

public class MTS_Project_04 extends PApplet {


SimpleOpenNI kinect;

public void setup() {
    
    kinect = new SimpleOpenNI(this);
    kinect.enableDepth();
}

public void draw() {
    kinect.update();

    PImage depthImage = kinect.depthImage();
    image(depthImage, 0, 0);
}

public void mousePressed() {
    int[] depthValues = kinect.depthMap();
    int clickPosition = mouseX + mouseY * width;
    int clickDepth = depthValues[clickPosition];

    float inches = clickDepth / 25.4f;

    println("inches: " + inches);
}

  public void settings() {  size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MTS_Project_04" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
