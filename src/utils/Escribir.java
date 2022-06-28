package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.player.Player;

public class Escribir {
    
    public static final String SEPARADOR = System.getProperty("file.separator");
    public static final String RUTA_PUNTAJE = System.getProperty("user.dir") + SEPARADOR + "src" + SEPARADOR + "data" + SEPARADOR;
    
    public static void escribirPuntaje(Player jugador) throws IOException {
        File file = new File(RUTA_PUNTAJE + "puntaje.txt");
        
        if(!file.exists()) {
            file.createNewFile();
        }
        
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(jugador.getFormatoPuntaje() + "\n");
    }
}
