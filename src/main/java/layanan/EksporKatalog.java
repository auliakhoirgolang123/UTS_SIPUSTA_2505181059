/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author MyBook Hype AMD
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Koleksi;

public class EksporKatalog {
    public static void eksporKeFile(List<Koleksi> daftarKoleksi, String namaFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            writer.write(String.format("%-10s %-30s %-10s %-20s %-20s%n", "KODE", "JUDUL", "TAHUN", "STATUS PINJAM", "KELAYAKAN"));
            writer.write("---------------------------------------------------------------------------------------------\n");
            
            for (Koleksi k : daftarKoleksi) {
                String status = k.isSedangDipinjam() ? "Dipinjam" : "Tersedia";
                String layak = k.isLayakDipinjam() ? "Layak" : "Tidak Layak";
                writer.write(String.format("%-10s %-30s %-10d %-20s %-20s%n", 
                        k.getKodeKoleksi(), k.getJudul(), k.getTahunTerbit(), status, layak));
            }
            System.out.println("Katalog berhasil diekspor ke berkas: " + namaFile);
        } catch (IOException e) {
            System.err.println("Gagal mengekspor file: " + e.getMessage());
        }
    }
}
