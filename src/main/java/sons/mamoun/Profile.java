package sons.mamoun;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class Profile {

    private  String name ;
    private String country;
    private ProfileLink _links;

    public Profile() {
    }

    public ProfileLink get_links() {
        return _links;
    }
    public ProfileLink server() {
        return _links;
    }

    public void set_links(ProfileLink _links) {
        this._links = _links;
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

    @Override
    public String
    toString() {
        return "profile{" +
                "name='" + name + '\'' + "\n" +
                ", country='" + country + '\'' + "\n" +
                '}';
    }

}



 class ProfileLink {

    private Link challenge;

     public ProfileLink() {
     }

     public Link getChallenge() {
         return challenge;
     }

     public List<Square> challenge() throws IOException {
         SquareWrapper wrapper = new Gson().fromJson
                 (new InputStreamReader(
                                 new URL(challenge.getHref()).openStream(), Charset.forName("UTF-8"))
                         , SquareWrapper.class );
         return  wrapper.get_square_list();
     }

     public void setChallenge(Link challenge) {
         this.challenge = challenge;
     }
 }

