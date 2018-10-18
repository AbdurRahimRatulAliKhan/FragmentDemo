package com.example.administrator.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    long fastTime,lastTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(new FragmentOne());

    }



    public void fragMethod(View view) {
        switch (view.getId()){
            case R.id.buttonOne:
                Toast.makeText(this, "Button One Is Pressed", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentOne());
                break;
            case R.id.buttonTwo:
                Toast.makeText(this, "Button Two Is Pressed", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentTwo());
                break;
            case R.id.buttonThree:
                Toast.makeText(this, "Button Three Is Pressed", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentThree());
                break;

        }
    }



    public void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.fragementId,fragment).commit();
    }

    @Override
    public void onBackPressed() {

        lastTime = fastTime;
        fastTime = System.currentTimeMillis();

        if(fastTime - lastTime < 250){
            finish();
        }
        else {
            Toast.makeText(this, "please double press the back button", Toast.LENGTH_SHORT).show();
        }
    }
}
