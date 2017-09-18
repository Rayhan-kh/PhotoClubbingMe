package www.foxcoders.com.photoclubbingme.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import www.foxcoders.com.photoclubbingme.R;

/**
 * Created by Ray on 9/17/2017.
 */

public class SlideshowAdapter extends PagerAdapter {

    List<Integer> drawables;
    Context context;
    LayoutInflater layoutInflater;
    private int position;

    public SlideshowAdapter(List<Integer> drawables,Context context)
    {
        this.drawables =drawables;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
     return drawables.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        this.position=position;
        View view=layoutInflater.inflate(R.layout.slide_show,container,false);
        RoundedImageView imageView=(RoundedImageView)view.findViewById(R.id.imageContainer);
        imageView.setImageResource(drawables.get(position));
        container.addView(view);
        return view;
    }




}
