package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Write {

    public static void writeLineScore(String line) {
        try {
            PrintWriter printWriter;
            try (FileWriter fw = new FileWriter(Const.PATH_SCORE, true)) {
                printWriter = new PrintWriter(fw);
                printWriter.write(line);
            }
            printWriter.close();
        } catch (IOException e) {
        }
    }
}
//--\\>>||