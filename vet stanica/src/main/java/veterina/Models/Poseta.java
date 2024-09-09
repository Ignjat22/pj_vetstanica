package veterina.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "poseta")
public class Poseta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "datum")
    private Date datum;

    @ManyToOne
    @JoinColumn(name = "veterinar_id")
    private Veterinar veterinar;

    @ManyToOne
    @JoinColumn(name = "pacijent_id")
    private Pacijent pacijent;

    @Column(name = "usluge_pruzene")
    private String uslugePruzene;

    @Column(name = "beleške")
    private String beleške;

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Veterinar getVeterinar() {
        return veterinar;
    }

    public void setVeterinar(Veterinar veterinar) {
        this.veterinar = veterinar;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public String getUslugePruzene() {
        return uslugePruzene;
    }

    public void setUslugePruzene(String uslugePruzene) {
        this.uslugePruzene = uslugePruzene;
    }

    public String getBeleške() {
        return beleške;
    }

    public void setBeleške(String beleške) {
        this.beleške = beleške;
    }

    @Override
    public String toString() {
        return "Poseta{" +
                "id=" + id +
                ", datum=" + datum +
                ", veterinar=" + veterinar +
                ", pacijent=" + pacijent +
                ", uslugePruzene='" + uslugePruzene + '\'' +
                ", beleške='" + beleške + '\'' +
                '}';
    }
}
