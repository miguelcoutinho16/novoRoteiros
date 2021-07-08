package pt.ipbeja.roteirosbeja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FreeVisitAdapter extends RecyclerView.Adapter<FreeVisitAdapter.MyViewHolder>{

    private List<InterestPoint> ipList;
    private Context context;


    public FreeVisitAdapter(Context ct, List<InterestPoint> ipList){

        this.context = ct;
        this.ipList = ipList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.freevisit_row, parent,false);
        return new MyViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull FreeVisitAdapter.MyViewHolder holder, int position) {
        InterestPoint InterestPoint = this.ipList.get(position);

        holder.titleView.setText(InterestPoint.getName());
        Glide.with(this.context).load(InterestPoint.getImages()).into(holder.imgView);

        holder.FreeVisitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  holder.GuidedVisitRecycler.scrollToPosition(position);
                GuidedVisitActivity.startActivity(context, InterestPoint.getEachInterestID(), position);


            }
        });
    }

    @Override
    public int getItemCount() {
        return this.ipList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleView;
        ImageView imgView;
        View FreeVisitActivity;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titleView = itemView.findViewById(R.id.titleView);
            this.imgView = itemView.findViewById(R.id.imgView);
            this.FreeVisitActivity = itemView;
        }
    }
}
