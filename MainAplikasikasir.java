/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.DaftarMenu;
import classes.Ramen;
import classes.Kuah;
import classes.Menu;
import classes.Toping;
import classes.Minuman;
import classes.Pesanan;
import classes.Transaksi;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class MainAplikasikasir {
    
    public DaftarMenu daftarMenu;
    //Tambahkan
    public static double PAJAK_PPN =0.10;
    public static double BIAYA_SERVICE =0.05;
    //End Of Tambahkan
   
    
    public static void main(String[] args){
    //inisialisasi kelas Scanner untuk mengambil
    //input dari keyboard
  
    Scanner input = new Scanner (System.in);
    //Tambahkan
    String no_transaksi, nama_pemesan, tanggal, no_meja ="";
    String transaksi_lagi ="", pesan_lagi ="", keterangan ="", makan_ditempat;
    int jumlah_pesanan, no_menu;
    //End Of Tambahkan
    MainAplikasikasir app = new MainAplikasikasir();
    //tampilkan daftar menu
     app.generateDaftarMenu();
     //mulai transaksi
     System.out.println("======== TRANSAKSI ========");
     do{
     //ambil data transaksi
     System.out.println("No Transaksi");
     no_transaksi = input.next();
     System.out.println("pemesan :");
     nama_pemesan = input.next();
     System.out.println("Tanggal : [dd-mm-yyyy]");
     tanggal = input.next();
     System.out.println("Makan ditempat? [Y/N]");
     makan_ditempat = input.next();
     
     if (makan_ditempat.equalsIgnoreCase("Y")){
         System.out.println("Nomor Meja :");
         no_meja = input.next();
      
     }
     //buat transaksi baru
     Transaksi trans = new Transaksi(no_transaksi, nama_pemesan, tanggal, no_meja);
     System.out.println("======== PESANAN ========");
     int no_kuah;
     do {
         //ambil menu berdasarkan no urut yang dipilih
         Menu menu_yang_dipilih = app.daftarMenu.pilihMenu();
         
         jumlah_pesanan = (int) app.cekInputNumber("Jumlah : ");
         
         Pesanan pesanan = new Pesanan(menu_yang_dipilih, jumlah_pesanan);
         trans.tambahpesanan(pesanan);
         
         //khusus untuk menu ramen, pesanan kuahnya langsung diinput juga
         if (menu_yang_dipilih.getKategori().equals("Ramen")){
             //looping sesuai jumlah pesanan ramen
             int jumlah_ramen = jumlah_pesanan;
                     
          do{
              //ambil objek menu berdasarkan nomor yang dipilih
              Menu kuah_yang_dipilih = app.daftarMenu.pilihMenu();
              
              System.out.println("Level : [0-5] : ");
              String level = input.next();
              
              
              //validasi jumlah kuah tidak boleh lebih besar dari jumlah_ramen
              int jumlah_kuah = 0;
              do{
                  jumlah_kuah = (int) app.cekInputNumber("Jumlah :");
                  
                  if (jumlah_kuah > jumlah_ramen){
                      System.out.println("[Err] Jumlah kuah melebihi jumlah ramen yang sudah dipesan");
                  }else {
                      break;
                  }
              }while(jumlah_kuah > jumlah_ramen);
              
              //set pesanan kuah
              Pesanan pesanan_kuah = new Pesanan();
              pesanan_kuah.setKeterangan("Level" + level);
              
              //tambahkan pesanan kuah ke transaksi
              trans.tambahpesanan(pesanan_kuah);
              
              //hitung jumlah ramen yang belum dipesan kuah nya
              jumlah_ramen -= jumlah_kuah;
              
          }while(jumlah_ramen > 0);           
         }else{
             //jika keterangan tidak diisi tulis -
             System.out.println("Keterangan [- jika kosong]:");
             keterangan = input.next();
         }
         //cek jika keterangan diisi selain "-" set ke pesanan
         if (!keterangan.equals('-')){
             pesanan.setKeterangan(keterangan);
            
         }
         //konfirmasi, mau tambah pesanan atau tidak
         System.out.println("Tambah Pesanan lagi? [Y/N] :[");
         pesan_lagi = input.next();
         
         
     }while(pesan_lagi.equalsIgnoreCase("Y") || pesan_lagi.equalsIgnoreCase("y"));
     //cetak Struk
     trans.cetakstruk();
     
     //hitung total harga
     double total_pesan = trans.hitungTotalPesanan();
        System.out.println("===================");
        System.out.println("Total : \t\t" + total_pesan);
    
    //hitung pajak
    //jika makan ditempat, biaya pajak = 10% ppn + 5% service
    trans.setPajak(PAJAK_PPN);
    double ppn = trans.hitungPajak();
    System.out.println("Pajak 10% : \t\t + ppn");
    
    double biaya_service =0;
    if(makan_ditempat.equalsIgnoreCase("Y")){
        trans.setBiayaService(BIAYA_SERVICE);
        biaya_service = trans.hitungBiayaService();
        System.out.println("Biaya Service 5% : \t + biaya_service");
        
    }
    //tampilkan total bayar
    System.out.println("Total : \t\t"+ trans.hitungTotalBayar(ppn, biaya_service));
    
    //cek uang bayar, apakah > total bayar atau tidak
    double kembalaian = 0;
        int kembalian = 0;
    do{
    //ambil input uang bayar
    double uang_bayar = app.cekInputNumber("Uang Bayar : \t\t");
    
         int Kembalian = trans.hitungKembalian(uang_bayar);
    if (Kembalian <0){
        System.out.println("[Err] Uang anda kurang");
        
    }else{
        System.out.println("Kembalian : \t\t " + kembalian);
        break;
        }
    }while(kembalian <0);
        System.out.println("Lakukan Transaksi Lagi?");
        transaksi_lagi = input.next();
    }while (transaksi_lagi.equalsIgnoreCase("Y"));
     System.out.println("====== TERIMA KASIH ======");
     
   }

    public void generateDaftarMenu() {
        
     DaftarMenu daftarMenu = new DaftarMenu();
     daftarMenu.tambahMenu(new Ramen("Ramen Seafood", 25000));
     daftarMenu.tambahMenu(new Ramen("Ramen Original", 18000));
     daftarMenu.tambahMenu(new Ramen("Ramen Vegetarian ", 22000));
     daftarMenu.tambahMenu(new Ramen("Ramen Karnivor", 28000));
     daftarMenu.tambahMenu(new Kuah("Kuah Orisinil")); 
     daftarMenu.tambahMenu(new Kuah("Kuah Internasional")); 
     daftarMenu.tambahMenu(new Kuah("Kuah Spicy Lada" ));
     daftarMenu.tambahMenu(new Kuah("Kuah Soto Padang")); 
     daftarMenu.tambahMenu(new Toping("Crab Stick Bakar", 6000)); 
     daftarMenu.tambahMenu(new Toping("Chicken Katsu", 8000));
     daftarMenu.tambahMenu(new Toping("Gyoza Goreng", 4000));
     daftarMenu.tambahMenu(new Toping("Bkaso Goreng", 7000));
     daftarMenu.tambahMenu(new Toping("Enoki Goreng", 5000)); 
     daftarMenu.tambahMenu(new Minuman("Jus Alpukat SPC", 10000)); 
     daftarMenu.tambahMenu(new Minuman("Jus Stroberi", 11000));
     daftarMenu.tambahMenu(new Minuman("Capucino Coffee", 15000));
     daftarMenu.tambahMenu(new Minuman("Vietnam Dripp", 14000));         
     
         daftarMenu.tampilDatfarMenu();
         
    }
    public double cekInputNumber(String label){
        try{
            Scanner get_input = new Scanner(System.in);
            System.out.println(label);
            
            double nilai = get_input.nextDouble();
            
            return nilai;
        }catch(InputMismatchException ex){
            System.out.println("[Err] Harap masukkan angka");
            return cekInputNumber(label);
            
        }
    }

    
}

/* CHALLENGE
1. validasi jumlah pesanan jika 0
2. validasi level jika ada yang input selain 1-5
3. validasi tanggal
4. tampilkan level di struk
*/
