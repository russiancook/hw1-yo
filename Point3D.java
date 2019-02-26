
/**
 * Write a description of class Point3D here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.Math;

public class Point3D
{
    // instance variables - replace the example below with your own
    private double _x, _y, _z;

    /**
     * Constructor and initializer for a point at
     * (x,y,z) initializes at 0
     */
    public Point3D()
    {
        // initialise instance variables
        _x = 0.0;
        _y = 0.0;
        _z = 0.0;
    }
    
    /**
     * Constructor and initializer for a point at
     * (x,y,z)
     * @param x The X coordinate of this point
     * @param y The Y coordinate of this point
     * @param z The Z coordinate of this point
     */
    public Point3D(double x, double y, double z)
    {
        // initialise instance variables
        _x = x;
        _y = y;
        _z = z;
    }
    
    /**
     * Constructor and initializer for a point at
     * (x,y,z)
     * @param otherPoint initializes based on other point
     */
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
    
    /**
     * Returns the X coordinate of the point
     * @return _x the x coordinate
     */
    public double getX(Point3D point)
    {
        return _x;
    }
    
    /**
     * Returns the Y coordinate of the point
     * @return _y the y coordinate
     */
    public double gety()
    {
        return _y;
    }
    
    /**
     * Returns the Z coordinate of the point
     * @return _z the z coordinate
     */
    public double getZ()
    {
        return _z;
    }
    
    /**
     * Sets the X coordinate of the point
     * @param num The new value of X
     */
    public void setX(double num) 
    {
        _x = num;
    }
    
    /**
     * Sets the Y coordinate of the point
     * @param num The new value of Y
     */
    public void setY(double num) 
    {
        _y = num;
    }
    
    /**
     * Sets the Z coordinate of the point
     * @param num The new value of Z
     */
    public void setZ(double num) 
    {
        _z = num;
    }
    
    /**
     * Returns the Coordinates of the point in (x,y,z) format
     * @return a string in (x,y,z) format
     */
    public String toString()
    {
        return "("+ _x + ","+ _y + "," + _z + ")";
    }
    
    /**
     * Checks if 2 3D Points are the same
     * @param point A 3D Point which is compared to another one 
     * @return true if equals false if doesnt equal
     */
    public boolean equals(Point3D point)
    {
        if ( _x == point._x && _y == point._y && _z == point._z)
        {
            return true;
        }
        return false;
           
    }
    
    /**
     * Checks if a 3D Point is above another one
     * @param point A 3D Point which is compared in 
     * height(the z grid) 
     * @return true if point is above. false if not
     */
    public boolean isAbove(Point3D point)
    {
        if (_z > point._z)
            return true;
        return false;
    }
    
    /**
     * Checks if a 3D Point is under another one.
     * @param point A 3D Point which is compared in 
     * height(the z grid) 
     * @return true if point is under. false if not
     */
    public boolean isUnder(Point3D point)
    {
        if (isAbove(point) == true)
            return false;
        return true;
    }
    
    /**
     * Checks if a 3D Point is left to another one
     * @param point A 3D Point which is compared in 
     * side to side(the y grid) 
     * @return true if point is left. false if not
     */
    public boolean isLeft(Point3D point)
    {
        if (_y > point._y)
            return true;
        return false;
    }
    
    /**
     * Checks if a 3D Point is right to another one.
     * @param point A 3D Point which is compared in 
     * side to side(the y grid) 
     * @return true if point is right. false if not
     */
    public boolean isRight(Point3D point)
    {
        if (isLeft(point) == true)
            return false;
        return true;
    }
    
    /**
     * Checks if a 3D Point is behind another one
     * @param point A 3D Point which is compared in 
     * behind(the x grid) 
     * @return true if point is behind. false if not
     */
    public boolean isBehind(Point3D point)
    {
        if (_x > point._x)
            return true;
        return false;
    }
    
    /**
     * Checks if a 3D Point is inFront of another one.
     * @param point A 3D Point which is compared in 
     * front(the x grid) 
     * @return true if point is in front. false if not
     */
    public boolean isInFrontOf(Point3D point)
    {
        if (isBehind(point) == true)
            return false;
        return true;
    }
    
    /**
     * Moves the point coordinates x by dx, y by dy, z by dz.
     * @param dx the amount to move the x coordinate
     * @param dy the amount to move the y coordinate
     * @param dz the amount to move the z coordinate
     */
    public void move(double dx, double dy, double dz)
    {
        _x+=dx;
        _y+=dy;
        _z+=dz;
    }
    
    /**
     * Checks the distance between tho 3D points.
     * @param point A 3D Point which the distance is measured from 
     * @return the distance between the 2 points
     */
    public double distance(Point3D p)
    {
        return Math.sqrt(Math.pow((_x - p._x),2) + Math.pow((_y - p._y),2)
                        + Math.pow((_z - p._z),2));
    }

    
}

