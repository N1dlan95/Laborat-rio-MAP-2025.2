package Entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Usuario {
    protected String nome;
    protected int matricula;
    protected Horario horario;


    public List<Disciplina> getDisciplinas() {
        return null;
    }

}
