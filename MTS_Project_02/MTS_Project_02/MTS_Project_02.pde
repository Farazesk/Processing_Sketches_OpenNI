import SimpleOpenNI.*;

SimpleOpenNI kinect;

void setup() {
    size(1280, 480);
    kinect = new SimpleOpenNI(this);

    kinect.enableDepth();
    kinect.enableRGB();
}

void draw() {
    kinect.update();

    PImage depthImage = kinect.depthImage();
    PImage rgbImage = kinect.rgbImage();

    image(depthImage, 0, 0);
    image(rgbImage, 640, 0);
}
