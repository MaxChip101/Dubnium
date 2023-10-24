import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Interpreter settings
    static boolean verbose = true;


    // Interpreter Memory
    static Map<String, Object> memory;
    static Map<String, Variable> variables;

    static String[] src;

    public static void main(String[] args) {

        File folder = new File("./");
        File[] files = folder.listFiles();

        String filePath = "";
        for (File file : files) {
            if (file.getName().endsWith(".dbm")) {
                filePath = file.getName();
            }
        }

        src = ReadFile(filePath);
        if (src[0].contains("@ERR")) {
            Verbose.ThrowError("ERR: File does not exist or failed to load", true);
        }

        AddMemory(src);

    }

    public static String[] ReadFile(String file) {
        try {
            Scanner myReader = new Scanner(new File(file));

            ArrayList<String> data = new ArrayList<>();
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
            }
            myReader.close();
            return data.toArray(new String[data.size()]);
        } catch (FileNotFoundException e) {
            return new String[]{"@ERR"};
        }
    }

    public static void AddMemory(String[] src) {
        boolean inFunc = false;
        boolean inStr = false;

        int scope = 0;

        int scopeLayer = 0;

        for (int line = 0; line < src.length; line++) {
            String[] tokens = src[line].split(" ");

            if (tokens[0].contains("FN")) {
                Function func = new Function();

            }

        }
    }

    public static void Interpret(String[] src) {
        boolean inFunc = false;
        boolean inStr = false;

        for (int line = 0; line < src.length; line++) {
            String[] tokens = src[line].split(" ");

        }
    }

}

class STD {
    public void println(String string) {
        System.out.println(string);
    }
}