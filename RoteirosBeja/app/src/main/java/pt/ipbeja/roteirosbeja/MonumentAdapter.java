package pt.ipbeja.roteirosbeja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class MonumentAdapter extends RecyclerView.Adapter<MonumentAdapter.MyViewHolder>{

    private List<Monument> monumentList;
    private Context context;

        public MonumentAdapter(Context ct, List<Monument> monumentList){

            this.context = ct;
            this.monumentList = monumentList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.monument_row, parent,false);
            return new MyViewHolder(view);
        }

        @NonNull
        @Override
        public void onBindViewHolder(@NonNull MonumentAdapter.MyViewHolder holder, int position) {

            Monument monument = this.monumentList.get(position);

            holder.textViewName.setText(monument.getTitle());
            holder.textViewDescription.setText(monument.getShortDescription());
            Glide.with(this.context).load(monument.getImage()).into(holder.myImage);

            /*
            MyViewHolder.getCbBookmark().setChecked(monument.isDone());


            holder.cbBookmark.getCbBookmark().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    monument.setDone(isChecked);
                    AppDatabase.getInstance(MonumentAdapter.this.context).getMonumentDAO().update(monument);
                }
            });

             */


            holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

              //      GuidedVisitActivity.startActivity(context, monument.getId());
                    FreeVisitActivity.startActivity(context, monument.getId());

                }
            });
        }

        @Override
        public int getItemCount() {
            return this.monumentList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{

            TextView textViewName, textViewDescription;
            ImageView myImage;
            View mainLayout;
            CheckBox cbBookmark;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                this.textViewName = itemView.findViewById(R.id.textViewName);
                this.textViewDescription = itemView.findViewById(R.id.textViewDescription);
                this.myImage = itemView.findViewById(R.id.imageView);
                this.mainLayout = itemView;
                this.cbBookmark = itemView.findViewById(R.id.cbBookmark);
            }

            public CheckBox getCbBookmark() {
                return cbBookmark;
            }
        }
    }

