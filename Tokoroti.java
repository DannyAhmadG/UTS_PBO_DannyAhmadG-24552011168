/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package uts.tokoroti;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tokoroti {
    private static List<produkroti> daftarSemuaRoti = new ArrayList<>();
    private static List<Penjualan> daftarSemuaPenjualan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        inisialisasiData(); 
        
        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu (1-6): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (pilihan) {
                case 1 -> tambahDataRoti();
                case 2 -> tampilkanDataRoti();
                case 3 -> cariDataRoti();
                case 4 -> ubahHargaRoti();
                case 5 -> cekStatusStok();
                case 6 -> System.out.println("Terima kasih, program keluar.");
                default -> System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        } while (pilihan != 6);
    }
    
    private static void inisialisasiData() {
        
        rotitawar rt1 = new rotitawar("RT001", "Roti Tawar Gandum", 25000, 50, "Gandum", true, 12);
        rotitawar rt2 = new rotitawar("RT002", "Roti Tawar Susu", 20000, 20, "susu", true, 8);
        rotitawar rt3 = new rotitawar("RT003", "Roti Tawar Baguette", 120000, 10, "Gandum", true, 6);
        rotimanis rm1 = new rotimanis("RM001", "Roti Cokelat Keju", 12000, 80, "Cokelat", "Keju Parut",100);
        rotimanis rm2 = new rotimanis("RM002", "Roti Stroberi Coklat", 7500, 50,"Coklat","Stroberi Selai", 75);
        rotimanis rm3 = new rotimanis("RM001", "Roti Bluebery Keju", 5000, 30, "Bluebery", "Keju Parut", 90);
        
        daftarSemuaRoti.add(rt1);
        daftarSemuaRoti.add(rm1);
        
        Penjualan p1 = new Penjualan("PJL001", "2025-11-23", "Gia");
        p1.tambahProduk(rm1);
        p1.tambahProduk(rm2);
        p1.tambahProduk(rm3);
        p1.tambahProduk(rt1);
        p1.tambahProduk(rt2);
        p1.tambahProduk(rt3);
        daftarSemuaPenjualan.add(p1);
        
        rt1.kurangiStok(1);
        rt2.kurangiStok(1);
        rt3.kurangiStok(1);
        rm1.kurangiStok(2);
        rm2.kurangiStok(2);
        rm3.kurangiStok(2);
        
    }

    private static void tampilkanMenu() {
        System.out.println("=========================================");
        System.out.println("    APLIKASI PRODUKSI TOKO ROTI ");
        System.out.println("=========================================");
        System.out.println("1. Tambah Produk Roti");
        System.out.println("2. Tampilkan Data Produk & Penjualan");
        System.out.println("3. Cari Produk Roti");
        System.out.println("4. Ubah Harga Produk ");
        System.out.println("5. Cek Stok Produk");
        System.out.println("6. Keluar dari Program");
        System.out.println("=========================================");
    }
   
    private static void tambahDataRoti() {
        System.out.println("--- TAMBANKAN PRODUK ---");
       System.out.print("Jenis Roti (1: Tawar, 2: Manis): ");
        int jenis = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Kode Produk: ");
        String kode = scanner.nextLine();
        System.out.print("Nama Roti: ");
        String nama = scanner.nextLine();
        System.out.print("Harga Jual: ");
        double harga = scanner.nextDouble();
        System.out.print("Stok Awal: ");
        int stok = scanner.nextInt();
        scanner.nextLine();
        
        switch (jenis) {
            case 1 ->                 {
                    System.out.print("Jenis Tepung: ");
                    String tepung = scanner.nextLine();
                    System.out.print("Mengandung Susu (true/false): ");
                    boolean susu = scanner.nextBoolean();
                    System.out.print("Jumlah Potongan: ");
                    int potong = scanner.nextInt();
                    scanner.nextLine();
                    rotitawar baru = new rotitawar(kode, nama, harga, stok, tepung, susu, potong);
                    daftarSemuaRoti.add(baru);
                    System.out.println("Roti Tawar '" + nama + "' berhasil ditambahkan!");
                }
            case 2 ->                 {
                    System.out.print("Isian: ");
                    String isian = scanner.nextLine();
                    System.out.print("Topping: ");
                    String topping = scanner.nextLine();
                    System.out.print("Berat (gram): ");
                    double berat = scanner.nextDouble();
                    scanner.nextLine();
                    rotimanis baru = new rotimanis(kode, nama, harga, stok, isian, topping, berat);
                    daftarSemuaRoti.add(baru);
                    System.out.println("Roti Manis '" + nama + "' berhasil ditambahkan!");
                }
            default -> System.out.println("Jenis roti tidak valid.");
        }
    }
    
    private static void tampilkanDataRoti() {
        System.out.println("--- DAFTAR SEMUA PRODUK ---");
        if (daftarSemuaRoti.isEmpty()) {
            System.out.println("Belum ada produk terdaftar.");
            return;
        }
        for (produkroti roti : daftarSemuaRoti) {
            roti.displayInfo(); 
            System.out.println("---------------------------------");
        }
        
        System.out.println("--- DAFTAR SEMUA PENJUALAN ---");
        if (daftarSemuaPenjualan.isEmpty()) {
            System.out.println("Belum ada transaksi penjualan.");
            return;
        }
        for (Penjualan penjualan : daftarSemuaPenjualan) {
            penjualan.displayDetailPenjualan();
        }
    }
    
    private static void cariDataRoti() {
        System.out.println("--- CARI DATA PRODUK ROTI ---");
        System.out.print("Masukkan Kode Produk atau Nama Roti: ");
        String keyword = scanner.nextLine().toLowerCase();
        
        boolean ditemukan = false;
        for (produkroti roti : daftarSemuaRoti) {
            if (roti.getKodeProduk().toLowerCase().contains(keyword) || 
                roti.getNamaRoti().toLowerCase().contains(keyword)) {
                
                System.out.println("Produk Ditemukan:");
                roti.displayInfo();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Produk tidak ditemukan.");
        }
    }
    
    private static void ubahHargaRoti() {
        System.out.println("--- UBAH HARGA PRODUK ---");
        System.out.print("Masukkan Kode Produk yang akan diubah: ");
        String kodeCari = scanner.nextLine();
        
        boolean ditemukan = false;
        for (produkroti roti : daftarSemuaRoti) {
            if (roti.getKodeProduk().equalsIgnoreCase(kodeCari)) {
                System.out.println("Harga saat ini: Rp" + roti.getHargaJual());
                System.out.print("Masukkan Harga Baru: ");
                double hargaBaru = scanner.nextDouble();
                scanner.nextLine();
                
                roti.setHargaJual(hargaBaru);
                System.out.println("Harga produk " + roti.getNamaRoti() + " berhasil diubah.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Kode produk tidak ditemukan.");
        }
    }
   
    private static void cekStatusStok() {
        System.out.println("--- CEK STATUS STOK PRODUK ---");
        for (produkroti roti : daftarSemuaRoti) {
            String status;
            if (roti.getStok() > 20) {
                status = "STOK AMAN";
            } else if (roti.getStok() > 0) {
                status = "STOK MENIPIS";
            } else {
                status = "STOK HABIS";
            }
            System.out.printf("[%s] %-20s : Stok %d (%s)", 
                              roti.getKodeProduk(), roti.getNamaRoti(), roti.getStok(), status);
        }
    }
}
