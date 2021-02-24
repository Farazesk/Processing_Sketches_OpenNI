import SimpleOpenNI.*;
SimpleOpenNI kinect;

void setup() {
    size(1280, 480);
    kinect = new SimpleOpenNI(this);

    kinect.enableRGB();
    kinect.enableDepth();
}

void draw() {
    kinect.update();

    PImage depthImage = kinect.depthImage();
    PImage rgbImage = kinect.rgbImage();

    image(rgbImage, 0, 0);
    image(depthImage, 640, 0);
}

void mousePressed() {
    color c = get(mouseX, mouseY);
    println("r: " + red(c) + " g: " + green(c) + " b: " + blue(c));
}

