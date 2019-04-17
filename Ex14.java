/**
 * Write a description of class Ex14 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex14
{
    //14-1
    // Helper function to get heighest point
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
    
    // The function sum the amount of water stored up to the highest point
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
    
    // The function sum the amount of water stored after the highest point
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
    
    // Deals with the case that both edges are the high points
    private static int bothHigh(int [] heights)
    {
        int sum = 0;
        for (int i = 1; i < heights.length - 1; i++)
        {
            sum += heights[0] - heights[i];
        }
        return sum;
    }
    
    /**
     * Returns the amount of water that the given water pot can hold
     * The efficiency is O(n) and the space is O(n)
     * @param heights the array representing the shape of the water pot
     * @return sum the total amount of water it can hold
     */
    public static int waterVolume (int [] heights)
    {
        int sum = 0;
        int highest = getHeighest(heights);
        // First is highest
        if (highest == 0)
            sum = afterHigh(heights, highest);
        // last is highest
        else if (highest == heights.length -1)
            sum = beforeHigh(heights, highest);
        // Both edges are the highest
        else if (highest == -1)
            sum = bothHigh(heights);
        // Highest is in the middle
        else    
            sum = beforeHigh(heights, highest) + afterHigh(heights, highest);
        return sum;
    }
    
    //14-2
    /**
     * Returns the amount of water that the given water pot can hold
     * The efficiency is O(n) and the space is O(n)
     * @param a the array of given numbers
     * @param low the number to start summing from
     * @param high the number to end summing at
     * @return res the sum of the array between the 2 numbers
     */
    public static int f (int[]a, int low, int high)
    {
        int res = 0;
        for(int i=low; i <=high; i++)
        {
            res += a[i];
        }
        return res;
    }
    
    /**
     * Returns the length of the longest chunk of numbers who's sum is odd
     * The efficiency was O(n^2). After the fix it became O(n)
     * @param a the array of given numbers
     * @return temp the length of the longest chunk of numbers who's sum 
     * is odd
     */
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
    // Helper function for printing
    private static void printSolution(int x1, int x2, int x3)
    {
        System.out.println(x1 + " + " + x2 + " + " + x3);
    }
    
    // The function that counts the solutions by testing the possible ones
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
    /**
     * Returns the possible options that an equation with 3 parameters 
     * between 1 - 10 that equal the given number.
     * Works by calling getSolutions which calls itself while iterating 
     * through the possible solutions
     * @param num the number that is the result of the equation
     * @return counter the amount of possible solutions
     */
    public static int solutions(int num)
    {
        int counter = getSolutions(num, MIN, MIN, 0);
        return counter;
    }    
}


//14-4
    
    private static String printPath(int path[][])
    {
       String theMatrix= "";
       
       for (int i = 0; i < path.length; i++)
       {
           for (int j = 0; j < path[0].length; j++)
           {
               // Avoid adding a \t at the end of each line
               if (j != path[0].length -1)
                    theMatrix = theMatrix + path[i][j] + "\t";
               else
                    theMatrix = theMatrix + path[i][j];
           }
           theMatrix = theMatrix + "\n";
       }
       return theMatrix;
    }
    
    private static boolean checkMove(int path[][], int i, int j)
    {
        if(i >= path.length || j >= path.length || i < 0 || j < 0 || path[i][j] == 1)
            return false;
        return true;
    }
    
    public static boolean findSum (int mat[][], int sum, int path[][])
    {
        int i,j =0;
        if (findSum(mat, sum, path, 0, 0, 0))
            return true;
        return false;
    }
    
    private static boolean findSum (int mat[][], int sum, int path[][], int i, 
    int j, int currentSum)
    {
        currentSum += mat[i][j];
        if (sum < currentSum)
        {    
            path[i][j] = 0;
            return false;
        }
        
        else if (sum == currentSum)
        {
            path[i][j] = 1;
            System.out.println(printPath(path));
            return true;
        }
        
        else
        {
            path[i][j] = 1;
            if(checkMove(path, i+1, j) && 
            findSum(mat, sum, path, i+1, j, currentSum))
            {
                return true;
            }
            else if(checkMove(path, i, j+1) && 
            findSum(mat, sum, path, i, j+1, currentSum))
            {
                return true;
            }
            else if(checkMove(path, i-1, j) && 
            findSum(mat, sum, path, i-1, j, currentSum))
            {
                return true;
            }
            else if(checkMove(path, i, j-1) && 
            findSum(mat, sum, path, i, j-1, currentSum))
            {
                return true;
            }
            else
            {
                path[i][j] =0;
                return false;
            }
            
        }
    }
}
