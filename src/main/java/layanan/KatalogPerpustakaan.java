package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;
import eksepsi.*;

public class KatalogPerpustakaan {
    private List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambahKoleksi(Koleksi k) { daftarKoleksi.add(k); }
    public List<Koleksi> getDaftarKoleksi() { return daftarKoleksi; }

    public void cetakStatus() {
        for (Koleksi k : daftarKoleksi) {
            System.out.println(k.deskripsi());
            System.out.println();
        }
    }

    public void urut(Comparator<Koleksi> comparator) {
        daftarKoleksi.sort(comparator);
    }

    public void pinjam(String kodeKoleksi) throws PustakaException {
        Koleksi target = null;
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                target = k;
                break;
            }
        }

        if (target == null) {
            throw new PustakaException("Ditolak: Koleksi dengan kode " + kodeKoleksi + " tidak ditemukan. Periksa kembali kode koleksi.");
        }

        if (target.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(target.getJudul());
        }

        if (!target.isLayakDipinjam()) {
            throw new KoleksiTidakLayakException(target.getJudul());
        }

        target.setSedangDipinjam(true);
        System.out.println("Berhasil meminjam " + target.getKodeKoleksi() + " - " + target.getJudul());
    }
}