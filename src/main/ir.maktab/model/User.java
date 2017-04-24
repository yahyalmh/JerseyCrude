package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by asus x555L on 2017/03/01.
 */
@Entity
public class User {
    @Id
    @Column
    @JsonProperty
    private int id;
    @Column
    @JsonProperty
    private String username;
    @Column
    @JsonProperty
    private String pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }




}
