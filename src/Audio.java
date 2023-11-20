public class Audio extends Recording implements Play{
    
    //creates final double for the bitrate object
    private final double BITRATE;

    //audio recording constructor with no parameters that calls the super method and intializles bitrate to 0
    public Audio(){
        super();
        BITRATE = 0;
    }

    //audiorecoding constuructor with arguments of sendingArtist, sendingName, sending Seconds, and a new bitrate
    public Audio(String sendingArtist, String sendingName, int sendingSeconds, double newBitRate){
        //calls the super consctuor with sendingArtist, sendingName, and sendingSeconds
        super(sendingArtist, sendingName, sendingSeconds);
        //sets bitrate to value
        BITRATE = newBitRate;
    }

    //toString
    public void play(){
        
        //creates the minutes and seconds
        int minutes = 0;
        int rSeconds = 0;
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
            //returns null if somthing doesn't exist
            System.out.println("ERROR: cannot play this recording");
        }
    }

    //toString
    public String toString(){
        
        //creates the minutes and seconds
        int minutes = 0;
        int rSeconds = 0;
        //checking that duration is > 0, name is null, and artist is not null
        if(DURATION_IN_SECONDS > 0 && NAME != null && ARTIST != null)
        {
            minutes = DURATION_IN_SECONDS/60;
            rSeconds = DURATION_IN_SECONDS % 60;
            //returns the artist song name and minutes and seconds
            //Same thing as play without the now playing
            return (ARTIST + " - " + NAME + " [" + minutes + "m" + rSeconds + "s] [AUDIO | bitrate: " + BITRATE + " kbps]");
        }
        else
        {
            //returns null if somthing doesn't exist
            return ("ERROR: cannot play this recording");
        }
    }
}
