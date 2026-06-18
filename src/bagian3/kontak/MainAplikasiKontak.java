
package bagian3.kontak;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

class Kontak {
    private String nama;
    private String noTelp;
    private String email; // Tambahan Atribut Email

    // Constructor yang disesuaikan
    public Kontak(String nama, String noTelp, String email) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.email = email;
    }

    // Getter
    public String getNama() { return nama; }
    public String getNoTelp() { return noTelp; }
    public String getEmail() { return email; }

    // Menampilkan info lengkap kontak
    public void info() {
        System.out.println("Nama   : " + nama);
        System.out.println("Telepon: " + noTelp);
        System.out.println("Email  : " + email);
    }

    // Mengubah objek menjadi baris teks untuk disimpan ke berkas (dengan pemisah koma)
    public String keBaris() {
        return nama + "," + noTelp + "," + email;
    }
}

class BukuKontak {
    private List<Kontak> daftarKontak = new ArrayList<>();
    private final String namaBerkas = "kontak.txt";

    // Menambah kontak ke list (sementara di memori)
    public void tambahKontak(Kontak k) {
        daftarKontak.add(k);
    }

    // [SOAL 1] Method untuk mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        System.out.println("-> Mencari kontak dengan nama: " + nama);
        boolean ditemukan = false;
        for (Kontak k : daftarKontak) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                k.info();
                ditemukan = true;
                break; // Berhenti jika sudah ketemu
            }
        }
        if (!ditemukan) {
            System.out.println("Pesan: Kontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // [SOAL 3] Method untuk menghapus kontak berdasarkan nama & langsung simpan perubahan
    public void hapusKontak(String nama) {
        System.out.println("-> Mencoba menghapus kontak: " + nama);
        Kontak yangDihapus = null;
        
        for (Kontak k : daftarKontak) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                yangDihapus = k;
                break;
            }
        }

        if (yangDihapus != null) {
            daftarKontak.remove(yangDihapus);
            System.out.println("Pesan: Kontak '" + nama + "' berhasil dihapus dari memori.");
            simpanKeBerkas(); // Sinkronisasi ke berkas fisik
        } else {
            System.out.println("Pesan: Gagal menghapus, kontak '" + nama + "' tidak ditemukan.");
        }
    }

    // Menyimpan seluruh list kontak ke dalam berkas kontak.txt
    public void simpanKeBerkas() {
        try {
            List<String> barisBaru = new ArrayList<>();
            for (Kontak k : daftarKontak) {
                barisBaru.add(k.keBaris());
            }
            Files.write(Paths.get(namaBerkas), barisBaru);
            System.out.println("Status: Data kontak berhasil disinkronkan ke " + namaBerkas);
        } catch (IOException e) {
            System.err.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    // [SOAL 2] Memuat data dari berkas dan memecah baris menjadi 3 bagian
    public void muatDariBerkas() {
        Path path = Paths.get(namaBerkas);
        if (!Files.exists(path)) {
            return; // Lewati jika berkas belum ada
        }

        daftarKontak.clear(); // Bersihkan list memori sebelum memuat ulang
        try {
            List<String> semuaBaris = Files.readAllLines(path);
            for (String baris : semuaBaris) {
                // Memecah menjadi maksimal 3 bagian (Nama, NoTelp, Email)
                String[] bagian = baris.split(",", 3);
                if (bagian.length == 3) {
                    Kontak k = new Kontak(bagian[0].trim(), bagian[1].trim(), bagian[2].trim());
                    daftarKontak.add(k);
                }
            }
        } catch (IOException e) {
            System.err.println("Gagal memuat dari berkas: " + e.getMessage());
        }
    }

    // Menampilkan seluruh isi buku kontak saat ini
    public void tampilkanSemua() {
        if (daftarKontak.isEmpty()) {
            System.out.println("[Buku Kontak Kosong]");
            return;
        }
        System.out.println("--- DAFTAR KONTAK SAAT INI ---");
        for (Kontak k : daftarKontak) {
            System.out.println("- " + k.getNama() + " (" + k.getNoTelp() + " | " + k.getEmail() + ")");
        }
    }
}

public class MainAplikasiKontak {
    public static void main(String[] args) {
        BukuKontak buku = new BukuKontak();

        // 1. Simulasikan pembuatan data awal dan simpan ke berkas
        System.out.println("=== 1. INISIALISASI DATA AWAL ===");
        buku.tambahKontak(new Kontak("Alice", "0812345", "alice@email.com"));
        buku.tambahKontak(new Kontak("Bob", "0856789", "bob@email.com"));
        buku.tambahKontak(new Kontak("Charlie", "0899999", "charlie@email.com"));
        buku.simpanKeBerkas();
        System.out.println();

        // 2. Muat data dari berkas (menguji split 3 bagian)
        System.out.println("=== 2. MEMUAT DATA DARI BERKAS ===");
        buku.muatDariBerkas();
        buku.tampilkanSemua();
        System.out.println();

        // 3. Menguji Fitur Cari Kontak (Soal 1)
        System.out.println("=== 3. PENGUJIAN FITUR CARI KONTAK ===");
        buku.cariKontak("Bob");       // Skenario: Ditemukan
        System.out.println();
        buku.cariKontak("SpongeBob"); // Skenario: Tidak Ditemukan
        System.out.println();

        // 4. Menguji Fitur Hapus Kontak + Auto Simpan (Soal 3)
        System.out.println("=== 4. PENGUJIAN FITUR HAPUS KONTAK ===");
        buku.hapusKontak("Alice"); // Menghapus Alice
        System.out.println();
        
        // 5. Cek hasil akhir untuk memastikan Alice benar-benar hilang di memori & berkas
        System.out.println("=== 5. VERIFIKASI HASIL AKHIR ===");
        buku.tampilkanSemua();
    }
}