/*
package sample;

import java.util.ArrayList;
import java.util.List;

public class LoadPerson {

    public static Person get_person()
    {
     return  new Person("Mamoun" , "Elkheir" , "male")  ;
    }

    public static String get_person_in_json()
    {
     return "{\"id\":3,\"name\":\"son_name\",\"last_name\":\"Mamon Elkheir\",\"full_name\":\"son_name Mamon Elkheir\",\"gender\":\"son_gender\",\"_links\":{\"add_son\":{\"href\":\"http://localhost:8080/person/3/son_name/son_gender\"},\"get_all_son\":{\"href\":\"http://localhost:8080/person/sons/3\"},\"get_father\":{\"href\":\"http://localhost:8080/person/father/3\"}}}";
    }

    public static String get_personlist_in_json()
    {
        return "{\"_embedded\":{\"entityModelList\":[{\"id\":3,\"name\":\"son_name\",\"last_name\":\"Mamon Elkheir\",\"full_name\":\"son_name Mamon Elkheir\",\"gender\":\"son_gender\",\"_links\":{\"add_son\":{\"href\":\"http://localhost:8080/person/3/son_name/son_gender\"},\"get_all_son\":{\"href\":\"http://localhost:8080/person/sons/3\"},\"get_father\":{\"href\":\"http://localhost:8080/person/father/3\"}}},{\"id\":5,\"name\":\"son_name\",\"last_name\":\"Mamon Elkheir\",\"full_name\":\"son_name Mamon Elkheir\",\"gender\":\"son_gender\",\"_links\":{\"add_son\":{\"href\":\"http://localhost:8080/person/5/son_name/son_gender\"},\"get_all_son\":{\"href\":\"http://localhost:8080/person/sons/5\"},\"get_father\":{\"href\":\"http://localhost:8080/person/father/5\"}}}]}}";
    }

    public static List<Person> get_person_list(int n){
        List<Person> list = new ArrayList<>();
        for (int i = 0 ; i<n ; i++)
        {
            list.add(new Person("Member"+i ,"Father"+i , i%2==0?"male" : "female" )  );
        }
        return list;
    }
}
*/
