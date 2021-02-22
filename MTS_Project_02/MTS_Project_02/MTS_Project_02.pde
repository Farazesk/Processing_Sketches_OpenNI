import SimpleOpenNI.*;

SimpleOpenNI kinect;

void setup() {
    size(1280, 640);
    kinect = new SimpleOpenNI(this);

    kinect.enableDepth();
    kinect.enableRGB();
}

void draw() {
    kinect.update();

    image(kinect.depthImage(), 0, 0);
    image(kinect.rgbImage(), 640, 0);
}

