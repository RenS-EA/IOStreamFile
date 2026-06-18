
package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // Membuat objek pengelola dan mengisinya
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111"));
        buku.tambahKontak(new Kontak("Budi", "0822222"));
        buku.tambahKontak(new Kontak("Citra", "0833333"));
    
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
    
        System.out.println();
    
        // Objek baru yang kosong, lalu memuat dari berkas
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak: " + bukuLain.jumlahKontak());
    }
}