package veterina.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pacijent")
public class Pacijent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PacijentID")
    private Long id;

    @Column(name = "Ime")
    private String ime;

    @Column(name = "Vrsta")
    private String vrsta;

    @Column(name = "Rasa")
    private String rasa;

    @Column(name = "godinaRodjenja")
    private Date godinaRodjenja;

    @Column(name = "ImeVlasnika")
    private String imeVlasnika;

    @Column(name = "KontaktVlasnika")
    private String kontaktVlasnika;

    @ManyToOne
    @JoinColumn(name = "VeterinarID")
    private Veterinar veterinar;

    @Transient // Ova anotacija označava da ovo polje ne bi trebalo da bude mapirano u bazu podataka
    private Integer veterinarId; // Koristi ovo za deserializaciju ID-a

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public Date getgodinaRodjenja() {
        return godinaRodjenja;
    }

    public void setGodinaRodjenja(Date godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }

    public String getImeVlasnika() {
        return imeVlasnika;
    }

    public void setImeVlasnika(String imeVlasnika) {
        this.imeVlasnika = imeVlasnika;
    }

    public String getKontaktVlasnika() {
        return kontaktVlasnika;
    }

    public void setKontaktVlasnika(String kontaktVlasnika) {
        this.kontaktVlasnika = kontaktVlasnika;
    }

    public Veterinar getVeterinar() {
        return veterinar;
    }

    public void setVeterinar(Veterinar veterinar) {
        this.veterinar = veterinar;
    }

    public Integer getVeterinarId() {
        return veterinarId;
    }

    public void setVeterinarId(Integer veterinarId) {
        this.veterinarId = veterinarId;
        // Ako je veterinarId postavljen, poveži sa Veterinar entitetom
        if (veterinarId != null) {
            this.veterinar = new Veterinar();
            this.veterinar.setId(veterinarId);
        } else {
            this.veterinar = null;
        }
    }

    @Override
    public String toString() {
        return "Pacijent{" +
                "id=" + id +
                ", vrsta='" + vrsta + '\'' +
                ", rasa='" + rasa + '\'' +
                ", ime='" + ime + '\'' +
                ", godinaRodjenja=" + godinaRodjenja +
                ", imeVlasnika='" + imeVlasnika + '\'' +
                ", kontaktVlasnika='" + kontaktVlasnika + '\'' +
                ", veterinar=" + (veterinar != null ? veterinar.toString() : "null") +
                '}';
    }
}
