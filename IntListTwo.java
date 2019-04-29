
/**
 * Write a description of class IntListTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntListTwo
{
    private IntNodeTwo _head, _tail;
    
    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }
    
    public IntListTwo(IntNodeTwo h, IntNodeTwo t)
    {
        _head = h;
        _tail = t;
    }
    
    public void addNumber(int num)
    {
        IntNodeTwo temp = _head;
        while(temp.getNum() < num )
        {
            temp = temp.getNext();
        }
        IntNodeTwo newNum = new IntNodeTwo(num, temp, temp.getPrev());
        newNum.getPrev().setNext(newNum);
        newNum.getNext().setPrev(newNum);
    }
    
    public void removeNumber(int num)
    {
        IntNodeTwo temp = _head;
        while(temp.getNum() < num )
        {
            temp = temp.getNext();
        }
        if (temp.getNum() == num)
        {
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
        }
        
    }
}
