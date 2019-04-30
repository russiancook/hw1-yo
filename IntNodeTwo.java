
/**
 * Write a description of class IntNodeTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntNodeTwo
{
    // instance variables - replace the example below with your own
    private int _num;
    private IntNodeTwo _next, _prev;
    /**
     * Constructor for objects of class IntNodeTwo
     */
    public IntNodeTwo(int n)
    {
        // initialise instance variables
        _num = n;
        _next = null;
        _prev = null;
    }
    
    public IntNodeTwo(int num, IntNodeTwo n, IntNodeTwo p)
    {
        // initialise instance variables
        _num = num;
        _next = n;
        _prev = p;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getNum()
    {
        // put your code here
        return _num;
    }
    
    public IntNodeTwo getNext()
    {
        return _next;
    }
    
    public IntNodeTwo getPrev()
    {
        return _prev;
    }
    
    public void setNum(int n)
    {
        _num = n;
    }
    
    public void setNext(IntNodeTwo node)
    {
        _next = node;
    }
    
    public void setPrev(IntNodeTwo node)
    {
        _prev = node;
    }
}
