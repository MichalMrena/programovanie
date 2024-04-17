package org.edupage.ssosza;

/**
 * ....
 */
public class ObecDataException extends Exception {
    public ObecDataException(int cisloRiadku, int cisloStlpca) {
        super(String.format(
                "Chyba data na riadku %d v stlpci %d.",
                cisloRiadku,
                cisloStlpca
        ));
    }
}
