package nl.leeuwte.pageradapter.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import nl.leeuwte.adapters.PagerAdapter;


import java.util.ArrayList;

/**
 * Created by Benny de Leeuw on 19-6-14.
 */
public class MyAdapter extends PagerAdapter {

    ArrayList<String> items = new ArrayList<String>();


    public MyAdapter(ArrayList<String> items, Context context) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        super.getView(i, view, viewGroup);

        TextView tv = new TextView(viewGroup.getContext());
        tv.setText(items.get(i));
        return tv;

    }

    @Override
    public void requestNewItems(int startIndex, int requestCount) {
        ArrayList<String> str = new ArrayList<String>();

        for (int i = startIndex; i <  startIndex + requestCount; i++) {
            str.add("ITEM " + i);
        }

        items.addAll(str);

        super.notifyDataSetChanged();

    }



}
