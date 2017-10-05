package dieula.collections.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dieula.collections.R;
import dieula.collections.models.Collections;

/**
 * Created by East Coast Pawn on 10/3/2017.
 */

public class FragmentAdapter extends ArrayAdapter<Collections>
{
    public FragmentAdapter(Context context, ArrayList<Collections> Collection)
    {
        super(context, android.R.layout.simple_list_item_1, Collection);
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // get the data item for position
        Collections Collection = getItem(position);
        // check the existing view being..
        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_collections, parent, false);
        }
        // find the image view
        ImageView ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfile);
        TextView tvphoto = (TextView) convertView.findViewById(R.id.tvPhoto);
        TextView tvname = (TextView) convertView.findViewById(R.id.tvName);


        tvphoto.setText(Collection.getPhoto());
        tvname.setText(Collection.getName());
        // clear out image from convertView
        ivProfileImage.setImageResource(android.R.color.transparent);

      //  String image = null;
      //  Picasso.with(getContext()).load(image).error(R.drawable.jem_ma).into(ivProfileImage);

        return convertView;
    }
}

  /*  public FragmentAdapter(Context context, ArrayList<Collections> Collection) {
                super(context, android.R.layout.simple_list_item_1, Collection);
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Collections Collection = getItem(position);
                ViewHolder viewHolder;

                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    convertView = inflater.inflate(R.layout.item_collections, parent, false);
                    viewHolder.tvphoto = (TextView) convertView.findViewById(R.id.tvPhoto);
                    viewHolder.tvname = (TextView) convertView.findViewById(R.id.tvName);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivProfile);
                ivImage.setImageResource(0);


                viewHolder.tvphoto.setText(Collection.getPhoto());
                viewHolder.tvname.setText(Collection.getName());

                String image = null;
                Picasso.with(getContext()).load(image).error(R.drawable.jem_ma).into(ivImage);

                return convertView;
            }
        }
}*/
