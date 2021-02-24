import SimpleOpenNI.*;
SimpleOpenNI kinect;

void setup() {
    size(640, 480);
    kinect = new SimpleOpenNI(this);
    kinect.enableDepth();
}

void draw() {
    kinect.update();

    PImage depthImage = kinect.depthImage();
    image(depthImage, 0, 0);
}

void mousePressed() {
    int[] depthValues = kinect.depthMap();
    int clickPosition = mouseX + mouseY * width;
    int clickDepth = depthValues[clickPosition];

    float millimeters = depthValues[clickPosition] / 1000.0;
    float inches = clickDepth / 25.4;

    println("m: " + millimeters + ", inches: " + inches);
}

