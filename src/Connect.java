import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by amandajonsson on 17-12-08.
 */
public class Connect {

    private static final  String key2 = "c3f919ad177f72a864a6924fc0f72070";

    public void APIConnection(String cityID){
        //String cityId = "1269750";
        //String cityLondon = "2643743";
        //String Rich = "2154855";

        String query = "http://api.openweathermap.org/data/2.5/weather?id=" + cityID + "&units=metric" + "&mode=xml" + "&APPID=" + key2;

        query = query.replace(" ", "%20");
        try
        {
            // Turn the string into a URL object
            URL urlObject = new URL(query);
            // Open the stream (which returns an InputStream):
            InputStream in = urlObject.openStream();
            XMLReader xr = XMLReaderFactory.createXMLReader();
            WeatherHandler handler = new WeatherHandler();
            xr.setContentHandler(handler);
            InputSource inSource = new InputSource(in);
            xr.parse(inSource);

        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();

        }
    }


    }


