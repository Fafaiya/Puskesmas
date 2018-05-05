package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wakhyudi on 26/12/17.
 */

public class ListLayanan {
    @SerializedName("ID")
    String id;

    String description;

    public ListLayanan() {
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
