package android.bignerdranch.tarkovtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWorkBenchTextView = (TextView) findViewById(R.id.workbench_text_view);

        mNextPage = (Button) findViewById(R.id.next_button);
        mNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to lavatory activity
                Intent intent = new Intent(MainActivity.this, LavatoryActivity.class);
                startActivity(intent);
            }
        });

        mBackPage = (Button) findViewById(R.id.back_button);
        mBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to nutrition unit activity
                Intent intent = new Intent(MainActivity.this, NutritionActivity.class);
                startActivity(intent);
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
                        Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                        mBlueGunpowderButton.setText(R.string.craft_text);
                        mRedGunpowderButton.setEnabled(true);
                        mGreenGunpowderButton.setEnabled(true);
                    }
                }.start();
            }
        });
    }
}