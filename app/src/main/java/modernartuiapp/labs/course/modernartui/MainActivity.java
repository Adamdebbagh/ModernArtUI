package modernartuiapp.labs.course.modernartui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    SeekBar seekbar = null;
    TextView views[];
    String[] colorArray = {"#b7baae","#6b6b4c","#d9d6bf","#ffffff","#763846","#e0dfd0","#ccb66d","#ffffff","#404254","#e6d37a","#957b6e","#ffffff","#b7a47b","#911b3a","#757745"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));


        views = new TextView[15];
        // initialize view Objects
        views[0] = (TextView) findViewById(R.id.textView0);
        views[1] = (TextView) findViewById(R.id.textView1);
        views[2] = (TextView) findViewById(R.id.textView2);
        views[3] = (TextView) findViewById(R.id.textView3);
        views[4] = (TextView) findViewById(R.id.textView4);
        views[5] = (TextView) findViewById(R.id.textView5);
        views[6] = (TextView) findViewById(R.id.textView6);
        views[7] = (TextView) findViewById(R.id.textView7);
        views[8] = (TextView) findViewById(R.id.textView8);
        views[9] = (TextView) findViewById(R.id.textView9);
        views[10] = (TextView) findViewById(R.id.textView10);
        views[11] = (TextView) findViewById(R.id.textView11);
        views[12] = (TextView) findViewById(R.id.textView12);
        views[13] = (TextView) findViewById(R.id.textView13);
        views[14] = (TextView) findViewById(R.id.textView14);

        seekbar = (SeekBar) findViewById(R.id.seekbar);
        // set TextViews background colors
        for (int i = 0; i<colorArray.length ;i++){
            views[i].setBackgroundColor(Color.parseColor(colorArray[i]));
        }
        //listen for seekbar change
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // change background colors of non white textviews
                for (int i = 0; i<colorArray.length ;i++){

                    if(colorArray[i] != "#ffffff"){
                        views[i].getBackground().setAlpha(progress);
                        views[i].setBackgroundColor(Color.parseColor(colorArray[i])*progress);

                    }

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //if More Information menu button is clickecked, open a dialog
        if (id == R.id.action_more_information) {

            openDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        builder.setTitle(R.string.title)
               .setMessage(R.string.message)
               .setPositiveButton(R.string.browse,new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                       //Browse to MoMa Website;

                       // First option : browse Moma website externally using an installed browser (implicit intent)
                       //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org/collection/object.php?object_id=65715"));
                       //startActivity(intent);

                      //Second option : browse Moma website from within the app (explicit intent)
                       startActivity(new Intent(MainActivity.this, MoMaPage.class));
                   }
               })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //cancel dialog
                        dialog.cancel();
                    }
                });
         //create and show dialog
        AlertDialog infoDialog = builder.create();
        infoDialog.show();

    }


}
