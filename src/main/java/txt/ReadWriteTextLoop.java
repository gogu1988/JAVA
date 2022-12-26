package txt;

import org.testng.annotations.Test;

import java.io.*;

public class ReadWriteTextLoop {

    @Test
    public void readTextFile() throws IOException {

        for (int i = 1; i <=26 ; i++) {
            if (i==25)
                continue;
            File file = new File("C:\\Users\\govreddy\\IdeaProjects\\JAVA\\src\\test\\resources\\transScript\\"+i+".txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter fw = new BufferedWriter(new FileWriter(i+"_Updated.txt"));

            String st;

            while ((st = br.readLine()) != null) {
                if(st.contains("."))
                    st=st.replace(".", ". ");
                fw.append(st);
            }
            fw.flush();
            fw.close();
        }





    }
}
