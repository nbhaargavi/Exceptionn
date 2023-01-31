package org.example;
import java.util.Scanner;
import java.util.logging.*;
public class pointexceptio implements Cloneable {
    Logger l=Logger.getLogger("kitty");
    private Integer x;
    private Integer y;
    public pointexceptio( Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    boolean eq()
    {
        return x.equals(y);
    }
    pointexceptio pt()
    {
        try
        {
            return(pointexceptio)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            l.info("clone error");
            return this;
        }
    }
    public static void main(String[] args) throws CloneNotSupportedException{
        Logger l=Logger.getLogger("kitty");
        Scanner sc=new Scanner(System.in);
        l.info("enter the x coordinate:");
        Integer x = sc.nextInt();
        l.info("enter the y coordinate:");
        Integer y = sc.nextInt();
        pointexceptio p1=new pointexceptio(x,y);
        pointexceptio p2=(pointexceptio)p1.clone();
        p2.eq();
        if (p2.eq())
        {
            l.info("x and y are same");
        }
        else {
            l.info("x and y are not same");
        }
    }
}