package org.sandec.klinik.puskesmas.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wakhyudi on 24/12/17.
 */

public class ListHistory {
    @SerializedName("history")
    private List<History>listHistory;

    public ListHistory() {
    }

    public List<History> getListHistory() {
        return listHistory;
    }
}
