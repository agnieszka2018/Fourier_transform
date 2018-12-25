/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.*;
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
            System.out.println("współczynnik (część rzeczywista) przy x stopnia: " + i);
            tablica[i][0] = scan.nextDouble();
            System.out.print("współczynnik (część urojona) przy x stopnia: " + i);
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

            suma += wielomian[i][0] * wartosc_x;
            wartosc_x *= re;    //z każdym krokiem domnażamy kolejny raz przez x;
        }

        tablica[0][0] = suma;   //tylko część rzeczywista

        return tablica;
    }

    public static double[][] iloczyn_wielomianu_definicja(double[][] wielomian_pierwszy, int stopien_pierwszy, double[][] wielomian_drugi, int stopien_drugi) {

         double tablica[][] = new double[stopien_pierwszy + stopien_drugi + 1][2];
         
         return tablica;
    }

    public static void main(String[] args) {

        scan.close();
    }

}
