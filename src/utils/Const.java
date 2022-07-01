package utils;

public class Const {
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final String PATH_USER = System.getProperty("user.dir");
    
    public static final String PATH_SCORE = String.format("%s%s%s%s%s%s%s", PATH_USER, FILE_SEPARATOR, "src", FILE_SEPARATOR, "data", FILE_SEPARATOR, "puntaje.txt");
    public static final String PATH_PDF = String.format("%s%s%s%s%s%s%s", PATH_USER, FILE_SEPARATOR, "src", FILE_SEPARATOR, "data", FILE_SEPARATOR, "help.pdf");
}
//--\\>>||