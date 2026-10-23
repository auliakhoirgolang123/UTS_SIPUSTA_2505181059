/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author MyBook Hype AMD
 */

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul) {
        super("Ditolak: Koleksi \"" + judul + "\" belum memenuhi ketentuan peminjaman. Silakan pilih koleksi lain.");
    }
}