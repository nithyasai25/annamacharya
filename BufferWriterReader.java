import java.io.*;
class BufferWriterReader{
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
            bw.write("FirstLine");
            bw.newLine();
            bw.write("secondLine");
            bw.close();
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
        }
    }
}
