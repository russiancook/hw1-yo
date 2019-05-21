/**
 * Write a description of class Ex14 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.lang.Math;

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
            if (heights[index] == heights[highIndex])
                index++;
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
            if (heights[index] == heights[highIndex])
                index--;
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
     * The efficiency is O(n) and the space is O(1)
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
     * Returns the length of the longest chunk of numbers who's sum is even
     * The efficiency was O(n^3). After the fix it became O(n) 
     * The space effeciency is now o(1)
     * @param a the array of given numbers
     * @return temp the length of the longest chunk of numbers who's sum 
     * is odd
     */
    public static int what (int []a)
    {
        int sum = 0; 
        int len = 0;
        
        for (int i = 0; i < a.length; i++) 
        { 
          sum += a[i]; 
        } 
        
        if (sum % 2 == 0)  
            return a.length;
            
        for (int i = 0; i < a.length; i++)  
        { 
            if (Math.abs(a[i] % 2) == 1 ) 
            { 
                len = Math.max(len, Math.max(a.length - i - 1, i)); 
            } 
        } 
  
        return len;
     
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
        if (num > 30 || num < 3)
            return 0;
        else
        {
            int counter = getSolutions(num, MIN, MIN, 0);
            return counter;
        }
    }    



    //14-4
    
    // Check if the place in the path is one we can continue on
    private static boolean checkMove(int path[][], int i, int j)
    {
        if(i >= path.length || j >= path.length || i < 0 || j < 0 || path[i][j] == 1)
            return false;
        return true;
    }
    
    /**
     * Returns true if there is a path in the mat that equals the given sum 
     * @param mat an array containing the numbers to go through
     * @param sum the sum that the path needs to equal
     * @param path an array containing 1's where the path to the sum goes through
     * @return true if there is a possible path to the sum
     */
    public static boolean findSum (int mat[][], int sum, int path[][])
    {
        int i,j =0;
        if (findSum(mat, sum, path, 0, 0, 0))
        {
            return true;
        }
        return false;
    }
    
    // Recursively move through the path to find the sum
    private static boolean findSum (int mat[][], int sum, int path[][], int i, 
    int j, int currentSum)
    {
        currentSum += mat[i][j];
        if (sum == currentSum)
        {
            path[i][j] = 1;
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
                path[i][j] = 0;
                
                if(currentSum - mat[i][j] == 0)
                {
                    if (j == path.length -1)
                    {
                        if (i == path.length - 1 )
                            return false;
                        else
                            return findSum(mat, sum, path, i+1, 0, 0);
                    }
                    else
                        return findSum(mat, sum, path, i, j+1, 0);
                }
                else
                    return false;
            } 
        }
    }
}
