package apptablet.sacooliveros.edu.pe.bdatossemana;

public class Model {

    private String codigo;
    private String asignatura;
    private boolean habilitar;
    private String capitulo;
    private String urlpdf;
    private String ssdpdf;
    private int imgphoto;

    public Model(String codigo, String asignatura, boolean habilitar, String capitulo, String urlpdf, String ssdpdf, int imgphoto) {
        this.codigo = codigo;
        this.asignatura = asignatura;
        this.habilitar = habilitar;
        this.capitulo = capitulo;
        this.urlpdf = urlpdf;
        this.ssdpdf = ssdpdf;
        this.imgphoto = imgphoto;
    }

    public Model(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public boolean isHabilitar() {
        return habilitar;
    }

    public void setHabilitar(boolean habilitar) {
        this.habilitar = habilitar;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getUrlpdf() {
        return urlpdf;
    }

    public void setUrlpdf(String urlpdf) {
        this.urlpdf = urlpdf;
    }

    public String getSsdpdf() {
        return ssdpdf;
    }

    public void setSsdpdf(String ssdpdf) {
        this.ssdpdf = ssdpdf;
    }

    public int getImgphoto() {
        return imgphoto;
    }

    public void setImgphoto(int imgphoto) {
        this.imgphoto = imgphoto;
    }
}
