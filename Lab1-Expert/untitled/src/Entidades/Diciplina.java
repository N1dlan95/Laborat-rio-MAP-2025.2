package Entidades;

import java.util.List;

public class Diciplina {
    public String nome;
    public Professor professorPrincipal;
    public List<Aluno> alunos;

    public Diciplina() {}

    public int getQntdAlunos() {
        return alunos.size();
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }

}
