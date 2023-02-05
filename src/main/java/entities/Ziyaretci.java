package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Ziyaretci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer yas;
    private Integer telefonNumarasi;

    @ManyToOne (cascade = CascadeType.ALL)
    private Sergi sergi;

    public Ziyaretci(String name, Integer yas, Integer telefonNumarasi, Sergi sergi) {
        this.name = name;
        this.yas = yas;
        this.telefonNumarasi = telefonNumarasi;
        this.sergi = sergi;
    }

    public Ziyaretci(String name, Integer yas, Integer telefonNumarasi) {
        this.name = name;
        this.yas = yas;
        this.telefonNumarasi = telefonNumarasi;
    }
}
