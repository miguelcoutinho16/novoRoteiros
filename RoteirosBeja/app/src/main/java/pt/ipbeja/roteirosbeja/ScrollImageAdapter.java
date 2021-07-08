package pt.ipbeja.roteirosbeja;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ScrollImageAdapter extends PagerAdapter {

    Context mContext;
    private int[] allImages = new int[] {};

    ScrollImageAdapter(Context context){
        mContext = context;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
