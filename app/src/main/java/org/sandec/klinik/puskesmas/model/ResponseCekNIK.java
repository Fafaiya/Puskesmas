package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wakhyudi on 26/12/17.
 */

public class ResponseCekNIK {

    String response;
    String nik;
    String bpjs;
    @SerializedName("bpjs_message")
    String bpjsMessage;

    public String getNikMessage() {
        return nikMessage;
    }

    @SerializedName("nik_message")
    String nikMessage;

    public ResponseCekNIK() {
    }

    public String getResponse() {
        return response;
    }

    public String getNik() {
        return nik;
    }

    public String getBpjs() {
        return bpjs;
    }

    public String getBpjsMessage() {
        return bpjsMessage;
    }


}
