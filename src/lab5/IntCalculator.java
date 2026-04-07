package lab5;

public class IntCalculator
{
    // punctul a
    protected int state;

    public IntCalculator(int valoareInitiala)
    {
        this.state=valoareInitiala;
    }

    public IntCalculator add(int valoare)
    {
        this.state=this.state+valoare;
        return this;
    }

    public IntCalculator subtract(int valoare)
    {
        this.state = this.state-valoare;
        return this;
    }

    public IntCalculator multiply(int valoare)
    {
        this.state=this.state*valoare;
        return this;
    }

    public int result()
    {
        return this.state;
    }

    public IntCalculator clear()
    {
        this.state=0;
        return this;
    }



}
