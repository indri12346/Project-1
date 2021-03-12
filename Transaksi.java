 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */


public class Transaksi {
    private String noTransaksi;
    private String namaPesanan;
    private String tanggal;
    private String noMeja;
    private ArrayList<Pesanan> pesanan;
    private double uangBayar;
    private double pajak;
    private double totalBayar;
    
    //tambah
    private double biayaService=0;
    
    
    public Transaksi(String no_transaksi, String nm_pemesan, String tanggal, String no_meja) {
       this.noTransaksi = no_transaksi;
       this.namaPesanan = nm_pemesan;
       this.tanggal = tanggal;
       this.noMeja = no_meja;
       
       pesanan =new ArrayList<>();
       
    }
    public void tambahpesanan(Pesanan pesanan){
        this.pesanan.add(pesanan);
    }
    
    //hilangkan dari stuktur kelas
    // public Pesanan getPesanan()
//    public Pesanan getpesanan(){return null;}
    public ArrayList<Pesanan> getsemuapesanan (){return pesanan;}
    public double hitungTotalBayar(){return 0;}
    public double hitungKembalian(){return 0;}
    public void cetakstruk(){}

    public double hitungTotalPesanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPajak(double PAJAK_PPN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double hitungPajak() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBiayaService(double BIAYA_SERVICE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double hitungBiayaService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String hitungTotalBayar(double ppn, double biaya_service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int hitungKembalian(double uang_bayar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

  

  
    
    
    
    
}
