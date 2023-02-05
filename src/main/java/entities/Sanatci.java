package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Sanatci {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Integer dogumYili;
    private Integer olumYili;

    @OneToMany (mappedBy = "sanatci", cascade = CascadeType.ALL)
    private List<Eser> esers;

    public Sanatci(String name, Integer dogumYili, Integer olumYili, List<Eser> esers) {
        this.name = name;
        this.dogumYili = dogumYili;
        this.olumYili = olumYili;
        this.esers = esers;
    }

    public Sanatci(String name, Integer dogumYili, List<Eser> esers) {
        this.name = name;
        this.dogumYili = dogumYili;
        this.esers = esers;
    }

    public Sanatci(String name, Integer dogumYili, Integer olumYili) {
        this.name = name;
        this.dogumYili = dogumYili;
        this.olumYili = olumYili;
    }

    public Sanatci(String name, Integer dogumYili) {
        this.name = name;
        this.dogumYili = dogumYili;
    }
}
