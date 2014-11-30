package controllers;


import interfaces.IController;
import interfaces.IView;
import model.WeatherModel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Mirel on 30.11.2014.
 */
public class WeatherController implements IController {

    private WeatherModel mModel;
    private List<IView> mViews;

    public WeatherController() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACTION_REFRESH)){
            refreshWeather();
        }
    }

    public void refreshWeather() {
        int min=-10;
        int max=40;
        int max2=100;
        int min2=0;

        Random random= new Random();

        float temp= random.nextInt(max-min+1)+min;
        float ws=random.nextInt(max2-min2+1)+min2;
        mModel.setTemperatureAndWindSpeed(temp,ws);
    }

    public void addView(IView view) {
        if (mViews == null)
            mViews = new ArrayList<IView>();
        mViews.add(view);
    }

    public void addModel(WeatherModel model) {
        mModel = model;
    }

    private void notifyViews(boolean isError, String message){
        if (mViews != null && mViews.isEmpty()){
            for (IView view : mViews)
            {
                view.onMessage(isError,message);
            }
        }
    }


}

