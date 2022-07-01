package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Open {

    public static void openPdf() {
        File file = new File(Const.PATH_PDF);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
        }
    }
}
