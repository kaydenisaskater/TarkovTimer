package android.bignerdranch.tarkovtimer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private Button mNextPage;
    private Button mBackPage;
    private Button mGreenGunpowderButton;
    private Button mRedGunpowderButton;
    private Button mBlueGunpowderButton;
    private TextView mWorkBenchTextView;
    private int messageResId = R.string.finish_text;

    private int greenCounter;
    private int redCounter;
    private int blueCounter;

    private int mPageIndex = 0;

    private static final String TAG = "MainActivity";

    private int view = R.layout.activity_main;
    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        mWorkBenchTextView = (TextView) findViewById(R.id.workbench_text_view);

        mNextPage = (Button) findViewById(R.id.next_button);
        mNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to lavatory activity
                Intent intent = new Intent(MainActivity.this, LavatoryActivity.class);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });

        mBackPage = (Button) findViewById(R.id.back_button);
        mBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to nutrition unit activity
                Intent intent = new Intent(MainActivity.this, NutritionActivity.class);
                finish();
                overridePendingTransition(0,0);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });

        mGreenGunpowderButton = (Button) findViewById(R.id.green_gunpowder);
        mGreenGunpowderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        mGreenGunpowderButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mBlueGunpowderButton.setEnabled(false);
                        mRedGunpowderButton.setEnabled(false);
                        greenCounter++;
                    }
                    public void onFinish(){
                        Toast.makeText(MainActivity.this, "Green Gunpowder Finished!", Toast.LENGTH_SHORT).show();
                        mGreenGunpowderButton.setText(R.string.craft_text);
                        mRedGunpowderButton.setEnabled(true);
                        mBlueGunpowderButton.setEnabled(true);
                    }
                }.start();
            }
        });

        mRedGunpowderButton = (Button) findViewById(R.id.red_gunpowder);
        mRedGunpowderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new CountDownTimer(20000, 1000){
                    public void onTick(long millisUntilFinished){
                        mRedGunpowderButton.setText("Time remaining" + millisUntilFinished / 1000);
                        mBlueGunpowderButton.setEnabled(false);
                        mGreenGunpowderButton.setEnabled(false);
                        redCounter++;
                    }
                    public void onFinish(){
                        Toast.makeText(MainActivity.this, "Red Gunpowder Finished!", Toast.LENGTH_SHORT).show();
                        mRedGunpowderButton.setText(R.string.craft_text);
                        mBlueGunpowderButton.setEnabled(true);
                        mGreenGunpowderButton.setEnabled(true);
                    }
                }.start();
            }
        });

        mBlueGunpowderButton = (Button) findViewById(R.id.blue_gunpowder);
        mBlueGunpowderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new CountDownTimer(10000, 1000){
                    public void onTick(long millisUntilFinished){
                        mBlueGunpowderButton.setText("Time remaining: " + millisUntilFinished / 1000);
                        mRedGunpowderButton.setEnabled(false);
                        mGreenGunpowderButton.setEnabled(false);
                        blueCounter++;
                    }
                    public void onFinish(){
                        Toast.makeText(MainActivity.this, "Blue Gunpowder Finished!", Toast.LENGTH_SHORT).show();
                        mBlueGunpowderButton.setText(R.string.craft_text);
                        mRedGunpowderButton.setEnabled(true);
                        mGreenGunpowderButton.setEnabled(true);
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