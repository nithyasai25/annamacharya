import java.io.*;
import java.util.Scanner;
public class scanner{
	public static void main(String[]args)throws IOException{
            Scanner sc = new Scanner(new File("data.txt"));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        }
    }
