package www.foxcoders.com.photoclubbingme;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by Ray on 9/17/2017.
 */

public class Util {

    public static void setTitleText(String title, Activity context)
    {
        TextView textView= (TextView) context.findViewById(R.id.toolbar_title);
        textView.setText(title);

    }
}
