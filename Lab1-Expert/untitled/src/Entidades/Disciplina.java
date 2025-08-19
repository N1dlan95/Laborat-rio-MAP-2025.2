package Entidades;

import java.util.List;

public class Disciplina {
    public String nome;
    public Professor professorPrincipal;
    public List<Aluno> alunos;

    public Disciplina() {}

    public int getQntdAlunos() {
        return alunos.size();
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }

}
