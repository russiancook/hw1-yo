/**
 * Write a description of class IntListTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class IntListTwo
{
    Scanner scan = new Scanner(System.in);
    
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
    
    //Not clear what they want
    public void readToList()
    {
        int num = scan.nextInt();
        while(num != -9999)
        {
            addNumber(num);
            num = scan.nextInt();
        }
    }
    
    public String toString()
    {
        String list = "{";
        IntNodeTwo temp = _head;
        while(temp.getNext() != _tail)
        {
            list = list + temp.getNum() + ",";
            temp = temp.getNext();
        }
        list = list + _tail.getNum() + "}";
        return list;
    }
    
    public int length()
    {
        int counter = 0;
        IntNodeTwo temp = _head;
        while(temp != null)
        {
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }
    
    public int sum()
    {
        int sum = 0;
        IntNodeTwo temp = _head;
        while(temp.getNext() != null)
        {
            sum += temp.getNum();
            temp = temp.getNext();
        }
        return sum;
    }
    
    private boolean checkFront(int num)
    {
        for int 
    }
    
    private boolean checkBack(int num)
    {
        
    }
    
    public int maxLength()
    {
        if(this.sum() % 2 == 0 )
            return this.length();
        
        for(int i = 0; i < this.length(); i++)
        {
            if (checkFront(i) || checkBack(i))
                return this.length() - i;
        }
        return 0;
    }
    
}
