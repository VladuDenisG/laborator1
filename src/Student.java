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

}
