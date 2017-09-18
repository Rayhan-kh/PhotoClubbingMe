package www.foxcoders.com.photoclubbingme.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import www.foxcoders.com.photoclubbingme.R;

/**
 * Created by Ray on 9/15/2017.
 */

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ViewHolder> {


    private String[] mData = new String[0];
    private LayoutInflater mInflater;
    private ThumbnailAdapter.ItemClickListener presenter;
    public boolean is_in_action_mode=false;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        CheckBox checkBox;
        ImageView imageView;
        CardView cardView;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.mask);
            imageView=(ImageView)itemView.findViewById(R.id.img_th);
            cardView=(CardView)itemView.findViewById(R.id.thumbCard);
            checkBox=(CheckBox)itemView.findViewById(R.id.checkbox);
            itemView.setOnClickListener(this);
            cardView.setLongClickable(true);
            cardView.setOnLongClickListener(this);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (presenter != null) {
                presenter.onThumbnailClick(v,getAdapterPosition());
            }
            }

        @Override
        public boolean onLongClick(View v) {
            presenter.onThumbnailLongClick(v,getAdapterPosition());
            return true;
        }
    }

    public ThumbnailAdapter(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        presenter=(ThumbnailAdapter.ItemClickListener)context;
    }

    @Override
    public ThumbnailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.thumbnail_card, parent, false);
        ThumbnailAdapter.ViewHolder viewHolder = new ThumbnailAdapter.ViewHolder(view);

        viewHolder.setIsRecyclable(true);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ThumbnailAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(R.drawable.dance);
        if(!is_in_action_mode)
        {
            if(holder.checkBox.isChecked())
            {
                holder.checkBox.setChecked(false);
            }
            holder.checkBox.setVisibility(View.GONE);
            holder.view.setVisibility(View.GONE);
        }
        else {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.view.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }


    public interface ItemClickListener {
        void onThumbnailClick(View view, int position);
        void onThumbnailLongClick(View view,int position);
    }


}
