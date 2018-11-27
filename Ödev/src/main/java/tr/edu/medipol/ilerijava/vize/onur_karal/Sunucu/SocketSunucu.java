package main.java.tr.edu.medipol.ilerijava.vize.onur_karal.Sunucu;
import main.java.tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.EkranSinifi;
import main.java.tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketOkuyucu;
import main.java.tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketYazici;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketSunucu {
    public static final int SERVER_PORT = 2885;
    public static void main(String[] args) {
        EkranSinifi SunucuEkrani = new SunucuEkrani("Sunucu Ekranı");
        SunucuEkrani.setVisible(true);

        try{
            ServerSocket SunucuSoketi = new ServerSocket(SERVER_PORT);
            System.out.println("İstemciler bekleniyor.." +
                    SunucuSoketi.getLocalPort());

            BroadcasterThread YayıncıThread = new BroadcasterThread(SunucuEkrani);
            YayıncıThread.start();

            while(true){
            //Istemci bağlantısı gelene kadar bekleme komutu..
            Socket IstemciBaglantisi = SunucuSoketi.accept();
            String ip = IstemciBaglantisi.getInetAddress().toString();
            System.out.println("İstemci bağlandı: " + ip);
            YayıncıThread.SocketEkle(ip, IstemciBaglantisi);


                SocketOkuyucu t1 = new SocketOkuyucu(IstemciBaglantisi, true,SunucuEkrani);
                t1.start();
            }
        }catch (IOException e ) {
            System.out.println(SERVER_PORT +
                    "Sunucu soketi açarken hata oluştu.");
            e.printStackTrace();
        }
    }
}