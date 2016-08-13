import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class WriteFile {
    private BufferedWriter b;

    public WriteFile(String path) throws FileNotFoundException{
        b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path))));
    }
    
    public void set(String s) throws IOException{
        b.write(s);
        b.newLine();
    }

    public void close() throws IOException{
        b.close();
    }
}