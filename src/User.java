public class User implements Playable{
    private String name;
    private int ID;
    private Playlist playlist;

    public User(String newName, int newID){
        name = newName;
        ID = newID;
        playlist = new Playlist();
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return ID;
    }

    public Playlist getPlaylist(){
        return playlist;
    }

    public boolean add(String type, String name, String artist, int duration, double rate){
        if(type.equals("V")){
            playlist.add(new Video(name,artist,duration,rate));
            return true;
        }
        else if (type.equals("A")){
            playlist.add(new Audio(name,artist,duration,rate));
            return true;
        }
        else{
            return false;
        }
    }

    public boolean add(String File){
        return playlist.add(File);
    }

    public void add(Playlist otherPlaylist){
        playlist.add(otherPlaylist);
    }

    public boolean remove(String name){
        return playlist.removeRecording(name);
    }

    public boolean remove(int index){
        return playlist.removeRecording(index);
    }

    public void play(String name){
        try{
            playlist.play(name);
        }catch(Unplayable ex){
            System.out.println(ex.getMessage());
        }
        
    }

    public void play(int index){
        try{
            playlist.play(index);
        }catch(Unplayable ex){
            System.out.println(ex.getMessage());
        }
    }

    public void play(){
        try{
            playlist.play();
        }catch(Unplayable ex){
            System.out.println(ex.getMessage());
        }
    }

    public void shuffle(){
        try{
            playlist.shuffle();
        }catch(Unplayable ex){
            System.out.println(ex.getMessage());
        }
    }

    public boolean export(){
        return playlist.save(name);
    }

    public void stats(){
        System.out.println("Username:" + name);
        System.out.println("ID:" + ID);
        System.out.println("Playlist details:");
        playlist.stats();
    }
}
