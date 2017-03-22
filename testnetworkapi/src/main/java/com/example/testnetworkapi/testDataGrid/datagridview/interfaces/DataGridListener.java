package com.example.testnetworkapi.testDataGrid.datagridview.interfaces;

import java.util.List;

/**
 * Created by pscj on 2016/11/30.
 */

public interface DataGridListener {
    void showHeader(List<String> mData, List<Integer> widthList);
    void hideHeader();
    int getScrollPosY();
    int getScrollPosX();
}
