
package bagian2.bacatulis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class KelolaHariBagian3 {
    public static void main(String[] args) {
        Path path = Paths.get("hari.txt");

        // Menggunakan try-with-resources agar Stream otomatis ditutup setelah selesai
        try (Stream<String> lines = Files.lines(path)) {
            
            // Menghitung jumlah baris menggunakan method .count()
            long jumlahBaris = lines.count();
            
            System.out.println("--- Analisis Berkas ---");
            System.out.println("Jumlah baris yang ada di dalam berkas 'hari.txt': " + jumlahBaris + " baris.");

        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat membaca berkas: " + e.getMessage());
        }
    }
}