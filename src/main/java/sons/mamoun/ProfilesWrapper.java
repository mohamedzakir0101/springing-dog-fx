package sons.mamoun;

import java.util.ArrayList;
import java.util.List;

public class ProfilesWrapper {
  private ProfileList _embedded;

    public ProfilesWrapper(ProfileList _embedded) {
        this._embedded = _embedded;
    }
    public ProfilesWrapper(List<Profile> list) {
        this._embedded = new ProfileList(list) ;
    }

    public ProfilesWrapper() {
    }

    public List<Profile> get_Prfiles(){return _embedded.getProfileList();}
    public ProfileList get_embedded() {
        return _embedded;
    }

    public void set_embedded(ProfileList _embedded) {
        this._embedded = _embedded;
    }

    @Override
    public String toString() {
        return "Wrapper{" + "\n" +
                "_embedded=" + _embedded +"\n" +
                '}';
    }
}


class ProfileList {
   private List<Profile> profileList = new ArrayList<>();

    public ProfileList(List<Profile> squareList) {
        this.profileList = squareList;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    @Override
    public String toString() {
        return "EntityModelList{" +
                "squareList=" + profileList +
                '}';
    }
}