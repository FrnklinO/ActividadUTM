import java.util.Random;
import java.util.Scanner;

public class IntruccionAsistida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int numPreguntas = 10;
        int numCorrectas = 0;
        double porcentajeCorrectas;
        
        System.out.println("Programa de Aprendizaje de Operaciones Aritméticas");
        
        int nivelDificultad = obtenerNivelDificultad(sc);
        int tipoProblema = obtenerTipoProblema(sc);
        
        for (int i = 0; i < numPreguntas; i++) {
            int num1 = generarNumeroAleatorio(nivelDificultad);
            int num2 = generarNumeroAleatorio(nivelDificultad);
            int resultadoEsperado = realizarOperacion(num1, num2, tipoProblema);
            
            int respuesta;
            do {
                System.out.print("¿Cuánto es " + num1 + " "
                        + obtenerOperador(tipoProblema) + " " + num2 + "? ");
                respuesta = sc.nextInt();
                if (respuesta == resultadoEsperado) {
                    numCorrectas++;
                    System.out.println(obtenerRetroalimentacionPositiva());
                } else {
                    System.out.println(obtenerRetroalimentacionNegativa());
                }
            } while (respuesta != resultadoEsperado);
        }
        
        porcentajeCorrectas = (double) numCorrectas / numPreguntas * 100;
        System.out.println("Porcentaje de respuestas correctas: " + porcentajeCorrectas + "%");
        
        if (porcentajeCorrectas < 75) {
            System.out.println("Por favor pide ayuda adicional a tu instructor.");
        } else {
            System.out.println("Felicidades, estás listo para pasar al siguiente nivel!");
        }
        
        sc.close();
    }
    
    public static int obtenerNivelDificultad(Scanner sc) {
        System.out.print("Elige el nivel de dificultad (1, 2, ...): ");
        return sc.nextInt();
    }
    
    public static int obtenerTipoProblema(Scanner sc) {
        System.out.print("Elige el tipo de problema (1: suma, 2: resta, 3: multiplicación, 4: división, 5: mezcla): ");
        return sc.nextInt();
    }
    
    public static int generarNumeroAleatorio(int nivelDificultad) {
        if (nivelDificultad == 1) {
            return new Random().nextInt(10);
        } else if (nivelDificultad == 2) {
            return new Random().nextInt(100);
        } else {
            // Agregar más niveles de dificultad según sea necesario
            return 0;
        }
    }
    
    public static String obtenerOperador(int tipoProblema) {
        switch (tipoProblema) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "x";
            case 4:
                return "/";
            default:
                return "+"; // En caso de mezcla o valor no válido
        }
    }
    
    public static int realizarOperacion(int num1, int num2, int tipoProblema) {
        switch (tipoProblema) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                return num1 / num2;
            default:
                return 0;
        }
    }
    
    public static String obtenerRetroalimentacionPositiva() {
        String[] respuestasPositivas = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
        return respuestasPositivas[new Random().nextInt(respuestasPositivas.length)];
    }
    
    public static String obtenerRetroalimentacionNegativa() {
        String[] respuestasNegativas = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "¡No te rindas!", "No. Sigue intentando."};
        return respuestasNegativas[new Random().nextInt(respuestasNegativas.length)];
    }
}