package interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

// Aspecto común de las ventanas: colores, encabezado y botones.
// Las ventanas se siguen armando con el diseñador; esto se aplica después de initComponents().
public class Estilo {

    public static final Color AZUL_NOCHE = new Color(19, 41, 75);
    public static final Color AZUL_TEXTO = new Color(205, 215, 230);
    public static final Color NARANJA = new Color(242, 140, 40);
    public static final Color NARANJA_OSCURO = new Color(222, 116, 16);
    public static final Color FONDO = new Color(246, 247, 249);
    public static final Color SELECCION = new Color(255, 226, 194);

    // Aspecto de Windows y letra un poco más grande en campos y botones (listas y tablas quedan como las dejó el diseñador, para que entren todas las filas). Se llama una vez al iniciar.
    public static void instalar() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}   // si no se puede, queda el aspecto por defecto de Java
        Font letra = new Font("Segoe UI", Font.PLAIN, 13);
        String[] claves = {"TextField.font", "TextArea.font", "RadioButton.font", "Button.font", "Label.font"};
        for (String clave : claves) UIManager.put(clave, letra);
    }

    // Pone una franja con título y subtítulo arriba de la ventana, da formato a sus listas y tablas,
    // y ajusta el tamaño de la ventana a su contenido (así no se corta ningún texto).
    public static void aplicar(JFrame ventana, String titulo, String subtitulo) {
        ventana.setTitle("Envíos - " + titulo);
        Container contenido = ventana.getContentPane();
        darFormato(contenido);
        ((JComponent) contenido).setBorder(BorderFactory.createEmptyBorder(4, 8, 12, 8));
        contenido.setBackground(FONDO);

        Dimension tamañoDiseño = ventana.getSize();
        JPanel encabezado = crearEncabezado(titulo, subtitulo);
        JPanel nuevo = new JPanel(new BorderLayout());
        nuevo.add(encabezado, BorderLayout.NORTH);
        nuevo.add(contenido, BorderLayout.CENTER);
        ventana.setContentPane(nuevo);
        // Nunca más chica que en el diseñador (más la franja), pero sí más grande si el contenido lo necesita
        ventana.pack();
        ventana.setSize(Math.max(ventana.getWidth(), tamañoDiseño.width),
                        Math.max(ventana.getHeight(), tamañoDiseño.height + encabezado.getPreferredSize().height));
        ventana.setLocationRelativeTo(null);
    }

    public static JPanel crearEncabezado(String titulo, String subtitulo) {
        JPanel encabezado = new JPanel(new GridLayout(2, 1));
        encabezado.setBackground(AZUL_NOCHE);
        encabezado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 4, 0, NARANJA),      // línea naranja abajo
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 19));
        lblTitulo.setForeground(Color.WHITE);
        JLabel lblSubtitulo = new JLabel(subtitulo);
        lblSubtitulo.setForeground(AZUL_TEXTO);
        encabezado.add(lblTitulo);
        encabezado.add(lblSubtitulo);
        return encabezado;
    }

    // Recorre los componentes de la ventana y les da formato según su tipo.
    private static void darFormato(Container contenedor) {
        for (Component c : contenedor.getComponents()) {
            if (c instanceof JTable) {
                JTable tabla = (JTable) c;
                tabla.setShowVerticalLines(false);
                tabla.setGridColor(new Color(225, 229, 235));
                tabla.setSelectionBackground(SELECCION);
                tabla.setSelectionForeground(AZUL_NOCHE);
                tabla.getTableHeader().setFont(tabla.getTableHeader().getFont().deriveFont(Font.BOLD));
            } else if (c instanceof JList) {
                JList<?> lista = (JList<?>) c;
                lista.setSelectionBackground(SELECCION);
                lista.setSelectionForeground(AZUL_NOCHE);
            } else if (c instanceof JButton) {
                botonSecundario((JButton) c);
            } else if (c instanceof JRadioButton) {
                c.setBackground(FONDO);
            }
            if (c instanceof Container) darFormato((Container) c);
        }
    }

    // Botón de la acción principal de la ventana: naranja con letra oscura, más oscuro con el mouse encima.
    public static void botonPrincipal(JButton boton) {
        darForma(boton, NARANJA, AZUL_NOCHE, NARANJA_OSCURO);
        boton.setBorder(BorderFactory.createEmptyBorder(8, 18, 8, 18));
    }

    // Resto de los botones: blancos con borde y letra azul.
    public static void botonSecundario(JButton boton) {
        darForma(boton, Color.WHITE, AZUL_NOCHE, new Color(234, 238, 245));
        boton.setBorder(bordeSecundario());
    }

    // Botón de la barra lateral del menú: texto blanco sobre el azul, con una marca naranja a la izquierda
    // cuando se pasa el mouse o se llega con el teclado (Tab).
    public static void botonLateral(JButton boton) {
        darForma(boton, AZUL_NOCHE, Color.WHITE, new Color(35, 62, 104));
        boton.setFont(boton.getFont().deriveFont(Font.PLAIN, 14f));
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        Border normal = BorderFactory.createEmptyBorder(7, 14, 7, 10);
        Border marcado = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 4, 0, 0, NARANJA),
                BorderFactory.createEmptyBorder(7, 10, 7, 10));
        boton.setBorder(normal);
        boton.getModel().addChangeListener(cambio ->
                boton.setBorder(boton.getModel().isRollover() || boton.hasFocus() ? marcado : normal));
        boton.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                boton.setBorder(marcado);
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                boton.setBorder(normal);
            }
        });
    }

    private static Border bordeSecundario() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(190, 198, 212)),
                BorderFactory.createEmptyBorder(7, 17, 7, 17));
    }

    private static void darForma(JButton boton, Color fondo, Color letra, Color fondoMouse) {
        boton.setBackground(fondo);
        boton.setForeground(letra);
        boton.setFont(boton.getFont().deriveFont(Font.BOLD));
        boton.setContentAreaFilled(false);      // sin el dibujo de Windows, para que se vea el color
        boton.setOpaque(true);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.getModel().addChangeListener(cambio -> {
            if (!boton.isEnabled()) boton.setBackground(new Color(225, 228, 233));
            else if (boton.getModel().isRollover()) boton.setBackground(fondoMouse);
            else boton.setBackground(fondo);
        });
    }
}
