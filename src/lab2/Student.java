package lab2;

public class Student
{
    private String nrMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private float nota;

    public Student (String nrMatricol , String prenume , String nume , String formatieDeStudiu)
    {
        this.nrMatricol=nrMatricol;
        this.prenume=prenume;
        this.nume=nume;
        this.formatieDeStudiu =formatieDeStudiu;
        this.nota=0.0f;
    }

    public String toString()
    {
        return nume + " " + prenume + " , numar matricol: " + nrMatricol + " , formatie de studiu: " + formatieDeStudiu + " , nota: " +nota;
    }
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o== null || getClass()!=o.getClass() )
            return false;

        Student student = (Student) o;
        return nrMatricol.equals(student.nrMatricol);
    }
    @Override
    public int hashCode()
    {
        return java.util.Objects.hash(nrMatricol);
    }

    public String getNume()
    {
        return nume;
    }
    public String getFormatieDeStudiu()
    {
        return formatieDeStudiu;
    }

    public void setNota(float nota)
    {
        this.nota=nota;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public String getPrenume() {
        return prenume;
    }
    public float getNota() {
        return nota;
    }

}
