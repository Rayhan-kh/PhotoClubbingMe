package www.foxcoders.com.photoclubbingme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class FolderActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);

        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] data2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "2", "3", "4", "5", "6", "7", "8", "9", "2", "3", "4", "5", "6", "7", "8", "9", "2", "3", "4", "5", "6", "7", "8", "9"};
        RecyclerView folder_rv = (RecyclerView) findViewById(R.id.folder_rv);
        RecyclerView thumb_rv = (RecyclerView) findViewById(R.id.thumb_rv);

        toolbar=(Toolbar)findViewById(R.id.folderToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("View");


        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        FolderAdapter folderAdapter=new FolderAdapter(this,data);
        folder_rv.setLayoutManager(linearLayoutManager);
        folder_rv.addItemDecoration(new ListSpacingDecoration(this,R.dimen.decor));
        folder_rv.setAdapter(folderAdapter);

        final GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        ThumbnailAdapter thumbnailAdapter=new ThumbnailAdapter(this,data2);
        thumb_rv.addItemDecoration(new ListSpacingDecoration(10));
        thumb_rv.setLayoutManager(gridLayoutManager);
        thumb_rv.setAdapter(thumbnailAdapter);




    }
}
