package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Muze {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isim;
    private String sehir;
    private String acilisSaati;
    private String kapanisSaati;

    @OneToMany (mappedBy = "muze",cascade = CascadeType.ALL)
    private List<Sergi> sergis;

    public Muze(String isim, String sehir, String acilisSaati, String kapanisSaati, List<Sergi> sergis) {
        this.isim = isim;
        this.sehir = sehir;
        this.acilisSaati = acilisSaati;
        this.kapanisSaati = kapanisSaati;
        this.sergis = sergis;
    }

    public Muze(String isim, String sehir, String acilisSaati, String kapanisSaati) {
        this.isim = isim;
        this.sehir = sehir;
        this.acilisSaati = acilisSaati;
        this.kapanisSaati = kapanisSaati;
    }
}
