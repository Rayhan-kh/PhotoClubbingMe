package www.foxcoders.com.photoclubbingme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makeramen.roundedimageview.RoundedImageView;

import www.foxcoders.com.photoclubbingme.R;

/**
 * Created by Ray on 9/15/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private String[] mData = new String[0];
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RoundedImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView=(RoundedImageView)itemView.findViewById(R.id.roundedImage1);
        }

        @Override
        public void onClick(View v) {

            if (mClickListener != null) {
                setClickListener(mClickListener);
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }


    public EventAdapter(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.event_card, parent, false);
        RoundedImageView imageView=(RoundedImageView)view.findViewById(R.id.roundedImage1);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}
