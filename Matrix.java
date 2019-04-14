    
/**
 * Write a description of class Matrix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Matrix
{
    // instance variables 
    private int[][] _matrix;

    /**
     * Constructs a Matrix from a two-dimensional array. The dimensions
     * as well as the values of this matrix will be the same as the 
     * dimensionsand values of the values of the 2D array.
     */
    public Matrix(int[][] array)
    {
        // parameters to shorten text
        int len = array.length;
        int height = array[0].length;
        // initialize size
        _matrix = new int[len][height];
        // Copy 2D elements 
        for (int i = 0; i < len ; i++)
        {
            for (int j = 0; j < height; j++)
            {
                _matrix[i][j] = array[i][j];
            }
        }
    }
    
    /**
     * Constructs a size1 by size2 Matrix of zeroes.
     */
    public Matrix(int size1, int size2)
    {
        _matrix = new int[size1][size2];
        for (int i = 0; i < size1 ; i++)
        {
            for (int j = 0; j < size2; j++)
            {
                _matrix[i][j] = 0;
            }
        }
    }
    
    /**
     * 
     * @return  
     */
    public String toString()
    {
       String theMatrix= "";
       
       for (int i = 0; i < _matrix.length; i++)
       {
           for (int j = 0; j < _matrix[0].length; j++)
           {
               // Avoid adding a \t at the end of each line
               if (j != _matrix[0].length -1)
                    theMatrix = theMatrix + _matrix[i][j] + "\t";
               else
                    theMatrix = theMatrix + _matrix[i][j];
           }
           theMatrix = theMatrix + "\n";
       }
       return theMatrix;
    }

    public Matrix makeNegative()
    {
        Matrix negativeMatrix = new Matrix(_matrix);
       for (int i = 0; i < _matrix.length; i++)
       {
           for (int j = 0; j < _matrix[0].length; j++)
           {
               negativeMatrix._matrix[i][j] = 255 - negativeMatrix._matrix[i][j];
           }
       }
       return negativeMatrix;
    }
    
    // Check if place is in matrix
    private boolean inMatrix(int line, int col)
    {
        if ( _matrix.length > line && line >= 0 &&  _matrix[0].length > col
        && col >= 0)
            return true;
        return false;
    }
    
    // Get area average
    private int areaAverage(int line, int col)
    {
        int sum = 0;
        int counter = 0;
        for (int i = line - 1; i <= line + 1; i++)
        {
            for (int j = col - 1; j <= col + 1; j++)
            {
                if (inMatrix(i, j))
                {
                    sum += _matrix[i][j];
                    counter ++;
                }
            }
        }
        return (int)(sum / counter);
    }
    
    public Matrix imageFilterAverage()
    {
        Matrix newMatrix = new Matrix(_matrix.length,_matrix[0].length);
        for (int i = 0; i < _matrix.length; i++)
        { 
            for (int j = 0; j < _matrix[0].length; j++)
            {
                newMatrix._matrix[i][j] = areaAverage(i, j);
            }
        }
        return newMatrix;
    }
    
    public Matrix rotateClockwise()
    {
        Matrix newMatrix = new Matrix(_matrix[0].length,_matrix.length);
        for (int i = 0; i < _matrix.length; i++)
        { 
            for (int j = 0; j < _matrix[0].length; j++)
            {
                newMatrix._matrix[j][_matrix.length -1 -i] = _matrix[i][j];
            }
        }
        return newMatrix;
    }
    
    public Matrix rotateCounterClockwise()
    {
        Matrix newMatrix = new Matrix(_matrix);
        newMatrix = newMatrix.rotateClockwise().rotateClockwise().rotateClockwise();
        return newMatrix;
    }
}
