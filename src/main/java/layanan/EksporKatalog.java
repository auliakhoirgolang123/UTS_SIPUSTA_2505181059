package layanan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Koleksi;

public class EksporKatalog {
    public static void eksporKeFile(List<Koleksi> daftarKoleksi, String namaFile) {
        File file = new File(namaFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Koleksi k : daftarKoleksi) {
                writer.write(k.deskripsi());
                writer.newLine();
                writer.newLine();
            }
            System.out.println("Katalog berhasil diekspor ke: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Gagal mengekspor file: " + e.getMessage());
        }
    }
}