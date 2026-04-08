package lab5;

public class StudentBursier extends Student
{
    private double cuantumBursa;
    public StudentBursier(String nrMatricol, String prenume, String nume, String formatieDeStudiu, float nota, double cuantumBursa)
    {
        super(nrMatricol, prenume, nume, formatieDeStudiu);
        this.setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public String toString()
    {
        return super.toString() + " , cuantum bursa: " + cuantumBursa;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof StudentBursier)) return false;
        if (!super.equals(o)) return false;
        StudentBursier altul = (StudentBursier) o;
        return altul.cuantumBursa == this.cuantumBursa;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), cuantumBursa);
    }

}
