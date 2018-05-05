package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wakhyudi on 18/12/17.
 */

public class Antrian {
    @SerializedName("jumlah_antrian")
    String jumlahAntrian;
    @SerializedName("antrian_akhir")
    String antrianTerakhir;
    @SerializedName("range_tanggal")
    String rangeTanggal;
    String judul1;
    String judul2;

    public Antrian() {
    }

    public String getJumlahAntrian() {
        return jumlahAntrian;
    }

    public String getAntrianTerakhir() {
        return antrianTerakhir;
    }

    public String getRangeTanggal() {
        return rangeTanggal;
    }

    public String getJudul1() {
        return judul1;
    }

    public String getJudul2() {
        return judul2;
    }

    //    {"antrian_akhir":"D000",
//            "jumlah_antrian":4,
//            "range_tanggal":"[{\"PILIH HARI\":\"-\"},{\"2018-05-04\":\"Jumat, 04\\\/05\\\/2018\"}]",
//            "judul1":"BEDAH UMUM (PAGI)",
//            "judul2":"dr. Handy Susetyo, Sp.B","info_poli":"-"}

//    @SerializedName("jumlah_antrian")
//    String jumlahAntrian;
//    @SerializedName("antrian_terakhir")
//    String antrianTerakhir;
//
//    public Antrian() {
//    }
//
//    public String getJumlahAntrian() {
//        return jumlahAntrian;
//    }
//
//    public String getAntrianTerakhir() {
//        return antrianTerakhir;
//    }




}
