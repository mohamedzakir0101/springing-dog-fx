package sons.mamoun;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Player {

    private String id;
   private  String name ;
   private String country;
   private String color;

   private PlayerLinks _links;

    static final public String WAITING_ROOM = "waiting_room";
    static final public String PLAYING = "playing";
    static final public String WATCHING = "watching" ;

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public String getColor() {
        return color;
    }
    public String getOtherColor() {
        return color.equals(Square.BLACK)?Square.WHITE:Square.BLACK ;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PlayerLinks get_links() {
        return _links;
    }
    public PlayerLinks server(){return _links;}

    public void set_links(PlayerLinks _links) {
        this._links = _links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" + "\n" +
                "Id='" + id + '\'' + "\n" +
                "name='" + name + '\'' + "\n" +
                ", country='" + country + '\'' +"\n" +
                ", color='" + color + '\'' +"\n" +
                ", _links=" + _links +"\n" +
                '}'+ "\n" ;
    }
}




 class PlayerLinks {

    private Link profile;
    private Link find_players;
    private Link load_game;
    private Link play_game;
    private Link stop_game;
    private Link delete_profile;

    public PlayerLinks() {
    }

    public Link getProfile() {
        return profile;
    }
     public Player update_profile() throws IOException {
         Player player = new Gson().fromJson
                 (new InputStreamReader(
                                 new URL(profile.getHref()).openStream(), StandardCharsets.UTF_8)
                         , Player.class );
         return player;
     }

    public void setProfile(Link profile) {
        this.profile = profile;
    }

    public Link getFind_players() {
        return find_players;
    }

    public List<Profile> find_players() throws IOException {
        ProfilesWrapper wrapper = new Gson().fromJson
                (new InputStreamReader(
                        new URL(find_players.getHref()).openStream(), StandardCharsets.UTF_8)
                        , ProfilesWrapper.class );
        return wrapper.get_Prfiles();
    }

    public void setFind_players(Link find_players) {
        this.find_players = find_players;
    }

    public Link getLoad_game() {
        return load_game;
    }

     public List<Square> load_game() throws IOException {
         SquareWrapper wrapper = new Gson().fromJson
                 (new InputStreamReader(
                                 new URL(load_game.getHref()).openStream(), StandardCharsets.UTF_8)
                         , SquareWrapper.class );
         return wrapper.get_square_list();
     }

    public void setLoad_game(Link load_game) {
        this.load_game = load_game;
    }

    public Link getPlay_game() {
        return play_game;
    }

     public Player play_game(Integer from ,Integer to) throws IOException {
        String url = play_game.getHref().replace("1996" ,from.toString()).replace("2020",to.toString());
         Player player = new Gson().fromJson
                 (new InputStreamReader(
                                 new URL(url).openStream(), StandardCharsets.UTF_8)
                         , Player.class );
         return  player;
     }


    public void setPlay_game(Link play_game) {
        this.play_game = play_game;
    }

    public Link getStop_game() {
        return stop_game;
    }

    public void setStop_game(Link stop_game) {
        this.stop_game = stop_game;
    }

    public Link getDelete_profile() {
        return delete_profile;
    }

    public void setDelete_profile(Link delete_profile) {
        this.delete_profile = delete_profile;
    }

    @Override
    public String toString() {
        return "Links{" +"\n" +
                "\t" + "profile=" + profile +"\n" +
                "\t" +  ", find_players=" + find_players +"\n" +
                "\t" + ", load_game=" + load_game +"\n" +
                "\t" + ", valid_moves=" + play_game +"\n" +
                "\t" + ", stop_game=" + stop_game +"\n" +
                "\t" + ", delete_profile=" + delete_profile +"\n" +
                '}';
    }
}

