package com.example.trivia11a;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> resultLauncher;

    private FbModule fbModule;

    private ConstraintLayout ll;

    private String themeI;

    private Button btnStartGame, btnSettings, btnInstructions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbModule = new FbModule(this);

        ll = findViewById(R.id.main);

        btnStartGame = findViewById(R.id.btnStart );
        btnSettings = findViewById(R.id.onClickSetting);
        btnInstructions = findViewById(R.id.btnInstruction);

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if (o.getResultCode() == RESULT_OK)
                        {
                            Intent data = o.getData();
                            String str = data.getStringExtra("color");

                            fbModule.writeBackgroundColorToFb(str);



                        }

                    }
                }
        );
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onClickSetting(View view) {
        Intent i = new Intent(this, SettingActivity.class);
        i.putExtra("Theme", themeI);
        resultLauncher.launch(i);
    }

    public void onClickInstruction(View view) {
    }

    public void setNewColorFromFb(String str) {
        //הפיירבייס קורא לפעולה בפעם הראשונה
        //ואחרי כל פעם שהמשתמש משנהאת הצבע
        //Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
        setTheme(str);

    }

    public void setTheme(String theme)
    {
        themeI = theme;

        switch (theme)
        {
            case "Dark":
            {
                ll.setBackgroundColor(Color.argb(255,59,59,59 ));
                btnInstructions.setBackgroundColor(Color.argb(255,74,74,74));
                btnSettings.setBackgroundColor(Color.argb(255,74,74,74));
                btnStartGame.setBackgroundColor(Color.argb(255,74,74,74));
                btnStartGame.setTextColor(Color.WHITE);
                btnSettings.setTextColor(Color.WHITE);
                btnInstructions.setTextColor(Color.WHITE);

                break;
            }

            case "Light":
            {
                ll.setBackgroundColor(Color.argb(255,183,201,232  ));
                btnInstructions.setBackgroundColor(Color.argb(255,224,228,242  ));
                btnSettings.setBackgroundColor(Color.argb(255,224,228,242  ));
                btnStartGame.setBackgroundColor(Color.argb(255,224,228,242 ));
                btnStartGame.setTextColor(Color.BLACK);
                btnSettings.setTextColor(Color.BLACK);
                btnInstructions.setTextColor(Color.BLACK);
                break;
            }

            case "Warm":
            {
                ll.setBackgroundColor(Color.argb(255,255,94,58 ));
                btnInstructions.setBackgroundColor(Color.argb(255,255,127,80 ));
                btnSettings.setBackgroundColor(Color.argb(255,255,127,80 ));
                btnStartGame.setBackgroundColor(Color.argb(255,255,127,80 ));
                btnStartGame.setTextColor(Color.WHITE);
                btnSettings.setTextColor(Color.WHITE);
                btnInstructions.setTextColor(Color.WHITE);
                break;
            }

            case "Cold":
            {
                ll.setBackgroundColor(Color.argb(255,128,203,196 ));
                btnInstructions.setBackgroundColor(Color.argb(255,178,223,219 ));
                btnSettings.setBackgroundColor(Color.argb(255,178,223,219 ));
                btnStartGame.setBackgroundColor(Color.argb(255,178,223,219 ));
                btnStartGame.setTextColor(Color.BLACK);
                btnSettings.setTextColor(Color.BLACK);
                btnInstructions.setTextColor(Color.BLACK);
                break;
            }

            default:
            {
                Toast.makeText(this, "Invalid theme", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}