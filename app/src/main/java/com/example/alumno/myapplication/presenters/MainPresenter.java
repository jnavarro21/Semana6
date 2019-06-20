package com.example.alumno.myapplication.presenters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.alumno.myapplication.MainActivity;
import com.example.alumno.myapplication.R;
import com.example.alumno.myapplication.helpers.Callback;
import com.example.alumno.myapplication.helpers.MonitorObservable;
import com.example.alumno.myapplication.helpers.ObserverBind;
import com.example.alumno.myapplication.models.Cliente;

import java.util.Observable;

public class MainPresenter {
    Button btnEdad;
    public MonitorObservable monitorObservable;
    ObserverBind observerBind;
    public MainPresenter(final Context _context, final Cliente clienteObject, final Button btnEdad){
        /* Aqui bindeamos un objeto con un observador */
        monitorObservable = new MonitorObservable(clienteObject);
        observerBind = new ObserverBind();
        observerBind.setCallback(new Callback(){
            @Override
            public void doThis(Observable o, Object x) {
                //Todo lo que yo quiera
                Log.v("bichito", "xxx");
                Toast.makeText(_context, clienteObject.getYear_old()+"", Toast.LENGTH_SHORT).show();
                btnEdad.setBackgroundColor(Color.parseColor("#bc647d"));
            }
        });
        monitorObservable.addObserver(observerBind);
    }
}
