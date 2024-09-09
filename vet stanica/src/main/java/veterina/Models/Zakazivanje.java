package veterina.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "zakazivanje")
public class Zakazivanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "datum")
    private LocalDateTime datum;

    @Column(name = "pacijent_ime")
    private String pacijentIme;

    @Column(name = "veterinar_ime")
    private String veterinarIme;

    @Column(name = "vrsta_tretmana")
    private String vrstaTretmana;

    // Default konstruktor
    public Zakazivanje() {}

    // Konstruktor sa parametrima
    public Zakazivanje(Long id, LocalDateTime datum, String pacijentIme, String veterinarIme, String vrstaTretmana) {
        this.id = id;
        this.datum = datum;
        this.pacijentIme = pacijentIme;
        this.veterinarIme = veterinarIme;
        this.vrstaTretmana = vrstaTretmana;
    }

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getPacijentIme() {
        return pacijentIme;
    }

    public void setPacijentIme(String pacijentIme) {
        this.pacijentIme = pacijentIme;
    }

    public String getVeterinarIme() {
        return veterinarIme;
    }

    public void setVeterinarIme(String veterinarIme) {
        this.veterinarIme = veterinarIme;
    }

    public String getVrstaTretmana() {
        return vrstaTretmana;
    }

    public void setVrstaTretmana(String vrstaTretmana) {
        this.vrstaTretmana = vrstaTretmana;
    }

    @Override
    public String toString() {
        return "Zakazivanje{" +
                "id=" + id +
                ", datum=" + datum +
                ", pacijentIme='" + pacijentIme + '\'' +
                ", veterinarIme='" + veterinarIme + '\'' +
                ", vrstaTretmana='" + vrstaTretmana + '\'' +
                '}';
    }
}
/*
{
        "datum": "2024-09-05T10:30:00",
        "pacijentIme": "Milos",
        "veterinarIme": "Dr. Jovan",
        "vrstaTretmana": "Vakcinacija"
        }


 */