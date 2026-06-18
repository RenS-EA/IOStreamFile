
package bagian2.bacatulis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class KelolaHari {

    public static void main(String[] args) {
        // Menentukan path berkas target
        Path path = Paths.get("hari.txt");

        System.out.println("=== SKENARIO 1: Menulis & Membaca 5 Hari ===");
        tulisDanBacaAwal(path);
        System.out.println();

        System.out.println("=== SKENARIO 2: Menambahkan (Append) 2 Hari ===");
        tambahHariLagi(path);
        System.out.println();

        System.out.println("=== SKENARIO 3: Menghitung Jumlah Baris ===");
        hitungJumlahBaris(path);
    }

    // 1. Menulis 5 nama hari awal lalu membacanya kembali
    public static void tulisDanBacaAwal(Path path) {
        List<String> limaHari = Arrays.asList("Senin", "Selasa", "Rabu", "Kamis", "Jumat");

        try {
            // Menulis ke berkas (akan membuat baru atau menimpa berkas lama jika sudah ada)
            Files.write(path, limaHari);
            System.out.println("Status: Berhasil menulis 5 hari awal ke berkas.");

            // Membaca kembali isi berkas
            System.out.println("Isi berkas saat ini:");
            List<String> isiBerkas = Files.readAllLines(path);
            for (String hari : isiBerkas) {
                System.out.println("- " + hari);
            }
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan di Skenario 1: " + e.getMessage());
        }
    }

    // 2. Menambahkan 2 nama hari tanpa menghapus data sebelumnya
    public static void tambahHariLagi(Path path) {
        List<String> duaHariTambahan = Arrays.asList("Sabtu", "Minggu");

        try {
            // Menggunakan StandardOpenOption.APPEND agar data ditambahkan di akhir berkas
            Files.write(path, duaHariTambahan, StandardOpenOption.APPEND);
            System.out.println("Status: Berhasil menambahkan 2 hari.");

            // Menampilkan seluruh isi berkas terbaru
            System.out.println("Isi seluruh berkas sekarang:");
            List<String> isiBerkas = Files.readAllLines(path);
            for (String hari : isiBerkas) {
                System.out.println("- " + hari);
            }
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan di Skenario 2: " + e.getMessage());
        }
    }

    // 3. Membaca berkas dan menghitung total baris yang ada di dalamnya
    public static void hitungJumlahBaris(Path path) {
        // Menggunakan try-with-resources agar Stream otomatis ditutup dari memori setelah selesai
        try (Stream<String> lines = Files.lines(path)) {
            
            long jumlahBaris = lines.count();
            System.out.println("Total baris di dalam berkas 'hari.txt': " + jumlahBaris + " baris.");

        } catch (IOException e) {
            System.err.println("Terjadi kesalahan di Skenario 3: " + e.getMessage());
        }
    }
}