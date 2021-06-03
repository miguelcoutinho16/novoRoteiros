package pt.ipbeja.roteirosbeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_roteiros);


    }

    public void onClickStart(View view){

        Intent intent = new Intent(this, allRoteiros.class);
        startActivity(intent);
    }

    public void onClickLanguage(View view){

        Intent intent = new Intent(this, ActivityLanguage.class);
        startActivity(intent);
    }

    public void onClickSair(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}