public class User {
    protected String name;
    protected int ID;
    protected Playlist playlist;

    public User(String newName, int newID){
        name = newName;
        ID = newID;
        playlist = new Playlist();
    }

    public void addRecording(Recording newRecording){
        playlist.addRecording(newRecording);
    }

    public boolean addRecording(String type, String name, String artist, int duration, double rate){
        if(type.equals("V")){
            playlist.addRecording(new Video(name,artist,duration,rate));
            return true;
        }
        else if (type.equals("A")){
            playlist.addRecording(new Audio(name,artist,duration,rate));
            return true;
        }
        else{
            return false;
        }
    }

    public boolean importPlaylist(String File){
        return playlist.addMultipleRecordings(File);
    }

    public void copyPlaylist(Playlist otherPlaylist){
        playlist.addMultipleRecordings(otherPlaylist);
    }

    public boolean reomveRecording(String name){
        return playlist.removeRecording(name);
    }

    public boolean reomveRecording(int index){
        return playlist.removeRecording(index);
    }

    public void playRecording(String name){
        playlist.playRecording(name);
    }

    public void playRecording(int ID){
        playlist.playRecording(ID);
    }

    public void playPlaylist(){
        playlist.play();
    }

    public void shuffle(){
        playlist.shuffle();
    }

    public boolean exportPlaylist(){
        return playlist.save();
    }

    public void stats(){
        System.out.println("Username:" + name);
        System.out.println("ID:" + ID);
        System.out.println("Playlist details:" + name);
        playlist.stats();
    }
}
