package com.example.runnable_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btnbasla,btnbitir;
    int number;
    Runnable runnable; //belirli bir işi belirlenen periyotta yapmamızı sağlar.
    Handler handler; //ele almak, yönetmek, runnable ve message ile çalışmamızı sağlar.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv);
        btnbasla=findViewById(R.id.btnbasla);
        btnbitir=findViewById(R.id.btnbitir);
    }
    public void start(View v){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                //run methodunda yazılan herşey belirlenen süreçte işlenecek.
                textView.setText("Süre: "+number);
                number++;
                textView.setText("Süre: "+number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        btnbasla.setEnabled(false); //bu fonk. sayesinde btnbasla butonuna sadece bir kez tıklayabiliyoruz.

    }
    public void finish(View v){
        btnbasla.setEnabled(true); //yukarıda kapattığımız butonu burda tekrar tıklanabilir hale getiriyoruz.
        handler.removeCallbacks(runnable); //runnable'i kapattık.
        number=0;
        textView.setText("Süre");

    }
}