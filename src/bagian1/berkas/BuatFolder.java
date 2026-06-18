
package bagian1.berkas;

import java.io.File;

public class BuatFolder {
    public static void main(String[] args) {
        // Buat objek File untuk folder
        File folder = new File("arsip");

        // Coba buat folder baru
        if (folder.mkdir()) {
            System.out.println("Pesan: Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Pesan: Gagal membuat folder 'arsip' (mungkin folder sudah ada).");
        }
    }
}