package nl.leeuwte.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Benny de Leeuw on 19-6-14.
 */
public abstract  class PagerAdapter extends BaseAdapter {


    int requestNew = 10;
    int maxItems = 99999;
    int pageSize = 50;

    private boolean requesting = false;

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public void setRequestNew(int requestNew) {
        this.requestNew = requestNew;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (getCount() - requestNew < i && getCount() < maxItems && !requesting) {
            requesting = true;

            int requestCount = pageSize;

            if (getCount() + pageSize >= maxItems)
                requestCount =  maxItems - getCount();

            this.requestNewItems(getCount(), requestCount);
        }

        return null;
    }

    public abstract void requestNewItems(int startIndex, int requestCount);

    @Override
    public void notifyDataSetChanged() {
        requesting = false;
        super.notifyDataSetChanged();
    }



}
