package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wakhyudi on 26/12/17.
 */

public class Daftarpoli {

    @SerializedName("ID")
    String id;
    String description;
    @SerializedName("icon")
    String linkIcon;
    String judul1;
    String judul2;

//    public Daftarpoli(String id, String description, String linkIcon) {
//        this.id = id;
//        this.description = description;
//        this.linkIcon = linkIcon;
//    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkIcon() {
        return linkIcon;
    }

    public String getJudul1() {
        return judul1;
    }

    public String getJudul2() {
        return judul2;
    }
}
