package www.foxcoders.com.photoclubbingme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.makeramen.roundedimageview.RoundedImageView;

public class ShowCaseActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView,imageView1,imageView2,imageView3;
    Toolbar toolbar;
    RoundedImageView roundedImageView;
    RelativeLayout mask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_case);

        toolbar=(Toolbar) findViewById(R.id.showCaseToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Images_01");
        mask=(RelativeLayout)findViewById(R.id.hideMask);

        imageView=(ImageView)findViewById(R.id.iv1);
        imageView1=(ImageView)findViewById(R.id.iv2);
        imageView2=(ImageView)findViewById(R.id.iv3);
        imageView3=(ImageView)findViewById(R.id.iv4);

        imageView.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        goToSend();
    }
    public void goToSend()
    {
        startActivity(new Intent(this,SendInfoActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.showcase_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.hide)
        {
            toolbar.getMenu().clear();
            toolbar.inflateMenu(R.menu.showcase_conxtual_menu);
            mask.setVisibility(View.VISIBLE);
        }
        if(item.getItemId()==R.id.unHide)
        {
            toolbar.getMenu().clear();
            toolbar.inflateMenu(R.menu.showcase_menu);
            mask.setVisibility(View.GONE);
        }
        if(item.getItemId()==R.id.delete)
        {
            finish();
        }
        if(item.getItemId()==R.id.toQueue)
        {
            finish();
        }

        if(item.getItemId()==R.id.watermark)
        {
            //// TODO: 9/16/2017
        }
        return super.onOptionsItemSelected(item);
    }
}
