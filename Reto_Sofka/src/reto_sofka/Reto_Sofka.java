package reto_sofka;

import javax.swing.JOptionPane;

/**
 *
 * Nelson Livanier Salgado Tejada
 */
public class Reto_Sofka {

    public static void main(String[] args) {

        int option = 0, elemento, Tope;
        do {
            try {
                option = ValidarMenu(
                        "1. Configurar Juego \n"
                        + "2. Iniciar el juego \n"

                        + "3. salir \n\n"
                        + "Que deseas hacer?", "CONCURSO DE PREGUNTAS\n"
                        + "Y RESPUESTAS", JOptionPane.INFORMATION_MESSAGE);
                switch (option) {
                    case 1:

                        break;
                    case 2:

                        break;
                

                    case 5:
                        JOptionPane.showMessageDialog(null, "Aplicación finalaizada", "FIN", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La Opción no esta en el MENU", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }

        } while (option != 3);

    }

    public static int ValidarMenu(String texto, String texto2, int ent) {
        int dato = Integer.parseInt((JOptionPane.showInputDialog(null, texto, texto2, ent)));
        if (dato >= 0 && dato <= 5) {
            return dato;
        } else {
            mensaje("La opcion no se encuentra en el MENU");
            return ValidarMenu(texto, texto2, ent);
        }
    }

    public static int ValidarNota(String texto, String texto2, int ent) {
        int dato = Integer.parseInt((JOptionPane.showInputDialog(null, texto, texto2, ent)));
        if (dato >= 0 && dato <= 5) {
            return dato;
        } else {
            mensaje("La nota ingresada no es valida");
            return ValidarMenu(texto, texto2, ent);
        }
    }

    public static void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

}
