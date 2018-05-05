package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wakhyudi on 24/12/17.
 */

public class History {
    private String token;
    private String nik;
    @SerializedName("jenis_layanan")
    private  String jenisLayanan;
    private String tanggal;
    @SerializedName("no_antrian")
    private String noAntrian;
    private String poli;
    private String status;

    public History() {

    }

    public History(String token, String nik, String jenisLayanan, String tanggal, String noAntrian, String poli, String status) {
        this.token = token;
        this.nik = nik;
        this.jenisLayanan = jenisLayanan;
        this.tanggal = tanggal;
        this.noAntrian = noAntrian;
        this.poli = poli;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public String getNik() {
        return nik;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getNoAntrian() {
        return noAntrian;
    }

    public String getPoli() {
        return poli;
    }

    public String getStatus() {
        return status;
    }
}
