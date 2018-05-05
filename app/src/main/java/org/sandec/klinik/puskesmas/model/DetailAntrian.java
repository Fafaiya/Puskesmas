package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wakhyudi on 03/05/18.
 */

public class DetailAntrian {
    @SerializedName("nomor_antrian")
    String idAntrian;

    @SerializedName("nama_layanan")
    String namaPoli;

    String ruang;

    @SerializedName("sub_desc")
    String subDesc;

    @SerializedName("total_antri")
    String totalAntri;

    @SerializedName("estimasi_waktu")
    String estimasiWaktu;

    @SerializedName("info_ticket")
    String infoTicket;

    public String getIdAntrian() {
        return idAntrian;
    }

    public String getNamaPoli() {
        return namaPoli;
    }

    public String getRuang() {
        return ruang;
    }

    public String getSubDesc() {
        return subDesc;
    }

    public String getTotalAntri() {
        return totalAntri;
    }

    public String getEstimasiWaktu() {
        return estimasiWaktu;
    }

    public String getInfoTicket() {
        return infoTicket;
    }
}

