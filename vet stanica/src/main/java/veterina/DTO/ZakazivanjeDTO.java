package veterina.DTO;

import java.time.LocalDateTime;

public class ZakazivanjeDTO {
    private Long id;
    private LocalDateTime datum;
    private String pacijentIme;
    private String veterinarIme;
    private String vrstaTretmana;

    // Default konstruktor
    public ZakazivanjeDTO() {
    }

    // Konstruktor sa parametrima
    public ZakazivanjeDTO(Long id, LocalDateTime datum, String pacijentIme, String veterinarIme, String vrstaTretmana) {
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
}
