package com.dicoding.java;/*
 * Project Name : Praktikum Struktur Data 4
 * Created by Robin Nusantara on Friday, October, 2019
 * 25/10/2019
 * 8:28
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Praktikum Modul 3");
        System.out.println("1. Kegiatan Satu");
        System.out.println("2. Kegiatan Dua");
        System.out.print("Pilih : ");
        int pilih = userInput.nextInt();
        if (pilih == 1) {
            Auth.menuKegSatu();
        } else {
            Auth.menuKegDua();
        }
    }
}
