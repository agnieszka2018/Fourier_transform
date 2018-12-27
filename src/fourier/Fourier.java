/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourier;

import static java.lang.Math.*;
import Jama.Matrix; //importuje class Matrix
import java.util.Scanner; //do wczytawania z klawiatury

/**
 *
 * @author AGA
 */
public class Fourier {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static double[] wczytaj_wielomian() {  //ale mamy dwa wielomiany! dwa razy wywołać funkcję; zrobić oba stopnia n, tylko uzupełnić zerami
        System.out.print("Podaj stopień wielomianu: ");
        int wielkosc; //stopień wielomianu
        wielkosc = scan.nextInt();

        double tablica[] = new double[wielkosc + 1];

        for (int i = 0; i <= wielkosc; i++) {
            System.out.println("współczynnik przy x stopnia " + i + ":");
            tablica[i] = scan.nextDouble();
        }

        return tablica;
    }

    public static double oblicz_wartosc_wielomianu(double[] wielomian, int wielkosc) { //argumentem funkcji jest wczytany wielomian

        System.out.println("podaj dla jakiego x chcesz obliczyć wartość wielomianu?");//czy zarówno x jak i współczynniki przy odpowiednich stopniach wielomianu mają być liczbami zespolonymi????
        double x; //część rzeczywista
        x = scan.nextDouble();

        //~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ na razie mnożenie tylko liczb rzeczywistych ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
        double akt_wartosc_x = 1.0;
        double suma = 0.0;

        for (int i = 0; i <= wielkosc; i++) {
            suma += (wielomian[i] * akt_wartosc_x);
            akt_wartosc_x *= x;    //z każdym krokiem domnażamy kolejny raz przez x;
        }

        System.out.println("Suma wartości wynosi: " + suma);
        return suma;    //wyliczona wartość wielomianu z zależnośco od x;
    }

    public static double[] iloczyn_wielomianu_definicja(double[] wielomian_pierwszy, int stopien_pierwszy, double[] wielomian_drugi, int stopien_drugi) {

        int k = stopien_pierwszy + stopien_drugi;    //stopień wynikowy m+n (ew. n+n);

        double tablica[] = new double[k + 1];//stopien wynikowego wielomianu jest równy sumie stopni wielomianu pierwszego i wielomianu drugiego, ale trzeba jeszcze dodac miejsce na wyraz wolny

        //mnożenie z definicji
        double suma = 0.0;

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= i; j++) {
                if ((j > stopien_pierwszy) || ((i - j) > stopien_drugi)) {
                    suma += 0;
                } else {
                    suma += wielomian_pierwszy[j] * wielomian_drugi[i - j];
                }
            }
            tablica[i] = suma;
            suma = 0.0;
        }

        return tablica;
    }

    public static void main(String[] args) {

        //wczytywanie
        double[] wielomian_pierwszy = wczytaj_wielomian(); //tablica ze współczynnikami przy kolejnych potęgach x - wielomian pierwszy;
        double[] wielomian_drugi = wczytaj_wielomian(); //tablica ze współczynnikami przy kolejnych potęgach x - wielomian drugi;

        //obliczanie wartości
        oblicz_wartosc_wielomianu(wielomian_pierwszy, 3);   //dla wielomianu stopnia 3!

        //mnożenie wielomianów z definicji
        iloczyn_wielomianu_definicja(wielomian_pierwszy, 3, wielomian_drugi, 3);     //dla wielomianów stopnia 3!

        //mnożenie wielomianów używając macierzy (DFT)
        //mnożenie wielomianów FFT
        scan.close();
    }

}
