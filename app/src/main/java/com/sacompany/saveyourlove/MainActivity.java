package com.sacompany.saveyourlove;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager;
    TextView textView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ViewPager Tanımlamaları
        fragmentManager = getSupportFragmentManager();
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new SayfaAdapter(fragmentManager));
    }

    public class SayfaAdapter extends FragmentPagerAdapter {

        public SayfaAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            //Bu kısımda hangi sayfada nerenin görüntüleneceğini seçiyoruz.
            //0 birinci sayfa...
            if (position == 0) {
                fragment = new Soru1();
            } else if (position == 1) {
                fragment = new Soru2();
            } else if (position == 2) {
                fragment = new Hata1();
            } else if (position == 3) {
                fragment = new Hata2();
            }

            return fragment;
        }

        @Override
        public int getCount() {

            //kaç sayfa varsa onu yazacaksın
            return 4;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
