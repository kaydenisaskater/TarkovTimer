package android.bignerdranch.tarkovtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MedstationActivity extends AppCompatActivity {

    private Button mNextPage;
    private Button mBackPage;
    private Button mAI2Button;
    private Button mGrizzlyButton;
    private Button mIFAKButton;

    private int messageResId = R.string.finish_text;

    private int ai2C;
    private int grizzlyC;
    private int ifakC;

    private static final String TAG = "MedstationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medstation);

        mNextPage = (Button) findViewById(R.id.next_button);
        mNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to nutrition activity
                Intent intent = new Intent(MedstationActivity.this, NutritionActivity.class);
                startActivity(intent);
            }
        });

        mBackPage = (Button) findViewById(R.id.back_button);
        mBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to lavatory activity
                Intent intent = new Intent(MedstationActivity.this, LavatoryActivity.class);
                startActivity(intent);
            }
        });

        mAI2Button = (Button) findViewById(R.id.ai2);
        mAI2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(10000, 1000){
                    public void onTick(long millisUntilFinished){
                        mAI2Button.setText("Time remaining: " + millisUntilFinished / 1000);
                        mGrizzlyButton.setEnabled(false);
                        mIFAKButton.setEnabled(false);
                        ai2C++;
                    }
                    public void onFinish(){
                        Toast.makeText(MedstationActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                        mAI2Button.setText(R.string.craft_text);
                        mGrizzlyButton.setEnabled(true);
                        mIFAKButton.setEnabled(true);
                    }
                }.start();
            }
        });

        mIFAKButton = (Button) findViewById(R.id.ifak);
        mIFAKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(20000, 1000){
                    public void onTick(long millisUntilFinished){
                        mIFAKButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mGrizzlyButton.setEnabled(false);
                        mAI2Button.setEnabled(false);
                        ifakC++;
                    }
                    public void onFinish(){
                        Toast.makeText(MedstationActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                        mIFAKButton.setText(R.string.craft_text);
                        mGrizzlyButton.setEnabled(true);
                        mAI2Button.setEnabled(true);
                    }
                }.start();
            }
        });

        mGrizzlyButton = (Button) findViewById(R.id.grizzly);
        mGrizzlyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        mGrizzlyButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mIFAKButton.setEnabled(false);
                        mAI2Button.setEnabled(false);
                        grizzlyC++;
                    }
                    public void onFinish(){
                        Toast.makeText(MedstationActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                        mGrizzlyButton.setText(R.string.craft_text);
                        mIFAKButton.setEnabled(true);
                        mAI2Button.setEnabled(true);
                    }
                }.start();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
