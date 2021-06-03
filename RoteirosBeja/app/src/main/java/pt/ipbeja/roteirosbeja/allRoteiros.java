package pt.ipbeja.roteirosbeja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class allRoteiros extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] s1, s2;
    int[] images = {R.drawable.castelo_beja, R.drawable.museu_regional_beja, R.drawable.museu_jorge_vieira};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_roteiros);

        recyclerView = findViewById(R.id.recycler_view);

        s1 = getResources().getStringArray(R.array.titulo_roteiros);
        s2 = getResources().getStringArray(R.array.descrição_roteiros);

        MyAdapter adapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}