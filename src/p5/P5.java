package juegoahorcado;

import java.util.Scanner;

public class JuegoAhorcado{
    public static void main(String[] args) {
        
        int n;
        System.out.println("¿Cuantas palabras quieres que acierten?");
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
            
        String[] palabras = new String[n] ;
        System.out.println("Introduce " + n + " palabras: ");
        
        for (int i = 0; i < n; i++) {
            Scanner scan2 = new Scanner(System.in);
            String s = scan2.next();
            palabras[i] = s;
        }
        
        int numPalrandom = (int) (Math.random() * palabras.length);
        
        char[] letras = new char[palabras[numPalrandom].length()];
        int intentos = 0;
        boolean adivina = false;
        do {
            switch (letraIntroducida(palabras[numPalrandom], letras)) {
                case 0:
                    intentos++;
                    break;
                case 1:
                    intentos++;
                    break;
                case 2:
                    break;
                case 3:
                    adivina = true;
                    clean();
                    System.out.println("----------> Acierto!! <-----------");
                    break;
            }
        } while (! adivina && intentos < 15);
        System.out.println("\nLa palabra es " + palabras[numPalrandom] + ". Intentos: " + intentos);
    }
    
    public static int letraIntroducida(String palabra, char[] letras)   
    {
        clean();
        System.out.print("Introduze una letra: ");
        if (! verPalabra(palabra, letras))
            return 3;
        System.out.print(" > ");
        Scanner input = new Scanner(System.in);
        int vacio = posVacia(letras);
        char userInput = input.nextLine().charAt(0);
        if (estaLetra(userInput, letras)) {
            System.out.println(userInput + " ya esta en la palabra");
            return 2;
        }
        else if (palabra.contains(String.valueOf(userInput))) {
            letras[vacio] = userInput;
            return 1;
        }
        else {
            System.out.println(userInput + " no esta en la palabra");
            return 0;
            }
    }

    public static boolean verPalabra(String palabra, char[] letras) {
        boolean asteriscos = false;
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (estaLetra(letra, letras))
                System.out.print(letra);
            else {
                System.out.print('*');
                asteriscos = true;
            }
        }
        return asteriscos;
    }

    public static boolean estaLetra(char letra, char[] letras) {
        return new String(letras).contains(String.valueOf(letra));
    }

    public static int posVacia(char[] letras) {
        int i = 0;
        while (letras[i] != '\u0000') i++;
        return i;
    }
    
    public static void clean() {
        for (int i = 0; i < 30; i++) {
            System.out.println(" ");
        }
    }
}