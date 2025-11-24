/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.tokoroti;
        
/**
 *
 * @author USER
 */
public class produkroti {
    private String kodeProduk;
    private String namaRoti;
    private double hargaJual;
    private int stok;
    public produkroti(String kodeProduk, String namaRoti, double hargaJual, int stok) {
        // Menginisialisasi atribut dengan nilai dari parameter
        this.kodeProduk = kodeProduk;
        this.namaRoti = namaRoti;
        this.hargaJual = hargaJual;
        this.stok = stok;
    }
  
    public void displayInfo() {
        System.out.println("  Kode: " + kodeProduk);
        System.out.println("  Nama: " + namaRoti);
        System.out.println("  Harga: Rp" + hargaJual);
        System.out.println("  Stok Tersedia: " + stok);
    }
    
    public boolean kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            this.stok -= jumlah;
            return true;
        } else {
            return false;
        }
    }
    
    public String getKodeProduk() {
        return kodeProduk;
    }
    
    public void setNamaRoti(String namaRoti) {
        this.namaRoti = namaRoti;
    }

    public String getNamaRoti() {
        return namaRoti;
    }

    public double getHargaJual() {
        return hargaJual;
    }
    
    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getStok() {
        return stok;
    }
}
