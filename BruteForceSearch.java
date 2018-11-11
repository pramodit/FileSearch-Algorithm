import java.io.*;
import java.util.*;

public class BruteForceSearch implements WordSearch{

  private final String fileName;
  private Map<String, Integer> result =  new HashMap<String, Integer>();
  private File file;
  private int count =0;


  public BruteForceSearch(File file) throws IOException {
    this.file =  file;
    this.fileName = file.getName();
    this.count = 0;
  }

  private void searchBruteForce(String toSearch) throws IOException {

      FileInputStream fstream = new FileInputStream(file);
      BufferedReader in = new BufferedReader(new InputStreamReader(fstream));
      String readLine = "";
      while ((readLine = in.readLine()) != null) {
        String[] words = readLine.split("\\W");
        for (String text : words) {
          if (text.equalsIgnoreCase(toSearch)) {
            count++;
          }
        }
      }
      in.close();
  }

  public String getFile() {
    return fileName;
  }

  public int getCount(String word) {
    return count;
  }

  public void search(String toSearch) throws IOException {
    searchBruteForce(toSearch);
    if (getCount(toSearch) != 0) {
        System.out.println(getFile() + " - " + getCount(toSearch) + " matches ");   
    } 
  }
}
