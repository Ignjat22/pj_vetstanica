package veterina.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tretman")
public class Tretman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "opis")
    private String opis;

    @Column(name = "cena")
    private Double cena;

    @Column(name = "trajanje")
    private String trajanje;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    @Override
    public String toString() {
        return "Tretman{" +
                "id=" + id +
                ", opis='" + opis + '\'' +
                ", cena=" + cena +
                ", trajanje='" + trajanje + '\'' +
                '}';
    }
}