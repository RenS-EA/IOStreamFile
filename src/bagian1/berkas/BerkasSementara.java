
package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class BerkasSementara {
    public static void main(String[] args) {
        File berkasSmt = new File("sementara.txt");

        try {
            // 1. Buat berkas baru jika belum ada
            if (berkasSmt.createNewFile()) {
                System.out.println("Berkas 'sementara.txt' berhasil dibuat.");
            }

            // 2. Tampilkan status keberadaan sebelum dihapus
            System.out.println("Status sebelum dihapus (exists()): " + berkasSmt.exists());

            // 3. Hapus berkas
            if (berkasSmt.delete()) {
                System.out.println("Berkas 'sementara.txt' berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus berkas.");
            }

            // 4. Tampilkan status keberadaan sesudah dihapus
            System.out.println("Status sesudah dihapus (exists()): " + berkasSmt.exists());

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O: " + e.getMessage());
        }
    }
}