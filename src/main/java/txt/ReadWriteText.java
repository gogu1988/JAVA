package txt;

import org.testng.annotations.Test;

import java.io.*;

public class ReadWriteText {

    @Test
    public void readTextFile() throws IOException {

        File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\URLs.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        BufferedWriter fw = new BufferedWriter(new FileWriter("UpdatedURLs.txt"));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {
            fw.append((st.split("<loc>", 2)[1]).split("</loc>")[0]);
            fw.newLine();
        }

        fw.flush();
        fw.close();

    }
}
