package pt.ipbeja.roteirosbeja;

import android.content.Context;

import java.util.List;

public class DataSource {

    private static List<Monument> infoList;

    private DataSource() {

    }
    public static List<Monument> getInfoList(Context context) {
        return AppDatabase.getInstance(context).getMonumentDAO().getAll();
    }

    public static Monument getMonument(Context context, long id) {
        return AppDatabase.getInstance(context).getMonumentDAO().getById(id);
    }

 //   public static InterestPoint getInterestingPoint(Context context, long id){
 //       return AppDatabase.getInstance(context).getInterestingPointDao().getById(id);
 //   }
}


