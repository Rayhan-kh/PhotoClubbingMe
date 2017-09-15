package www.foxcoders.com.photoclubbingme;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

/**
 * Created by Ray on 9/15/2017.
 */

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ViewHolder> {


    FolderActivity folderActivity;
    private String[] mData = new String[0];
    private LayoutInflater mInflater;
    private ThumbnailAdapter.ItemClickListener presenter;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CheckBox checkBox;
        ImageView imageView;
        CardView cardView;
        View view;

        public ViewHolder(View itemView, final FolderActivity folderActivity) {
            super(itemView);
            view=itemView.findViewById(R.id.mask);
            imageView=(ImageView)itemView.findViewById(R.id.img_th);
            cardView=(CardView)itemView.findViewById(R.id.thumbCard);
            checkBox=(CheckBox)itemView.findViewById(R.id.checkbox);
            itemView.setOnClickListener(this);
            cardView.setLongClickable(true);
            cardView.setOnLongClickListener(folderActivity);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (presenter != null) {
                presenter.onThumbnailClick(v,getAdapterPosition());
            }
            }

    }

    public ThumbnailAdapter(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        folderActivity= (FolderActivity) context;
        presenter=(ThumbnailAdapter.ItemClickListener)context;
    }

    @Override
    public ThumbnailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.thumbnail_card, parent, false);
        ThumbnailAdapter.ViewHolder viewHolder = new ThumbnailAdapter.ViewHolder(view,folderActivity);
        viewHolder.setIsRecyclable(true);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ThumbnailAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(R.drawable.ic_perm_identity);
        if(!folderActivity.is_in_action_mode)
        {
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
    }


}
