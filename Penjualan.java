/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.tokoroti;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.List;

public class Penjualan {
    private String idTransaksi;
    private String tanggalPenjualan;
    private String namaKasir;
    

    private List<produkroti> daftarProduk;

    public Penjualan(String idTransaksi, String tanggalPenjualan, String namaKasir) {
        this.idTransaksi = idTransaksi;
        this.tanggalPenjualan = tanggalPenjualan;
        this.namaKasir = namaKasir;
        this.daftarProduk = new ArrayList<>(); 
    }
    public void tambahProduk(produkroti produk) {
        this.daftarProduk.add(produk);
    }
    public double hitungTotalPenjualan() {
        double total = 0;
        for (produkroti produk : daftarProduk) {
            total += produk.getHargaJual(); 
        }
        return total;
    }
    public void displayDetailPenjualan() {
        System.out.println("--- Detail Penjualan ID: " + idTransaksi + " ---");
        System.out.println("Tanggal: " + tanggalPenjualan);
        System.out.println("Kasir: " + namaKasir);
        System.out.println("Produk Dibeli (" + daftarProduk.size() + " item):");
        for (produkroti produk : daftarProduk) {
            
            System.out.println("  - " + produk.getNamaRoti() + " (Rp" + produk.getHargaJual() + ")"); 
        }
        System.out.println("TOTAL PENJUALAN: Rp" + hitungTotalPenjualan());
        System.out.println("----------------------------------------------");
    }
    public String getIdTransaksi() {
        return idTransaksi;
    }

    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
/**
     *
     * @author USER
     */
    public static class rotimanis {
    }
}
