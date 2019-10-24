package com.dicoding.java;

import java.util.HashMap;
import java.util.Scanner;

class Auth {
    private static Scanner userInput = new Scanner(System.in);
    private static HashMap<String, String> tabelAkun = new HashMap<>();
    private static HashMap<String, String> tabelSesiLogin = new HashMap<>();

    //Kegiatan 1
    public static void main(String[] args) {

        tabelAkun.put("labit@umm.ac.id", "Labit321");
        tabelAkun.put("kharismamuzaki@gmail.com", "Testing123");
        tabelAkun.put("byasageng@gmail.com", "cobaLagi321");
        tabelAkun.put("dosen.tersayang@umm.ac.id", "dosenkuGG");
        tabelAkun.put("email.saya@umm.ac.id", "email_Student");

        String email, password;
        System.out.println("\n<><><>Hash Map<><><>");
        System.out.println("1. Register Akun");
        System.out.println("2. Hapus Akun");
        System.out.println("3. Email UMM");
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
                break;
            case 2:
                System.out.println("\n<><>Hapus Akun<><>");
                System.out.print("Inputkan Email      : ");
                email = userInput.next();
                System.out.print("Inputkan Password   : ");
                password = userInput.next();
                hapusAkun(email, password);
                break;
            case 3:
                System.out.println("\n<><>List Email UMM<><>");
                totalEmailUMM();
                break;
            default:
                System.err.println("Pilihan tidak ada!!!");
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

        if (tabelAkun.containsKey(email) && tabelAkun.containsValue(password)) {
            System.out.println("Akun berhasil di hapus");
            tabelAkun.remove(email);
            System.out.println();
            for (String key : tabelAkun.keySet()) {
                System.out.println("Email : " + key);
            }
            System.out.println();
            return true;
        } else {
            System.err.println("Akun tidak ditemukan ");
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
    


}
