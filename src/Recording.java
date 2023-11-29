public abstract class Recording implements Playable{
    
    //creating variables with final declaration so they can't be changed
    protected final String ARTIST;
    protected final String NAME ;
    protected final int DURATION_IN_SECONDS;
    protected int timesPlayed = 0;
    
    //creating consturcotr with no arguments sent in
    public Recording()
    {
        //setting the variables to unknown or 0
        ARTIST = "Unknown";
        NAME = "Unknown";
        DURATION_IN_SECONDS = 0;
    }
    
    //creating constructor that sends in the artist, song name, and number of seconds
    public Recording(String Name, String Artist, int Seconds)
    { 
        //checking that artist is not null and if not then setting it to the value entered
        if(Artist != null)
        {
            ARTIST = Artist;
        }
        //else making it unknown
        else
        {
            ARTIST = "unknown";
        }
        //checking to see if the name is null and if not setting to the sent in name
        if(Name != null)
        {
            NAME = Name;
        }
        //else make it unknown
        else
        {
            NAME = "unknown";
        }
        //making sure seconds is not negative or less than 0 and then  it in
        if(Seconds > 0)
        {
            DURATION_IN_SECONDS = Seconds; 
        }
        //else make it 0
        else
        {
            DURATION_IN_SECONDS = 0;
        }
        
        
    }
    abstract
    public void play() throws Unplayable;
    abstract
    public String toString();
}
