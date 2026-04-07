package lab5.advanced;

public class DoubleCalculator extends ACalculator
{
    public DoubleCalculator(double valoare)
    {
        this.state=valoare;
    }

    @Override
    protected void init()
    {
        this.state = 0.0;
    }

    public DoubleCalculator add(double v)
    {
        this.state=(Double)this.state+v;
        return this;
    }

    public DoubleCalculator subtract(double v)
    {
        this.state=(Double)this.state-v;
        return this;
    }

    public DoubleCalculator multiply(double v)
    {
        this.state = (Double)this.state*v;
        return this;
    }
}
