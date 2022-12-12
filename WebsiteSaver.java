package utilStuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebsiteSaver {

  public static void main(String[] args) {
    try {
      // Website-URL
      String website = "https://sked.lin.hs-osnabrueck.de/sked/grp/22DWF1-1.html";

      // Verbindung zur Website herstellen
      URL url = new URL(website);
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

      // Datei zum Speichern der Website erstellen
      FileWriter writer = new FileWriter("C:\\Users\\Bruns\\projekte\\java\\my-second-project\\src\\utilStuff\\example.html");
      System.out.println("Test");

      // Website-Daten zeilenweise lesen und in Datei schreiben
      String line;
      while ((line = reader.readLine()) != null) {
        writer.write(line);
        writer.write("\n");
      }
      writer.close();
      reader.close();
      ArrayList<String> courses = new ArrayList<>();
      File input = new File("C:\\Users\\Bruns\\projekte\\java\\my-second-project\\src\\utilStuff\\example.html");
      Document doc = Jsoup.parse(input, "UTF-8", "");
      Element table = doc.selectFirst("table");
      Elements rows = table.select("tr");
      for(int i = 0; i<rows.size();i++) {
    	  Element row = rows.get(i);
    	  Elements cols = row.select("td");
    	  courses.add(cols.text());
      }
    
      for(int i = 0; i<courses.size();i++) {
    	System.out.println(courses.get(i));  
      }
       
      FileWriter txtWriter = new FileWriter("C:\\Users\\Bruns\\Documents\\JavaStuff\\Stundenplan\\plan.txt");
      for(int i = 0; i<courses.size();i++) {
    	txtWriter.write(courses.get(i)+"\n");
      }
      txtWriter.close();
      File origF = new File("C:\\Users\\Bruns\\Documents\\JavaStuff\\Stundenplan\\Musterplan.txt");
      File newF = new File("C:\\Users\\Bruns\\Documents\\JavaStuff\\Stundenplan\\plan.txt");
      System.out.println("TexT");

      Scanner scanner1 = new Scanner(origF);
      Scanner scanner2 = new Scanner(newF);


      if (!scanner1.next().equals(scanner2.next())) {
          // Die beiden Dateien haben den gleichen Inhalt.
    	  System.out.println("Any Truers?");
      } else {
          // Die beiden Dateien haben unterschiedlichen Inhalt.
    	  System.out.println("Test");
      }


    } catch (Exception e) {
      System.out.println("Beim Speichern der Website ist ein Fehler aufgetreten: " + e.getMessage());
    }
  }
}

