import SimpleOpenNI.*;
SimpleOpenNI kinect;

int clossetValue;
int closestX;
int closestY;

void setup() {
    size(640, 480);
    kinect = new SimpleOpenNI(this);
    kinect.enableDepth();
}

void draw() {
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

