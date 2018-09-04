package us.mattgreen;


import java.io.*;
import java.util.*;
/**
 * The run class of the animals project
 * @author Matt Green
 * @version 1.0.0
 */

public class Main {

    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");
    public static void main(String[] args) throws Exception {

        ArrayList<Talkable> zoo = new ArrayList<>();

        zoo.add(addDog());
        zoo.add(addCat());
        zoo.add(addStudent());

        for (Talkable thing: zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();
        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    /**
     * A method to print the name and sound made of a Talkable to the console and write them to a file
     * @param p the Talkable for the operation to be ran on
     */
    public static void printOut(Talkable p)  {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
    }

    public static Cat addCat() throws Exception {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(inStream);
        int miceKilled;

        System.out.println("What is the name of the cat?");

        String name = inStream.readLine();

        System.out.println("How many mice has the cat killed?");

        try {
             miceKilled = scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("Invalid input: please enter an integer");
        }

        return new Cat(miceKilled, name);
    }

    public static Student addStudent() throws Exception {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(inStream);
        int age;

        System.out.println("What is the name of the Student?");

        String name = inStream.readLine();

        System.out.println("How old is the student?");

        try {
            age = scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("Invalid input: please enter an integer");
        }

        return new Student(age, name);
    }

    public static Dog addDog() throws Exception {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(inStream);
        boolean isFriendly;

        System.out.println("What is the name of the dog?");

        String name = inStream.readLine();

        System.out.println("Is the dog friendly?(true/false)");

        try {
            isFriendly = scanner.nextBoolean();
        } catch (Exception e) {
            throw new Exception("Invalid input: please enter true or False");
        }

        return new Dog(isFriendly, name);
    }
}
