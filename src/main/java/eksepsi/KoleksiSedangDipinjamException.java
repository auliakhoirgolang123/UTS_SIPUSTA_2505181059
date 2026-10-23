/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author MyBook Hype AMD
 */

public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String kode) {
        super("Gagal Pinjam: Koleksi dengan kode " + kode + " saat ini sedang dipinjam oleh pengguna lain.");
    }
}
