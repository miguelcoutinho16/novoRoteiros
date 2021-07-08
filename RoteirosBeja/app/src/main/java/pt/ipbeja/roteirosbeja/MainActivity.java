package pt.ipbeja.roteirosbeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MonumentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickStart(View view){

        Intent intent = new Intent(this, AllRoteirosActivity.class);
        startActivity(intent);
    }

    public void onClickSair(View view){
        finish();
    }

    protected void onStart() {
        super.onStart();
        AppDatabase.getInstance(this).getMonumentDAO().getAll();
    }
}