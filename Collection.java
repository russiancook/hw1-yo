    
/**
 * Write a description of class Collection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Collection
{
    // instance variables - replace the example below with your own
    private int _noOfBoxes;
    private Box3D [] _boxes;
    public final int MAX_NUM_BOXES = 100;

    /**
     * Constructor for objects of class Collection
     */
    public Collection()
    {
        // initialise instance variables
        _boxes = new Box3D[MAX_NUM_BOXES]; //Allocate memory
    }
    
    private void insertBox(Box3D box)
    {
        for (int i=_boxes.length-1; i>=0; i--)
        {
            if (_boxes[i] != null)
            {
                if (box.isLargerCapacity(_boxes[i]))
                {
                    _boxes[i+1] = new Box3D(box);
                    break;
                }
                else
                {
                    _boxes[i+1] = new Box3D(_boxes[i]);
                }
                
            }
        }
    }

    public boolean addBox(Point3D base, int length, int width, int height)
    {
        Box3D newBox = new Box3D(base, length, width, height);
        //Check if there is space by seeing if the last box is empty
        if (_boxes[_boxes.length -1] == null) 
        {
            insertBox(newBox);
            return true;
        }
    
        return false; 
    }
    
    public Box3D mostUpperBaseCorner()
    {
        int max = 0;
        Point3D maxPoint = new Point3D(_boxes[max].getBase());
        // loop will go until and of array or empty box
        for (int i=1; i < _boxes.length -1 && _boxes[i] != null; i++)
        {
            Point3D tempPoint = new Point3D(_boxes[i].getBase());
            if (maxPoint.isUnder(tempPoint))
            {
                maxPoint = new Point3D(tempPoint);
                max = i;
            }
            
        }
        return _boxes[max];
    }
    
    public double totalSurfaceArea()
    {
        double surfaceSum =0;
        for (int i=0; i < _boxes.length -1 && _boxes[i] != null; i++)
        {
            surfaceSum += _boxes[i].getSurface();
        }
        return surfaceSum;
    }
    
    public double longestDistance()
    {
        double maxDistance = 0;
        for (int i=0; i < _boxes.length -1 && _boxes[i] != null; i++)
        {
            for (int j=i+1; j < _boxes.length -1 && _boxes[j] != null; j++)
            {
                double currentDistance = _boxes[i].distance(_boxes[j]);
                if (currentDistance > maxDistance)
                    maxDistance = currentDistance;
            }
        }
        return maxDistance;
    }
}
