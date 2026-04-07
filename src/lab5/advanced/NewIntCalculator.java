package lab5.advanced;

public class NewIntCalculator extends ACalculator
{
    public NewIntCalculator(int valoare)
    {
        this.state=valoare;
    }

    @Override
    protected void init()
    {
        this.state = 0;
    }

    public NewIntCalculator add(int v)
    {
        this.state=(Integer)this.state+v;
        return this;
    }

    public NewIntCalculator subtract(int v)
    {
        this.state=(Integer)this.state-v;
        return this;
    }

    public NewIntCalculator multiply(int v)
    {
        this.state = (Integer)this.state*v;
        return this;
    }

}
