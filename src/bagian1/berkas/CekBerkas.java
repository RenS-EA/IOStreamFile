
package bagian1.berkas;

import java.io.File;

public class CekBerkas {
    public static void main(String[] args) {
        // Buat objek File
        File berkas = new File("laporan.txt");

        // Periksa apakah berkas ada
        if (berkas.exists()) {
            System.out.println("Status: Berkas 'laporan.txt' ditemukan.");
            System.out.println("Ukuran berkas: " + berkas.length() + " byte");
        } else {
            System.out.println("Status: Berkas 'laporan.txt' tidak ditemukan.");
        }
    }
}