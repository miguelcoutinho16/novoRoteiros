package pt.ipbeja.roteirosbeja;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Locale;

public class GuidedVisitAdapter extends RecyclerView.Adapter<GuidedVisitAdapter.MyViewHolder> {

    private List<InterestPoint> ipList;
    private Context context;
    private TextToSpeech tts;


    public GuidedVisitAdapter(Context ct, List < InterestPoint > ipList) {

        this.context = ct;
        this.ipList = ipList;
    }

        @NonNull
        @Override
        public GuidedVisitAdapter.MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent,
        int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.guidedvisit_row, parent, false);
        return new GuidedVisitAdapter.MyViewHolder(view);

    }

        @NonNull
        @Override
        public void onBindViewHolder (@NonNull GuidedVisitAdapter.MyViewHolder holder,int position){
        InterestPoint InterestPoint = this.ipList.get(position);

        holder.titleView.setText(InterestPoint.getName());
        holder.descView.setText(InterestPoint.getDescription());
        Glide.with(this.context).load(InterestPoint.getImages()).into(holder.imgView);
        Glide.with(this.context).load(InterestPoint.getMaps()).into(holder.imgMaps);


            tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status == TextToSpeech.SUCCESS){
                        int result = tts.setLanguage(new Locale("pt"));
                        if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                            Log.e("TTS", "Language not supported.");
                        }
                    }else{
                        Log.e("TTS", "Initialization failed.");

                    }
                }
            });

            holder.btnTalks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.btnTalks.setVisibility(View.INVISIBLE);
                    holder.btnStop.setVisibility(View.VISIBLE);

                    String text = holder.descView.getText().toString();
                    String title = holder.titleView.getText().toString();
                    String space = ",";

                    tts.speak(title + space + text, TextToSpeech.QUEUE_FLUSH, null);

                    holder.btnStop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                           // holder.btnStop.setBackgroundDrawable(R.drawable.);
                            tts.stop();
                            holder.btnStop.setVisibility(View.INVISIBLE);
                            holder.btnTalks.setVisibility(View.VISIBLE);

                        }
                    });
                }
            });



            holder.GuidedVisitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  GuidedVisitActivity.startActivity(context, InterestPoint.getId());

            }
        });
    }

        @Override
        public int getItemCount () {
        return this.ipList.size();
    }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView titleView, descView;
            ImageView imgView, imgMaps;
            View GuidedVisitActivity;
            FloatingActionButton btnTalks, btnStop;
            RecyclerView FreeVisitRecycler;
            RecyclerView GuidedVisitRecycler;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                this.titleView = itemView.findViewById(R.id.txtTitle);
                this.descView = itemView.findViewById(R.id.txtDescription);
                this.imgView = itemView.findViewById(R.id.imgMonument);
                this.imgMaps = itemView.findViewById(R.id.imgMap);
                this.btnTalks = itemView.findViewById(R.id.btnTalk);
                this.btnStop = itemView.findViewById(R.id.btnTalkStop);
                this.GuidedVisitActivity = itemView;
                this.FreeVisitRecycler = itemView.findViewById(R.id.FreeVisitRecycler);
                this.GuidedVisitRecycler = itemView.findViewById(R.id.GuidedVisitRecycler);
            }

        }

    }
