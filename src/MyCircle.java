// Class for representing circles as MyCircle objects
public class MyCircle {
   private double x; // center x-coordinate on the drawing canvas
   private double y; // center y-coordinate on the drawing canvas
   private double r; // radius of the circle

   // constructor for creating a MyCircle object with given x, y and r values
   MyCircle(double x, double y, double r) {
      this.x = x;
      this.y = y;
      this.r = r;
   }

   public double getRadius() {
      return r;
   }

   // method for drawing a MyCircle object
   public void draw() {
      StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
      StdDraw.setPenRadius(0.001);
      StdDraw.filledCircle(x, y, r);
   }

   // method for computing and returning the distance between the centers of this
   public double distance(MyCircle p) {
      return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
   }
}
