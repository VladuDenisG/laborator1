package lab2;
import java.sql.SQLOutput;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        /*Student studentul1= new Student("447", "Darius", "Vladescu", "Grupa 22/1");
        System.out.println(studentul1);*/


        List<Integer> x=new ArrayList<>();
        List<Integer> y=new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<5;i++)
            x.add(random.nextInt(11));
        for(int i=0;i<7;i++)
            y.add(random.nextInt(11));

        System.out.println("Lista x: "+x);
        System.out.println("Lista y: "+y);
        //punctul a
        List<Integer> xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("a) =  "+ xPlusY);

        //punctul b
        Set<Integer> zSet=new TreeSet<>(x);
        zSet.retainAll(y);
        System.out.println("b) =  "+ zSet);

        //punctul c
        List<Integer> xMinusY =new ArrayList<>(x);
        xMinusY.removeAll(y);
        System.out.println("c) =  "+ xMinusY);

        //punctul d
        int p=4;
        Set<Integer> xPlusYLimitedByP = new TreeSet<>();
        for(Integer val:x)
        {
            if(val<=p)
                xPlusYLimitedByP.add(val);
        }
        for(Integer val:y)
        {
            if(val<=p)
                xPlusYLimitedByP.add(val);
        }
        System.out.println("d) =  "+ xPlusYLimitedByP);


    }
}
