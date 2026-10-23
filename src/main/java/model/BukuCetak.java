/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MyBook Hype AMD
 */
public class BukuCetak extends Koleksi implements Terarsip {
    private int jumlahHalaman;
    private String nomorRakAttr;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRakAttr, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRakAttr = nomorRakAttr;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean isLayakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String nomorRak() {
        return nomorRakAttr;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai 1 (Area Buku)";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Type: Buku Cetak | Halaman: " + jumlahHalaman + " | " + ringkasanArsip();
    }
}