package pt.ipbeja.roteirosbeja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.InputQueue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EachRoteirosActivity extends AppCompatActivity {

    private Monument monument;

    private ImageView eachMainImg;
    private TextView eachTitle, longDescription;

    private String data1, data2;
    private int myImage;
    private Context context;

    public static void startActivity(Context context, long infoId) {
        Intent intent = new Intent(context, EachRoteirosActivity.class);
        intent.putExtra(KEY_INFOID, infoId);
        context.startActivity(intent);
    }

    private static final String KEY_INFOID = "infoID";
    private static final String TAG = "eachRoteiro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_roteiros);

        this.eachMainImg = findViewById(R.id.eachMainImg); // a variavel "mainImg" = ao imgView da form
        this.eachTitle = findViewById(R.id.eachTitle);
        this.longDescription = findViewById(R.id.longDescription);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long infoId = bundle.getLong(KEY_INFOID, -1);
            if (infoId == -1){
                Log.e(TAG, "Invalid position found!");
            finish();
            return;
        }

            this.monument = DataSource.getMonument( this, infoId);
            this.eachTitle.setText(monument.getTitle());
            this.longDescription.setText(monument.getLongDescription());
            Glide.with(this).load(this.monument.getImage()).into(this.eachMainImg);



        } else {
            Log.e(TAG, "No position specified!");
            finish();
        }
    }

    private List<Monument> monumentList;
    private List<InterestPoint> ipList;


    RecyclerView FreeVisitRecycler;

    public void onClickFreeVisit (View view){

        Intent intent = new Intent(this, FreeVisitActivity.class);
        startActivity(intent);

    }

}

