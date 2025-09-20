import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class ReadFile {
    public static void main(String[] ari){
        String path ="C:\\Users\\ariha\\Downloads\\text.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;

            while((line = reader.readLine()) != null){
                System.out.println(line);

            }

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("Something went wrong");
        }
    }
}
