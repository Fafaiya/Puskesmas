package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wakhyudi on 27/12/17.
 */

public class DaftarHistory {
    @SerializedName("nama_layanan")
    String namaPoli;
    @SerializedName("status_proses")
    String status;
    String tanggal;
    @SerializedName("nomor_antrian")
    String noAntrian;
    @SerializedName("icon")
    String linkIcon;

    public DaftarHistory(String namaPoli, String status, String tanggal, String noAntrian, String linkIcon) {
        this.namaPoli = namaPoli;
        this.status = status;
        this.tanggal = tanggal;
        this.noAntrian = noAntrian;
        this.linkIcon = linkIcon;
    }

    public String getNamaPoli() {
        return namaPoli;
    }

    public String getStatus() {
        return status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getNoAntrian() {
        return noAntrian;
    }

    public String getLinkIcon() {
        return linkIcon;
    }
}
