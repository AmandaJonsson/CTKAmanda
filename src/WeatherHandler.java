
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import java.util.ArrayList;

/**
 * Created by amandajonsson on 17-12-06.
 */
public class WeatherHandler extends DefaultHandler {

    static String cityID;
    static String cityName;
    static String temperature;
    static String minTemp;
    static String maxTemp;
    static String windValue;
    static String windName;
    static String clouds;
    static String weather;

    public WeatherHandler() {
        super();
    }

    @Override
    public void startDocument() {
        System.out.println("Start document");
    }


    @Override
    public void endDocument() {
        System.out.println("End document");
    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.compareTo("city") == 0) {
            cityID = attributes.getValue(0);
            System.out.println("City ID: " + cityID);
        }


        if (qName.compareTo("city") == 0) {
            cityName = attributes.getValue(1);
            System.out.println("City : " + cityName);
        }

        if (qName.compareTo("temperature") == 0) {
            temperature = attributes.getValue("value");
            System.out.println("Temperature: " + temperature);
        }

        if (qName.compareTo("temperature") == 0){
            minTemp = attributes.getValue(1);
            System.out.println("Min temp: " + minTemp);
        }

        if (qName.compareTo("temperature") == 0){
            maxTemp = attributes.getValue(2);
            System.out.println("Max temp: " + maxTemp);
        }

        if(qName.compareTo("speed")==0){
            windValue = attributes.getValue(0);
            System.out.println("Wind : " + windValue);
        }

        if(qName.compareTo("speed")==0){
            windName = attributes.getValue(1);
            System.out.println("Wind direction: " + windName);
        }


        if (qName.compareTo("clouds") == 0) {
            clouds = attributes.getValue(1);
            System.out.println("Clouds: " + clouds);

        }
        if (qName.compareTo("weather") == 0) {
            weather = attributes.getValue(1);
            System.out.println("Weather: " + weather);
        }


    }
}

