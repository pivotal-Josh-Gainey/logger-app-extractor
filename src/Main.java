import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Read all comments

//download the application logs from Metrics and put in the assets folder with the name logs.log

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        //reference the logs
        File file = new File("assets/lab5.log");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //parse the log line by line and extract the number beside the keyword
        if(scanner.hasNext()){
            do{
                String line = scanner.nextLine();

                //Put in the keyword here that is sent to the tracking_app app
                String targetWord = "test5";

                int start = line.indexOf(targetWord);
                int lineLength = line.length();

                if(start>0){
                    String wordToChop = line.substring(start,lineLength);
                    int countNumber = Integer.parseInt(wordToChop.substring(wordToChop.indexOf(",") + 1,wordToChop.length()-1));
                    System.out.println("found" + countNumber );
                    if(!list.contains(countNumber)){
                        list.add(countNumber);
                    }
                }
            }while(scanner.hasNextLine());

        }

        //Sort the list in ascending order
        System.out.println("Sorting now...");
        Collections.sort(list);

        //Find the missing values.
        System.out.println("Finding missing values...");

        int topnum = list.get(list.size()-1);

        System.out.println("List size " + + list.size());
        System.out.println("First " + list.get(0));
        System.out.println("Last " + topnum);

        for(int i = list.get(0); i< topnum; i++){
            if(!list.contains(i)){
                System.out.println("Missing " + i);
            }
        }
    }


}
