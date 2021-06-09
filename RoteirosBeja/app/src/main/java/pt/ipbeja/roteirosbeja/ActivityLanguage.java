package pt.ipbeja.roteirosbeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }

    public void onClickBack(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}