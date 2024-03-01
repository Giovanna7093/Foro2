import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

// Clase base para equipos
class Equipo {
    String fabricante;
    String modelo;
    String microprocesador;
    String memoria;
    String capacidadDiscoDuro;
    AbstractStringBuilder sistemaOperativo;

    Equipo(String fabricante, String modelo, String microprocesador, String memoria, String capacidadDiscoDuro) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.memoria = memoria;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    public String toString() {
        return "Fabricante: " + fabricante + "\n" +
               "Modelo: " + modelo + "\n" +
               "Microprocesador: " + microprocesador + "\n" +
               "Memoria: " + memoria + "\n" +
               "Capacidad de disco duro: " + capacidadDiscoDuro;
    }
}

// Subclase para Desktops
class Desktop extends Equipo {
    String tarjetaGrafica;
    String tamanoTorre;

    Desktop(String fabricante, String modelo, String microprocesador, String memoria, String capacidadDiscoDuro, String tarjetaGrafica, String tamanoTorre) {
        super(fabricante, modelo, microprocesador, memoria, capacidadDiscoDuro);
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoTorre = tamanoTorre;
    }

    public String toString() {
        return super.toString() + "\n" +
               "Tarjeta gráfica: " + tarjetaGrafica + "\n" +
               "Tamaño de torre: " + tamanoTorre;
    }
}

// Subclase para Laptops
class Laptop extends Equipo {
    String tamanoPantalla;

    Laptop(String fabricante, String modelo, String microprocesador, String memoria, String capacidadDiscoDuro, String tamanoPantalla) {
        super(fabricante, modelo, microprocesador, memoria, capacidadDiscoDuro);
        this.tamanoPantalla = tamanoPantalla;
    }

    public String toString() {
        return super.toString() + "\n" +
               "Tamaño de pantalla: " + tamanoPantalla;
    }
}

// Subclase para Tablets
class Tablet extends Equipo {
    String tamanoDiagonalPantalla;
    String tipoPantalla;
    String capacidadNAND;
    String sistemaOperativo;

    Tablet(String fabricante, String modelo, String microprocesador, String memoria, String capacidadDiscoDuro, String tamanoDiagonalPantalla, String tipoPantalla, String capacidadNAND, String sistemaOperativo) {
        super(fabricante, modelo, microprocesador, memoria, capacidadDiscoDuro);
        this.tamanoDiagonalPantalla = tamanoDiagonalPantalla;
        this.tipoPantalla = tipoPantalla;
        this.capacidadNAND = capacidadNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    public String toString() {
        return super.toString() + "\n" +
               "Tamaño diagonal de pantalla: " + tamanoDiagonalPantalla + "\n" +
               "¿Capacitiva/Resistiva?: " + tipoPantalla + "\n" +
               "Tamaño memoria NAND: " + capacidadNAND + "\n" +
               "Sistema Operativo: " + sistemaOperativo;
    }
}

public class RegistroEquipos {
    public static void main(String[] args) {
        List<Equipo> equipos = new ArrayList<>();

        while (true) {
            String[] opciones = {"Registrar equipo", "Ver equipos", "Salir"};
            int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Registro de Equipos", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (opcionSeleccionada) {
                case 0 -> // Registrar equipo
                    registrarEquipo(equipos);
                case 1 -> // Ver equipos
                    verEquipos(equipos);
                case 2 -> {
                    // Salir
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    System.exit(0);
                }
            }
        }
    }

    public static void registrarEquipo(List<Equipo> equipos) {
        String[] tiposEquipos = {"Desktops", "Laptops", "Tablets"};
        String tipoEquipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de equipo a registrar", "Registro de Equipos", JOptionPane.QUESTION_MESSAGE, null, tiposEquipos, tiposEquipos[0]);

        if (tipoEquipo != null) {
            String fabricante = JOptionPane.showInputDialog("Ingrese el fabricante:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
            String microprocesador = JOptionPane.showInputDialog("Ingrese el microprocesador:");
            String memoria = JOptionPane.showInputDialog("Ingrese la memoria:");
            String capacidadDiscoDuro = JOptionPane.showInputDialog("Ingrese la capacidad de disco duro:");
            
            // Validación de datos de entrada
        if (fabricante.isEmpty() || modelo.isEmpty() || microprocesador.isEmpty() || memoria.isEmpty() || capacidadDiscoDuro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, ingrese la información nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            switch (tipoEquipo) {
                case "Desktops":
                    String tarjetaGrafica = JOptionPane.showInputDialog("Ingrese la tarjeta gráfica:");
                    String tamanoTorre = JOptionPane.showInputDialog("Ingrese el tamaño de la torre:");
                    equipos.add(new Desktop(fabricante, modelo, microprocesador, memoria, capacidadDiscoDuro, tarjetaGrafica, tamanoTorre));
                    break;
                case "Laptops":
                    String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                    equipos.add(new Laptop(fabricante, modelo, microprocesador, memoria, capacidadDiscoDuro, tamanoPantalla));
                    break;
                case "Tablets":
                    String tamanoDiagonalPantalla = JOptionPane.showInputDialog("Ingrese el tamaño diagonal de pantalla:");
                    String tipoPantalla = JOptionPane.showInputDialog("¿Capacitiva/Resistiva?:");
                    String capacidadNAND = JOptionPane.showInputDialog("Ingrese la capacidad de memoria NAND:");
                    String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                    equipos.add(new Tablet(fabricante, modelo, microprocesador, memoria, capacidadDiscoDuro, tamanoDiagonalPantalla, tipoPantalla, capacidadNAND, sistemaOperativo));
                    break;
            }
        }
    }

    public static void verEquipos(List<Equipo> equipos) {
    List<Equipo> desktops = new ArrayList<>();
    List<Equipo> laptops = new ArrayList<>();
    List<Equipo> tablets = new ArrayList<>();

    for (Equipo equipo : equipos) {
        if (equipo instanceof Desktop) {
            desktops.add(equipo);
        } else if (equipo instanceof Laptop) {
            laptops.add(equipo);
        } else if (equipo instanceof Tablet) {
            tablets.add(equipo);
        }
    }

    StringBuilder sb = new StringBuilder();

    sb.append("<html><body>");
    sb.append("<h1>Equipos Registrados</h1>");

    // Crear la tabla comparativa en forma vertical
    sb.append("<table border='1'>");

    // Agregar encabezados de categoría
    sb.append("<tr>");
    sb.append("<th>Desktops</th>");
    sb.append("<th>Laptops</th>");
    sb.append("<th>Tablets</th>");
    sb.append("</tr>");

    // Encontrar la cantidad máxima de elementos en las listas
    int maxCount = Math.max(desktops.size(), Math.max(laptops.size(), tablets.size()));

    // Agregar filas con elementos de cada categoría
    for (int i = 0; i < maxCount; i++) {
        sb.append("<tr>");
        // Elemento de Desktops
        if (i < desktops.size()) {
            sb.append("<td>");
            sb.append("<b>Fabricante:</b> ").append(desktops.get(i).fabricante).append("<br>");
            sb.append("<b>Modelo:</b> ").append(desktops.get(i).modelo).append("<br>");
            sb.append("<b>Microprocesador:</b> ").append(((Desktop) desktops.get(i)).microprocesador).append("<br>");
            sb.append("<b>Memoria:</b> ").append(desktops.get(i).memoria).append("<br>");
            sb.append("<b>Tarjeta gráfica:</b> ").append(((Desktop) desktops.get(i)).tarjetaGrafica).append("<br>");
            sb.append("<b>Tamaño de torre:</b> ").append(((Desktop) desktops.get(i)).tamanoTorre).append("<br>");
            sb.append("<b>Capacidad de disco duro:</b> ").append(desktops.get(i).capacidadDiscoDuro).append("<br>");
            sb.append("</td>");
        } else {
            sb.append("<td></td>");
        }

        // Elemento de Laptops
        if (i < laptops.size()) {
            sb.append("<td>");
            sb.append("<b>Fabricante:</b> ").append(laptops.get(i).fabricante).append("<br>");
            sb.append("<b>Modelo:</b> ").append(laptops.get(i).modelo).append("<br>");
            sb.append("<b>Microprocesador:</b> ").append(((Laptop) laptops.get(i)).microprocesador).append("<br>");
            sb.append("<b>Memoria:</b> ").append(laptops.get(i).memoria).append("<br>");
            sb.append("<b>Tamaño de pantalla:</b> ").append(((Laptop) laptops.get(i)).tamanoPantalla).append("<br>");
            sb.append("<b>Capacidad de disco duro:</b> ").append(laptops.get(i).capacidadDiscoDuro).append("<br>");
            sb.append("</td>");
        } else {
            sb.append("<td></td>");
        }

        // Elemento de Tablets
        if (i < tablets.size()) {
            sb.append("<td>");
            sb.append("<b>Fabricante:</b> ").append(tablets.get(i).fabricante).append("<br>");
            sb.append("<b>Modelo:</b> ").append(tablets.get(i).modelo).append("<br>");
            sb.append("<b>Microprocesador:</b> ").append(((Tablet) tablets.get(i)).microprocesador).append("<br>");
            sb.append("<b>Tamaño diagonal de pantalla:</b> ").append(((Tablet) tablets.get(i)).tamanoDiagonalPantalla).append("<br>");
            sb.append("<b>¿Capacitiva/Resistiva?:</b> ").append(((Tablet) tablets.get(i)).tipoPantalla).append("<br>");
            sb.append("<b>Tamaño memoria NAND:</b> ").append(((Tablet) tablets.get(i)).capacidadNAND).append("<br>");
            sb.append("<b>Sistema Operativo:</b> ").append(tablets.get(i).sistemaOperativo).append("<br>");
            sb.append("</td>");
        } else {
            sb.append("<td></td>");
        }

        sb.append("</tr>");
    }

    sb.append("</table></body></html>");

    JOptionPane.showMessageDialog(null, sb.toString(), "Equipos Registrados", JOptionPane.PLAIN_MESSAGE);
}


}

