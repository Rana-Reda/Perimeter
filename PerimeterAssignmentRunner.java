import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    //This method counts the number of point in a shape
    public int getNumPoints (Shape s) {
        int numb = 0;
        //for every point in the shape
        for (Point currPt : s.getPoints()){
            //increment the count of points
            numb = numb +1;
        }
        return numb;
    }
    //this method return the average length of a shape
    public double getAverageLength(Shape s) {
        double totalPerim = 0.0;
        //get the last point in the shape s to start with
        Point prevPt = s.getLastPoint();
        int numb = 0;
        for (Point currPt : s.getPoints()){
           //get the distance between the current point and the previous one
           double currDist = prevPt.distance(currPt);   
           //add this distance to the total
           totalPerim = totalPerim + currDist;
           //update the previous point to be the current point to get the distance between it and the next point
           prevPt = currPt;
            numb = numb +1;
        }
        //get the average by dividing the total by the number of points in the shape
        double leng = totalPerim /(double) numb;
        return leng;
    
    }
    //method to return the longest side in the shape
    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double prevDist = 0.0;
        double largeDist = 0.0;
        for(Point currPt : s.getPoints()){
         double currDist = prevPt.distance(currPt);
         if(currDist> largeDist){
             largeDist = currDist;
             prevPt = currPt;
            }
          
        }
        return largeDist;
        
    }
    //method to get the largest x distance in the shape
    public double getLargestX(Shape s) {
        double largeX=0.0;
        Point prevPt =s.getLastPoint();
        double prevX = 0.0;
        for(Point currPt : s.getPoints()){
         //get the x distance of the current point
         double currX = currPt.getX();
         //compare it with the largest x 
         if(currX> largeX){
             //set the largest x to the longest of the two
             largeX = currX;
            
            }
            
        }
        return largeX;
        
    }
    //this method returns the largest perimeter of a shape in a muliple files
    public double getLargestPerimeterMultipleFiles() {
        // create a new directoryResource to open files
        DirectoryResource dr = new DirectoryResource();
        double largestperim=0.0;
        //for every file you selected
        for(File f : dr.selectedFiles()){
            //create a new fileResource to draw a shape
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            //call getPerimeter method to get the perimeter of this shape
            double perim = getPerimeter (s);
            //compare the perimeters of shapes to return the largest of them
            if (perim > largestperim){
                largestperim = perim;
              
            }
        }
        return largestperim;      
    }
    //this method returns the file with the shape that has the largest perimeter
    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestperim=0.0;
        File temp = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter (s);
            if (perim > largestperim){
                largestperim = perim;
                temp = f;
              
            }
        }
        
        //get the name of this file and then return it
        return temp.getName();
    }
    //this method tests the perimeter method
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int number = getNumPoints(s);
        double leng = getAverageLength(s);
        double largeside = getLargestSide(s);
        double largex = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + number);
        System.out.println("average length = " +leng);
        System.out.println("largest side =" +largeside);
        System.out.println("largest x =" +largex);
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
        
    }
    
    public void testPerimeterMultipleFiles() {
        double largestperim = getLargestPerimeterMultipleFiles();
        System.out.println(" largestpermit = " + largestperim);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("file name: " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
