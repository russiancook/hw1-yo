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
        
        if (num >= _tail.getNum())
        {
            IntNodeTwo newNum = new IntNodeTwo(num, null, _tail);
            _tail.setNext(newNum);
            _tail = newNum;
        }
        
        else if (num <= _head.getNum())
        {
            IntNodeTwo newNum = new IntNodeTwo(num, _head, null);
            _head.setPrev(newNum);
            _head = newNum;
        }
        else
        {
            IntNodeTwo temp = _head;
            while(temp.getNum() < num)
            {
                temp = temp.getNext();
            }
            IntNodeTwo newNum = new IntNodeTwo(num, temp, temp.getPrev());
            temp.getPrev().setNext(newNum);
            temp.setPrev(newNum);
        }
        
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
        while(temp.getNext() != null)
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
        return sum + _tail.getNum();
    }
    
    
    public int maxLength()
    {
        IntNodeTwo temp = _head;
        int longest = 0;
        
        if(this.sum() % 2 == 0 )
            return this.length();
      
        for(int i = 0; i < this.length(); i++)
        {
            if(temp.getNum() % 2 != 0)
            {
                int sum = 0;
                if (temp == _tail)
                    sum = temp.getNum();
                else
                {
                    IntListTwo tempList = new IntListTwo(temp.getNext(), this._tail);
                    sum = tempList.sum();
                }                   
                if (sum % 2 == 0)
                {
                    if (this.length() - i > longest)
                        longest = this.length() - i;
                    if(i > longest)
                        longest = i;
                }
                    
            }
            temp = temp.getNext();
        }
        return longest;
    }
    
    public boolean isAverage(double num)
    {
        IntNodeTwo temp = _head;
        for (int i=0; i < this.length(); i++)
        {
            int sum = 0;
            IntListTwo tempList = new IntListTwo(temp, this._tail);
            for (int j = i; j < this.length(); j++)
            {
                sum += temp.getNum();
                if ((double)(sum / (j+1)) == num)
                    return true;
            }
        }
        return false;
    }
}
