package com.example.materialdemo1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @ProjectName: MaterialTest
 * @Package: com.example.materialdemo1
 * @ClassName: MyAdapter
 * @Author: DashingQI
 * @CreateDate: 2018/12/15 11:17 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/15 11:17 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Fruit> fruitList;
    private Context mContext;

    public MyAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null)
            mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Fruit fruit = fruitList.get(i);
        viewHolder.mTextView.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getSrc()).into(viewHolder.mImageView);

        viewHolder.mCarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        ImageView mImageView;
        CardView mCarView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCarView = (CardView) itemView;
            mTextView = itemView.findViewById(R.id.mTextView);
            mImageView = itemView.findViewById(R.id.mImageView);
        }
    }
}
