/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.DaftarMenu;
import classes.Ramen;
import classes.Kuah;
import classes.Toping;
import classes.Minuman;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class MainAplikasikasir {
    public static void main(String[] args){
    //inisialisasi kelas Scanner untuk mengambil
    //input dari keyboard
  
    Scanner input = new Scanner (System.in);
    
    MainAplikasikasir app = new MainAplikasikasir();
    //tampilkan daftar menu
     app.generateDaftarMenu();
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

   
}
