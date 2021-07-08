package pt.ipbeja.roteirosbeja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class FreeVisitActivity extends AppCompatActivity {

    private static final String KEY_MONUMENTID = "monumentID";
    private static final String TAG = "FreeVisitActivity";
    private FreeVisitAdapter adapter;



    public static void startActivity(Context context, long infoID) {
        Intent intent = new Intent(context, FreeVisitActivity.class);
        intent.putExtra(KEY_MONUMENTID, infoID);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_visit);

        RecyclerView FreeVisitRecycler = findViewById(R.id.FreeVisitRecycler);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long infoID = bundle.getLong(KEY_MONUMENTID, -1);
            if (infoID == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
                return;
            }

            long eachInterestID = infoID;

            List<InterestPoint> interestList = AppDatabase.getInstance(this).getInterestingPointDao().getAllForEach(eachInterestID);

            this.adapter = new FreeVisitAdapter(this, interestList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            FreeVisitRecycler.setLayoutManager(layoutManager);
            FreeVisitRecycler.setAdapter(adapter);


        }




//        FreeVisitAdapter adapter = new FreeVisitAdapter(this, AppDatabase.getInstance(this).getInterestingPointDao().getAll());
   //     FreeVisitRecycler.setAdapter(adapter);
    //    FreeVisitRecycler.setLayoutManager(new LinearLayoutManager(this));

    }

    void scrollToPosition(int position) {
        RecyclerView FreeVisitRecycler = findViewById(R.id.FreeVisitRecycler);
        FreeVisitRecycler.scrollToPosition(position);
    }

}