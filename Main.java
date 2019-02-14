import java.util.*;
import java.lang.*;
import java.io.*;



class Monkey {
    private int towerNum;
    private ArrayDeque<Integer> height /*= new ArrayDeque<>()*/;
    private Stack<Integer> jumper /*= new Stack<Integer>()*/;
    private String again;
    private boolean Run = true;

    public Monkey() {
        while(Run){
            height = new ArrayDeque<>();
            jumper = new Stack<Integer>();
            int n;
            System.out.printf("Number of trees : ");
            Scanner getNum = new Scanner(System.in);
            do {
                while (!getNum.hasNextInt() /*|| getNum.nextInt() < 0*/) {
                    System.out.println("Please enter an integer!");
                    getNum.next(); // this is important!
                }
                towerNum = getNum.nextInt();
                if(towerNum < 0)System.out.println("Enter an positive integer");

            } while (towerNum < 0);

            for (int i = 0; i < towerNum; i++) {
                System.out.printf("     Tree Height (%d) = ", i + 1);
                Scanner getHeight = new Scanner(System.in);
                do {
                    while (!getHeight.hasNextInt() /*|| getHeight.nextInt() < 0*/ ) {
                        System.out.println("Please enter an integer!");
                        getHeight.next();// this is important!
                    }
                    n = getHeight.nextInt();
                    if(n < 0 ) System.out.println("Enter an positive integer");
                } while (n < 0);
                height.add(n);
            }
            System.out.print("\n");
            move();
            System.out.println("\nDo you want to run again? Enter yes to run again or anything else to end the program.");
            System.out.print("==> ");
            Scanner Conti = new Scanner(System.in);
            do {
                while (Conti.hasNextInt()) {
                    System.out.println("Please enter a string!");
                    Conti.next(); // this is important!\
                }
            } while (!Conti.hasNext());
            again = Conti.next();
            switch (again){
                case "Y" : True(); break;
                case "y":  True(); break;
                case "yes": True();break;
                default: False();break;
                            }
        }
        System.out.println("The program is done. Thanks for playing!");
    }

    public void move(){
        int n = height.peekLast(),count = 1,first,jump;
        while(!height.isEmpty()){  /// while array height is available
            first = height.peekFirst();
            if(!jumper.isEmpty() && jumper.peek() <= first)
            {  jump = jumper.pop();
                System.out.print("  " + count + "   From " + jump+ "-ft tree to " + first + "-ft tree\n");
                count++;
                continue; }
            first = height.pop();
            if(!height.isEmpty())   // is the value inside height array isn't null print the move step
            {   if (first > height.peekFirst())jumper.add(first);
                System.out.print("  " + count + "   From " + first + "-ft tree to " + height.peekFirst() + "-ft tree\n");
                count++; }
            else {
                break;
                }; // break the loop
        }
        System.out.printf("\nTotal swinging paths = " + (count-1));
    }

    public void True(){
        Run = true;
    }
    public void False(){
        Run = false;
    }
}


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        new Monkey();
    }
}
