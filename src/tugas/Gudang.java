
package tugas;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Gudang {
    private List<Barang> daftarBarang = new ArrayList<>();
    private final String namaBerkas = "barang.txt";

    // Method untuk menambah barang ke dalam ArrayList
    public void tambahBarang(Barang b) {
        daftarBarang.add(b);
    }

    // Method untuk menampilkan semua barang yang ada di memori saat ini
    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("[Gudang Kosong]");
            return;
        }
        for (Barang b : daftarBarang) {
            b.info();
        }
    }

    // Method untuk menyimpan seluruh data dari ArrayList ke berkas teks
    public void simpanKeBerkas() {
        try {
            List<String> barisBaru = new ArrayList<>();
            for (Barang b : daftarBarang) {
                barisBaru.add(b.keBaris());
            }
            Files.write(Paths.get(namaBerkas), barisBaru);
            System.out.println("Status: Berhasil menyimpan data ke " + namaBerkas);
        } catch (IOException e) {
            System.err.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    // Method untuk memuat kembali data dari berkas teks ke dalam ArrayList
    public void muatDariBerkas() {
        Path path = Paths.get(namaBerkas);
        if (!Files.exists(path)) {
            System.out.println("Pesan: Berkas " + namaBerkas + " belum dibuat.");
            return;
        }

        daftarBarang.clear(); // Bersihkan list memori terlebih dahulu
        try {
            List<String> semuaBaris = Files.readAllLines(path);
            for (String baris : semuaBaris) {
                String[] bagian = baris.split(",", 3);
                if (bagian.length == 3) {
                    String nama = bagian[0].trim();
                    double harga = Double.parseDouble(bagian[1].trim());
                    int stok = Integer.parseInt(bagian[2].trim());
                    
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Status: Berhasil memuat data dari " + namaBerkas);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Gagal memuat atau memecah data dari berkas: " + e.getMessage());
        }
    }

    // Method untuk menghitung total nilai persediaan (harga * stok) dari seluruh barang
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}