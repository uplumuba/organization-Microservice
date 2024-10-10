package com.ORsystem.ORgdto;

import lombok.Data;
import lombok.NonNull;

@Data
public class ORgdto { private String Name;
    @NonNull
    private String abrivatedname;
    private String logo;
    @NonNull
    private String stablishedyear;
    private String mission;
    private String vission;

    public ORgdto(String abrivatedname, String name, String logo, String stablishedyear, String mission, String vission) {
        this.abrivatedname = abrivatedname;
        Name = name;
        this.logo = logo;
        this.stablishedyear = stablishedyear;
        this.mission = mission;
        this.vission = vission;
    }
}
