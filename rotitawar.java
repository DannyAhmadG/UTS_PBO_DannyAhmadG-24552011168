/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.tokoroti;

/**
 *
 * @author USER
 */
public class rotitawar extends produkroti {
    private String jenisTepung;
    private boolean adaSusu;
    private int jmlPotongan;
    
    public rotitawar(String kodeProduk, String namaRoti, double hargaJual, int stok, 
                     String jenisTepung, boolean adaSusu, int jmlPotongan) {
        
        super(kodeProduk, namaRoti, hargaJual, stok); 
        this.jenisTepung = jenisTepung;
        this.adaSusu = adaSusu;
        this.jmlPotongan = jmlPotongan;
    }
    
        @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("  Jenis Tepung: " + jenisTepung);
        System.out.println("  Mengandung Susu: " + (adaSusu ? "Ya" : "Tidak"));
        System.out.println("  Jumlah Potongan: " + jmlPotongan + " slice");
        System.out.println("  Status Pemotongan: " + cekStatusPotong()); // Memanggil method tambahan
    }
    
    public String cekStatusPotong() {
        if (jmlPotongan > 0) {
            return "Sudah dipotong";
        } else {
            return "Belum dipotong";
        }
    }

    public int getJmlPotongan() {
        return jmlPotongan;
    }
}
