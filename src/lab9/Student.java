package lab9;

class Student {
    private int nrmatricol;
    private String prenume, nume, grupa;
    private double nota;

    public Student(int id, String prenume, String nume, String grupa, double nota) {
        this.nrmatricol = id; this.prenume = prenume; this.nume = nume; this.grupa = grupa; this.nota = nota;
    }
    public int getNrmatricol()
    { return nrmatricol; }
    public String getPrenume()
    { return prenume; }
    public String getNume()
    { return nume; }
    public String getGrupa()
    { return grupa; }
    public double getNota()
    { return nota; }
}