/*
    Created by : Robin Nusantara
*/

package com.dicoding.java;

import java.util.HashMap;
import java.util.Scanner;

class Auth {
    private static Scanner userInput = new Scanner(System.in);
    private static HashMap<String, String> tabelAkun = new HashMap<>();
    private static HashMap<String, String> tabelSesiLogin = new HashMap<>();
    private static int countLogin, countLogout;
    private static String email, password;

    //Kegiatan 1
    static void menuKegSatu() {

        tabelAkun.put("labit@umm.ac.id", "Labit321");
        tabelAkun.put("kharismamuzaki@gmail.com", "Testing123");
        tabelAkun.put("byasageng@gmail.com", "cobaLagi321");
        tabelAkun.put("dosen.tersayang@umm.ac.id", "dosenkuGG");
        tabelAkun.put("email.saya@umm.ac.id", "email_Student");

        System.out.println("\n<><>Kegiatan Satu<><>");
        System.out.println("1. Register Akun");
        System.out.println("2. Hapus Akun");
        System.out.println("3. Email UMM");
        System.out.println("4. Kegiatan Dua");
        System.out.print("Input Pilihan : ");
        int input = userInput.nextInt();
        switch (input) {
            case 1:
                System.out.println("\n<><>Register Akun<><>");
                System.out.print("Inputkan Email      : ");
                email = userInput.next();
                System.out.print("Inputkan Password   : ");
                password = userInput.next();
                registerAkun(email, password);
                menuKegSatu();
                break;
            case 2:
                System.out.println("\n<><>Hapus Akun<><>");
                System.out.print("Inputkan Email      : ");
                email = userInput.next();
                System.out.print("Inputkan Password   : ");
                password = userInput.next();
                hapusAkun(email, password);
                menuKegSatu();
                break;
            case 3:
                System.out.println("\n<><>List Email UMM<><>");
                totalEmailUMM();
                menuKegSatu();
                break;
            case 4:
                menuKegDua();
                break;
            default:
                System.err.println("Pilihan tidak ada!!!");
                menuKegSatu();
        }
    }


    static Boolean registerAkun(String email, String password) {

        if (tabelAkun.containsKey(email)) {
            System.err.println("Register gagal email sudah terdaftar");
            return false;
        } else {
            System.out.println("Email berhasil didaftarkan");
            tabelAkun.put(email, password);
            System.out.println();
            for (String key : tabelAkun.keySet()) {
                System.out.println("Email : " + key);
            }
            System.out.println();
            return true;
        }

    }

    static Boolean hapusAkun(String email, String password) {

        if (tabelAkun.containsKey(email) && password.equals(tabelAkun.get(email))) {
            System.out.println("Akun berhasil di hapus");
            tabelAkun.remove(email);
            System.out.println();
            for (String key : tabelAkun.keySet()) {
                System.out.println("Email : " + key);
            }
            System.out.println();
            menuKegSatu();
            return true;
        } else {
            System.err.println("Hapus akun gagal!!!\n" +
                    "Email/Password salah atau tidak terdaftar");
            menuKegSatu();
            return false;
        }
    }

    private static int totalEmailUMM() {
        int count = 0;
        for (String key : tabelAkun.keySet()) {
            if (key.endsWith("@umm.ac.id")) {
                count++;
            }
        }
        System.out.println("Jumlah email @umm.ac.id : " + count);
        return 0;
    }

    //Kegiatan 2
    static void menuKegDua() {
        System.out.println("\n<><>Kegiatan Dua<><>");
        System.out.println("1. Login Akun");
        System.out.println("2. Logout Akun");
        System.out.println("3. Total Akun yang Login");
        System.out.println("4. Total Akun yang Logout");
        System.out.println("5. Total Akun yang dalam Sesi Login");
        System.out.println("6. Kegiatan Satu");
        System.out.print("Input Pilihan : ");
        int pilih = userInput.nextInt();
        switch (pilih) {
            case 1:
                System.out.println("\nLogin Akun");
                System.out.print("Inputkan Email      : ");
                email = userInput.next();
                System.out.print("Inputkan Password   : ");
                password = userInput.next();
                loginAkun(email, password);
                break;
            case 2:
                System.out.println("\nLogout Akun");
                System.out.println("Konfirmasi email untuk logout akun");
                System.out.print("Inputkan Email      : ");
                email = userInput.next();
                logoutAkun(email);
                break;
            case 3:
                totalLogin();
                break;
            case 4:
                totalLogout();
                break;
            case 5:
                totalAuth();
                break;
            case 6:
                menuKegSatu();
                break;
            default:
                System.err.println("Pilihan tidak ada!!!");
                menuKegDua();
        }
    }

    private static Boolean loginAkun(String email, String password) {

        if (tabelAkun.containsKey(email) && password.equals(tabelAkun.get(email))) {
            System.out.println("\nLogin Berhasil");
            tabelSesiLogin.put(email, password);
            System.out.println("Welcome ^_^ " + email);
            countLogin += 1;
            menuKegDua();
            return true;
        } else {
            System.err.println("Login gagal!!!\n" +
                    "Email/Password salah atau tidak terdaftar");
            menuKegDua();
            return false;
        }
    }

    private static Boolean logoutAkun(String email) {

        if (tabelSesiLogin.containsKey(email)) {
            tabelSesiLogin.remove(email);
            System.out.println("\nLogout Akun....");
            System.out.println("Logout Berhasil ");
            countLogin -= 1;
            countLogout += 1;
            menuKegDua();
            return true;
        } else {
            System.err.println("Email Salah");
            menuKegDua();
            return false;
        }
    }

    private static int totalLogin() {
        System.out.println("\nTotal akun yang Login " + countLogin);
        menuKegDua();
        return countLogin;
    }

    private static int totalLogout() {
        System.out.println("\nTotal akun yang Logout " + countLogout);
        menuKegDua();
        return countLogout;
    }

    private static int totalAuth() {
        System.out.println("Total Data Yang Sedang Login : ");
        System.out.println("Total : " + tabelSesiLogin.size());
        for (String key : tabelSesiLogin.keySet()) {
            System.out.println("Email yang Sedang Login : " + key);
        }
        menuKegDua();
        return 0;
    }
}
