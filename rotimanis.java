/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.tokoroti;

/**
 *
 * @author USER
 */
public class rotimanis extends produkroti {
    private String isian;
    private String topping;
    private double beratGram;
    
    public rotimanis(String kodeProduk, String namaRoti, double hargaJual, int stok, 
                     String isian, String topping, double beratGram) {

        super(kodeProduk, namaRoti, hargaJual, stok); 
        this.isian = isian;
        this.topping = topping;
        this.beratGram = beratGram;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("  Isian: " + isian);
        System.out.println("  Topping: " + topping);
        System.out.println("  Berat: " + beratGram + " gram");
        System.out.println("  Status Rasa: " + getStatusRasa());
    }
    public String getStatusRasa() {
        if (isian.toLowerCase().contains("cokelat") || isian.toLowerCase().contains("keju")) {
            return "Populer";
        } else {
            return "Reguler";
        }
    }
    
    public String getIsian() {
        return isian;
    }
}
