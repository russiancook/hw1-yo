
/**
 * Write a description of class Point3D here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point3D
{
    // instance variables - replace the example below with your own
    private double _x, _y, _z;

    /**
     * Constructor for objects of class Point3D
     */
    public Point3D()
    {
        // initialise instance variables
        _x = 0.0;
        _y = 0.0;
        _z = 0.0;
    }
    
    public Point3D(double x, double y, double z)
    {
        // initialise instance variables
        _x = x;
        _y = y;
        _z = z;
    }
    
    public Point3D(Point3D otherPoint)
    {
        // initialise instance variables
        if (otherPoint != null)
        {
            _x = otherPoint._x;
            _y = otherPoint._y;
            _z = otherPoint._z;
        }
    }
    
    public double getX(Point3D point)
    {
        return _x;
    }
    
    public double gety()
    {
        return _y;
    }
    
    public double getX()
    {
        return _x;
    }
    
    public void setX(double num) 
    {
        _x = num;
    }
    
    public void setY(double num) 
    {
        _y = num;
    }
    
    public void setZ(double num) 
    {
        _z = num;
    }
    
    public String toString()
    {
        return "("+ _x + ","+ _y + "," + _z + ")";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double sampleMethod(int y)
    {
        // put your code here
        return _x + _y;
    }
}

