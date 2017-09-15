package www.foxcoders.com.photoclubbingme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements EventAdapter.ItemClickListener {

    private EventAdapter eventAdapter;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recEventList);
        toolbar=(Toolbar)findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Event List");
        final GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        eventAdapter = new EventAdapter(this, data);
        eventAdapter.setClickListener(this);
        recyclerView.setAdapter(eventAdapter);
        recyclerView.addItemDecoration(new ListSpacingDecoration(this, R.dimen.decor));

    }

    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(this,FolderActivity.class));
    }
}
