package org.edupage.ssosza;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ISpravcaObci spravcaObci = new SpravcaObci();
        HlavneOkno okno = new HlavneOkno(spravcaObci);

        SwingUtilities.invokeLater(okno::zobraz);
    }
}