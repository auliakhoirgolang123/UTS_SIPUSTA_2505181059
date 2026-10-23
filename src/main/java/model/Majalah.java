/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MyBook Hype AMD
 */
public class Majalah extends Koleksi implements Terarsip {
    private int edisi;
    private String bulanTerbit;
    private String nomorRakAttr;
    private String lantaiAttr;
    private boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRakAttr, String lantaiAttr, boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRakAttr = nomorRakAttr;
        this.lantaiAttr = lantaiAttr;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean isLayakDipinjam() { return !edisiTerbaru; }

    @Override
    public String nomorRak() { return nomorRakAttr; }

    @Override
    public String lokasiLantai() { return lantaiAttr; }

    @Override
    public String deskripsi() {
        String terbaruStr = edisiTerbaru ? "Ya" : "Tidak";
        String kelayakanStr = isLayakDipinjam() ? "LAYAK" : "TIDAK LAYAK";
        String pinjamStr = isSedangDipinjam() ? "SEDANG DIPINJAM" : "BELUM DIPINJAM";
        
        return super.deskripsi() + " | Majalah edisi " + edisi + " | Bulan: " + bulanTerbit + " | " + ringkasanArsip() + " | Edisi terbaru: " + terbaruStr +
               "\nKelayakan: " + kelayakanStr + " | Peminjaman: " + pinjamStr;
    }
}