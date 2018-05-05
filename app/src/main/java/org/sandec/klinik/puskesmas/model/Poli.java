package org.sandec.klinik.puskesmas.model;

/**
 * Created by wakhyudi on 29/11/17.
 */

public class Poli {
    private int gambarPoli;
    private String namaPoli;

    public Poli(int gambarPoli, String namaPoli) {
        this.gambarPoli = gambarPoli;
        this.namaPoli = namaPoli;
    }

    public int getGambarPoli() {
        return gambarPoli;
    }

    public String getNamaPoli() {
        return namaPoli;
    }
}
