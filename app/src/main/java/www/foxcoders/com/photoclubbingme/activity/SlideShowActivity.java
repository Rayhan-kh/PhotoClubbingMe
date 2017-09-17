package www.foxcoders.com.photoclubbingme.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

import www.foxcoders.com.photoclubbingme.R;
import www.foxcoders.com.photoclubbingme.Util;
import www.foxcoders.com.photoclubbingme.adapter.SlideshowAdapter;

public class SlideShowActivity extends AppCompatActivity {

    Toolbar toolbar;
    List<Integer> drawables=new ArrayList<>();
    private SharedPreferences sharedPref;
    private boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);

        sharedPref = this.getSharedPreferences("MyData", Context.MODE_PRIVATE);
        isLoggedIn=sharedPref.getBoolean("isLoggedIn",false);



        toolbar=(Toolbar)findViewById(R.id.slideshowToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Util.setTitleText("Back",this);
        initImages();

        HorizontalInfiniteCycleViewPager viewPager= (HorizontalInfiniteCycleViewPager) findViewById(R.id.slideShow);
        SlideshowAdapter slideshowAdapter=new SlideshowAdapter(drawables,this);
        viewPager.setAdapter(slideshowAdapter);
    }

    private void initImages() {

        drawables.add(R.drawable.moon);
        drawables.add(R.drawable.road);
        drawables.add(R.drawable.man);
        drawables.add(R.drawable.flower);
        drawables.add(R.drawable.unnamed);
        drawables.add(R.drawable.star);
        if(!isLoggedIn)
        {
            drawables.add(2,R.drawable.advlarge);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return true;
    }
}
