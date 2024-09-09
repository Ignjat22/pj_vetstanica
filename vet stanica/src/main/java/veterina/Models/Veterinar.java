package veterina.Models;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "veterinar")
public class Veterinar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Ime")
    private String ime;

    @Column(name = "Specijalnost")
    private String specijalnost;

    @Column(name = "Prezime", nullable = false)
    private String prezime;

    @OneToMany(mappedBy = "veterinar")
    private List<Pacijent> pacijenti;

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    // Getteri i setteri
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        this.specijalnost = specijalnost;
    }

    /*public List<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void setPacijenti(List<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

     */

    @Override
    public String toString() {
        return "Veterinar{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", specijalnost='" + specijalnost + '\'' +
                '}';
    }
}
