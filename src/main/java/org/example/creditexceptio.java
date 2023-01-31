package org.example;
import java.util.Scanner;
import java.util.logging.Logger;
public class Creditexceptio implements Cloneable {
    Logger l=Logger.getLogger("kitty");
    private String cname;
    private Integer cno;
    private Integer cnum = 501005463;
    private Integer expdate;

    public Creditexceptio( String cname,Integer cno, Integer expdate) {
        this.cname=cname;
        this.cno=cno;
        this.expdate=expdate;
    }
    void eq()
    {
        if(cnum.equals(cno)) {
            l.info("Credit card number matched!");
        }
        else
        {
            l.info("OOPS! Credit card number doesn't match");
        }
    }
    Creditexceptio cr()
    {
        try
        {
            return (Creditexceptio) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            l.info("cloned error");
            return this;
        }
    }
    public static void main(String[] args)
    {
        Logger l=Logger.getLogger("kitty");
        Scanner sc=new Scanner(System.in);
        l.info("Enter the credit card holder name:");
        String cname = sc.next();
        l.info("Enter the credit card number:");
        Integer cno = sc.nextInt();
        l.info("Enter the expiration date:");
        Integer expdate = sc.nextInt();
        Creditexceptio c1=new Creditexceptio(cname,cno,expdate);
        Creditexceptio c2 = c1.cr();
        c2.eq();
    }
}
