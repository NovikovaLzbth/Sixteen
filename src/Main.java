import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main    {

    public static void main(String[] args) throws Exception {
        File file1 = new File("C:\\Users\\novik\\IdeaProjects\\sixteen\\file1.txt");
        File file2 = new File("C:\\Users\\novik\\IdeaProjects\\sixteen\\file2.txt");

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\novik\\IdeaProjects\\sixteen\\file1.txt")); FileWriter fw = new FileWriter("C:\\Users\\novik\\IdeaProjects\\sixteen\\file2.txt")) {
            String data = null;
            StringBuilder sb = new StringBuilder();
            Pattern p = Pattern.compile("(//[\\s\\S].*)|(/\\*[\\s\\S]*\\*/)");

            while ((data = br.readLine()) != null) {
                sb.append(data + "\n");
            }
            data = sb.toString();
            Matcher matcher = p.matcher(sb);
            data = matcher.replaceAll("");
            System.out.println("Файл успешно записан");
            fw.write(data);

        } catch (IOException ex) {
            System.out.println("Произошла ошибка: " + ex.getMessage());
        }

    }

}