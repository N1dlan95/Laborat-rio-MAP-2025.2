package event;

import java.util.EventObject;
import model.Assento;

public class AssentoEvent extends EventObject {
    private Assento assentoAlterado;
    private Assento[] todasPoltronas;

    public AssentoEvent(Object source, Assento assentoAlterado, Assento[] todasPoltronas) {
        super(source);
        this.assentoAlterado = assentoAlterado;
        this.todasPoltronas = todasPoltronas;
    }

    /** Assento que teve seu status modificado neste evento. */
    public Assento getAssentoAlterado() {
        return assentoAlterado;
    }

    /** Snapshot de todas as poltronas do ônibus para re-renderização completa. */
    public Assento[] getTodasPoltronas() {
        return todasPoltronas;
    }
}
