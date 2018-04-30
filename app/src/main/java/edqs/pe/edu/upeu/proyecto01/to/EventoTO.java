package edqs.pe.edu.upeu.proyecto01.to;

/**
 * Created by erick on 29/04/2018.
 */

public class EventoTO {
    Integer idEvento;
    String fecha;
    String horainicio;
    String horafin;
    String nombreevento;
    String lugarevento;
    String tiempotolerancia;
    String estado;

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public String getNombreevento() {
        return nombreevento;
    }

    public void setNombreevento(String nombreevento) {
        this.nombreevento = nombreevento;
    }

    public String getLugarevento() {
        return lugarevento;
    }

    public void setLugarevento(String lugarevento) {
        this.lugarevento = lugarevento;
    }

    public String getTiempotolerancia() {
        return tiempotolerancia;
    }

    public void setTiempotolerancia(String tiempotolerancia) {
        this.tiempotolerancia = tiempotolerancia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

