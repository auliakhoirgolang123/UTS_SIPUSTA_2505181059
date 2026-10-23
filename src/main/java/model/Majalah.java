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
    private boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRakAttr, boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRakAttr = nomorRakAttr;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean isLayakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return nomorRakAttr;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai 2 (Area Majalah & Serial)";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Type: Majalah | Edisi: " + edisi + " (" + bulanTerbit + ") | " + ringkasanArsip();
    }
}
