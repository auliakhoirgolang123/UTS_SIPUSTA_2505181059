import model.*;
import layanan.*;
import eksepsi.*;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // 1. TAMBAH DATA UJI
        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "Rak A-12", "lantai 1", false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "Rak B-04", "lantai 1", true);
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "Rak C-01", "lantai 2", true);
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "Rak C-02", "lantai 2", false);
        BerkasDigital bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15.0, "unduh.polmed.ac.id/bd001");
        BerkasDigital bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8.0, "unduh.polmed.ac.id/bd002");

        katalog.tambahKoleksi(bk1);
        katalog.tambahKoleksi(bk2);
        katalog.tambahKoleksi(mj1);
        katalog.tambahKoleksi(mj2);
        katalog.tambahKoleksi(bd1);
        katalog.tambahKoleksi(bd2);

        // STATUS AWAL
        System.out.println("=== STATUS AWAL KOLEKSI ===");
        katalog.cetakStatus();

        // CONTOH RINGKASAN ARSIP
        System.out.println("=== CONTOH RINGKASAN ARSIP ===");
        System.out.println(bk1.ringkasanArsip());
        System.out.println(mj1.ringkasanArsip());
        System.out.println();

        // URUT BERDASARKAN JUDUL
        System.out.println("=== URUT BERDASARKAN JUDUL ===");
        katalog.urut(Comparator.comparing(Koleksi::getJudul));
        katalog.cetakStatus();

        // URUT LAYAK LALU JUDUL
        System.out.println("=== URUT LAYAK LALU JUDUL ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // PENGUJIAN PEMINJAMAN
        System.out.println("=== PENGUJIAN PEMINJAMAN ===");
        String[] daftarPinjam = {"BK-001", "BK-001", "BK-002", "MJ-001", "MJ-002", "BD-001", "BD-002", "XX-999"};
        for (String kode : daftarPinjam) {
            try {
                katalog.pinjam(kode);
            } catch (PustakaException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        // STATUS SETELAH PEMINJAMAN
        System.out.println("=== STATUS SETELAH PEMINJAMAN ===");
        katalog.cetakStatus();

        // EKSPOR KATALOG
        System.out.println("=== EKSPOR KATALOG ===");
        EksporKatalog.eksporKeFile(katalog.getDaftarKoleksi(), "katalog.txt");
    }
}