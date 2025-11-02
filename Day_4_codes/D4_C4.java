/* Question 4 - Write a program in java to exploit constructor overloading. (cube and cuboid volume calculation

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

class Main {
    public static void main(String args[]) {

        // create shapes using various constructors
        ThreeDimensionShape shape1 = new ThreeDimensionShape(5, 6, 7); 
        ThreeDimensionShape shape2 = new ThreeDimensionShape();        
        ThreeDimensionShape shape3 = new ThreeDimensionShape(8);       

        double volume; 

        volume = shape1.volume();
        System.out.println("Volume of shape1 is " + volume);

        volume = shape2.volume();
        System.out.println("Volume of shape2 is " + volume);

        volume = shape3.volume();
        System.out.println("Volume of shape3 is " + volume);
    }
}

class ThreeDimensionShape {
    double width, height, depth;

  
    ThreeDimensionShape(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    ThreeDimensionShape(double length) {
        width = height = depth = length;
    }

    ThreeDimensionShape() {
        width = height = depth = 0;
    }

    // compute and return volume
    double volume() {
        return width * height * depth;
    }
}