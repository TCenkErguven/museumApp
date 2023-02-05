package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Sergi {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String baslangicTarihi;
    private String bitisTarihi;
    private String konusu;

    @OneToOne (cascade = CascadeType.ALL)
    private Muze muze;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Eser> esers;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Ziyaretci> ziyaretcis;

    public Sergi(String name, String baslangicTarihi, String bitisTarihi, String konusu, Muze muze, List<Eser> esers, List<Ziyaretci> ziyaretcis) {
        this.name = name;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.konusu = konusu;
        this.muze = muze;
        this.esers = esers;
        this.ziyaretcis = ziyaretcis;
    }

    public Sergi(Integer id, String name, String baslangicTarihi, String bitisTarihi, String konusu, Muze muze, List<Eser> esers, List<Ziyaretci> ziyaretcis) {
        this.id = id;
        this.name = name;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.konusu = konusu;
        this.muze = muze;
        this.esers = esers;
        this.ziyaretcis = ziyaretcis;
    }
}
