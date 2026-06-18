
package bagian2.bacatulis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class KelolaHariBagian2 {
    public static void main(String[] args) {
        Path path = Paths.get("hari.txt");
        List<String> duaHariTambahan = Arrays.asList("Sabtu", "Minggu");

        try {
            // 1. Menambahkan (append) 2 nama hari
            Files.write(path, duaHariTambahan, StandardOpenOption.APPEND);
            System.out.println("--- Berhasil menambahkan 2 hari ke hari.txt ---\n");

            // 2. Menampilkan seluruh isinya
            System.out.println("Isi seluruh berkas setelah ditambahkan:");
            List<String> isiBerkas = Files.readAllLines(path);
            for (String hari : isiBerkas) {
                System.out.println(hari);
            }

        } catch (IOException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}