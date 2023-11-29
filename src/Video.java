public class Video extends Recording{
    
    private final double FRAMERATE;

    // non-peramiterized non-defult constructor 
    // super of Recording witht the addition of framerate
    public Video(){
        super();
        FRAMERATE = 0;
    }
    
    //videorecording construcotr that sends in the artist, name, video length, and framereate
    public Video(String Name, String Artist, int Seconds, double FrameRate){
        //calls the super method and sends the artitst, name, and seconds
        super(Artist, Name, Seconds);
        //assigns framerate
        FRAMERATE = FrameRate;
    }

    public void play() throws Unplayable{
        
        //creates the minutes and seconds
        int minutes = 0;
        int rSeconds = 0;
        timesPlayed += 1;
        if(DURATION_IN_SECONDS > 0 && NAME != null && ARTIST != null)
        {
            minutes = DURATION_IN_SECONDS/60;
            rSeconds = DURATION_IN_SECONDS % 60;
            //returns the artist song name and minutes and seconds
            //Same thing as play without the now playing
            System.out.println(ARTIST + " - " + NAME + " [" + minutes + "m" + rSeconds + "s] [VIDEO | framerate: " + FRAMERATE + " fps]");
        }
        else
        {
            throw new Unplayable("Corupted Video Recording");
        }
    }

    public String toString(){
        return (ARTIST + " - " + NAME + " - " + timesPlayed);
    }
}
