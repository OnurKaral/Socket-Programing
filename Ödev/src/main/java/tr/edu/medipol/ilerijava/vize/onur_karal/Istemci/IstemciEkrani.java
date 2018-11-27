package main.java.tr.edu.medipol.ilerijava.vize.onur_karal.Istemci;
import main.java.tr.edu.medipol.ilerijava.vize.onur_karal.Sunucu.SunucuEkrani;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class IstemciEkrani extends SunucuEkrani   {

    private  JTextField SayiAlani;
    private  JTextField SayiAlani2;
    private final JButton SayiGöndericiButonu2;
    private final JComboBox işlemler;

    public IstemciEkrani(String title) {
        super(title);
        super.setSize(750,500);

        //SAYI
        JPanel sayigönderimpaneli = new JPanel();
        SayiAlani = new JTextField(10);
        sayigönderimpaneli.add(SayiAlani);
        add(sayigönderimpaneli);

        //Choice
        JPanel işlempaneli = new JPanel();
        işlemler = new JComboBox();
        işlemler.addItem("Toplama '+' ");
        işlemler.addItem("Çıkarma '-' ");
        işlemler.addItem("Çarpma '*' ");
        işlemler.addItem("Bölme '/' ");
        add(işlempaneli);
        işlempaneli.add(işlemler);

        //SAYI
        JPanel SayiGönderimPaneli2 = new JPanel();
        SayiAlani2 = new JTextField(10);
        SayiGönderimPaneli2.add(SayiAlani2);
        SayiGöndericiButonu2 = new JButton("Gönder");
        SayiGönderimPaneli2.add(SayiGöndericiButonu2);

        //İşlemler
        SayiGöndericiButonu2.addActionListener(event -> {
            int sayialani1 = Integer.valueOf(this.SayiAlani.getText());
            int sayialani2 = Integer.valueOf(this.SayiAlani2.getText());
            int sonuc;

            if(işlemler.getSelectedItem().equals("Toplama '+' ")){
               sonuc= Integer.valueOf(sayialani1 + sayialani2);
               getMesajKuyruğu().offer(String.valueOf(sonuc));
            }else if(işlemler.getSelectedItem().equals("Çıkarma '-' ")){
                sonuc= Integer.valueOf(sayialani1 - sayialani2);
                getMesajKuyruğu().offer(String.valueOf(sonuc));
            }else if(işlemler.getSelectedItem().equals("Çarpma '*' ")){
                sonuc= Integer.valueOf(sayialani1 * sayialani2);
                getMesajKuyruğu().offer(String.valueOf(sonuc));
            }else if (işlemler.getSelectedItem().equals("Bölme '/' ")){
                sonuc= Integer.valueOf(sayialani1 / sayialani2);
                getMesajKuyruğu().offer(String.valueOf(sonuc));
            }

            SayiAlani2.setText("");
            SayiAlani.setText("");
        });
        add(SayiGönderimPaneli2);
    }
}

