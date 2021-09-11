package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.OrganizationEntity;
import com.alkemy.ong.database.jparepositories.OrganizationJPARepository;
import com.alkemy.ong.domain.organizations.OrganizationModel;
import com.alkemy.ong.domain.organizations.OrganizationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class DefaultOrganizationRepository implements OrganizationRepository {
    OrganizationJPARepository jpaRepository;

    public DefaultOrganizationRepository(OrganizationJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<OrganizationModel> findAll() {
        return jpaRepository.findAll().stream()
                .map(o -> toModel(o))
                .collect(toList());
    }

    @Override
    public void updateContactInfo(OrganizationModel organizationModel, int id) {
        if (jpaRepository.findById(id).isPresent()) {
            jpaRepository.save(toEntity(organizationModel));
        }
    }

    public OrganizationModel toModel(OrganizationEntity organization) {
        OrganizationModel organizationModel = new OrganizationModel();
        organizationModel.setName(organization.getName());
        organizationModel.setImage(organization.getImage());
        organizationModel.setAddress(organization.getAddress());
        organizationModel.setPhone(organization.getPhone());
        organizationModel.setEmail(organization.getEmail());
        organizationModel.setWelcomeText(organization.getWelcomeText());
        organizationModel.setAboutUsText(organization.getAboutUsText());
        organizationModel.setCreatedAt(organization.getCreatedAt());
        organizationModel.setUpdatedAt(organization.getUpdatedAt());
        organizationModel.setUrlFacebook(organization.getUrlFacebook());
        organizationModel.setUrlLinkedin(organization.getUrlLinkedin());
        organizationModel.setUrlInstagram(organization.getUrlInstagram());
        organizationModel.setDeleted(organization.isDeleted());
        return organizationModel;
    }

    public OrganizationEntity toEntity(OrganizationModel organization) {
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setName(organization.getName());
        organizationEntity.setImage(organization.getImage());
        organizationEntity.setAddress(organization.getAddress());
        organizationEntity.setPhone(organization.getPhone());
        organizationEntity.setEmail(organization.getEmail());
        organizationEntity.setWelcomeText(organization.getWelcomeText());
        organizationEntity.setAboutUsText(organization.getAboutUsText());
        organizationEntity.setUpdatedAt(organization.getUpdatedAt());
        organizationEntity.setUrlFacebook(organization.getUrlFacebook());
        organizationEntity.setUrlLinkedin(organization.getUrlLinkedin());
        organizationEntity.setUrlInstagram(organization.getUrlInstagram());
        organizationEntity.setDeleted(organization.isDeleted());
        return organizationEntity;
    }
}

