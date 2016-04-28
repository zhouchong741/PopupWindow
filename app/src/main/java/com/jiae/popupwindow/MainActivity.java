package com.jiae.popupwindow;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow popupWindow;
    private Button button;
    private Button button2;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        initListener();
    }

    private void initListener() {
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    //知道了 取消按钮
    public void button_known(View view) {
        popupWindow.dismiss();
    }

    public void select_cancel(View view) {
        popupWindow.dismiss();
    }

    private void popup() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.demand_popup, null);
        popupWindow = new PopupWindow(view, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        WindowManager.LayoutParams params = getWindow().getAttributes();//创建当前界面的一个参数对象
        params.alpha = 0.8f;
        getWindow().setAttributes(params);//把该参数对象设置进当前界面中


        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1.0f;//设置为不透明，即恢复原来的界面
                getWindow().setAttributes(params);
            }
        });

        //第一个参数为父View对象，即PopupWindow所在的父控件对象，第二个参数为它的重心，后面两个分别为x轴和y轴的偏移量
        popupWindow.showAtLocation(inflater.inflate(R.layout.activity_main, null), Gravity.CENTER, 0, 0);
    }

    private void popup2() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.demand_popup_select, null);
        popupWindow = new PopupWindow(view, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setContentView(view);

        text1 = (TextView) view.findViewById(R.id.text1);
        text2 = (TextView) view.findViewById(R.id.text2);
        text3 = (TextView) view.findViewById(R.id.text3);
        text4 = (TextView) view.findViewById(R.id.text4);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string1 = text1.getText().toString();
                TextView textshow = (TextView) findViewById(R.id.text_show);
                textshow.setText(string1);
//                Toast.makeText(MainActivity.this, "选择了：" + string1, Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string2 = text2.getText().toString();
                TextView textshow = (TextView) findViewById(R.id.text_show);
                textshow.setText(string2);
//                Toast.makeText(MainActivity.this, "选择了：" + string2, Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string3 = text3.getText().toString();
                TextView textshow = (TextView) findViewById(R.id.text_show);
                textshow.setText(string3);
//                Toast.makeText(MainActivity.this, "选择了：" + string3, Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string4 = text4.getText().toString();
                TextView textshow = (TextView) findViewById(R.id.text_show);
                textshow.setText(string4);
//                Toast.makeText(MainActivity.this, "选择了：" + string4, Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        WindowManager.LayoutParams params = getWindow().getAttributes();//创建当前界面的一个参数对象
        params.alpha = 0.8f;
        getWindow().setAttributes(params);//把该参数对象设置进当前界面中
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1.0f;//设置为不透明，即恢复原来的界面
                getWindow().setAttributes(params);
            }
        });

        //第一个参数为父View对象，即PopupWindow所在的父控件对象，第二个参数为它的重心，后面两个分别为x轴和y轴的偏移量
        popupWindow.showAtLocation(inflater.inflate(R.layout.activity_main, null), Gravity.CENTER, 0, 0);
    }

    /*private void initItem() {
        final String[] items = new String[]{
                "LOGO设计", "VI系统设计", "DM单页", "海报", "宣传册", "包装设计", "PPT模板设计"
        };
        ListView listView = (ListView) findViewById(R.id.listview);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return items.length;
            }

            @Override
            public Object getItem(int position) {
                return items[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setGravity(Gravity.CENTER);
                TextView textView = new TextView(MainActivity.this);
                textView.setText(items[position]);
                linearLayout.addView(textView);
                return linearLayout;
            }
        };
        listView.setAdapter(adapter);
    }
*/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                popup();
                break;
            case R.id.button2:
                popup2();
                break;
        }
    }
}

