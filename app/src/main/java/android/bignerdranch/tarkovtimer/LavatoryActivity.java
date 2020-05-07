package android.bignerdranch.tarkovtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LavatoryActivity extends AppCompatActivity {

    private Button mNextPage;
    private Button mBackPage;
    private Button mBleachButton;
    private Button mMagCaseButton;
    private Button mAirFilterButton;
    private int messageResId = R.string.finish_text;

    private int bleachC;
    private int magCaseC;
    private int airFilterC;

    private static final String TAG = "LavatoryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lavatory);

        mNextPage = (Button) findViewById(R.id.next_button);
        mNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to medstation activity
                Intent intent = new Intent(LavatoryActivity.this, MedstationActivity.class);
                finish();
                overridePendingTransition(0,0);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });

        mBackPage = (Button) findViewById(R.id.back_button);
        mBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to workbench activity
                Intent intent = new Intent(LavatoryActivity.this, MainActivity.class);
                finish();
                overridePendingTransition(0,0);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });

        mMagCaseButton = (Button) findViewById(R.id.magcase);
        mMagCaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        mMagCaseButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mAirFilterButton.setEnabled(false);
                        mBleachButton.setEnabled(false);
                        magCaseC++;
                    }
                    public void onFinish(){
                        Toast.makeText(LavatoryActivity.this, "Mag Case Finished!", Toast.LENGTH_SHORT).show();
                        mMagCaseButton.setText(R.string.craft_text);
                        mAirFilterButton.setEnabled(true);
                        mBleachButton.setEnabled(true);
                    }
                }.start();
            }
        });

        mAirFilterButton = (Button) findViewById(R.id.air_filter);
        mAirFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(20000, 1000){
                    public void onTick(long millisUntilFinished){
                        mAirFilterButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mMagCaseButton.setEnabled(false);
                        mBleachButton.setEnabled(false);
                        airFilterC++;
                    }
                    public void onFinish(){
                        Toast.makeText(LavatoryActivity.this, "Air Filter Finished!", Toast.LENGTH_SHORT).show();
                        mAirFilterButton.setText(R.string.craft_text);
                        mMagCaseButton.setEnabled(true);
                        mBleachButton.setEnabled(true);
                    }
                }.start();
            }
        });

        mBleachButton = (Button) findViewById(R.id.bleach);
        mBleachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(10000, 1000){
                    public void onTick(long millisUntilFinished){
                        mBleachButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mMagCaseButton.setEnabled(false);
                        mAirFilterButton.setEnabled(false);
                        bleachC++;
                    }
                    public void onFinish(){
                        Toast.makeText(LavatoryActivity.this, "Bleach Finished!", Toast.LENGTH_SHORT).show();
                        mBleachButton.setText(R.string.craft_text);
                        mMagCaseButton.setEnabled(true);
                        mAirFilterButton.setEnabled(true);
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
