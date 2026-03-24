package lab2;

public class Student
{
    private String nrMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;

    public Student (String nrMatricol , String prenume , String nume , String formatieDeStudiu)
    {
        this.nrMatricol=nrMatricol;
        this.prenume=prenume;
        this.nume=nume;
        this.formatieDeStudiu =formatieDeStudiu;
    }

    public String toString()
    {
        return nume + " " + prenume + " , numar matricol: " + nrMatricol + " , formatie de studiu: " + formatieDeStudiu;
    }

    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o== null || getClass()!=o.getClass() )
            return false;

        Student student = (Student) o;
        return this.nume.equals(student.nume) && this.prenume.equals(student.prenume) &&
                this.formatieDeStudiu.equals(student.formatieDeStudiu);
    }

    public int hashCode()
    {
        return java.util.Objects.hash(nume , prenume , formatieDeStudiu);
    }

    public String getNume()
    {
        return nume;
    }
    public String getFormatieDeStudiu()
    {
        return formatieDeStudiu;
    }

}
