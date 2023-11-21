
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
    }