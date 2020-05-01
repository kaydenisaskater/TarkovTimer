package android.bignerdranch.tarkovtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NutritionActivity extends AppCompatActivity {

    private Button mNextPage;
    private Button mBackPage;
    private Button mWilstonButton;
    private Button mSugarButton;
    private Button mLunchBoxButton;
    private int messageResId = R.string.finish_text;

    private int wilstonC;
    private int sugarC;
    private int lunchBoxC;

    private static final String TAG = "NutritionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        mNextPage = (Button) findViewById(R.id.next_button);
        mNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back to main activity
                Intent intent = new Intent(NutritionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mBackPage = (Button) findViewById(R.id.back_button);
        mBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to medstation activity
                Intent intent = new Intent(NutritionActivity.this, MedstationActivity.class);
                startActivity(intent);
            }
        });

        mWilstonButton = (Button) findViewById(R.id.wilston);
        mWilstonButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        mWilstonButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mSugarButton.setEnabled(false);
                        mLunchBoxButton.setEnabled(false);
                        wilstonC++;
                    }
                    public void onFinish(){
                        Toast.makeText(NutritionActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                        mWilstonButton.setText(R.string.craft_text);
                        mSugarButton.setEnabled(true);
                        mLunchBoxButton.setEnabled(true);
                    }
                }.start();
            }
        });

        mLunchBoxButton = (Button) findViewById(R.id.lunchbox);
        mLunchBoxButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new CountDownTimer(20000, 1000){
                    public void onTick(long millisUntilFinished){
                        mLunchBoxButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mSugarButton.setEnabled(false);
                        mWilstonButton.setEnabled(false);
                        lunchBoxC++;
                    }
                    public void onFinish(){
                        Toast.makeText(NutritionActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                        mLunchBoxButton.setText(R.string.craft_text);
                        mSugarButton.setEnabled(true);
                        mWilstonButton.setEnabled(true);
                    }
                }.start();
            }
        });

        mSugarButton = (Button) findViewById(R.id.sugar);
        mSugarButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new CountDownTimer(10000, 1000){
                    public void onTick(long millisUntilFinished){
                        mSugarButton.setText("Time remainging: " + millisUntilFinished / 1000);
                        mLunchBoxButton.setEnabled(false);
                        mWilstonButton.setEnabled(false);
                        sugarC++;
                    }
                    public void onFinish(){
                        Toast.makeText(NutritionActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                        mLunchBoxButton.setText(R.string.craft_text);
                        mSugarButton.setEnabled(true);
                        mWilstonButton.setEnabled(true);
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
