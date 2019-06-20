package com.example.alumno.myapplication.helpers;

import com.example.alumno.myapplication.models.Cliente;

import java.util.Observable;

public class MonitorObservable extends Observable {
    Cliente wachedValue;
    public MonitorObservable(Cliente o){
        this.wachedValue = o;
    }

    public void setWachedValue(Cliente o) {
        if (o != null && o.getYear_old() != this.wachedValue.getYear_old()) {
            this.wachedValue=o;
            setChanged();
            notifyObservers(o);
        }else{
            setChanged();
            notifyObservers();
        }
    }
}
