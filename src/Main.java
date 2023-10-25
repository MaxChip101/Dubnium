package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
                func.name = tokens[1];
                if (tokens[2].contains("|")) {
                    ArrayList<String[]> args = new ArrayList<>();
                    String[] tempArgsArray = new String[2];
                    int argindx = 0;
                    for (int arg = 3; arg < tokens.length; arg++) {
                        if (tokens[arg].contains(",")) {
                            args.add(new String[] {tempArgsArray[0], tempArgsArray[1]});
                            argindx = 0;
                        } else if (tokens[arg].contains(":")) {
                            args.add(new String[] {tempArgsArray[0], tempArgsArray[1]});
                        } else {
                            tempArgsArray[argindx] = tokens[arg];
                            argindx++;
                        }
                    }
                    func.args = args.toArray(new String[args.size()][]);
                    System.out.println(Arrays.toString(func.args[0]));
                    System.out.println(Arrays.toString(func.args[1]));
                }
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