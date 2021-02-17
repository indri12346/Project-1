/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author ASUS
 */
import java.until.ArrayList;

public class Transaksi {
    private String noTransaksi;
    private String namapesanan;
    private String tanggal;
    private String noMeja;
    private ArrayList<pesanan> pesanan;
    private double uangBayar;
    private double pajak;
    private double totalBayar;
    
    public Transaksi(String no_transaksi, String nm_pemesan, String tanggal, String no_meja) {}
    public void tambahpesanan(pesanan pesanan){}
    public pesanan getpesanan(){return null;}
    public ArrayList<pesanan> getsemuapesanan (){return null;}
    public double hitungTotalBayar(){return 0;}
    public double hitungKembalian(){return 0;}
    public void cetakstruk(){}
    
    
    
    
}
