import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;

public class StreamingSystem {
    Scanner keyboard = new Scanner(System.in);
    String regex = "[0-9]+"; 
    Pattern p = Pattern.compile(regex); 
    boolean running;
    int choice;
    Database database = new Database();


    public void run(){
        running = true;
        mainMenu();
        
    }
    

    public void mainMenu(){
        while (running){
            System.out.println("Main menu:");
            System.out.println("[1] Add new user");
            System.out.println("[2] Remove user");
            System.out.println("[3] List all users");
            System.out.println("[4] User menu");
            System.out.println("[5] Exit");
            System.out.println("What is your choice?");
            choice = keyboard.nextInt();
            keyboard.nextLine();
            if(choice == 1){
                addUserMenu();
            }

            if(choice == 2){
                removeUserMenu();
            }

            if(choice == 3){
                listAllUsers();
            }

            if(choice == 4){
                userMenu();
            }

            if(choice == 5){
                running = false;
            }
        }
        
    }

    public void addUserMenu(){
        System.out.println("Enter a Username:");
        System.out.print(" -- ");
        String newUsername = keyboard.nextLine();
        System.out.println(newUsername);
        
        if (confirmCancel()){
            database.add(newUsername);
        }
    }

    public void removeUserMenu(){
        System.out.println("Enter a Username or User ID");
        String removeUser = keyboard.nextLine();

        if (removeUser == null) { 
            System.out.println("No User found");
        } 

        Matcher m = p.matcher(removeUser);

        if (m.matches()){
            int userID = Integer.parseInt(removeUser);
            if (confirmCancel()){
                database.remove(userID);
            }
        }
        else{
            String userName = removeUser;
            database.remove(userName);
        }
    }

    public void listAllUsers(){
        int counter = 1;
        for (User user:database.listofUsers){
                System.out.print("[" + counter++ + "]: ");
                System.out.println("Name: " + user.getName() + ", ID: " + user.getID());
            }
    }
    
    public void userMenu(){
        User currentUser;

        System.out.println("Select a User");
        listAllUsers();
        try{
            currentUser = database.listofUsers.get(keyboard.nextInt()-1);
        }catch(InputMismatchException ex){
            System.out.println("Not an option");
            return;
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Not an option");
            return;
        }
        

        System.out.println("User menu:");
        System.out.println("[1] Add recording");
        System.out.println("[2] Add playlist from file");
        System.out.println("[3] Add playlist from another user");
        System.out.println("[4] Remove recording from playlist");
        System.out.println("[5] Play individual recording");
        System.out.println("[6] Play entire playlist in order");
        System.out.println("[7] Play entire playlist shuffled");
        System.out.println("[8] Save playlist to a file");
        System.out.println("[9] Display user and playlist stats");
        System.out.println("[10] back to main menu");
        System.out.println("What is your choice?");
        try{
            choice = keyboard.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Not an option");
            return;
        }
        if(choice == 1){
            String type;
            String name;
            String artist;
            int duration;
            double rate;
            int choice2;
            try{
                System.out.println("What type of recording are you adding?");
                System.out.println("[1] Video");
                System.out.println("[2] Audio");
                choice2 = keyboard.nextInt();
                if (choice2 == 1){
                    type = "V";
                }
                else{
                    type = "A";
                }
                System.out.println("What is the name of the recording?");
                name = keyboard.nextLine();
                System.out.println("What is the name of the artist?");
                artist = keyboard.nextLine();
                System.out.println("What is the duration of the recording?");
                duration = keyboard.nextInt();
                System.out.println("What is the rate of the recording (FPS for Video, BPM for Audio)?");
                rate = keyboard.nextDouble();

                currentUser.add(type, name, artist, duration, rate);

            }catch(InputMismatchException ex){
                System.out.println("Not an option");
                return;
            }
        }

        if(choice == 2){
            System.out.println("Enter the full name of the file");
            currentUser.add(keyboard.nextLine());
        }

        if(choice == 3){
            System.out.println("Enter the ID of the user");
            try{
                int newID = keyboard.nextInt();
                for (User user:database.listofUsers){
                    if (newID == user.getID()){
                        currentUser.add(user.getPlaylist());
                    }
                }
            }catch(InputMismatchException ex){
                System.out.println("Not an option");
                return;
            }
            
        }

        if(choice == 4){
            System.out.println("Enter a song name or index position");
            String removeSong = keyboard.nextLine();

            if (removeSong == null) { 
                System.out.println("No song found");
            } 

            Matcher m = p.matcher(removeSong);

            if (m.matches()){
                int songIndex = Integer.parseInt(removeSong);
                if (confirmCancel()){
                    currentUser.remove(songIndex);
                }
            }
            else{
                String songName = removeSong;
                currentUser.remove(songName);
            }

        }
        
        if(choice == 5){
            System.out.println("Enter the name or inxed of the song you would like to play");
            String playSong = keyboard.nextLine();

            if (playSong == null) { 
                System.out.println("No song found");
            } 

            Matcher m = p.matcher(playSong);

            if (m.matches()){
                int songIndex = Integer.parseInt(playSong);
                if (confirmCancel()){
                    currentUser.play(songIndex);
                }
            }
            else{
                String songName = playSong;
                currentUser.play(songName);
            }

        }
        
        if(choice == 6){
            currentUser.play();
        }
        
        if(choice == 7){
            currentUser.shuffle();
        }
        
        if(choice == 8){
            currentUser.export();
        }
        
        if(choice == 9){
            currentUser.stats();
            
        }
        
        if(choice == 10){
            return;
        }
        
        else{
            System.out.println("Not an option");
            return;
        }
    }

    public void removeRecording(){
        System.out.println("Remove recording from playlist menu:");
        System.out.println("[1] Remove recording by id");
        System.out.println("[2] Remove recording by name");
        System.out.println("[3] Go back to previous menu");
        System.out.println("What is your choice?");
        choice = keyboard.nextInt();
    }

    public void recordingMenu(){
        System.out.println("Play individual recording menu:");
        System.out.println("[1] Play recording by id");
        System.out.println("[2] Play recording by name");
        System.out.println("[3] Go back to previous menu");
        System.out.println("What is your choice?");
        choice = keyboard.nextInt();

    }

    private boolean confirmCancel(){
        System.out.println("[1] Conferm\n[2] Cancel");
        int check = keyboard.nextInt();
        keyboard.nextLine();
        if (check == 1){
            return true;
        }
        else{
            return false;
        }
    }

}