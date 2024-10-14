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

    public ORgdto createorganization(ORgdto oRgdto) {
        Orgmodel org = new Orgmodel();
        org.setName(oRgdto.getName());
        org.setAbrivatedname(oRgdto.getAbrivatedname());
        org.setStablishedyear(oRgdto.getStablishedyear());
        org.setMission(oRgdto.getMission());
        org.setVission(oRgdto.getVission());
        org.setLogo(oRgdto.getLogo());

        Orgmodel savedOrg = oRgRepository.save(org);
        return new ORgdto(
                savedOrg.getId(),

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
                org.getId(),
                org.getAbrivatedname(),
                org.getName(),
                org.getLogo(),
                org.getStablishedyear(),
                org.getMission(),
                org.getVission()
        )).collect(Collectors.toList());
    }
    public ORgdto updateorganization(ORgdto oRgdto ) {
        Optional<Orgmodel> org = oRgRepository.findById(oRgdto.getId());
        Orgmodel savedOrg = org.get();
        if(oRgdto.getAbrivatedname() != null) {
            savedOrg.setAbrivatedname(oRgdto.getAbrivatedname());
        }
        if(oRgdto.getName() != null) {
            savedOrg.setName(oRgdto.getName());

        }
        if(oRgdto.getLogo() != null) {
            savedOrg.setLogo(oRgdto.getLogo());
        }
        if(oRgdto.getStablishedyear() != null) {
            savedOrg.setStablishedyear(oRgdto.getStablishedyear());
        }
        if(oRgdto.getMission() != null) {
            savedOrg.setMission(oRgdto.getMission());
        }
        if(oRgdto.getVission() != null) {
            savedOrg.setVission(oRgdto.getVission());
        }
        Orgmodel savedOrg1 = oRgRepository.save(savedOrg);
        return new ORgdto(
                savedOrg1.getId(),
                savedOrg1.getName(),
                savedOrg1.getAbrivatedname(),
                savedOrg1.getVission(),
                savedOrg1.getMission(),
                savedOrg1.getStablishedyear(),
                savedOrg1.getLogo()
        );


    }

    public Optional<ORgdto> getOrganizationById(Long id) {
        Optional<Orgmodel> orgOptional = oRgRepository.findById(id);
        return orgOptional.map(org -> new ORgdto(
                org.getId(),
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
