package lab2;

public class Student
{
    private String nrMatricol;
    private String prenume;
    private String nume;
    private String FormatieDeStudiu;

    public Student (String nrMatricol , String prenume , String nume , String FormatieDeStudiu)
    {
        this.nrMatricol=nrMatricol;
        this.prenume=prenume;
        this.nume=nume;
        this.FormatieDeStudiu=FormatieDeStudiu;
    }

    public String toString()
    {
        return nume + " " + prenume + " , numar matricol: " + nrMatricol + " , formatie de studiu: " + FormatieDeStudiu ;
    }

    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o== null || getClass()!=o.getClass() )
            return false;

        Student student = (Student) o;
        return this.nume.equals(student.nume) && this.prenume.equals(student.prenume) &&
                this.FormatieDeStudiu.equals(student.FormatieDeStudiu);
    }




}
