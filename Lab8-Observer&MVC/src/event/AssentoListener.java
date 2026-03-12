package event;

import java.util.EventListener;

public interface AssentoListener extends EventListener {
    void assentoAtualizado(AssentoEvent event);
}
