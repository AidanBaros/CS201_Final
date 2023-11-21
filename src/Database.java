import java.util.ArrayList;

public class Database {
    protected ArrayList<User> listofUsers;
    private static int IDcounter = 0;

    public Database(){
        listofUsers = new ArrayList<User>();
    }

    // adds a new user to the database
    public boolean addUser(String name){
        if(name != null){
            listofUsers.add(new User(name,IDcounter++));
            return true; // returns true if it was able to add a user to the database
        }
        else{
            return false; //returns false if it did not add the user to the data base
        }
    }

    // removes a user from the database based on the users name
    public boolean removeUser(String name){
        // This needs to have an interface with it so that you can see the playlist assocated to the name so that is there is the same name twice you can chose with name to delete
        
        return true;
    }

    // removes a user from the database based on theie ID
    public boolean removeUser(int ID){
        for (User user:listofUsers){
            if (user.ID == ID){
                listofUsers.remove(user);
                return true; // returns true if it succsesfuly removed a user
            }
        }
        return false; // returns false if it did not remove a user
    }
}
