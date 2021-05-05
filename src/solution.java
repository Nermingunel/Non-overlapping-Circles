import java.util.Random; // used for generating random values for circle parameters
import java.util.ArrayList; // used for storing non-overlapping random circles

public class solution {
   public static void main(String[] args) {
      // number of non-overlapping random circles to be created
      int N = 250;

      // drawing parameters
      // set the size of the drawing canvas
      int canvas_width = 600, canvas_height = 600;
      StdDraw.setCanvasSize(canvas_width, canvas_height);
      StdDraw.setScale(0, 1); // both x and y coordinates are in the range [0, 1]
      // drawing canvas white
      StdDraw.clear(StdDraw.WHITE);

      // create an array list for storing non-overlapping random circles
      ArrayList< MyCircle> circles = new ArrayList<>();

      // generate N non-overlapping random circles
      Random randomGenerator = new Random(); // create a random number generator
      double rMin = 0.01, rMax = 0.2; // range for random circle radiuses

      // loop until N non-overlapping random circles are created
      while (circles.size() < N) {
         double r = rMin + (rMax - rMin) * randomGenerator.nextDouble();
         double x = r + (1 - 2 * r) * randomGenerator.nextDouble();
         double y = r + (1 - 2 * r) * randomGenerator.nextDouble();
        
         MyCircle p = new MyCircle(x, y, r);

         // create a flag that shows if there is any intersection between the circle
         // p and the circles created before p
         boolean intersect = false;
         // check each non-overlapping random circle in the circles array list
         for (MyCircle circle : circles) // using a for-each loop
            if (circle.distance(p) < p.getRadius() + circle.getRadius()) {
               intersect = true;
               break;
            }
        
         if (intersect)
            continue; // continue from the next iteration of the while loop

         // add the non-overlapping circle p to the circles array list
         circles.add(p);
         // draw the circle on the drawing canvas
         p.draw();
         // print the number of non-overlapping random circles created so far
         System.out.printf("Circle count: %5d\n", circles.size());
      }
      
      // save the resulting image as a file
      String outputFileName = "out_" + N + ".png";
      StdDraw.save(outputFileName);
      System.out.println("Program finished.");
   }
}
