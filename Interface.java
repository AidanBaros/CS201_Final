
public class Interface
{

    int state = 0;

    public Interface(int state)
    {
        this.state  = state;
    }

    public void setState(int state)
    {
        this.state = state;
    }
    
    public int getState()
    {
        return this.state;
    }

    public void choose(int state)
    {
        if(state == 0){
            System.out.println("This the music player");
            System.out.println("Options List");
            System.out.println("1 : Add User");
            System.out.println("2: Remove User");
            System.out.println("3: List Users");
            System.out.println("4: Choose User");
        }

        if(state == 1)
        {
            UserInterface user = new UserInterface();
            user.add("No clue what I'm doing");
        }

        if(state == 2)
        {
            System.out.println("this will remove a user");
        }

        if(state == 3)
        {
            System.out.println("This should print the user list, need to be doing user dot list users");
        }

        if(state == 4)
        {
            System.out.println("Literally no clue how to do this outside the main");
        }
        
    }
}