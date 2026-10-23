/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author MyBook Hype AMD
 */
import java.util.Comparator;
import model.Koleksi;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi k1, Koleksi k2) {
        if (k1.isLayakDipinjam() != k2.isLayakDipinjam()) {
            return k1.isLayakDipinjam() ? -1 : 1;
        }
        return k1.getJudul().compareToIgnoreCase(k2.getJudul());
    }
}
