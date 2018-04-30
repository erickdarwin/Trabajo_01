package edqs.pe.edu.upeu.proyecto01.to;

/**
 * Created by erick on 29/04/2018.
 */

public class AsistenciaTO {
    int idAsistencia;
    int idEvento;
    int idUsuario;
    String codigo;
    String nombres;
    String companhia;
    String fechahora;
    String ofline;

    String nombreusuario;
    String nombreevento;

    public AsistenciaTO() {

    }

    public AsistenciaTO(int idAsistencia, int idEvento, int idUsuario, String codigo, String nombres, String companhia, String fechahora, String ofline, String nombreusuario, String nombreevento) {
        this.idAsistencia = idAsistencia;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
        this.codigo = codigo;
        this.nombres = nombres;
        this.companhia = companhia;
        this.fechahora = fechahora;
        this.ofline = ofline;
        this.nombreusuario = nombreusuario;
        this.nombreevento = nombreevento;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getOfline() {
        return ofline;
    }

    public void setOfline(String ofline) {
        this.ofline = ofline;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getNombreevento() {
        return nombreevento;
    }

    public void setNombreevento(String nombreevento) {
        this.nombreevento = nombreevento;
    }
}
