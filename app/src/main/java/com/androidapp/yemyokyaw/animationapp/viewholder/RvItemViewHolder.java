package com.androidapp.yemyokyaw.animationapp.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidapp.yemyokyaw.animationapp.delegates.RvItemDelegates;

/**
 * Created by yemyokyaw on 12/1/17.
 */

public class RvItemViewHolder extends RecyclerView.ViewHolder {

    private RvItemDelegates mDelegate;

    public RvItemViewHolder(View itemView, RvItemDelegates itemDelegate) {
        super(itemView);
        mDelegate = itemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapItem();
            }
        });
    }
}
