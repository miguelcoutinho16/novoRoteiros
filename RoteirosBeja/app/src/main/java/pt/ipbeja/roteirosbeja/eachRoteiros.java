package pt.ipbeja.roteirosbeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class eachRoteiros extends AppCompatActivity {

    ImageView mainImg;
    TextView title, description;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_roteiros);

        mainImg = findViewById(R.id.mainImg); // a variavel "mainImg" = ao imgView da form
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();

        }

    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImg.setImageResource(myImage);

    }

    public void onClickGuidedVisit(View view){

        Intent intent = new Intent(this, GuidedVisit.class);
        startActivity(intent);

    }


}