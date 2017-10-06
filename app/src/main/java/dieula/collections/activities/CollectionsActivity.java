package dieula.collections.activities;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import dieula.collections.R;
import dieula.collections.adapter.FragmentAdapter;
import dieula.collections.fragment.FeaturedFragment;
import dieula.collections.fragment.FollowingFragment;
import dieula.collections.fragment.TweetsListFragment;
import dieula.collections.models.Collections;

public class CollectionsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

   FragmentAdapter equipeAdapter;
    ArrayList<Collections> aCollection;
   // FragmentPagerAdapter adapterViewPager;
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        grid = (GridView) findViewById(R.id.lvGrid);
        // onclick in the listview for seeing the details
     /*   grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Collections Collection = (Collections) grid.getItemAtPosition(position);
                // Toast.makeText(TeamFayBerActivity.this, "Just click on the list and get back to do other choice", Toast.LENGTH_SHORT).show();

            }
        });*/

      //  grid = (GridView) findViewById(R.id.lvGrid);
     //   grid.setAdapter((ListAdapter) new FragmentAdapter(getSupportFragmentManager()));

        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        //set the viewpager adapter for the pager
        vpPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        //Find the slinding tabstrip
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabStrip.setViewPager(vpPager);

   /*     aCollection = new ArrayList<>();
        equipeAdapter = new FragmentAdapter(CollectionsActivity.this, aCollection);
        grid.setAdapter(equipeAdapter);

        equipeAdapter.addAll(Collections.fromFakeData());
        equipeAdapter.notifyDataSetChanged();*/

        // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.collections, menu);
        //inflate the button search
        getMenuInflater().inflate(R.menu.search, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
     return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private static int NUM_ITEMS = 3;

        // Returns total number of pages
        public int getCount() {
            return NUM_ITEMS;
        }
        // Returns the fragment to display for that page
        public  class FragmentAdapter extends FragmentPagerAdapter
        {
            private String tabTitles[] = {"FEATURED" , "FOLLOWING", "YOURS"};

            public FragmentAdapter(FragmentManager fm){
                super(fm);
            }

            public Fragment getItem(int position) {
                switch (position) {
                    case 0: // Fragment # 0 - This will show FirstFragment
                        return FeaturedFragment.newInstance(0, "Page # 1");
                    case 1: // Fragment # 0 - This will show FirstFragment different title
                        return FollowingFragment.newInstance(1, "Page # 2");
                    case 2: // Fragment # 1 - This will show SecondFragment
                        return FeaturedFragment.newInstance(2, "Page # 3");
                    case 3: // Fragment # 1 - This will show SecondFragment
                       return TweetsListFragment.newInstance(2, "Page # 3");
                    default:
                        return null;
                }
            }

            // Returns the page title for the top indicator
            @Override
            public CharSequence getPageTitle(int position)
            {
                return  tabTitles[position];
            }
            public int getCount()

            {
                return tabTitles.length;
            }


        }
    }



