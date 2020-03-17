import java.io.*;
import java.util.*;
import java.net.URL;
import java.nio.file.Paths;

class Journal{
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;
    public void addEntry(String text){
        entries.add(""+(count++)+" : "+text);
    }
    public void removeEntry(int index){
        entries.remove(index);
    }


    @Override
    public String toString(){
        return String.join(System.lineSeparator(),entries);
    }

    /* Here, we are implementing a multiple functions that are related to this class but makes the class more baggy and prevents --> (S)OLID  <---.
    IDEA - we can implement 'persistent' in a seperate class which saves the data into a seperate file*/
    public void loadIntoFile(String filename){ }
    public void loadFromFile(URL url) { }

}
/* This is the solution for the above problem. Seperation of concerns*/
class Persistence{
    public void saveToFile(Journal journal,String fileName, boolean overwrite) throws FileNotFoundException{
        if(overwrite || new File(fileName).exists()){
            try(PrintStream out = new PrintStream(fileName)){
                out.println(journal.toString());
            }
            catch(FileNotFoundException e){
                System.out.println(e);
            }
        }
    }
    public void loadFile(String fileName){ }
    public void loadWeb(URL url){ }

}


class S {
    public static void main(String[] args) throws Exception{
        Journal j = new Journal();
        j.addEntry("I am angry today");
        j.addEntry("I hate bugs");
        System.out.println(j);
        Persistence p = new Persistence();
        String currDir = Paths.get("").toAbsolutePath().toString();
        System.out.println(currDir);
        String fileName = currDir+"\\SOLID\\S\\journal.txt";
        p.saveToFile(j, fileName, true);
    }
}