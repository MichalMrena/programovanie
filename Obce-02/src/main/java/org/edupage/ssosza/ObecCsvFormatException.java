package org.edupage.ssosza;

/**
 * TODO
 */
public class ObecCsvFormatException extends Exception {
    public ObecCsvFormatException(int cisloRiadku, int cisloStlpca, String problematickeCislo) {
        super(String.format(
                "Chyba v datach na riadku %d v stlpci %d pri parsovani cisla %s",
                cisloRiadku,
                cisloStlpca,
                problematickeCislo
        ));
    }
}
