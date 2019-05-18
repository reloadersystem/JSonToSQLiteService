package apptablet.sacooliveros.edu.pe.bdatossemana.DataBaseHelper;

public class Utilidades {

    public static String TABLA_VIDEOSEMINARIO="videoseminario";
    public static String CAMPO_CODIGO="codigo";
    public static String CAMPO_ASIGNATURA="asignatura";
    public static String CAMPO_HABILITAR="habilitar";
    public static String CAMPO_CAPITULO="capitulo";
    public static String CAMPO_URLPDF="urlpdf";
    public static String CAMPO_SSDPDF="ssdpdf";
    public static String CAMPO_TOMOPDF="tomopdf";
    public static String CAMPO_GRADOPDF="gradopdf";


    public static final String CREAR_TABLA_VIDEOSEMINARIO = "CREATE TABLE " + TABLA_VIDEOSEMINARIO + "("+CAMPO_CODIGO+" TEXT, "+CAMPO_ASIGNATURA+" TEXT, "+CAMPO_HABILITAR+" TEXT, "+CAMPO_CAPITULO+" TEXT, "+CAMPO_URLPDF+" TEXT, "+CAMPO_SSDPDF+" TEXT, "+CAMPO_TOMOPDF+" TEXT, "+CAMPO_GRADOPDF+" TEXT)";

}
