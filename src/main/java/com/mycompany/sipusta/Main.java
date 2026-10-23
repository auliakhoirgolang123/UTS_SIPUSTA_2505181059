/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipusta;

/**
 *
 * @author MyBook Hype AMD
 */
import model.*;
import layanan.*;
import eksepsi.*;

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // Mengisi Data Uji Wajib
        katalog.tambahKoleksi(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false));
        katalog.tambahKoleksi(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "B-04", false));
        katalog.tambahKoleksi(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001"));
        katalog.tambahKoleksi(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002"));

        System.out.println("\n--- STATUS AWAL KATALOG ---");
        katalog.cetakStatus();

        System.out.println("\n--- PENGURUTAN (LAYAK DULUAN, LALU JUDUL) ---");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n--- UJI EKSEPSI PEMINJAMAN ---");
        // Uji peminjaman sukses
        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println(e.getMessage());
        }

        // Uji eksepsi koleksi sedang dipinjam
        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println(e.getMessage());
        }

        // Uji eksepsi koleksi tidak layak
        try {
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- EKSPOR KATALOG KE FILE ---");
        EksporKatalog.eksporKeFile(katalog.getDaftarKoleksi(), "katalog.txt");
    }
}
