import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by amandajonsson on 17-12-06.
 */

public class Main implements ActionListener{

    String city;
    JTextField cityID;
    JTextArea weatherInfo;

    public Main(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel enterACityID = new JLabel();
        enterACityID.setText("Enter a cityID : ");
        panel.add(enterACityID);
        enterACityID.setLocation(20, 380);


        cityID = new JTextField(20);
        panel.add(cityID);
        cityID.addActionListener(this);

        weatherInfo= new JTextArea();
        weatherInfo.setSize(400, 200);
        weatherInfo.setLocation(0, 0);

        panel.add(weatherInfo);
        panel.validate();

        frame.setVisible(true);

    }

    private void submitAction() {
        city = cityID.getText();
        System.out.println(city);
        Connect view = new Connect();
        view.APIConnection(city);
        WeatherHandler wh = new WeatherHandler();

        String print = "City ID:" + wh.cityID + '\n' + "City name: " + wh.cityName + '\n' + "Temperature: " + wh.temperature + '\n' + "Min temp: " + wh.minTemp + '\n' + "Max temp: " + wh.maxTemp + '\n'+ "Wind: "+ wh.windValue + '\n'+
                "Wind direction: " + wh.windName + '\n' + "Clouds: "+ wh.clouds + '\n' + "Weather: "+ wh.weather;

        weatherInfo.setText(print);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        submitAction();

    }
    public static void main(String [] args) {
        new Main();
    }

}


