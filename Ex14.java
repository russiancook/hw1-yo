/**
 * Write a description of class Ex14 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex14
{
    //14-1
    
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
    
    //14-2
    
    public static int f (int[]a, int low, int high)
    {
        int res = 0;
        for(int i=low; i <=high; i++)
        {
            res += a[i];
        }
        return res;
    }
    
    public static int what (int []a)
    {
      int temp = 0;
      for (int i=0; i <= a.length; i++)
      {
          if (f(a, i, a.length -1 -i)%2 == 1)
          {
              temp = a.length;
          }
    
          else if (f(a, i, a.length -1 -(i+1))%2 == 1 || f(a, i + 1, a.length -1 -i)%2 == 1)
          {
              temp = a.length -(i + 1);
          }
      }
      return temp;
    }
    
    //14-3
    
    final static int MAX = 10;
    final static int MIN = 1;
    private static void printSolution(int x1, int x2, int x3)
    {
        System.out.println(x1 + " + " + x2 + " + " + x3);
    }
    
    private static int getSolutions(int num, int x1, int x2, int counter)
    {
        
        if(x1 > 10 || num - (x1 + x2) < 0)
            return counter;
        else if(x2 > 10 || num - (x1 + x2) == 0)
            return getSolutions(num, x1+1, 1, counter);
        else if(num - (x1 + x2) > 10)
            return getSolutions(num, x1, x2+1, counter);
        else
        {
            int x3 = num - (x1 + x2);
            printSolution(x1, x2, x3);
            return getSolutions(num, x1, x2+1, counter+1);
        }
    }
    
    public static int solutions(int num)
    {
        int counter = getSolutions(num, MIN, MIN, 0);
        return counter;
    }    
}
