         
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
    
    /**
     * Finds and returns the box with the highest base point
     * @return The box with the highest base point
     */
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
    
    /**
     * Calculates the sum of the 3D boxes in the collection
     * @return The total surface area of the collection's boxes
     */
    public double totalSurfaceArea()
    {
        double surfaceSum =0;
        for (int i=0; i < _boxes.length -1 && _boxes[i] != null; i++)
        {
            surfaceSum += _boxes[i].getSurface();
        }
        return surfaceSum;
    }
    
    /**
     * Calculates the longest distance between the farthest boxes in the 
     * collection
     * @return The longest distance between the base point of farthest boxes
     */
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
    
    // Checks if number is in array
    private boolean checkIndex(int number)
    {
        if (number >= MAX_NUM_BOXES || number < 0)
            return false;
        return true;
    }
    
    /**
     * Returns the volume of the smallest 3D box that can contain
     * any box between the indexes
     * @param i an index in the array
     * @param j another index in the array
     * @return the volume of the smallest 3D box that can contain
     * any box between the indexes
     */
    public int volumeOfSmallestBox(int i, int j)
    {
        int bigger;
        if (!checkIndex(i) || !checkIndex(i))
            return 0;
        // The array is in size order therefore the further down one is the biggest
        else
        {
            if (i > j)
                bigger = i;
            else 
                bigger = j;
            Box3D bigBox = new Box3D(_boxes[bigger]);
            // in order to make the box bigger than the largest well add 1 to all parameters 
            bigBox.setLength(bigBox.getLength() + 1);
            bigBox.setWidth(bigBox.getWidth() + 1);
            bigBox.setHeight(bigBox.getHeight() + 1);
            int biggestSize = bigBox.getVolume();
            return biggestSize;
        }
    }
    
    /**
     * Returns the number of 3D boxes in the collection
     * @return the amount of 3D Boxes in the collection
     */
    public int getNumOfBoxes()
    {
        int counter = 0;
        while (counter < _boxes.length -1 && _boxes[counter] != null)
        {
            counter++;
        }
        //adding 1 cause we started from 0
        return counter + 1;
    }
    
    /**
     * Returns a collection containing only the full part of given one
     * @return An array containing a the full 3D boxes
     */
    public Box3D[] getBoxes()
    {
        Box3D [] newBoxes;
        int totalBoxes = getNumOfBoxes();
        newBoxes = new Box3D[totalBoxes];
        for (int i = 0; i < totalBoxes - 1; i++)
        {
            newBoxes[i] = new Box3D(_boxes[i]);
        }
        return newBoxes;
    }
    
    /**
     * Returns the 3D boxes in Box3D format
     * @return A string listing the 3D boxes in the collection 
     */
    public String toString()
    {
        String allBoxes = "";
        int totalBoxes = getNumOfBoxes();
        for (int i = 0; i < totalBoxes - 1; i++)
        {
            allBoxes = allBoxes + "\n" + _boxes[i].toString();
        }
        return allBoxes;
    }
}

