package com.zaaach.tabradiobuttongithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = findViewById(R.id.rg_android);
        rg.check(R.id.rb_conversation);

        RadioGroup rg2 = findViewById(R.id.rg_top);
        rg2.check(R.id.rb_contact);

        RadioGroup rg3 = findViewById(R.id.rg_left);
        rg3.check(R.id.rb_plugin);

        RadioGroup rg4 = findViewById(R.id.rg_no_text);
        rg4.check(R.id.rb_now);
    }
}
