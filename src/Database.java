import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Database {
    protected ArrayList<User> listofUsers;
    private static int IDcounter = 0;
    Scanner keyboard = new Scanner(System.in);

    public Database(){
        listofUsers = new ArrayList<User>();
    }

    // adds a new user to the database
    public boolean add(String name){
        if(name != null){
            listofUsers.add(new User(name,IDcounter++));
            return true; // returns true if it was able to add a user to the database
        }
        else{
            return false; //returns false if it did not add the user to the data base
        }
    }

    // removes a user from the database based on the users name
    public boolean remove(String name){
        // This needs to have an interface with it so that you can see the playlist assocated to the name so that is there is the same name twice you can chose with name to delete
        // done
        ArrayList <User> usersWithName = new ArrayList<User>();
        for (User user:listofUsers){
            if (user.getName().equals(name)){
                usersWithName.add(user);
            }
        }
        if (usersWithName.size() == 0){
            System.out.println("No User by that name");
            return false;
        }
        else if (usersWithName.size() == 1){
            if (confirmCancel()){
                    listofUsers.remove(usersWithName.get(0));
                }
            return true;
        }
        else{
            System.out.println("Which user would you like to remove? ");
            int counter = 1;
            for (User user:usersWithName){
                System.out.println("\n[" + counter++ + "]: ");
                user.stats();
            }
            System.out.print(" -- ");
            try{
                int whichUser = keyboard.nextInt();
                if (confirmCancel()){
                    listofUsers.remove(usersWithName.get(whichUser - 1));
                }
                return true;
            }catch(InputMismatchException ex){
                System.out.println("Not an option");
                return false;
            }
        }
    }

    // removes a user from the database based on their ID
    public boolean remove(int ID){
        for (User user:listofUsers){
            if (user.getID() == ID){
                listofUsers.remove(user);
                return true; // returns true if it succsesfuly removed a user
            }
        }
        System.out.println("Not an option");
        return false; // returns false if it did not remove a user
    }

    private boolean confirmCancel(){
        System.out.println("[1] Conferm\n[2] Cancel");
        int check = keyboard.nextInt();
        if (check == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
