import java.util.ArrayList;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

public class Playlist implements Play{
    ArrayList<Recording> listofRecordings;
    int runtime = 0;

    //constructor
    public Playlist(){
        listofRecordings = new ArrayList<Recording>();
    }

    // adds a single recording to the playlist
    public void addRecording (Recording newRecording){
        listofRecordings.add(newRecording);
        runtime += newRecording.DURATION_IN_SECONDS;
    }

    // adds multiple recordings to the playlist from a given file
    public boolean addMultipleRecordings (String File){
        try {
            File myFile = new File(File);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] listofData = data.split(",");
                try{
                    if (listofData[0].equals("V")){
                        listofRecordings.add(new Video(listofData[1], listofData[2], Integer.valueOf(listofData[3]), Double.valueOf(listofData[4])));
                    }
                    else{
                        listofRecordings.add(new Audio(listofData[1], listofData[2], Integer.valueOf(listofData[3]), Double.valueOf(listofData[4])));
                    }
                    runtime += Integer.valueOf(listofData[3]);
                }catch (NumberFormatException ex){
                    System.out.println("Corrupted data");
                }
            }
            myReader.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            return false;
        } 
    }

    // adds multiple recordings to the playlist from another users playlist
    public void addMultipleRecordings (Playlist otherPlaylist){
        for (Recording recording:otherPlaylist.listofRecordings){
            listofRecordings.add(recording);
            runtime += recording.DURATION_IN_SECONDS;
        }
    }

    // removes a recording from the playlist based on its name
    public boolean removeRecording (String name){
        for (Recording recording:listofRecordings){
            if (recording.NAME.equals(name)){
                listofRecordings.remove(recording);
                runtime -= recording.DURATION_IN_SECONDS;
                return true;
            }
        }
        return false;
    }

    // removes a recording from the playlist based on its index
    public boolean removeRecording (int index){
        try{
            runtime -= listofRecordings.get(index).DURATION_IN_SECONDS;
            listofRecordings.remove(index);
            return true;
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Your playlist is not that long.");
            return false;
        }
    }

    // plays a specific recording in the playlist based on the name
    public void playRecording (String name){
        for (Recording recording:listofRecordings){
            if (recording.NAME.equals(name)){
                recording.play();
            }
        }
    }

    // plays a specific recording in the playlist based on the index
    public void playRecording (int index){
        listofRecordings.get(index).play();
    }

    // plays the whole playlistindex
    public void play (){
        for (Recording recording:listofRecordings){
            recording.play();
        }
    }

    // randomly shuffles the recordings in the playlist
    public void shuffle (){
        Collections.shuffle(listofRecordings);
    }

    // saves the playlist to a .txt file
    public boolean save (){
        try {
            File myFile = new File("playlist.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(myFile);
            for (Recording recording:listofRecordings){
                myWriter.write(recording.toString());
            }
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

    // displays the stats of the playlist like how many recordings it contains the total play time and the info about each recording.
    public void stats(){
        int minutes = runtime/60;
        int seconds = runtime % 60;
        System.out.println("Nuber of recordings: " + listofRecordings.size());

        System.out.println("Duration: " + minutes + "m " + seconds + "s.");
        System.out.println("Recordings: ");
        for (Recording recording:listofRecordings){
            System.out.println(recording.toString());
        }
    }
}
