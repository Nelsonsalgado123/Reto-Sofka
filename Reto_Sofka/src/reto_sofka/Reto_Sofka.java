package reto_sofka;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * Nelson Livanier Salgado Tejada
 */
public class Reto_Sofka {

    //Menu de opciones
    public static void main(String[] args) throws IOException {
        ListaJugadores IngresarDatos = new ListaJugadores();
        int option = 0, Codigo = 0, premio = 0;
        String Nombre;

        do {
            try {
                option = ValidarMenu(
                        "1. Iniciar el juego \n"
                        + "2. salir \n\n"
                        + "Que deseas hacer?", "CONCURSO DE PREGUNTAS\n"
                        + " Y RESPUESTAS", JOptionPane.INFORMATION_MESSAGE);
                switch (option) {
                    case 1:
                        do {
                            try {
                                option = ValidarMenu2(
                                        "1. Ingresa datos del jugador\n\n"
                                        + "2. Ver historico general \n\n"
                                        + "3. Buscar jugador \n\n"
                                        + "4. Eliminar juagador \n\n"
                                        + "5. Anterior \n\n"
                                        + "¿ Que deseas hacer ? ", "Menu de opciones\n",
                                        JOptionPane.INFORMATION_MESSAGE);

                                switch (option) {
                                    case 1:
                                        Nombre = LeerCadenaTxt(
                                                "Ingresa el Nombre", "Agregando Nombre", JOptionPane.INFORMATION_MESSAGE);

                                        Codigo++;
                                        premio = SeleccionPregunta(option);

                                        IngresarDatos.insertar(Nombre, Codigo, premio);
                                        break;
                                    case 2:
                                        if (!IngresarDatos.EstaVacia()) {

                                            IngresarDatos.MostrarLista();

                                        } else {

                                            JOptionPane.showMessageDialog(null, "Lista vacia", "NO hay Elemento", JOptionPane.INFORMATION_MESSAGE);
                                        }

                                        break;

                                    case 3:
                                        if (!IngresarDatos.EstaVacia()) {
                                            Nombre = LeerCadenaTxt(
                                                    "Ingresa el Nombre", "Agregando Nombre", JOptionPane.INFORMATION_MESSAGE);

                                            IngresarDatos.BuscarJugador(Nombre);

                                        } else {

                                            JOptionPane.showMessageDialog(null, "Lista vacia", "NO hay Elemento", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        break;
                                    case 4:
                                        if (!IngresarDatos.EstaVacia()) {
                                            Nombre = LeerCadenaTxt(
                                                    "Ingresa el Nombre", "Agregando Nombre", JOptionPane.INFORMATION_MESSAGE);

                                            IngresarDatos.EliminarNombre(Nombre);

                                        } else {

                                            JOptionPane.showMessageDialog(null, "Lista vacia", "NO hay Elemento", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        break;
                                    case 5:

                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "La Opción no esta en el MENU", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } catch (NumberFormatException n) {
                                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                            }

                        } while (option != 5);

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

        } while (option != 2);

    }

    //Validamos que el dato ingresado sea un numero entero y este en el rango del menu
    public static int ValidarMenu(String texto, String texto2, int ent) {
        int dato = Integer.parseInt((JOptionPane.showInputDialog(null, texto, texto2, ent)));
        if (dato >= 0 && dato <= 2) {
            return dato;
        } else {
            mensaje("La opcion no se encuentra en el MENU");
            return ValidarMenu(texto, texto2, ent);
        }
    }

    //Validamos que el dato ingresado sea un numero entero y este en el rango del menu
    public static int ValidarMenu2(String texto, String texto2, int ent) {
        int dato = Integer.parseInt((JOptionPane.showInputDialog(null, texto, texto2, ent)));
        if (dato >= 0 && dato <= 5) {
            return dato;
        } else {
            mensaje("La opcion no se encuentra en el MENU");
            return ValidarMenu(texto, texto2, ent);
        }
    }

    //Validamos que el dato ingresado sea una letra (a, b, c, d)
    public static String ValidarPregunta(String texto, String texto2, int ent) {
        String dato = JOptionPane.showInputDialog(null, texto, texto2, ent);
        if (dato.equalsIgnoreCase("A") || dato.equalsIgnoreCase("B") || dato.equalsIgnoreCase("C") || dato.equalsIgnoreCase("D")) {
            return dato;
        } else {
            mensaje("La opcion no se encuentra en el MENU");
            return ValidarPregunta(texto, texto2, ent);
        }
    }
    //Validamos que el dato ingresado sea un numero entero positivo

    public static int ValidarEntero(String texto, String texto2, int ent) {
        int dato = Integer.parseInt((JOptionPane.showInputDialog(null, texto, texto2, ent)));
        if (dato >= 0) {
            return dato;
        } else {
            mensaje("el nodo no es valido ingresada no es valida");
            return ValidarEntero(texto, texto2, ent);
        }
    }

    //mostrasmos un mensaje con JOptionPane
    public static void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    //con este ingresamos solo Cadenas de testo si numeros
    public static String LeerCadenaTxt(String texto, String texto2, int ent) {
        String dato = JOptionPane.showInputDialog(null, texto, texto2, ent);

        if (dato.matches("[0-9]")) {
            JOptionPane.showMessageDialog(null, "Este campo es de texto, reintente por favor", "Dato Erroneo", 2);
            return LeerCadenaTxt(texto, texto2, ent);
        }

        if (dato.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo vacio, reintente por favor", "Dato Erroneo", 2);
            return LeerCadenaTxt(texto, texto2, ent);
        }
        return dato;
    }

    //Seleccionamos de forma aleatori cada una de las preguntas
    public static int SeleccionPregunta(int resu) throws IOException {
        int[] letra = new int[1];
        String opcionA = "";
        boolean estado = true, Ganador = false;

        String control = "si";
        int suma1 = 0, sumatotal = 0, cont = 0;
        cont = 1;
        //Mientras la varianble control sea "si" y el estado sea verdadero se ejecutara el codigo
        while (control.equalsIgnoreCase("si") && estado == true) {
            //letra.length actua como bandera 
            for (int j = 0; j < letra.length; j++) {
                //Math.random() no elige una opcion aleatoria entre 1 y 5
                letra[j] = (int) (Math.random() * 5 + 1);

            }
            if (cont == 1) {
                for (int j = 0; j < letra.length; j++) {

                    /*switch permite elejir una de las 5 preguntas
                      de forma aleatoria con la bandera (j) cargada
                      con el dato que aleatoriamente le dio Math.random()*/
                    switch (letra[j]) {
                        case 1:
                            //ingresamos la opccion deseada y la controlamos con ValidarPregunta()
                            opcionA = ValidarPregunta(
                                    " Las caries dan en....\n\n\n\n"
                                    + "A. Los ojos \n\n"
                                    + "B. Los dientes\n\n"
                                    + "C. Las manos \n\n"
                                    + "D. El cuello  \n\n"
                                    + "Seleccione su respuesta", "Nivel Basico\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            //comparamos si la opcion es correcta
                            if (opcionA.equalsIgnoreCase("B")) {
                                mensaje("Repuesta correcta acumulas 100000");
                                suma1 = 100000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 2:
                            opcionA = ValidarPregunta(
                                    " La mascarilla es un tratamirnto de belleza que se aplica en.......\n\n\n\n"
                                    + "A. El pelo \n\n"
                                    + "B. Las uñas \n\n"
                                    + "C. Las manos \n\n"
                                    + "D. La cara  \n\n"
                                    + "Seleccione su respuesta", "Nivel Basico\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 100000");
                                suma1 = 100000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 3:
                            opcionA = ValidarPregunta(
                                    " La banda kiss se inscribe dentro del genero musical....\n\n\n\n"
                                    + "A. Cumbia \n\n"
                                    + "B. Heavy Metal \n\n"
                                    + "C. Joropo \n\n"
                                    + "D. Funk \n\n"
                                    + "Seleccione su respuesta", "Nivel Basico\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("B")) {
                                mensaje("Repuesta correcta acumulas 100000");
                                suma1 = 100000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 4:
                            opcionA = ValidarPregunta(
                                    " ¿Como se llama la parte del reloj que marca la hora?....\n\n\n\n"
                                    + "A. Manecilla \n\n"
                                    + "B. Mica \n\n"
                                    + "C. Correa \n\n"
                                    + "D. Chip  \n\n"
                                    + "Seleccione su respuesta", "Nivel Basico\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("A")) {
                                mensaje("Repuesta correcta acumulas 100000");
                                suma1 = 100000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 5:
                            opcionA = ValidarPregunta(
                                    " El cuento de 'Ali Baba y los cuarenta ladrones' \nEsta contenico en el libro...\n\n\n\n"
                                    + "A. Las mil y una noche \n\n"
                                    + "B. La naranja mecanica \n\n"
                                    + "C. El titanic \n\n"
                                    + "D. Paseando a Miss Dissy  \n\n"
                                    + "Seleccione su respuesta", "Nivel Basico\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("A")) {
                                mensaje("Repuesta correcta acumulas 100000");
                                suma1 = 100000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            //si desea continuar aumentamos la variable de control y el nivel sube al 2 (Nivel Elemental)
            if (cont == 2) {
                for (int j = 0; j < letra.length; j++) {
                    switch (letra[j]) {
                        case 1:
                            opcionA = ValidarPregunta(
                                    " Cual de estos es un genero periodistico....\n\n\n\n"
                                    + "A. Una obra de teatro \n\n"
                                    + "B. Un cuento de ciecia ficcion \n\n"
                                    + "C. Un reportaje \n\n"
                                    + "D. Una novela \n\n"
                                    + "Seleccione su respuesta", "Nivel Elemental\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("C")) {
                                mensaje("Repuesta correcta acumulas 200000");
                                suma1 = 200000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 2:
                            opcionA = ValidarPregunta(
                                    " ¿Que pintor se corto la oreja y se hizo un autoretrato? \n\n\n\n"
                                    + "A. Joaquin Sorolla \n\n"
                                    + "B. Enrrique Grau \n\n"
                                    + "C. Diego Velazque \n\n"
                                    + "D. Vincent van Gogh  \n\n"
                                    + "Seleccione su respuesta", "Nivel Elemental\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 200000");
                                suma1 = 200000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 3:
                            opcionA = ValidarPregunta(
                                    " La banda kiss se inscribe dentro del genero musical....\n\n\n\n"
                                    + "A. Cumbia \n\n"
                                    + "B. Heavy Metal \n\n"
                                    + "C. Joropo \n\n"
                                    + "D. Funk \n\n"
                                    + "Seleccione su respuesta", "Nivel Elemental\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("B")) {
                                mensaje("Repuesta correcta acumulas 200000");
                                suma1 = 200000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 4:
                            opcionA = ValidarPregunta(
                                    " ¿La plaza Roja se puede visitar en la ciudad de...\n\n\n\n"
                                    + "A. Beijing \n\n"
                                    + "B. Taipei \n\n"
                                    + "C. Seul \n\n"
                                    + "D. Moscu  \n\n"
                                    + "Seleccione su respuesta", "Nivel Elemental\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 200000");
                                suma1 = 200000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 5:
                            opcionA = ValidarPregunta(
                                    " Las ceramicas pintadas conocidas como azulejos son\n artesanias representativas de...\n\n\n\n"
                                    + "A. Polonia \n\n"
                                    + "B. Estados Unidos \n\n"
                                    + "C. Colombia \n\n"
                                    + "D. Portugal \n\n"
                                    + "Seleccione su respuesta", "Nivel Elemental\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 200000");
                                suma1 = 200000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            //si desea continuar aumentamos la variable de control y el nivel sube al 3 (Nivel intermedio)
            if (cont == 3) {
                for (int j = 0; j < letra.length; j++) {
                    switch (letra[j]) {
                        case 1:
                            opcionA = ValidarPregunta(
                                    " ¿Caul es el rio mas largo del mundo....\n\n\n\n"
                                    + "A. El Magdalena \n\n"
                                    + "B. El Yangze\n\n"
                                    + "C. El Amazonas \n\n"
                                    + "D. El Nilo  \n\n"
                                    + "Seleccione su respuesta", "Nivel intermedio\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("C")) {
                                mensaje("Repuesta correcta acumulas 300000");
                                suma1 = 300000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 2:
                            opcionA = ValidarPregunta(
                                    " ¿Cuál es el país con más habitantes del mundo?\n\n\n\n"
                                    + "A. China \n\n"
                                    + "B. India \n\n"
                                    + "C. España \n\n"
                                    + "D. Peru  \n\n"
                                    + "Seleccione su respuesta", "Nivel intermedio\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("A")) {
                                mensaje("Repuesta correcta acumulas 300000");
                                suma1 = 300000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 3:
                            opcionA = ValidarPregunta(
                                    "  ¿Cuál es el país con menos habitantes del mundo?\n\n\n\n"
                                    + "A. La Ciudad del Vaticano\n\n"
                                    + "B. Peru \n\n"
                                    + "C. Colomba \n\n"
                                    + "B. EE.UU \n\n"
                                    + "Seleccione su respuesta", "Nivel intermedio\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("A")) {
                                mensaje("Repuesta correcta acumulas 300000");
                                suma1 = 300000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 4:
                            opcionA = ValidarPregunta(
                                    " ¿En qué año el ser humano llegó al espacio?\n\n\n\n"
                                    + "A. 1800 \n\n"
                                    + "B. 1961 \n\n"
                                    + "C. 1965 \n\n"
                                    + "D. 2001 \n\n"
                                    + "Seleccione su respuesta", "Nivel intermedio\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("B")) {
                                mensaje("Repuesta correcta acumulas 300000");
                                suma1 = 300000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 5:
                            opcionA = ValidarPregunta(
                                    " ¿Cuál es el edificio más alto del mundo?\n\n\n\n"
                                    + "A. Torre de Shanghái \n\n"
                                    + "B. Burj Khalifa \n\n"
                                    + "C. Abraj Al Bait \n\n"
                                    + "D. Coltejer  \n\n"
                                    + "Seleccione su respuesta", "Nivel intermedio\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("B")) {
                                mensaje("Repuesta correcta acumulas 300000");
                                suma1 = 300000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            //si desea continuar aumentamos la variable de control y el nivel sube al 4 (Nivel Intermedio - Alto)
            if (cont == 4) {
                for (int j = 0; j < letra.length; j++) {
                    switch (letra[j]) {
                        case 1:
                            opcionA = ValidarPregunta(
                                    " ¿Cuándo empezó la Revolución Rusa?\n\n\n\n"
                                    + "A. 1919 \n\n"
                                    + "B. 1976 \n\n"
                                    + "C. 2021 \n\n"
                                    + "D. 1917  \n\n"
                                    + "Seleccione su respuesta", "Nivel Intermedio - Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 400000");
                                suma1 = 400000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                control = "no";
                            }
                            break;
                        case 2:
                            opcionA = ValidarPregunta(
                                    "  ¿Cuál fue la primera civilización humana?\n\n\n\n"
                                    + "A. Antigua Mesopotamia \n\n"
                                    + "B. Civilización sumeria. \n\n"
                                    + "C. Acadia \n\n"
                                    + "D. Civilización babilónica  \n\n"
                                    + "Seleccione su respuesta", "Nivel Intermedio - Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("B")) {
                                mensaje("Repuesta correcta acumulas 400000");
                                suma1 = 400000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 3:
                            opcionA = ValidarPregunta(
                                    " ¿Cuál es la luna más grande de Saturno?\n\n\n\n"
                                    + "A. Titán \n\n"
                                    + "B. Dione \n\n"
                                    + "C. Mimas \n\n"
                                    + "D. Pan \n\n"
                                    + "Seleccione su respuesta", "Nivel Intermedio - Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("A")) {
                                mensaje("Repuesta correcta acumulas 400000");
                                suma1 = 400000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 4:
                            opcionA = ValidarPregunta(
                                    " ¿Cuándo se inventó la imprenta?\n\n\n\n"
                                    + "A. 1325 \n\n"
                                    + "B. 702 \n\n"
                                    + "C. 1440 \n\n"
                                    + "D. 1905  \n\n"
                                    + "Seleccione su respuesta", "Nivel Intermedio - Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("C")) {
                                mensaje("Repuesta correcta acumulas 400000");
                                suma1 = 400000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 5:
                            opcionA = ValidarPregunta(
                                    "  ¿Cuál es el animal más rápido?\n\n\n\n"
                                    + "A. Tiburón Mako. \n\n"
                                    + "B. Guepardo. \n\n"
                                    + "C. Pantera \n\n"
                                    + "D. El halcón peregrino  \n\n"
                                    + "Seleccione su respuesta", "Nivel Intermedio - Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 400000");
                                suma1 = 400000;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            //si desea continuar aumentamos la variable de control y el nivel sube al 5 (Alto)
            if (cont == 5) {
                for (int j = 0; j < letra.length; j++) {
                    switch (letra[j]) {
                        case 1:
                            opcionA = ValidarPregunta(
                                    " ¿Cuál es la videoconsola más vendida de la historia?\n\n\n\n"
                                    + "A. La PlayStation 2 \n\n"
                                    + "B. Nintendo DS \n\n"
                                    + "C. PlayStation 4 \n\n"
                                    + "D. Xbox 360  \n\n"
                                    + "Seleccione su respuesta", "Nivel Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("B")) {
                                mensaje("Repuesta correcta acumulas 500000");
                                suma1 = 500000;
                                Ganador = true;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 2:
                            opcionA = ValidarPregunta(
                                    " ¿Cuál es la ciudad más poblada del mundo?\n\n\n\n"
                                    + "A. Tokio \n\n"
                                    + "B. Nueva York \n\n"
                                    + "C. Medellín \n\n"
                                    + "D. París  \n\n"
                                    + "Seleccione su respuesta", "Nivel Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 500000");
                                suma1 = 500000;
                                Ganador = true;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 3:
                            opcionA = ValidarPregunta(
                                    "  ¿Cuántos dientes tenemos? \n\n\n\n"
                                    + "A. 38 \n\n"
                                    + "B. 27 \n\n"
                                    + "C. 34 \n\n"
                                    + "D. 32 \n\n"
                                    + "Seleccione su respuesta", "Nivel Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 500000");
                                suma1 = 500000;
                                Ganador = true;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 4:
                            opcionA = ValidarPregunta(
                                    " ¿Cuál es el primer elemento de la tabla periódica?\n\n\n\n"
                                    + "A.  Helio (He) \n\n"
                                    + "B.  Hidrógeno (H) \n\n"
                                    + "C.  Helio (He) \n\n"
                                    + "D.  Nitrógeno (N) \n\n"
                                    + "Seleccione su respuesta", "Nivel Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("B")) {
                                mensaje("Repuesta correcta acumulas 500000");
                                suma1 = 500000;
                                Ganador = true;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        case 5:
                            opcionA = ValidarPregunta(
                                    "  ¿Quién descubrió la penicilina?\n\n\n\n"
                                    + "A. Albert Einstein \n\n"
                                    + "B. Marie Curie \n\n"
                                    + "C. Charles Darwin \n\n"
                                    + "D. Alexander Fleming.  \n\n"
                                    + "Seleccione su respuesta", "Nivel Alto\n",
                                    JOptionPane.QUESTION_MESSAGE);
                            if (opcionA.equalsIgnoreCase("D")) {
                                mensaje("Repuesta correcta acumulas 500000");
                                suma1 = 500000;
                                Ganador = true;
                            } else {
                                mensaje("Respuesta incorrecta Pierdes todo");
                                estado = false;
                            }
                            break;
                        default:
                            break;

                    }

                }
            }
           
            sumatotal = sumatotal + suma1;
            cont = cont + 1;
            if (estado == false) {
                sumatotal = 0;
            }
             if (Ganador == true) {
                mensaje("Felicidades has superado todos los niveles tu premio acumulado es de " + sumatotal);
                estado = false;
             }
            if (estado != false) {
                control = JOptionPane.showInputDialog("ACTUALMENTE TIENES UN PREMIO DE " + sumatotal + "\n\n ¿ Deseas continuar    SI  /  NO  ?");

                while (!control.equalsIgnoreCase("si") && (!control.equalsIgnoreCase("no"))) {

                    JOptionPane.showMessageDialog(null, "OPCIÓN NO VÁLIDA");
                    control = JOptionPane.showInputDialog("ACTUALMENTE TIENES UN PREMIO DE " + sumatotal + "\n\n ¿ Deseas continuar    SI  /  NO  ?");
                }
            }
        }

        return sumatotal;
    }

}
