package org.adv.exelfile;

import java.util.ArrayList;
import java.util.List;

public class ExcelRowModel {
    private List<String> rowData;

    public void addRowData(String rowData){
        if (this.rowData == null){
            this.rowData = new ArrayList<>();
        }
        this.rowData.add(rowData);
    }

    public List<String> getRowData() {
        return rowData;
    }

    public void setRowData(List<String> rowData) {
        this.rowData = rowData;
    }
}
