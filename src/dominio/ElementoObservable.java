package dominio;

import java.io.Serializable;
import java.util.Observable;

public class ElementoObservable extends Observable implements Serializable {
    public void notificar(){
        setChanged();
        notifyObservers();
    }
}
