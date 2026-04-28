package lab7.util;

import java.util.Objects;

public final class Student {
    private final String nrMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final float nota;

    public Student(String nrMatricol, String prenume, String nume, String formatieDeStudiu)
    {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = 0.0f;
    }

    private Student(String nrMatricol, String prenume, String nume, String formatieDeStudiu, float nota)
    {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    public Student schimbaFormatia(String nouaFormatie)
    {
        return new Student(this.nrMatricol, this.prenume, this.nume, nouaFormatie, this.nota);
    }

    public String getNume() { return nume; }

    public String getPrenume() { return prenume; }

    public String getNrMatricol() { return nrMatricol; }

    public String getFormatieDeStudiu() { return formatieDeStudiu; }

    public float getNota() { return nota; }

    @Override
    public String toString()
    {
        return nume + " " + prenume + ", nr matricol: " + nrMatricol + ", formatie: " + formatieDeStudiu + ", nota: " + nota;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nrMatricol, student.nrMatricol);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(nrMatricol);
    }
}