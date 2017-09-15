package www.foxcoders.com.photoclubbingme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ray on 9/15/2017.
 */

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());        }
    }

    private String[] mData = new String[0];
    private LayoutInflater mInflater;
    private EventAdapter.ItemClickListener mClickListener;

    public ThumbnailAdapter(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ThumbnailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.thumbnail_card, parent, false);
        ThumbnailAdapter.ViewHolder viewHolder = new ThumbnailAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ThumbnailAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    // allows clicks events to be caught
    public void setClickListener(EventAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
