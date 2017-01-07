package com.sacompany.saveyourlove;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by arifsami on 02/01/2017.
 */
public class Soru1 extends Fragment {
    RadioGroup cevap1;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soru1, container, false);
        //ekleyeceğin görsel elamnları bu view ile ekleyeceksin
        //örneğin burda view.findViewbyId dedik bunun gibi
        //TextView txtSoru1 = (TextView) view.findViewById(R.id.txtSoru1);
        //Bu kısımdan sonra textView.setText diyerek işlemlerini yapabilirsin

        cevap1 = (RadioGroup) view.findViewById(R.id.radioGroupCevap1);

        cevap1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
              //  Toast.makeText(getContext(), "" + radioGroup.getCheckedRadioButtonId() + " - \ni = " + i, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
