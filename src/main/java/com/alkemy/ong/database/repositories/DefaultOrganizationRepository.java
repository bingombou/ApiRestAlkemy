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
        organizationModel.setDeleted(organization.isDeleted());
        return organizationModel;
    }
}
