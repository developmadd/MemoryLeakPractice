package com.madd.madd.memoryleakpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button buttonMLeak;
    CustomAsyncTask customAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.BTN_Activity_One);
        buttonMLeak = findViewById(R.id.BTN_Memory_Leak);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SecondaryActivity.class);
                startActivity(intent);
            }
        });
        Toast.makeText(this,"onCreate A1",Toast.LENGTH_LONG).show();

        buttonMLeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customAsyncTask!= null){
                    finish();
                }

                customAsyncTask = new CustomAsyncTask(MainActivity.this);
                customAsyncTask.execute();
            }
        });


    }




    private class CustomAsyncTask extends AsyncTask<Void,Void,Void>{

        Context context;

        public CustomAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }


    }

















    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart A1",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume A1",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause A1",Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart A1",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop A1",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy A1",Toast.LENGTH_LONG).show();
        customAsyncTask.cancel(true);
    }
}



