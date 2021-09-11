package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.organizations.OrganizationModel;
import com.alkemy.ong.domain.organizations.OrganizationService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/organization")
public class OrganizationController {
    OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/")
    public List<OrganizationModel> getAll() {
        return organizationService.getAllOrganization();
    }

    @GetMapping("/public")
    public List<OrganizationDTO> getPublicInfo() {
        return organizationService.getAllOrganization().stream()
                .map(o -> toDTO(o))
                .collect(toList());
    }

    private OrganizationDTO toDTO(OrganizationModel organizationModel) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setName(organizationModel.getName());
        organizationDTO.setImage(organizationModel.getImage());
        organizationDTO.setPhone(organizationModel.getPhone());
        organizationDTO.setAddress(organizationModel.getAddress());
        organizationDTO.setUrlFacebook(organizationModel.getUrlFacebook());
        organizationDTO.setUrlLinkedin(organizationModel.getUrlLinkedin());
        organizationDTO.setUrlInstagram(organizationModel.getUrlInstagram());

        return organizationDTO;
    }

    @Data
    private class OrganizationDTO {
        public String name;
        public String image;
        public int phone;
        public String address;
        private String urlFacebook;
        private String urlLinkedin;
        private String urlInstagram;
    }
}



