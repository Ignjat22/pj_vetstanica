package veterina.DTO;

import java.time.LocalDateTime;

public class PosetaDTO {  private Long id;
    private Long posetaID;
    private LocalDateTime vreme;
    private String dodatno;

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppointmentId() {
        return posetaID;
    }

    public void setAppointmentId(Long posetaID) {
        this.posetaID = posetaID;
    }

    public LocalDateTime getVisitTime() {
        return vreme;
    }

    public void setVisitTime(LocalDateTime vreme) {
        this.vreme = vreme;
    }

    public String getNotes() {
        return dodatno;
    }

    public void setNotes(String dodatno) {
        this.dodatno = dodatno;
    }

}
