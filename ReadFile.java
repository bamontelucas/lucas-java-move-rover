import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ReadFile {
    private BufferedReader b;

    public ReadFile(String path) throws FileNotFoundException{
        b = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
    }
    
    public String get() throws IOException{
        String s;
        if((s = b.readLine()) == null) {
            b.close();
        }
        return s;
    }

    public void close() throws IOException{
        b.close();
    }
}