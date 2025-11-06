package org.adv.exelfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelSheetModel {
    private List<Map<String, Map<String, ExcelRowModel>>> sheets;

    public void addRow(String rowNum, Map<String, ExcelRowModel> row) {
        if (this.sheets == null) {
            this.sheets = new ArrayList<>();
        }

        Map<String, Map<String, ExcelRowModel>> map = new HashMap<>();
        map.put(rowNum, row);

        this.sheets.add(map);
    }

    public List<Map<String, Map<String, ExcelRowModel>>> getSheets() {
        return sheets;
    }

    public void setSheets(List<Map<String, Map<String, ExcelRowModel>>> sheets) {
        this.sheets = sheets;
    }
}
