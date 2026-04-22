package lab5.advanced;

public class DoubleCalculator extends ACalculator
{
    public DoubleCalculator(double valoare)
    {
        this.state=valoare;
    }

    @Override
    public void init()
    {
        this.state = 0.0;
    }

    public DoubleCalculator add(double v)
    {
        this.state=(Double)this.state+v;
        return this;
    }
    public DoubleCalculator() {
        super();
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

    public DoubleCalculator divide(double v)
    {
        if (v == 0.0) {
            throw new ArithmeticException("Nu se poate împărți la zero!");
        }
        state = (Double)state / v;
        return this;
    }
}
