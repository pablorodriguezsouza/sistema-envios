package dominio;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    private String mail;

    public Cliente(String nombre, String celular, String mail) {
        super(nombre, celular);
        this.mail = mail;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
}
