import java.util.ArrayList;

public class Database {
    protected ArrayList<User> listofUsers;

    public Database(){
        listofUsers = new ArrayList<User>();
    }

    public boolean addUser(String name){
        // need to ask the prof about how to create IDs with static again
        if(name != null){
            listofUsers.add(new User(name,1));
            return true;
        }
        //else making it unknown
        else{
            return false;
        }
    }

    public boolean removeUser(String name){
        // This needs to have an interface with it so that you can see the playlist assocated to the name so that is there is the same name twice you can chose with name to delete
        
        return true;
    }

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
