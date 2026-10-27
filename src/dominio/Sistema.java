package dominio;

import java.io.*;
import java.util.*;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.*;

public class Sistema implements Serializable{
    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Paquete> paquetes;
    private ArrayList<Envio> envios;
    private Tarifas tarifas;
    private int numSigEnvio;
    private ElementoObservable obs;
    
    public Sistema() {
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        paquetes = new ArrayList<>();
        envios = new ArrayList<>();
        tarifas = new Tarifas();
        numSigEnvio = 1;
        obs = new ElementoObservable();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public ArrayList<Envio> getEnvios() {
        return envios;
    }

    public Tarifas getTarifas() {
        return tarifas;
    }

    public int getNumSigEnvio() {
        return numSigEnvio;
    }
    
    public void addObserver(Observer o) {
        obs.addObserver(o);
    }
    
    
    // Persistencia
    private static final String ARCHIVO_DATOS = "datos";
    
    public static Sistema cargarDatos() throws IOException, ClassNotFoundException {
        try (ObjectInputStream leer = new ObjectInputStream(new FileInputStream(ARCHIVO_DATOS))) {
            return (Sistema) leer.readObject();
        }
    }

    public void guardarDatos() throws IOException {
        try (ObjectOutputStream grabar = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS))) {
            grabar.writeObject(this);
        }
    }

    public boolean existenDatosGuardados() {
        return new File(ARCHIVO_DATOS).exists();
    }

    // Metodos auxiliares Cliente y Funcionario
    
    public boolean existeNombre(String nombre) {
        boolean res = false;
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                res = true;
            }
        }
        for (Funcionario f : funcionarios) {
            if (f.getNombre().equalsIgnoreCase(nombre)) {
                res = true;
            }
        }
        return res;
    }
    
    public boolean existeComoCliente(String nombre) {
        boolean res = false;
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                res = true;
            }
        }
        return res;
    }

    public boolean existeComoFuncionario(String nombre) {
        boolean res = false;
        for (Funcionario f : funcionarios) {
            if (f.getNombre().equalsIgnoreCase(nombre)) {
                res = true;
            }
        }
        return res;
    }

    public boolean existeNombreExcepto(String nombre, Persona excepto) {
        boolean res = false;
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c != excepto) {
                res = true;
            }
        }
        for (Funcionario f : funcionarios) {
            if (f.getNombre().equalsIgnoreCase(nombre) && f != excepto) {
                res = true;
            }
        }
        return res;
    }
    
    // Validaciones

    public boolean fechaValida(String fecha) {
        boolean res = true;
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(fecha, fmt);
        } catch (DateTimeParseException e) {
            res = false;
        }
        return res;
    }

    // ================= CLIENTES =================

    public boolean addCliente(String nombre, String celular, String mail) throws IOException {
        boolean res = false;
        if (!existeNombre(nombre)) {
            clientes.add(new Cliente(nombre, celular,mail));
            obs.notificar();
            logTransacciones("Ingreso de cliente " + nombre);
            res = true;
        }
        return res;
    }
    
    public boolean modificarCliente(Cliente c, String nombre, String celular, String mail) throws IOException {
    boolean res = false;
        if (!existeNombreExcepto(nombre, c)) {
            String mod = "Modificación de cliente " + c.getNombre();
            if (!c.getNombre().equals(nombre)) {
                mod += " | nombre: " + c.getNombre() + " -> " + nombre;
            }
            if (!c.getCelular().equals(celular)) {
                mod += " | celular: " + c.getCelular() + " -> " + celular;
            }
            if (!c.getMail().equals(mail)) {
                mod += " | mail: " + c.getMail() + " -> " + mail;
            }
            c.setNombre(nombre);
            c.setCelular(celular);
            c.setMail(mail);
            logTransacciones(mod);
            obs.notificar();
            res = true;
        }
        return res;
    }

    public ArrayList<Cliente> getClienteOrdenados() {
        ArrayList<Cliente> lista = new ArrayList<>(clientes);
        Collections.sort(lista, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.getNombre().compareTo(c2.getNombre());
            }
        });
        return lista;
    }
    
    public int getClientesPorZonaYEstado(String zona, String estado) {
        ArrayList<String> clientes = new ArrayList<>();
        for (Paquete p : getPaquetesPorZonaYEstado(zona, estado)) {
            if (!clientes.contains(p.getCliente().getNombre())) {
                clientes.add(p.getCliente().getNombre());
            }
        }
        return clientes.size();
    }
    
    // ================= FUNCIONARIOS =================
    
    public boolean addFuncionario(String nombre, String celular, int num, int año) throws IOException {
        boolean res = false;
        if (!existeNombre(nombre)) {
            funcionarios.add(new Funcionario(nombre, celular, num, año));
            obs.notificar();
            logTransacciones("Ingreso de funcionario " + nombre);
            res = true;
        }
        return res;
    }
    
    public boolean modificarFuncionario(Funcionario f, String nombre, String celular, int num, int año) throws IOException {
        boolean res = false;
        if (!existeNombreExcepto(nombre, f)) {
            String mod = "Modificación de funcionario " + f.getNombre();
            if (!f.getNombre().equals(nombre)) {
                mod += " | nombre: " + f.getNombre() + " -> " + nombre;
            }
            if (!f.getCelular().equals(celular)) {
                mod += " | celular: " + f.getCelular() + " -> " + celular;
            }
            if (f.getNumFuncionario() != num) {
                mod += " | nro: " + f.getNumFuncionario() + " -> " + num;
            }
            if (f.getAñoIngreso() != año) {
                mod += " | año: " + f.getAñoIngreso() + " -> " + año;
            }
            f.setNombre(nombre);
            f.setCelular(celular);
            f.setNumFuncionario(num);
            f.setAñoIngreso(año);
            obs.notificar();
            logTransacciones(mod);
            res = true;
        }
        return res;
    }
    
    public ArrayList<Funcionario> getFuncionariosOrdenados() {
        ArrayList<Funcionario> lista = new ArrayList<>(funcionarios);
        Collections.sort(lista, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario f1, Funcionario f2) {
                return f2.getAñoIngreso() - f1.getAñoIngreso();
            }
        });
        return lista;
    }
    
    // ================= PAQUETES =================
        
    public boolean addPaquete(String id, Cliente cliente, String fecha, String destinatario, String direccion, String dpto, int peso) throws IOException {
        boolean res = false;
        if (!idExiste(id)) {
            int precio = tarifas.calcularPrecio(tarifas.getDptoZona(dpto), peso);
            Paquete p = new Paquete(id, cliente,fecha, destinatario, direccion, dpto, peso, precio);
            paquetes.add(p);
            obs.notificar();
            logTransacciones("Ingreso de paquete de cliente " + cliente.getNombre());
            res = true;
        }
        return res;
    }
    
    public ArrayList<Paquete> getPaquetesPorZonaYEstado(String zona, String estado) {
        ArrayList<Paquete> lista = new ArrayList<>();
        for (Paquete p : paquetes) {
            if (tarifas.getDptoZona(p.getDpto()).equals(zona) && p.getEstado().equals(estado)) {
                lista.add(p);
            }
        }
        return lista;
    }

    public ArrayList<Paquete> getPaquetesPendientesPorZona(String zona) {
        ArrayList<Paquete> lista = new ArrayList<>();
        for (Paquete p : paquetes) {
            if (p.getEstado().equals("PENDIENTE") && tarifas.getDptoZona(p.getDpto()).equals(zona)) {
                lista.add(p);
            }
        }
        return lista;
    }    
    
    public ArrayList<Paquete> getPaquetesPorCliente(Cliente cliente) {
        ArrayList<Paquete> lista = new ArrayList<>();
        for (Paquete p : paquetes) {
            if (p.getCliente().equals(cliente)) {
                lista.add(p);
            }
        }
        return lista;
    }


    public ArrayList<String> getDptosPorZonaYEstado(String zona, String estado) {
        ArrayList<String> dptos = new ArrayList<>();
        for (Paquete p : getPaquetesPorZonaYEstado(zona, estado)) {
            if (!dptos.contains(p.getDpto())) {
                dptos.add(p.getDpto());
            }
        }
        return dptos;
    }

    public boolean idExiste(String id) {
        boolean res = false;
        for (Paquete p : paquetes) {
            if (p.getId().equalsIgnoreCase(id)) {
                res = true;
            }
        }
        return res;
    }
    
    public int calcularPrecio(String dpto, int peso) {
        String zona = tarifas.getDptoZona(dpto);
        return tarifas.calcularPrecio(zona, peso);
    }
    
    public void registrarRecepcion(Envio envio, ArrayList<Paquete> recibidos) throws IOException {
        ArrayList<Paquete> noEntregados = new ArrayList<>();
        for (Paquete p : envio.getPaquetes()) {
            if (recibidos.contains(p)) {
                p.setEstado("RECIBIDO");
            } else {
                p.setEstado("PENDIENTE");
                noEntregados.add(p);
            }
        }
        for (Paquete p : noEntregados) {
            envio.removePaquete(p);
        }
        envio.setRegistroRecepcion(true);
        logTransacciones("Recepción del envío número " + envio.getNumero());
        obs.notificar();
    }
    
    // ================= ENVIOS =================

    public boolean addEnvio(String fecha, String zona, Funcionario funcionario, ArrayList<Paquete> seleccionados ) throws IOException {
        boolean res = false;
        if (seleccionados.size() > 0) {
            Envio e = new Envio(numSigEnvio, fecha, zona, funcionario);
            for (Paquete p : seleccionados) {
                p.setEstado("ENVIADO");
                e.addPaquete(p);
            }
            envios.add(e);
            numSigEnvio++;
            obs.notificar();
            logTransacciones("Ingreso de envío número " + e.getNumero());
            res = true;
        }
        return res;
    }
    
    public ArrayList<Envio> getEnviosOrdenados() {
        ArrayList<Envio> lista = new ArrayList<>(envios);
        Collections.sort(lista, new Comparator<Envio>() {
            @Override
            public int compare(Envio e1, Envio e2) {
                return e2.getNumero() - e1.getNumero();
            }
        });
        return lista; 
    }
     
    // ================= TARIFAS =================
    
    public void leerTarifas() throws IOException {
        try (Scanner arch = new Scanner(Paths.get("Tarifas.txt"))) {
            while (arch.hasNext()) {
                String linea = arch.nextLine();
                String[] partes = linea.split("#");
                String zona = partes[0];
                String[] valores = partes[1].split(",");
                int[] precios = new int[4];
                for (int i = 0; i < 4; i++) {
                    precios[i] = Integer.parseInt(valores[i]);
                }
                tarifas.setZona(tarifas.getZonaIndice(zona), precios);
            }
        }
    }
    
    private void guardarTarifas() throws IOException {
        try (Formatter arch = new Formatter("Tarifas.txt")) {
            String[] zonas = {"NORTE", "OESTE", "ESTE", "SUR"};
            int[][] precios = tarifas.getPrecios();
            for (int i = 0; i < 4; i++) {
                arch.format("%s#%d,%d,%d,%d\n", zonas[i], precios[i][0], precios[i][1], precios[i][2], precios[i][3]);
            }
        }
    }
    
    public void actualizarTarifas(int porcentaje) throws IOException {
        tarifas.porcentajeAumento(porcentaje);
        guardarTarifas();
        obs.notificar();
        logTransacciones("Modificación de tarifas");
    }
    
    // ================= LOG =================
    
    public void logTransacciones(String descripcion) throws IOException {
        try (FileWriter f = new FileWriter("Transacciones.log", true);
            Formatter arch = new Formatter(f)) {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
            arch.format("%s - %s%n", ahora.format(fmt), descripcion);
        }
    }
    
    public String leerLog() {
        String res = "";
        try {
            Scanner arch = new Scanner(Paths.get("Transacciones.log"));
            while (arch.hasNext()) {
                res += arch.nextLine() + "\n";
            }
            arch.close();
        } catch (java.nio.file.NoSuchFileException e) {
            res = "No hay transacciones registradas";
        } catch (IOException e) {
            res = "Error al leer el log";
        }
        return res;
    }
    
    public void borrarLog() throws IOException {
        Formatter arch = new Formatter("Transacciones.log");
        arch.close();
    }
}
