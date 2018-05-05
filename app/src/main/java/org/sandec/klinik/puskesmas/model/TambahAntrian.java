package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wakhyudi on 26/12/17.
 */

public class TambahAntrian {
    String response;
//    String timeout;
//    String reload;
    @SerializedName("antrian_ID")
    String idAntrian;
    @SerializedName("direct_to")
    String directTo;
//    @SerializedName("layanan_ID")
//    String layananId;
//    String message;


    public TambahAntrian() {
    }

    public String getResponse() {
        return response;
    }

    public String getIdAntrian() {
        return idAntrian;
    }

    public String getDirectTo() {
        return directTo;
    }

    //    public String getMessage() {
//        return message;
//    }
//
//    public String getTimeout() {
//        return timeout;
//    }
//
//    public String getReload() {
//        return reload;
//    }
//
//    public String getTotalAntri() {
//        return totalAntri;
//    }
//
//    public String getLayananId() {
//        return layananId;
//    }
}
