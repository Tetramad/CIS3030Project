import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {
    public static List<List<String>> readToList(String path) {
        List<List<String>> list = new ArrayList<List<String>>();
        File csv = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
            Charset.forName("UTF-8");
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] token = line.split(",");
                List<String> tempList = new ArrayList<String>(Arrays.asList(token));
                list.add(tempList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}


