import controllers.WeatherController;
import model.WeatherModel;
import views.WeatherView;

/**
 * Created by Mirel on 30.11.2014.
 */
public class WeatherMain {

    public static void main(String[] args) {
        // Instantiate the MVC elements
        WeatherModel model = new WeatherModel();
        WeatherView view = new WeatherView();
        WeatherController controller = new WeatherController();

        //Attach the view to the model
        model.addModelListener(view);

        //Tell the view about the model and the controller
        view.addModel(model);
        view.addController(controller);

        //Tell the controller about the model and the view
        controller.addModel(model);
        controller.addView(view);

        //Display the view
        view.setVisible(true);
    }
}
