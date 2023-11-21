public class UserInterface {
    int state = 0;

    public UserInterface(int state)
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
        if(state == 0)
        {
            System.out.println("This the user interface");
            System.out.println("Options List");
            System.out.println("1 : Add recording");
            System.out.println("2: Add playlist");
            System.out.println("3: Remove playlist");
            System.out.println("4: Shuffle playlist");
            System.out.println("5: Save playlist");
            System.out.println("6: Display playlist statistics");
        }
        
        if(state == 1)
        {
            System.out.println("Add song some how while also checking for different type sof song input");
        }

        if(state == 2)
        {
            System.out.println("Adds a playlist from a file or from a another user, but I don't know how");
        }

        if(state == 3)
        {
            System.out.println("Same things as state 2, but for removing songs");
        }


        if(state == 4)
        {
            System.out.println("Somehow calls the shuffle method based on the correct user");
        }

        if(state == 5)
        {
            System.out.println("Somehow saves playlist, this would be way easier in main and I would understand it");
        }

        if(state == 6)
        {
            System.out.println("Possibly will display the statistcs, porobaly do somthign like user.statics somehow");
        }
    }

}
