package com.ORsystem.ORgdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ORgdto {

    private Long id;
    @NonNull
    private String Name;
    private String abrivatedname;
    private String logo;
    @NonNull
    private String stablishedyear;
    private String mission;
    private String vission;


}
