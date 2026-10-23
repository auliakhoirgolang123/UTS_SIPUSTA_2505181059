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
    private String lantaiAttr;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRakAttr, String lantaiAttr, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRakAttr = nomorRakAttr;
        this.lantaiAttr = lantaiAttr;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean isLayakDipinjam() { return !sedangDiperbaiki; }

    @Override
    public String nomorRak() { return nomorRakAttr; }

    @Override
    public String lokasiLantai() { return lantaiAttr; }

    @Override
    public String deskripsi() {
        String diperbaikiStr = sedangDiperbaiki ? "Ya" : "Tidak";
        String kelayakanStr = isLayakDipinjam() ? "LAYAK" : "TIDAK LAYAK";
        String pinjamStr = isSedangDipinjam() ? "SEDANG DIPINJAM" : "BELUM DIPINJAM";
        
        return super.deskripsi() + " | Buku cetak: " + jumlahHalaman + " halaman | " + ringkasanArsip() + " | Diperbaiki: " + diperbaikiStr +
               "\nKelayakan: " + kelayakanStr + " | Peminjaman: " + pinjamStr;
    }
}