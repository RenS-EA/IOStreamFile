
package tugas;

// Nama : [Nama Anda]
// NPM  : [NPM Anda]

public class MainTugas {
    public static void main(String[] args) {
        
        // --- Bagian Tambahan 1: Array Kategori Statis ---
        System.out.println("=== 1. DAFTAR KATEGORI BARANG ===");
        String[] kategori = {"Elektronik", "Pakaian", "Makanan", "Alat Tulis"};
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.println();

        // --- Inisialisasi Gudang Pertama dan Tambah Minimal 5 Barang ---
        System.out.println("=== 2. PROSES PEMBUATAN DATA AWAL ===");
        Gudang gudangAwal = new Gudang();
        gudangAwal.tambahBarang(new Barang("Laptop", 8500000, 5));
        gudangAwal.tambahBarang(new Barang("Smartphone", 3500000, 10));
        gudangAwal.tambahBarang(new Barang("Kemeja", 150000, 25));
        gudangAwal.tambahBarang(new Barang("Indomie Box", 120000, 15));
        gudangAwal.tambahBarang(new Barang("Buku Tulis", 5000, 100));

        System.out.println("Isi Gudang Awal sebelum disimpan:");
        gudangAwal.tampilkanSemua();
        
        // --- Bagian Tambahan 2: Menyimpan ke Berkas Teks ---
        gudangAwal.simpanKeBerkas();
        System.out.println();

        // --- Bagian Tambahan 3: Membuat Objek Gudang Baru & Memuat dari Berkas ---
        System.out.println("=== 3. PENGUJIAN INSTANSIASI GUDANG BARU (RESTORASI DATA) ===");
        Gudang gudangBaru = new Gudang();
        
        // Memuat ulang data untuk membuktikan berkas teks bekerja
        gudangBaru.muatDariBerkas();
        
        System.out.println("\nIsi Gudang Baru setelah memuat data:");
        gudangBaru.tampilkanSemua();
        
        // Menampilkan total nilai persediaan gudang baru
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("Total Nilai Persediaan Barang: Rp%,.2f\n", gudangBaru.totalNilai());
        System.out.println("-----------------------------------------------------------------");
    }
}