
/**
 * Write a description of class Ex14 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex14
{
    private static int getHeighest(int [] heights)
    {
        int tmp = 0;
        for (int i = 1; i < heights.length; i++)
        {
            if (heights[tmp] <= heights[i])
                tmp = i;
        }
        if (tmp == heights.length - 1 && heights[tmp] == heights[0])
            return -1;
        return tmp;    
    }
    
    private static int beforeHigh(int [] heights, int highIndex)
    {
        int totalSum = 0;
        int sum = 0;
        int currentHigh = 0;
        int index = 1;
        while (index < highIndex) 
        {
            while (heights[currentHigh] >= heights[index] )
            {
                sum += heights[currentHigh] - heights[index];
                index++;
            }
            currentHigh = index;
        }
        
        return sum;
    }
    
    private static int afterHigh(int [] heights, int highIndex)
    {
        int totalSum = 0;
        int sum = 0;
        int currentHigh = heights.length - 1;
        int index = currentHigh -1;
        while (index > highIndex) 
        {
            while (heights[currentHigh] >= heights[index] )
            {
                sum += heights[currentHigh] - heights[index];
                index--;
            }
            currentHigh = index;
        }
        return sum;
    }
    private static int bothHigh(int [] heights)
    {
        int sum = 0;
        for (int i = 1; i < heights.length - 1; i++)
        {
            sum += heights[0] - heights[i];
        }
        return sum;
    }
    public static int waterVolume (int [] heights)
    {
        int sum = 0;
        int highest = getHeighest(heights);
        if (highest == 0)
            sum = afterHigh(heights, highest);
        else if (highest == heights.length -1)
            sum = beforeHigh(heights, highest);
        else if (highest == -1)
            sum = bothHigh(heights);
        else    
            sum = beforeHigh(heights, highest) + afterHigh(heights, highest);
        return sum;
    }
}
