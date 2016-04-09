package com.example.jutao.strategymodel;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jutao.strategymodel.Factor.CashFactor;
import com.example.jutao.strategymodel.Factor.CashSuper;
import com.example.jutao.strategymodel.Strategy.CashContext;
import java.util.ArrayList;
import java.util.RandomAccess;

public class MainActivity extends ActionBarActivity {
  EditText et_dj;
  EditText et_sl;
  Button btn_enter;
  Button btn_reset;
  TextView tv_detail;
  TextView tv_total;
  Spinner sp_jsfs;
  ArrayList<String> calus;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
    initSpinnerData();
  }

  private void initView() {
    et_dj = (EditText) findViewById(R.id.et_dj);
    et_sl = (EditText) findViewById(R.id.et_sl);
    btn_enter = (Button) findViewById(R.id.btn_enter);
    btn_reset = (Button) findViewById(R.id.btn_reset);
    tv_detail = (TextView) findViewById(R.id.tv_detail);
    tv_total = (TextView) findViewById(R.id.tv_total);
    sp_jsfs = (Spinner) findViewById(R.id.sp_jsfs);

    MyListener myListener = new MyListener();

    btn_enter.setOnClickListener(myListener);

    btn_reset.setOnClickListener(myListener);
  }

  private void initSpinnerData() {
    calus = new ArrayList<String>();
    calus.add("正常收费");
    calus.add("满300返100");
    calus.add("打八折");
    calus.add("打七折");
    calus.add("打五折");
    ArrayAdapter<String> arr_adapter =
        new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, calus);
    arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    sp_jsfs.setAdapter(arr_adapter);
  }

  private class MyListener implements View.OnClickListener {

    @Override public void onClick(View v) {
      switch (v.getId()) {
        case R.id.btn_enter:
          doEnter();
          break;
        case R.id.btn_reset:
          doReset();
          break;
      }
    }

    private void doEnter() {
      String stringTotal = tv_total.getText().toString().trim();
      double total;
      if (stringTotal != null && stringTotal != "") {
        total = Double.valueOf(stringTotal);
      } else {
        total = 0.0d;
      }

      String stringDJ = et_dj.getText().toString().trim();
      String stringSL = et_sl.getText().toString().trim();
      if (stringDJ != null && !stringDJ.equals("") && stringSL != null && !stringSL.equals("")) {
        Log.d("TAG", "123" + stringDJ + "123");
        double price = Double.valueOf(stringDJ);
        int number = Integer.valueOf(stringSL);
        double totalPrice = price * number;
        CashContext cc = new CashContext(sp_jsfs.getSelectedItemPosition());
        totalPrice = cc.GetResule(totalPrice);
        total = total + totalPrice;

        tv_total.setText(String.valueOf(total));
        String text = tv_detail.getText().toString()
            + "单价： "
            + price
            + " 数量："
            + number
            + " "
            + sp_jsfs.getSelectedItem().toString()
            + " 合计:"
            + totalPrice
            + "\n";
        tv_detail.setText(text);
      }
    }

    private void doReset() {
      et_dj.setText("");
      et_sl.setText("");
      tv_total.setText(String.valueOf(0.0d));
      tv_detail.setText("");
    }
  }
}
