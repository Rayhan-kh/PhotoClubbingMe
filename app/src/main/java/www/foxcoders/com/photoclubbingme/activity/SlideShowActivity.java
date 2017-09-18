package www.foxcoders.com.photoclubbingme.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

import www.foxcoders.com.photoclubbingme.R;
import www.foxcoders.com.photoclubbingme.Util;
import www.foxcoders.com.photoclubbingme.adapter.SlideshowAdapter;

public class SlideShowActivity extends AppCompatActivity {

    Toolbar toolbar;
    List<Integer> drawables = new ArrayList<>();
    private SharedPreferences sharedPref;
    private boolean isLoggedIn;
    ImageView imageView;
    private HorizontalInfiniteCycleViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);

        sharedPref = this.getSharedPreferences("MyData", Context.MODE_PRIVATE);
        isLoggedIn = sharedPref.getBoolean("isLoggedIn", false);

        if (!isLoggedIn) {
            imageView = (ImageView) findViewById(R.id.adv);
            imageView.setVisibility(View.VISIBLE);
        }


        toolbar = (Toolbar) findViewById(R.id.slideshowToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Util.setTitleText("Back", this);
        initImages();

        viewPager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.slideShow);
        SlideshowAdapter slideshowAdapter = new SlideshowAdapter(drawables, this);
        if (drawables.size() > 2) {
            viewPager.startAutoScroll(true);
            viewPager.setScrollDuration(2000);
        }
        viewPager.setAdapter(slideshowAdapter);
    }

    private void initImages() {

        drawables.add(R.drawable.music);
        drawables.add(R.drawable.jelly);
        drawables.add(R.drawable.dance);
        drawables.add(R.drawable.tree);
        drawables.add(R.drawable.travle);
//        drawables.add(R.drawable.unnamed);
//        drawables.add(R.drawable.star);
//        if(!isLoggedIn)
//        {
//            drawables.add(3,R.drawable.advlarge);
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.stop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if (item.getItemId() == R.id.play) {
            toolbar.getMenu().clear();
            toolbar.inflateMenu(R.menu.stop);
            viewPager.startAutoScroll(true);
            viewPager.setScrollDuration(2000);
        }

        if (item.getItemId() == R.id.stop) {
            toolbar.getMenu().clear();
            toolbar.inflateMenu(R.menu.play);
            viewPager.setScrollDuration(250);
            viewPager.stopAutoScroll();

        }

        return true;
    }

}
