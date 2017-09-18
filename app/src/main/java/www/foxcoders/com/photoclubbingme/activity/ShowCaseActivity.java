package www.foxcoders.com.photoclubbingme.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.makeramen.roundedimageview.RoundedImageView;

import www.foxcoders.com.photoclubbingme.R;
import www.foxcoders.com.photoclubbingme.Util;

public class ShowCaseActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView, imageView1, imageView2, imageView3;
    Toolbar toolbar;
    RoundedImageView imgWaterMark;
    RelativeLayout hideMask;
    RelativeLayout deleteMask;
    private SharedPreferences sharedPref;
    private boolean isLoggedIn;
    private ImageView adv;
    private View bottomBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_case);

        imgWaterMark = (RoundedImageView) findViewById(R.id.imgWatermark);
        sharedPref = this.getSharedPreferences("MyData", Context.MODE_PRIVATE);
        isLoggedIn = sharedPref.getBoolean("isLoggedIn", false);
        adv = (ImageView) findViewById(R.id.adv);
        bottomBottom = findViewById(R.id.nav);

        if (isLoggedIn) {
            adv.setVisibility(View.GONE);
        } else {
            bottomBottom.setVisibility(View.GONE);
        }

        toolbar = (Toolbar) findViewById(R.id.showCaseToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Util.setTitleText("Image_title", this);
        hideMask = (RelativeLayout) findViewById(R.id.hideMask);
        deleteMask = (RelativeLayout) findViewById(R.id.deleteMask);

        imageView = (ImageView) findViewById(R.id.iv1);
        imageView1 = (ImageView) findViewById(R.id.iv2);
        imageView2 = (ImageView) findViewById(R.id.iv3);
        imageView3 = (ImageView) findViewById(R.id.iv4);

        imageView.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        goToSend();
    }

    public void goToSend() {
        startActivity(new Intent(this, SendInfoActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.showcase_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.hide) {
            toolbar.getMenu().clear();
            toolbar.inflateMenu(R.menu.showcase_conxtual_menu);
            hideMask.setVisibility(View.VISIBLE);
        }
        if (item.getItemId() == R.id.unHide) {
            toolbar.getMenu().clear();
            toolbar.inflateMenu(R.menu.showcase_menu);
            hideMask.setVisibility(View.GONE);
        }
        if (item.getItemId() == R.id.delete) {
            if (hideMask.getVisibility() == View.VISIBLE) {
                hideMask.setVisibility(View.GONE);
            }
            deleteMask.setVisibility(View.VISIBLE);
        }
        if (item.getItemId() == R.id.toQueue) {
            finish();
        }

        if (item.getItemId() == R.id.watermark) {
            imgWaterMark.setVisibility(View.VISIBLE);
        }

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;

    }
}
