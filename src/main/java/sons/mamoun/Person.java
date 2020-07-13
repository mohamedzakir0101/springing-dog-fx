/*
package sample;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;


public class Person {
    private  long id;
    private String name ;
    private String last_name;
    private  String full_name;
    private String gender;
    private PlayerLinks _links;

    public static long counter = 0;

    public Person(String name, String last_name , String gender1)  {
        this.name = name;
        this.last_name = last_name;
        this.full_name = name.concat(" "+last_name);
        this.gender = gender1;
        id = ++counter;

        String a = "http://www.google.com";
        _links = new PlayerLinks(a,a,a);

    }

    public Person(String full_name , String gender) {
        this.full_name = full_name;
        this.name = full_name.split(" ")[0];
        this.last_name = full_name.split(" ")[1];
        this.gender = gender;
        id = ++counter;

        String a = "http://www.google.com";
        _links = new PlayerLinks(a,a,a);
    }

    public Person() {
    }


    public Person add_son(String son_name , String son_gender)
    {
        String url = _links.getAdd_son().getHref().
                replace("son_name" ,son_name).
                replace("son_gender",son_gender);
        try {
            InputStreamReader reader= new InputStreamReader( new URL(url).openStream());
            Person son = new Gson().fromJson(reader,Person.class);
            return son;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null ;
    }

    public Wrapper get_all_son()
    {
        try {
            InputStreamReader reader = new InputStreamReader(new URL(get_links().getGet_all_son().getHref()).openStream());
            Wrapper son_list = new Gson().fromJson(reader , Wrapper.class);
            return son_list;
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
        this.name = full_name.split(" ")[0];
        this.last_name = full_name.split(" ")[1];
    }

    public PlayerLinks get_links() {
        return _links;
    }

    public void set_links(PlayerLinks _links) {
        this._links = _links;
    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Person.counter = counter;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name; this.full_name = name.concat(" " + this.last_name);
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name; full_name = this.name.concat(" "+last_name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                name.equals(person.name) &&
                last_name.equals(person.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, last_name);
    }

    @Override
    public String toString() {
        return "Person{" + "\n" +
                "id=" + id +"\n" +
                ", name='" + name + '\'' +"\n" +
                ", last_name='" + last_name + '\'' +"\n" +
                ", full_name='" + full_name + '\'' +"\n" +
                ", gender='" + gender + '\'' +"\n" +
                ", _links=" + _links +
                '}' ;
    }
}




*/
