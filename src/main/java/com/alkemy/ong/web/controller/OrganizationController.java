package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.organizations.OrganizationModel;
import com.alkemy.ong.domain.organizations.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.http.ResponseEntity;
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
    public List<OrganizationPublicDTO> getPublicInfo() {
        return organizationService.getAllOrganization().stream()
                .map(o -> toPublicDTO(o))
                .collect(toList());
    }

    @PostMapping("/public")
    //@PreAutorize(ROLE_ADIM)
    public ResponseEntity<OrganizationDTO> updatePublicData(@RequestBody OrganizationDTO dto) {
        return ResponseEntity.ok(toDTO(organizationService.update(toModel(dto))));
    }

    @Data
    @AllArgsConstructor
    static class OrganizationDTO {
        @JsonIgnore
        private int id;
        private String name;
        private String image;
        private int phone;
        private String address;
        private String urlFacebook;
        private String urlLinkedin;
        private String urlInstagram;
    }

    @Data
    @AllArgsConstructor
    static class OrganizationPublicDTO {
        private String urlFacebook;
        private String urlLinkedin;
        private String urlInstagram;
    }

    private OrganizationPublicDTO toPublicDTO(OrganizationModel organizationModel) {
        return new OrganizationPublicDTO(
                organizationModel.getUrlFacebook(),
                organizationModel.getUrlLinkedin(),
                organizationModel.getUrlInstagram());
    }

    private OrganizationDTO toDTO(OrganizationModel organizationModel) {
        return new OrganizationDTO(
                organizationModel.getId(),
                organizationModel.getName(),
                organizationModel.getImage(),
                organizationModel.getPhone(),
                organizationModel.getAddress(),
                organizationModel.getUrlFacebook(),
                organizationModel.getUrlLinkedin(),
                organizationModel.getUrlInstagram());
    }

    public OrganizationModel toModel(OrganizationDTO organizationDto) {
        OrganizationModel organizationModel = new OrganizationModel();
        organizationModel.setId(organizationDto.getId());
        organizationModel.setName(organizationDto.getName());
        organizationModel.setImage(organizationDto.getImage());
        organizationModel.setPhone(organizationDto.getPhone());
        organizationModel.setAddress(organizationDto.getAddress());
        organizationModel.setUrlFacebook(organizationDto.getUrlFacebook());
        organizationModel.setUrlLinkedin(organizationDto.getUrlLinkedin());
        organizationModel.setUrlInstagram(organizationDto.getUrlInstagram());

        return organizationModel;
    }
}