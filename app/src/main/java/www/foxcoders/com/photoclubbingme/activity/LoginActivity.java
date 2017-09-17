package www.foxcoders.com.photoclubbingme.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import www.foxcoders.com.photoclubbingme.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fab;
    TextView textView;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         sharedPref = this.getSharedPreferences("MyData",Context.MODE_PRIVATE);


        fab=(FloatingActionButton)findViewById(R.id.loginFab);
        fab.setOnClickListener(this);
        textView=(TextView)findViewById(R.id.skip);
        textView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if(v.getId()==fab.getId())
        {
            editor = sharedPref.edit();
            editor.putBoolean("isLoggedIn",true);
            editor.apply();
            editor.commit();
            startActivity(new Intent(this,MainActivity.class));
        }

        if(v.getId()==textView.getId())
        {
            editor = sharedPref.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();
            editor.commit();
            startActivity(new Intent(this,MainActivity.class));

        }

    }
}
