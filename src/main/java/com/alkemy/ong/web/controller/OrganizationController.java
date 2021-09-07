package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.organizations.OrganizationModel;
import com.alkemy.ong.domain.organizations.OrganizationService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<OrganizatioDTO> getPublicInfo() {
        return organizationService.getAllOrganization().stream()
                .map(o -> toDTO(o))
                .collect(toList());
    }

    private OrganizatioDTO toDTO(OrganizationModel organizationModel) {
        OrganizatioDTO organizationDTO = new OrganizatioDTO();
        organizationDTO.setName(organizationModel.getName());
        organizationDTO.setImage(organizationModel.getImage());
        organizationDTO.setPhone(organizationModel.getPhone());
        organizationDTO.setAddress(organizationModel.getAddress());
        return organizationDTO;
    }

    @Data
    private class OrganizatioDTO {
        public String name;
        public String image;
        public int phone;
        public String address;
    }

}



