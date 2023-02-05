package entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Eser {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer yapimYili;

    @OneToOne (cascade = CascadeType.ALL)
    private Sanatci sanatci;

    @ManyToOne (cascade = CascadeType.ALL)
    private Sergi sergi;

    public Eser(String name, Integer yapimYili, Sanatci sanatci, Sergi sergi) {
        this.name = name;
        this.yapimYili = yapimYili;
        this.sanatci = sanatci;
        this.sergi = sergi;
    }

    public Eser(String name, Integer yapimYili, Sanatci sanatci) {
        this.name = name;
        this.yapimYili = yapimYili;
        this.sanatci = sanatci;
    }
}
