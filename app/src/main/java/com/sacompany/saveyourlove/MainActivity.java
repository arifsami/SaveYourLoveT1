package com.sacompany.saveyourlove;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    // soruların sırasını tutar   -- Şu an için 2 soru var
    int[] soruListesi = new int[]{1, 2};
    // cevapların sırasını tutar
    int[] cevapListesi = new int[]{1, 2};


    public ViewFlipper viewFlipperTest;


    // -- Soru 1 için -- //
    RadioGroup cevaplarSoru1;
    LinearLayout layoutHata1;
    Button btnHata1;

    // -- Soru 2 için -- //
    RadioGroup cevaplarSoru2;
    LinearLayout layoutHata2;
    Button btnHata2;

    // eğer bir hata yapılırsa true olarak işaretlenir ve en başa dönmek için kullanılır.
    boolean yanlisMi = false;

    public void TumElemanlariTanimla() {

        viewFlipperTest = (ViewFlipper) findViewById(R.id.viewFlipperTest);

        // -- Cevaplar -- //
        cevaplarSoru1 = (RadioGroup) findViewById(R.id.radioGroupCevap1);
        cevaplarSoru2 = (RadioGroup) findViewById(R.id.radioGroupCevap2);

        // -- Hatalar -- //
        layoutHata1 = (LinearLayout) findViewById(R.id.hata1);
        layoutHata2 = (LinearLayout) findViewById(R.id.hata2);

        // hata buton //
        btnHata1 = (Button) findViewById(R.id.btnHata1);
        btnHata2 = (Button) findViewById(R.id.btnHata2);

        // -- cevaplar sırasıyla -- // -- seçili olayı için çözüm olmaz ise tek tek kullanılabilir.
        RadioButton soru1cevap1 = (RadioButton) findViewById(R.id.cevap1soru1);
        RadioButton soru1cevap2 = (RadioButton) findViewById(R.id.cevap2soru1);
        RadioButton soru1cevap3 = (RadioButton) findViewById(R.id.cevap3soru1);
        RadioButton soru1cevap4 = (RadioButton) findViewById(R.id.cevap4soru1);
        RadioButton soru2cevap1 = (RadioButton) findViewById(R.id.cevap1soru2);
        RadioButton soru2cevap2 = (RadioButton) findViewById(R.id.cevap2soru2);
        RadioButton soru2cevap3 = (RadioButton) findViewById(R.id.cevap3soru2);
        RadioButton soru2cevap4 = (RadioButton) findViewById(R.id.cevap4soru2);

    }

    public void MesajGoster(String mesaj) {
        Toast.makeText(this, mesaj, Toast.LENGTH_SHORT).show();
    }

    private void TumCevaplarinKontrolleri() {

        cevaplarSoru1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Random rand = new Random();
                int chance = rand.nextInt(2);
                if (chance == 1) {
                    HataGoster();
                } else {
                    viewFlipperTest.showNext();
                }
                final RadioButton r = (RadioButton) radioGroup.findViewById(i);
                r.setChecked(false);
            }
        });

        cevaplarSoru2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Random rand = new Random();
                int chance = rand.nextInt(2);
                if (chance == 1) {
                    HataGoster();
                } else {
                    viewFlipperTest.showNext();
                }
                RadioButton r = (RadioButton) radioGroup.findViewById(i);
                r.setChecked(false);
            }
        });

    }

    private void HataGoster() {

        Random rand = new Random();
        int chance = rand.nextInt(2);

        MesajGoster("rastgele sayı: " + chance);
        if (chance == 1) {
            MesajGoster("2. hata ekranı denk geldi");
            viewFlipperTest.setVisibility(View.GONE);
            layoutHata1.setVisibility(View.GONE);
            layoutHata2.setVisibility(View.VISIBLE);

            btnHata2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MesajGoster("2. hata ekranındaki buton a bastın");
                    layoutHata2.setVisibility(View.GONE);
                    layoutHata1.setVisibility(View.GONE);
                    viewFlipperTest.setVisibility(View.VISIBLE);
                    viewFlipperTest.setDisplayedChild(0);

                }
            });

        } else {
            MesajGoster("1. hata ekranı denk geldi");
            viewFlipperTest.setVisibility(View.GONE);
            layoutHata2.setVisibility(View.GONE);
            layoutHata1.setVisibility(View.VISIBLE);

            btnHata1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MesajGoster("1. hata ekranındaki buton a bastın");
                    layoutHata2.setVisibility(View.GONE);
                    layoutHata1.setVisibility(View.GONE);
                    viewFlipperTest.setVisibility(View.VISIBLE);
                    viewFlipperTest.setDisplayedChild(0);

                }
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TumElemanlariTanimla();

        TumCevaplarinKontrolleri();

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
