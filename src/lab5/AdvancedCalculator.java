package lab5;

public class AdvancedCalculator extends IntCalculator
{
    // punctul b
    public AdvancedCalculator(int initialValue)
    {
        super(initialValue);
    }

    public AdvancedCalculator divide(int value)
    {
        if(value != 0)
        {
            this.state=this.state/ value;
        }
        return this;
    }

    public AdvancedCalculator power(int exponent)
    {
        this.state=(int) Math.pow(this.state, exponent);
        return this;
    }

    public AdvancedCalculator root(int order)
    {
        this.state=(int) Math.pow(this.result(),1.0/order);
        return this;
    }
}
