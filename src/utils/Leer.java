package utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Leer {

    public static String leerPuntaje() throws IOException {
        File file = new File(Const.PATH_SCORE);

        if (!file.exists()) {
            file.createNewFile();
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%12s %12s %12s %12s \n", "NOMBRE", "PUNTAJE", "ATAQUES", "ERRORES"));
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] params = sc.nextLine().split(",");
                sb.append(String.format("%12s %12s %12s %12s\n", params[0], params[1], params[2], params[3]));
            }
        }
        
        return sb.toString();
    }
}
