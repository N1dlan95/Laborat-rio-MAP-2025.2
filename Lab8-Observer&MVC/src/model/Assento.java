package model;

public class Assento {
    private int numIdentificador;
    private StatusAssento status;

    public Assento(int numIdentificador) {
        this.numIdentificador = numIdentificador;
        this.status = StatusAssento.Disponivel;
    }

    public int getNumIdentificador() {
        return numIdentificador;
    }

    public StatusAssento getStatus() {
        return status;
    }

    public void setStatus(StatusAssento status) {
        this.status = status;
    }
}
