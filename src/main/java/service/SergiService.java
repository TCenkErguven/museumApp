package service;

import entities.*;
import repository.SergiDao;

import java.util.Arrays;
import java.util.List;

public class SergiService {
    private SergiDao sergiDao = new SergiDao();

    public void save(){
        try {
            Muze muze = new Muze("Sabancı Müzesi", "İstanbul", "10:00", "20:00");
            Sanatci sanatci = new Sanatci("Pablo Ruiz Picasso", 1881, 1973);
            Eser eser1 = new Eser("Eski Gitarist", 1904, sanatci);
            Eser eser2 = new Eser("GuerNica", 1937, sanatci);
            Sanatci canliSanatci = new Sanatci("Ben daha ölmedim", 1969);
            Eser eser3 = new Eser("O daha ölmedi", 1987, canliSanatci);
            Ziyaretci ziyaretci = new Ziyaretci("A kişisi", 34, 2125954832);
            Sergi sergi = new Sergi("Ortaya Karışık", "02.05.2023", "25.08.2023", "karışık sanat akımları", muze, Arrays.asList(eser1, eser2, eser3)
                    , Arrays.asList(ziyaretci));
            sergiDao.save(sergi);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void getAll(){
        try {
            List<Sergi> sergiList = sergiDao.getAll();

            for(Sergi i : sergiList){
                Integer sergiId = i.getId();
                String sergiName = i.getName();
                String sergiBaslangicTarihi = i.getBaslangicTarihi();
                String sergiBitisTarihi = i.getBitisTarihi();
                String konusu = i.getKonusu();
                String muzeAdi = i.getMuze().getIsim();
                List<Eser> esers = i.getEsers();
                List<Ziyaretci> ziyaretcis = i.getZiyaretcis();
                System.out.println("Sergi Id: " + sergiId + ", Sergi Adı: " + sergiName + "" +
                                    "\nSergi Başlangıç Tarihi: " + sergiBaslangicTarihi + " Sergi Bitiş Tarihi: " + sergiBitisTarihi +
                                    "\nKonusu: " + konusu + " Müze Adı : " + muzeAdi);
                for(Eser eser : esers){
                    System.out.print("Eser:" + eser.getName() );
                }
                System.out.println("\nZiyaretçiler: ");
                for(Ziyaretci ziyaretci : ziyaretcis){
                    System.out.println(ziyaretci.getName() + " ");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void update(Sergi sergi){
        try{
            sergiDao.update(sergi);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void delete(Integer id){
        try{
            sergiDao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
