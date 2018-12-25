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

    public static double[][] wczytaj_wielomian() {  //ale mamy dwa wielomiany! dwa razy wywołać funkcję
        System.out.print("Podaj stopień wielomianu: ");

        int wielkosc; //stopień wielomianu
        wielkosc = scan.nextInt();

        double tablica[][] = new double[wielkosc + 1][2];    //[i][0] to część rzeczywista, [i][1] to część urojona;

        for (int i = 0; i <= wielkosc; i++) {
            System.out.println("współczynnik (część rzeczywista) przy x stopnia " + i + ":");
            tablica[i][0] = scan.nextDouble();
            System.out.println("współczynnik (część urojona) przy x stopnia " + i + ":");
            tablica[i][1] = scan.nextDouble();
        }

        return tablica;
    }

    public static double[][] oblicz_wartosc_wielomianu(double[][] wielomian, int wielkosc) { //argumentem funkcji jest wczytany wielomian

        double tablica[][] = new double[1][2];   // wartość wielomianu -> [0][0] to część rzeczywista, [0][1] to część urojona;

        System.out.println("podaj dla jakiego x chcesz obliczyć wartość wielomianu?");//czy zarówno x jak i współczynniki przy odpowiednich stopniach wielomianu mają być liczbami zespolonymi????
        System.out.println("podaj część rzeczywistą x:");
        double re; //część rzeczywista
        re = scan.nextDouble();
        System.out.println("podaj część urojoną x:");
        double im;  //część zespolona 
        im = scan.nextDouble();

        //~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ na razie mnożenie tylko części rzeczywistych ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
        double wartosc_x = 1.0;
        double suma = 0.0;

        for (int i = 0; i <= wielkosc; i++) {
            suma += (wielomian[i][0] * wartosc_x);
            wartosc_x *= re;    //z każdym krokiem domnażamy kolejny raz przez x;
        }

        tablica[0][0] = suma;   //tylko część rzeczywista

        return tablica;
    }

    public static double[][] iloczyn_wielomianu_definicja(double[][] wielomian_pierwszy, int stopien_pierwszy, double[][] wielomian_drugi, int stopien_drugi) {

        int stopien_wynikowy = stopien_pierwszy + stopien_drugi;

        double tablica[][] = new double[stopien_wynikowy + 1][2];//stopien wynikowego wielomianu jest równy sumie stopni wielomianu pierwszego i wielomianu drugiego, ale trzeba jeszcze dodac miejsce na wyraz wolny

        //mnożenie z definicji??????
        double suma = 0.0;
        for (int i = 0; i <= stopien_wynikowy; i++) {
            for (int j = 0; j <= i; j++) {

                if ((j > stopien_pierwszy) || ((i + j) > stopien_drugi)) {
                    suma += 0;
                } else {
                    suma += (wielomian_pierwszy[j][0] * wielomian_drugi[i + j][0]);
                }
            }
            tablica[i][0] = suma;
        }

        return tablica;
    }

    public static void main(String[] args) {

        //wczytywanie
        double[][] wielomian_pierwszy = wczytaj_wielomian(); //tablica ze współczynnikami przy kolejnych potęgach x - wielomian pierwszy;
        double[][] wielomian_drugi = wczytaj_wielomian(); //tablica ze współczynnikami przy kolejnych potęgach x - wielomian drugi;

        //obliczanie wartości
        //mnożenie wielomianów z definicji
        //mnożenie wielomianów używając macierzy
        //mnożenie wielomianów FFT
        scan.close();
    }

}
