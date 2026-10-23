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
            
            writer.write(String.format("%-10s %-30s %-10s %-20s %-20s", 
                    "KODE", "JUDUL", "TAHUN", "STATUS PINJAM", "KELAYAKAN"));
            writer.newLine();
            writer.write("---------------------------------------------------------------------------------------------");
            writer.newLine();
            
            // Baris Data Sejajar Rapi
            for (Koleksi k : daftarKoleksi) {
                String status = k.isSedangDipinjam() ? "Dipinjam" : "Tersedia";
                String layak = k.isLayakDipinjam() ? "Layak" : "Tidak Layak";
                
                writer.write(String.format("%-10s %-30s %-10d %-20s %-20s", 
                        k.getKodeKoleksi(), 
                        k.getJudul(), 
                        k.getTahunTerbit(), 
                        status, 
                        layak));
                writer.newLine();
            }
            
            System.out.println("Katalog berhasil diekspor ke: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Gagal mengekspor file: " + e.getMessage());
        }
    }
}