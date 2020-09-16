package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView theView = findViewById(R.id.cakeview);
        CakeController controller = new CakeController(theView);

        Button blowing = findViewById(R.id.button2);
        blowing.setOnClickListener(controller);

        Switch candleSwitch = findViewById( R.id.switchcandles );
        candleSwitch.setOnCheckedChangeListener(controller);

        SeekBar candleSeek = findViewById( R.id.seekCandles );
        candleSeek.setOnSeekBarChangeListener(controller);


    }
    //Reference to the CakeView class
    public void goodbye(View button){
        Log.i("button","Goodbye");
    }
}
