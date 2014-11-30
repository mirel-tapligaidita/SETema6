package views;

import interfaces.IController;
import interfaces.IModelListener;
import interfaces.IView;
import model.WeatherModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mirel on 30.11.2014.
 */
public class WeatherView extends JFrame implements IModelListener, IView{

    private JButton mRefreshBtn = new JButton("Refresh");
    private JTextField mTemperatureTxtF = new JTextField("Temperature");
    private JTextField mWindSpeedTxtF = new JTextField("Wind Speed");

    private IController mWeatherController;
    private WeatherModel mModel;


    public WeatherView() {

        mTemperatureTxtF.setEditable(false);
        mWindSpeedTxtF.setEditable(false);

        //Layout the components
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Temperature"));
        content.add(mTemperatureTxtF);
        content.add(new JLabel("Wind Speed"));
        content.add(mWindSpeedTxtF);
        content.add(mRefreshBtn);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Weather");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addModel(WeatherModel model) {
        mModel = model;
    }

    public void addController(IController controller){
        mRefreshBtn.setActionCommand(IController.ACTION_REFRESH);
        mRefreshBtn.addActionListener(controller);
    }

    @Override
    public void onMessage(boolean isError, String message) {

    }

    @Override
    public void onUpdate() {
        mTemperatureTxtF.setText(mModel.getmTemperature());
        mWindSpeedTxtF.setText(mModel.getmWindSpeed());
    }
}
