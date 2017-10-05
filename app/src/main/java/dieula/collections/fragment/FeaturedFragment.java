package dieula.collections.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dieula.collections.R;

/**
 * Created by East Coast Pawn on 10/2/2017.
 */

public class FeaturedFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FeaturedFragment newInstance(int page, String title) {
        FeaturedFragment fragmentFirst = new FeaturedFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_collections, container, false);
        //   TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        // tvLabel.setText(page + " -- " + title);
        return view;
    }
}

