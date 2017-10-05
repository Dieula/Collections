package dieula.collections.models;

import android.text.TextUtils;
import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import dieula.collections.R;

/**
 * Created by East Coast Pawn on 10/2/2017.
 */

public class Collections implements Serializable {
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    String photo;
    String name;

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    int image;

    public Collections() {
    }

    public static ArrayList<Collections> fromFakeData()
    {
        ArrayList<Collections> results = new ArrayList<>();

        Collections Collections = new Collections();
        Collections.setImage(R.drawable.jema);
        Collections.setPhoto("PHOTOGRAPHY");
        Collections.setName("Dieula Sylvie");
        results.add(Collections);

        return results;
    }
    public static ArrayList<Collections> searchFakeData(String query) {
        query = query.toLowerCase();

        ArrayList<Collections> results = new ArrayList<>();

        ArrayList<Collections> Collection = Collections.searchFakeData(query);

        for (Collections s : Collection) {

            if (s.getName().toLowerCase().contains(query) || TextUtils.isEmpty(query)) {
                results.add(s);
                Log.d("DEBUG-Search", s.getName());
            }

        }

        return results;
    }
}