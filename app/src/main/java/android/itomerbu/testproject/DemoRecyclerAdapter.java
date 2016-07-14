package android.itomerbu.testproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by iTomer on 07/07/2016.
 * Licence GPLv3
 * Copyright (C) 2016  iTomer
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class DemoRecyclerAdapter extends RecyclerView.Adapter<DemoRecyclerAdapter.MyVH> {
    ArrayList<String> data = new ArrayList<>();
    public DemoRecyclerAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);

        fillDummyData();
    }

    private void fillDummyData() {
        for (int i = 0; i < 100; i++) {
            data.add(String.format(Locale.US, "Item No: %d ", i));
        }
    }

    LayoutInflater inflater;

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyVH(inflater.inflate(R.layout.demo_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void remove(int adapterPosition) {
        data.remove(adapterPosition);
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView textView;

        public MyVH(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}