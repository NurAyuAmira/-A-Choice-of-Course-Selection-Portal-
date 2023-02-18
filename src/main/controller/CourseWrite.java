//Authors: Engku Faiz Naqiuddin & Daniel Imtiyaz
package controller;
import model.CourseStore;
import org.json.JSONObject;
import java.io.*;
//Represents a writer that writes JSON representation of Courses to file.
public class CourseWrite
{
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    //Constructs writer to write to destination file
    public CourseWrite(String destination)
    {
        this.destination = destination;
    }

    //Opens writer; throws FileNotFoundException if destination file cannot be opened for writing
    public void open() throws FileNotFoundException
    {
        writer = new PrintWriter(new File(destination));
    }

    //Writes JSON representation of Courses to file
    public void write(CourseStore c)
    {
        JSONObject json = c.toJson();
        saveToFile(json.toString(TAB));
    }

    //Closes writer
    public void close()
    {
        writer.close();
    }

    //Writes string to file
    private void saveToFile(String json)
    {
        writer.print(json);
    }


}
