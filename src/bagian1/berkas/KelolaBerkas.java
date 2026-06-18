
package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class KelolaBerkas {

    public static void main(String[] args) {
        System.out.println("=== SKENARIO 1: Cek Berkas ===");
        cekLaporan();
        System.out.println();

        System.out.println("=== SKENARIO 2: Buat Folder ===");
        buatFolderArsip();
        System.out.println();

        System.out.println("=== SKENARIO 3: Buat & Hapus Berkas Sementara ===");
        kelolaBerkasSementara();
    }

    // Skenario 1: Memeriksa keberadaan dan ukuran laporan.txt
    public static void cekLaporan() {
        File berkas = new File("laporan.txt");

        if (berkas.exists()) {
            System.out.println("Status: Berkas 'laporan.txt' ditemukan.");
            System.out.println("Ukuran berkas: " + berkas.length() + " byte");
        } else {
            System.out.println("Status: Berkas 'laporan.txt' tidak ditemukan.");
        }
    }

    // Skenario 2: Membuat folder 'arsip' dengan mkdir()
    public static void buatFolderArsip() {
        File folder = new File("arsip");

        if (folder.mkdir()) {
            System.out.println("Pesan: Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Pesan: Gagal membuat folder 'arsip' (mungkin folder sudah ada).");
        }
    }

    // Skenario 3: Membuat, mengecek, dan menghapus sementara.txt
    public static void kelolaBerkasSementara() {
        File berkasSmt = new File("sementara.txt");

        try {
            // Membuat berkas baru
            if (berkasSmt.createNewFile()) {
                System.out.println("Pesan: Berkas 'sementara.txt' berhasil dibuat.");
            }

            // Status sebelum dihapus
            System.out.println("Status sebelum dihapus (exists()): " + berkasSmt.exists());

            // Menghapus berkas
            if (berkasSmt.delete()) {
                System.out.println("Pesan: Berkas 'sementara.txt' berhasil dihapus.");
            } else {
                System.out.println("Pesan: Gagal menghapus berkas.");
            }

            // Status sesudah dihapus
            System.out.println("Status sesudah dihapus (exists()): " + berkasSmt.exists());

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O: " + e.getMessage());
        }
    }
}