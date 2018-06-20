package com.taopao.rxdatepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.taopao.rxdatepicker.widget.RxDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RxDatePicker mRxDatePicker1, mRxDatePicker2;
    private TextView mTvTime;
    private TextView mTvDate;
    private TextView mTvYear;
    private String mNow;
    private RxDatePicker mRxDatePicker3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvDate = (TextView) findViewById(R.id.tv_date);
        mTvYear = (TextView) findViewById(R.id.tv_year);
        initDatePicker();

        mTvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 日期格式为yyyy-MM-dd
                mRxDatePicker1.show(mTvDate.getText().toString());
            }
        });

        mTvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 日期格式为yyyy-MM-dd HH:mm
                mRxDatePicker2.show(mTvTime.getText().toString());
            }
        });

        mTvYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 日期格式为yyyy-MM-dd HH:mm
                mRxDatePicker3.show(mTvTime.getText().toString());
            }
        });

    }

    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        mNow = sdf.format(new Date());
        mTvDate.setText(mNow.split(" ")[0]);
        mTvTime.setText(mNow);

        mRxDatePicker1 = new RxDatePicker(this, new RxDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                mTvDate.setText(time.split(" ")[0]);
            }
        }, "2010-01-01 00:00", mNow); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        mRxDatePicker1.showSpecificTime(false); // 不显示时和分
        mRxDatePicker1.setIsLoop(false); // 不允许循环滚动


        mRxDatePicker2 = new RxDatePicker(this, new RxDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                mTvTime.setText(time);
            }
        }, "2010-01-01 00:00", mNow); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        mRxDatePicker2.showSpecificTime(true); // 显示时和分
        mRxDatePicker2.setIsLoop(true); // 允许循环滚动


        mRxDatePicker3 = new RxDatePicker(this, new RxDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                String[] split = time.split("-");
                mTvYear.setText(split[0]);
            }
        }, "2010-01-01 00:00", mNow); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        mRxDatePicker3.showOnlyYear();


    }

}
