import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by amandajonsson on 17-12-06.
 */

public class Main implements ActionListener{

    String city;
    JTextField text;

    JTextArea textarea;

    public Main(){


        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        JPanel frame= new JPanel();
        JLabel cityName = new JLabel();
        cityName.setText("Enter a cityID : ");
        frame.add(cityName);
        cityName.setLocation(20, 380);


        frame1.add(frame);
        frame1.setSize(400, 400);
        text = new JTextField(20);
        frame.add(text);
        frame1.setVisible(true);
        text.addActionListener(this);

        textarea= new JTextArea();

        textarea.setSize(400, 200);
        textarea.setLocation(0, 0);

        frame.add(textarea);
        frame.validate();
    }

    private void submitAction() {
        city = text.getText();
        System.out.println(city);
        Connect view = new Connect();
        view.APIConnection(city);
        WeatherHandler wh = new WeatherHandler();
        String ne = wh.cityID;
        String name = wh.cityName;
        String temp = wh.temperature;
        String mintemp = wh.minTemp;
        String maxtemp = wh.maxTemp;
        String wind = wh.windValue;
        String winddir = wh.windName;
        String clouds= wh.clouds;
        String weather = wh.weather;

        String print = "City ID:" + ne + '\n' + "City name: " + name + '\n' + "Temperature: " + temp + '\n' + "Min temp: " + mintemp + '\n' + "Max temp: " + maxtemp + '\n'+ "Wind: "+ wind + '\n'+
                "Wind direction: " + winddir + '\n' + "Clouds: "+ clouds + '\n' + "Weather: "+ weather;

        textarea.setText(print);

    }


    public static void main(String [] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        submitAction();

    }
}


