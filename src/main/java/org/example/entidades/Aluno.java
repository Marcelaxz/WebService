package org.example.entidades;

public class Aluno {
    private long tia;
    private String nome;
    private String sobrenome;
    private String curso;
    private int semestre;

    public Aluno(long tia, String nome, String sobrenome, String curso, int semestre) {
        this.tia = tia;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.curso = curso;
        this.semestre = semestre;
    }

    public Aluno(){}

    public long getTia() {
        return tia;
    }

    public void setTia(long tia) {
        this.tia = tia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
