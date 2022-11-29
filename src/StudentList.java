//File Name StudentList.java

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) throws IOException {
        String r = "";
        BufferedReader s = null;
        try {
            s = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")));
            r = s.readLine();
        } catch (Exception e) {
            System.out.println("File not found");
        }
//		Check arguments
        if (args.length == 0) {
            System.out.println("input de beta age");
        } else if (args[0].equals("a")) {
            System.out.println(AllString.loadedData);
            String i[] = r.split(", ");
            for (String j : i) {
                System.out.println(j);
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            String i[] = r.split(", ");
            System.out.println(i[new Random().nextInt(i.length)]);
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter rw = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String t = args[0].substring(1);
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                rw.write(", " + t + "\nList last updated on " + dateFormat.format(new Date()));
                rw.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            String i[] = r.split(",");
            boolean done = false;
            String t = args[0].substring(1);
            for (int idx = 0; idx < i.length && !done; idx++) {
                if (i[idx].equals(t)) {
                    System.out.println("We found it!");
                    done = true;
                }
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            String D = s.readLine();
            char a[] = D.toCharArray();
            boolean in_word = false;
            int count = 1;
            for (char c : a) {
                if (c == ' ') {
                    count++;
                }
            }
            System.out.println(count + " word(s) found " + a.length);
            System.out.println("Data Loaded.");
        } else {
            System.out.println("Invalid argument pass from rayhan and farhan");
        }
    }
}