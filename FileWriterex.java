import java.io.*;
public class FileWriterex{
	public static void main (String[]args)  throws IOException{
  FileWriter writer= new FileWriter("output.txt");
writer.write("Hello, Java FileWriter!");
writer.close();
FileReader reader= new FileReader("output.txt");
int ch;
while((ch=reader.read())!=-1){
	System.out.print((char)ch);
}
reader.close();
	}
}
