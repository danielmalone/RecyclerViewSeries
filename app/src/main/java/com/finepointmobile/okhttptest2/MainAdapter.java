package com.finepointmobile.okhttptest2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by danielmalone on 5/13/17.
 */

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<String> mDataset;

    public MainAdapter(ArrayList<String> dataset) {
        mDataset = dataset;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        try {
            JSONObject jsonArray = new JSONObject(mDataset.get(position));
            JSONObject address = jsonArray.getJSONObject("address");
            holder.mTitle.setText(jsonArray.getString("name"));
            holder.mEmail.setText(jsonArray.getString("email"));
            holder.mAddress.setText(address.getString("street"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public TextView mEmail;
        public TextView mAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mEmail = (TextView) itemView.findViewById(R.id.email);
            mAddress = (TextView) itemView.findViewById(R.id.address);
        }
    }
}
