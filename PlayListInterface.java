public class PlayListInterface {
    int state = 0;

    public PlayListInterface(int state)
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
            System.out.println("1 : Add song");
            System.out.println("2: Remove song");
            System.out.println("3: Play");
            System.out.println("4: Shuffle");
            System.out.println("5: Save");
            System.out.println("6: Statistics");
        }

}
