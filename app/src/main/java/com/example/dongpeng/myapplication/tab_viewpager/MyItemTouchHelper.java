package com.example.dongpeng.myapplication.tab_viewpager;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by dongpeng on 2016/8/19.
 */
public class MyItemTouchHelper extends ItemTouchHelper.Callback {
    MyRecycleAdapter adapter;
    public MyItemTouchHelper(MyRecycleAdapter adapter) {
        this.adapter=adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int drags=makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,ItemTouchHelper.LEFT|ItemTouchHelper.UP|
        ItemTouchHelper.RIGHT|ItemTouchHelper.DOWN);
        int swipes = makeFlag(ItemTouchHelper.ACTION_STATE_SWIPE,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT);
        return makeMovementFlags(drags,swipes);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.moveItem(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return false;
    }
}
