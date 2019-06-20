package com.example.alumno.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alumno.myapplication.helpers.Callback;
import com.example.alumno.myapplication.helpers.MonitorObservable;
import com.example.alumno.myapplication.helpers.ObserverBind;
import com.example.alumno.myapplication.models.Cliente;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {
    Button btnEdad;
    MonitorObservable monitorObservable;
    ObserverBind observerBind;
    Cliente clienteObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clienteObject = new Cliente();
        clienteObject.setYear_old(19);
        /* Aqui bindeamos un objeto con un observador */
        monitorObservable = new MonitorObservable(clienteObject);
        observerBind = new ObserverBind();
        observerBind.setCallback(new Callback(){
            @Override
            public void doThis(Observable o, Object x) {
                //Todo lo que yo quiera
                Log.v("bichito", "xxx");
                Toast.makeText(MainActivity.this, "Vamos..!!!", Toast.LENGTH_SHORT).show();
                btnEdad.setBackgroundColor(Color.parseColor("#bc647d"));
            }
        });
        monitorObservable.addObserver(observerBind);

        btnEdad=(Button)findViewById(R.id.btnEdad);
        btnEdad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clienteObject.setYear_old(clienteObject.getYear_old() +1);
                monitorObservable.setWachedValue(clienteObject);
            }
        });
    }
}
