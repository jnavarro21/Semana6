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
import com.example.alumno.myapplication.presenters.MainPresenter;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {
    Button btnEdad;
    MainPresenter mainPresenter;
    MonitorObservable monitorObservable;
    ObserverBind observerBind;
    Cliente clienteObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clienteObject = new Cliente();
        clienteObject.setYear_old(19);
        btnEdad=(Button)findViewById(R.id.btnEdad);
            mainPresenter = new MainPresenter(this, clienteObject, btnEdad);


        btnEdad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clienteObject.setYear_old(clienteObject.getYear_old() +1);
                mainPresenter.monitorObservable.setWachedValue(clienteObject);
            }
        });
    }
}
