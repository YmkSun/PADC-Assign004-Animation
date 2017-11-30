package com.androidapp.yemyokyaw.animationapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.yemyokyaw.animationapp.R;
import com.androidapp.yemyokyaw.animationapp.delegates.RvItemDelegates;
import com.androidapp.yemyokyaw.animationapp.viewholder.RvItemViewHolder;

/**
 * Created by yemyokyaw on 12/1/17.
 */

public class RvItemAdapter extends RecyclerView.Adapter {

    private LayoutInflater mLayoutInflator;
    private RvItemDelegates mRvItemDelegate;

    public RvItemAdapter(Context context, RvItemDelegates itemDelegate) {
        mLayoutInflator = LayoutInflater.from(context);
        mRvItemDelegate = itemDelegate;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflator.inflate(R.layout.view_rv_item, parent, false);
        return new RvItemViewHolder(itemView, mRvItemDelegate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
