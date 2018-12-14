package cn.dashingqi.com.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/12/14<p>
 * <p>更改时间：2018/12/14<p>
 * <p>版本号：1<p>
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Fruit> listData;
    private Context mContext;

    public MyAdapter(List<Fruit> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null)
            mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_view, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = listData.get(position);
                Intent intent = new Intent(mContext, FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME, fruit.getName());
                intent.putExtra(FruitActivity.FRUIT_SRC, fruit.getSrc());
                mContext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fruit fruit = listData.get(i);
        viewHolder.mTextView.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getSrc()).into(viewHolder.mImageView);

    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;
        public CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCardView = (CardView) itemView;
            mImageView = itemView.findViewById(R.id.mImageView);
            mTextView = itemView.findViewById(R.id.mTextView);
        }
    }
}
