/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author MyBook Hype AMD
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;

public class KatalogPerpustakaan {
    private List<Koleksi> daftarKoleksi;

    public KatalogPerpustakaan() {
        this.daftarKoleksi = new ArrayList<>();
    }

    public void tambahKoleksi(Koleksi k) {
        daftarKoleksi.add(k);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    public void cetakStatus() {
        System.out.println("======================================== KATALOG KOLEKSI ========================================");
        for (Koleksi k : daftarKoleksi) {
            String statusPinjam = k.isSedangDipinjam() ? "Sedang Dipinjam" : "Tersedia";
            String kelayakan = k.isLayakDipinjam() ? "LAYAK PINJAM" : "TIDAK LAYAK PINJAM";
            System.out.println(k.deskripsi() + " | Status: " + statusPinjam + " [" + kelayakan + "]");
        }
        System.out.println("=================================================================================================");
    }

    public void urut(Comparator<Koleksi> comparator) {
        daftarKoleksi.sort(comparator);
    }

    public void pinjam(String kodeKoleksi) throws KoleksiSedangDipinjamException, KoleksiTidakLayakException {
        Koleksi target = null;
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                target = k;
                break;
            }
        }

        if (target != null) {
            if (target.isSedangDipinjam()) {
                throw new KoleksiSedangDipinjamException(kodeKoleksi);
            }
            if (!target.isLayakDipinjam()) {
                throw new KoleksiTidakLayakException(target.getJudul());
            }
            target.setSedangDipinjam(true);
            System.out.println("Berhasil meminjam: " + target.getJudul());
        } else {
            System.out.println("Koleksi dengan kode " + kodeKoleksi + " tidak ditemukan.");
        }
    }
}
