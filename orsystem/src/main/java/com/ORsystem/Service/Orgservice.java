package com.ORsystem.Service;

import com.ORsystem.Model.Orgmodel;
import com.ORsystem.ORgdto.ORgdto;
import com.ORsystem.Repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Orgservice {
    @Autowired
    private OrgRepository oRgRepository;


    public Orgservice(OrgRepository oRgRepository) {
        this.oRgRepository = oRgRepository;
    }

    public ORgdto createUser(ORgdto oRgdto) {
        Orgmodel org = new Orgmodel();
        org.setName(oRgdto.getName());
        org.setAbrivatedname(oRgdto.getAbrivatedname());
        org.setStablishedyear(oRgdto.getStablishedyear());
        org.setMission(oRgdto.getMission());
        org.setVission(oRgdto.getVission());
        org.setLogo(oRgdto.getLogo());

        Orgmodel savedOrg = oRgRepository.save(org);
        return new ORgdto(
                savedOrg.getAbrivatedname(),
                savedOrg.getName(),
                savedOrg.getLogo(),
                savedOrg.getStablishedyear(),
                savedOrg.getMission(),
                savedOrg.getVission()
        );
    }


    public List<ORgdto> getAllOrganizations() {
        List<Orgmodel> orgList = oRgRepository.findAll();
        return orgList.stream().map(org -> new ORgdto(
                org.getAbrivatedname(),
                org.getName(),
                org.getLogo(),
                org.getStablishedyear(),
                org.getMission(),
                org.getVission()
        )).collect(Collectors.toList());
    }

    public Optional<ORgdto> getOrganizationById(Long id) {
        Optional<Orgmodel> orgOptional = oRgRepository.findById(id);
        return orgOptional.map(org -> new ORgdto(
                org.getAbrivatedname(),
                org.getName(),
                org.getLogo(),
                org.getStablishedyear(),
                org.getMission(),
                org.getVission()
        ));
    }


    public boolean deleteOrganization(Long id) {
        if (oRgRepository.existsById(id)) {
            oRgRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
