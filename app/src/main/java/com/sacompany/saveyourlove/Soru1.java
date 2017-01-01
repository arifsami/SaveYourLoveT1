package com.sacompany.saveyourlove;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by arifsami on 02/01/2017.
 */
public class Soru1 extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soru1, container, false);
        //ekleyeceğin görsel elamnları bu view ile ekleyeceksin
        //örneğin burda view.findViewbyId dedik bunun gibi
        //TextView txtSoru1 = (TextView) view.findViewById(R.id.txtSoru1);
        //Bu kısımdan sonra textView.setText diyerek işlemlerini yapabilirsin
        return view;
    }

}
