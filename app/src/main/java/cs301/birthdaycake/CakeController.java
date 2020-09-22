package cs301.birthdaycake;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener,  CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
   private CakeView cakeView; //Reference to the CakeView class
   private CakeModel cakeModel; //Reference to the CakeModel class


    public CakeController(CakeView cv){
       //Inititalize both references
       this.cakeView = cv;
       this.cakeModel = cv.getCakeModel();
   }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();
        cakeModel.xPos = event.getX();
        cakeModel.yPos = event.getY();
        cakeModel.balloonCoordinates[0] = x;
        cakeModel.balloonCoordinates[1] = y;
        cakeView.invalidate();
        return true;
    }

//blow out candles
@Override
 public void onClick(View v) {
     Log.d("On Click", "Clicked");
     this.cakeModel.lit = false;
     this.cakeView.invalidate();

 }
//candles on cake or not

   @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
       Log.d("On Check", "Checked");
        //this.cakeModel.hasCandles= true;
       if(!isChecked) this.cakeModel.hasCandles =false;
       else if(isChecked) this.cakeModel.hasCandles= true;
         //cakeView.getCakeModel().hasCandles = !cakeView.getCakeModel().hasCandles;
         this.cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int prog, boolean b) {
        cakeView.getCakeModel().candleCount = prog;
        cakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Not used
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Not used
    }

    }
