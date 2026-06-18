
package bagian2.bacatulis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class KelolaHariBagian1 {
    public static void main(String[] args) {
        Path path = Paths.get("hari.txt");
        List<String> limaHari = Arrays.asList("Senin", "Selasa", "Rabu", "Kamis", "Jumat");

        try {
            // 1. Menulis 5 nama hari ke dalam berkas (satu nama per baris)
            Files.write(path, limaHari);
            System.out.println("--- Berhasil menulis 5 hari ke hari.txt ---\n");

            // 2. Membaca kembali dan menampilkan ke layar
            System.out.println("Isi berkas saat ini:");
            List<String> isiBerkas = Files.readAllLines(path);
            for (String hari : isiBerkas) {
                System.out.println(hari);
            }

        } catch (IOException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}