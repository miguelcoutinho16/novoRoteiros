package pt.ipbeja.roteirosbeja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

public class GuidedVisitActivity extends AppCompatActivity {

    private static final String KEY_MONUMENTID = "monumentID";
    private static final String KEY_POSITIONID = "positionID";
    private static final String TAG = "GuidedVisitActivity";
    private GuidedVisitAdapter adapter;
    Context context;


    public static void startActivity(Context context, long infoID,  int position) {
        Intent intent = new Intent(context, GuidedVisitActivity.class);
        intent.putExtra(KEY_MONUMENTID, infoID);
        intent.putExtra(KEY_POSITIONID, position);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guided_visit);

        RecyclerView GuidedVisitRecycler = findViewById(R.id.GuidedVisitRecycler);

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

            this.adapter = new GuidedVisitAdapter(this, interestList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            GuidedVisitRecycler.setLayoutManager(layoutManager);
            GuidedVisitRecycler.setAdapter(adapter);


            Bundle bundle2 = getIntent().getExtras();
            if (bundle2 != null) {
                int position = bundle2.getInt(KEY_POSITIONID, -1);
                if (position == -1) {
                    Log.e(TAG, "Invalid position found!");
                    finish();
                    return;
                }

                layoutManager.smoothScrollToPosition(GuidedVisitRecycler, new RecyclerView.State(), position);

            }

        }

    }

}
