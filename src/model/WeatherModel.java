package model;

import interfaces.IModelListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mirel on 30.11.2014.
 */
public class WeatherModel {

    private Float mTemperature;
    private Float mWindSpeed;

    private List<IModelListener> mListeners;

    public String getmTemperature() {
        return Float.toString(mTemperature);
    }

    public String getmWindSpeed() {
        return Float.toString(mWindSpeed);
    }

    public void setTemperatureAndWindSpeed(Float temperature,Float windSpeed) {
        this.mTemperature = temperature;
        this.mWindSpeed= windSpeed;
        notifyListeners();

    }



    public WeatherModel(){

    }

    public void addModelListener(IModelListener listener){
        if (mListeners == null)
            mListeners = new ArrayList<IModelListener>();
        mListeners.add(listener);
    }

    private void notifyListeners(){
        if (mListeners != null && !mListeners.isEmpty())
            for (IModelListener listener : mListeners)
                listener.onUpdate();
    }
}
