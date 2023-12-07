public class Audio extends Recording{
    
    //creates final double for the bitrate object
    private final double BITRATE;  
    private final String TYPE;  

    //audio recording constructor with no parameters that calls the super method and intializles bitrate to 0
    public Audio(){
        super();
        BITRATE = 0;
        TYPE = "A";
    }

    //audiorecoding constuructor with arguments of Artist, Name,  Seconds, and a new bitrate
    public Audio(String Name, String Artist, int Seconds, double BitRate){
        //calls the super consctuor with Artist, Name, and Seconds
        super(Name, Artist, Seconds);
        //sets bitrate to value
        BITRATE = BitRate;
        TYPE = "A";
    }

    public double getRate(){
        return BITRATE;
    }

    public String getType(){
        return TYPE;
    }

    //toString
    public void play() throws Unplayable{
        
        //creates the minutes and seconds
        int minutes = 0;
        int rSeconds = 0;
        timesPlayed += 1;
        //checking that duration is > 0, name is null, and artist is not null
        if(DURATION_IN_SECONDS > 0 && NAME != null && ARTIST != null)
        {
            minutes = DURATION_IN_SECONDS/60;
            rSeconds = DURATION_IN_SECONDS % 60;
            //returns the artist song name and minutes and seconds
            //Same thing as play without the now playing
            System.out.println(ARTIST + " - " + NAME + " [" + minutes + "m" + rSeconds + "s] [AUDIO | bitrate: " + BITRATE + " kbps]");
        }
        else
        {
            throw new Unplayable("Corupted Audio Recording");
        }
    }

    //toString
    public String toString(){
        return (ARTIST + " - " + NAME + " - " + timesPlayed);
    }
}
