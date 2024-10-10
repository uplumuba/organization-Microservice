package com.ORsystem.Model;

import jakarta.persistence.OneToMany;
import jakarta.websocket.OnClose;
import lombok.Data;

@Data
public class Orgmodel {

    private long id;
    private String Name;
    private String abrivatedname;
    private String logo;
    private String stablishedyear;
    private String mission;
    private String vission;
    @OneToMany(Class="organization",Cas)
    private <List> department;

    public Orgmodel(String name, String abrivatedname, String logo, String stablishedyear, String mission, String vission) {
        Name = name;
        this.abrivatedname = abrivatedname;
        this.logo = logo;
        this.stablishedyear = stablishedyear;
        this.mission = mission;
        this.vission = vission;
    }

    public Orgmodel(long id, String abrivatedname, String logo, String stablishedyear, String mission, String vission) {
        this.id = id;
        this.abrivatedname = abrivatedname;
        this.logo = logo;
        this.stablishedyear = stablishedyear;
        this.mission = mission;
        this.vission = vission;
    }

    public Orgmodel(String name, long id, String logo, String stablishedyear, String mission, String vission) {
        Name = name;
        this.id = id;
        this.logo = logo;
        this.stablishedyear = stablishedyear;
        this.mission = mission;
        this.vission = vission;
    }

    public Orgmodel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAbrivatedname() {
        return abrivatedname;
    }

    public void setAbrivatedname(String abrivatedname) {
        this.abrivatedname = abrivatedname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStablishedyear() {
        return stablishedyear;
    }

    public void setStablishedyear(String stablishedyear) {
        this.stablishedyear = stablishedyear;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getVission() {
        return vission;
    }

    public void setVission(String vission) {
        this.vission = vission;
    }

}
