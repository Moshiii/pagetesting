import java.nio.file.Files;

public class SortPlace {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting sorting place...");
        SortPlace sortPlace = new SortPlace();
        sortPlace.sorting("PlaceCollector/localhost.log");
        System.out.println("Done!");
    }

    private void sorting(String filename) throws IOException {
        String text = reader(filename);
        writer("PlaceCollector/place.txt", text);
    }

    private String reader(String filename) throws IOException {
        String temp1 = "";
        String text = "";
        String line;
        String[] temp2;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        while ((line = br.readLine()) != null) {
            temp1 += line;
        }

        //need to change when start a new gathering season
        temp1 = temp1.replace(".html?_ijt=33j0l59q04m27u80mgdaleg561:49", "");

        temp2 = temp1.split("Collector ");

        for (int i = 1; i < temp2.length; i++) {
            text += temp2[i] + "\t\n";
        }

        return text;
    }

    private void writer(String filename, String text) throws IOException {
        File output = new File(filename);
        Files.deleteIfExists(output.toPath());

        PrintWriter pw = new PrintWriter(new FileWriter(output));
        pw.print(text);

        pw.flush();
        pw.close();
    }
}
