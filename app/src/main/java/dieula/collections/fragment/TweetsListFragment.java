package dieula.collections.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dieula.collections.R;
import dieula.collections.adapter.FragmentAdapter;
import dieula.collections.models.Collections;

public class TweetsListFragment extends Fragment{

    private ArrayList<Collections> Collection;
    private FragmentAdapter aTweets;
    private GridView Grid;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_tweets_list_fragment,parent,false);
        Grid = (GridView) v.findViewById(R.id.lvGrid);
        Grid.setAdapter(aTweets);
        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Collection = new ArrayList<>();
        aTweets = new FragmentAdapter(getActivity(), Collection);
    }

    public void addAll(ArrayList<Collections> Collection){
        aTweets.addAll(Collection);
        aTweets.notifyDataSetChanged();
    }
}
