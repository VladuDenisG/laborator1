package lab5.advanced;

public class NewIntCalculator extends ACalculator
{
    public NewIntCalculator(Integer valoare)
    {
        this.state=valoare;
    }
    public NewIntCalculator() {
        super();
    }

    @Override
    public void init()
    {
        this.state = 0;
    }

    public NewIntCalculator add(Integer v)
    {
        this.state=(Integer)this.state+v;
        return this;
    }

    public NewIntCalculator subtract(Integer v)
    {
        this.state=(Integer)this.state-v;
        return this;
    }

    public NewIntCalculator multiply(Integer v)
    {
        this.state = (Integer)this.state*v;
        return this;
    }

    public NewIntCalculator divide(Integer v)
    {
        this.state = (Integer)this.state/v;
        return this;
    }

}
