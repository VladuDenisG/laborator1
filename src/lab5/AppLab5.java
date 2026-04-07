package lab5;

public class AppLab5
{
public static void main(String[] args)
{
    //punctul a
    IntCalculator calculator = new IntCalculator(20);
    int result = calculator.add(5).subtract(6).multiply(3).result();
    System.out.println("a) " + result);

    //punctul b

    AdvancedCalculator advCalc = new AdvancedCalculator(12);
    int rezultat2 = advCalc.divide(4).power(2).root(3).result();
    System.out.println("b) " + rezultat2);






}
}
