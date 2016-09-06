package com.example.enterprise.progressbarcolor;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.CountDownTimer;

public class MainActivity extends Activity {

    private int progressStatus = 0;
    //The number of milliseconds in the future from the
    //call to start() until the count down is done
    private long millisInFuture = 20000; //20 seconds (make it dividable by 1000)
    //The interval along the way to receive onTick() callbacks
    private long countDownInterval = 1000; //1 second (don't change this value)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the widgets reference from XML layout
        final ProgressBar pb = (ProgressBar) findViewById(R.id.pb);
        final TextView tv = (TextView) findViewById(R.id.tv);
        final Button btn = (Button) findViewById(R.id.btn);
        //pb.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
pb.getProgressDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
//pb.getProgressDrawable().setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_IN);
//pb.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
//pb.getProgressDrawable().setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);
//pb.getProgressDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        //Cast long value to int value
        //When defining above variables, make sure 'progressBarMaximumValue' always rerun integer value
        int progressBarMaximumValue = (int)(millisInFuture/countDownInterval);
        //Set ProgressBar maximum value
        //ProgressBar range (0 to maximum value)
        pb.setMax(progressBarMaximumValue);
        //Display the CountDownTimer initial value
        tv.setText(progressBarMaximumValue + "  Seconds...");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Initialize a new CountDownTimer instance
                new CountDownTimer(millisInFuture, countDownInterval){
                    public void onTick(long millisUntilFinished){
                        //Another one second passed
                        tv.setText(millisUntilFinished/1000 + "  Seconds...");
                        //Each second ProgressBar progress counter added one
                        progressStatus +=1;
                        pb.setProgress(progressStatus);
                    }

                    public void onFinish(){
                        //Do something when count down end.
                        progressStatus +=1;
                        pb.setProgress(progressStatus);
                        tv.setText(progressStatus - pb.getMax() + "  Seconds...");
                    }
                }.start();
            }
        });
    }
}
