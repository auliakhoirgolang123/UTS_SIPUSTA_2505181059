/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MyBook Hype AMD
 */
public class BerkasDigital extends Koleksi {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean isLayakDipinjam() { return true; }

    @Override
    public String deskripsi() {
        String kelayakanStr = isLayakDipinjam() ? "LAYAK" : "TIDAK LAYAK";
        String pinjamStr = isSedangDipinjam() ? "SEDANG DIPINJAM" : "BELUM DIPINJAM";
        
        return super.deskripsi() + " | Berkas digital: " + ukuranMB + " MB | Tautan: " + tautanUnduh +
               "\nKelayakan: " + kelayakanStr + " | Peminjaman: " + pinjamStr;
    }
}
