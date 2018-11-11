import java.util.*;
import java.io.*;

public class Searcher {

  private static String filepath = null;

  //private static String filepath = "/";
  //C:\\Users\\3 Embed\\Desktop\\EzeTap\\Files_Search_RD\\sample_text

  private static final String defaultPath = "C:\\Users\\3 Embed\\Desktop\\EzeTap\\Files_Search_RD\\sample_text";

  private Searcher() {
    this.filepath = defaultPath;
  }

  private Searcher(String dir) {
    if (dir.isEmpty()) {
      this.filepath = defaultPath;
    } else {
      this.filepath = dir;
    }
  }

  public static void main(String[] args) throws IOException {
    Searcher search = new Searcher();

    String toSearch="";

    String folderToSearch = search.filepath;

    System.out.println("Folder name "+folderToSearch);

    File folder = new File(folderToSearch);
    Set<File> list = new HashSet<File>();
    search.getFiles(folder, list);

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
			System.out.println("Input the String to Search:  ");
			
			try {

            toSearch = br.readLine();

		//System.out.println("Searching in 4 files: "+searchFiles(input));
			} catch(Exception e) {
				e.printStackTrace();
			}
	
	//Print Set elements
	Iterator iter = list.iterator();
	while (iter.hasNext()) {
	    System.out.println(iter.next());
	}

    for (File file : list) {
     BruteForceSearch bSerch = new BruteForceSearch(file);
     bSerch.search(toSearch);
    }
  }

  private void getFiles(File folder, Set<File> list) {

    folder.setReadOnly();
    File[] files = folder.listFiles();
	System.out.println("Files length inside folder "+files.length);
    for (int j = 0; j < files.length; j++) {
      list.add(files[j]);
      if (files[j].isDirectory())
        getFiles(files[j], list);
    }
  }

}