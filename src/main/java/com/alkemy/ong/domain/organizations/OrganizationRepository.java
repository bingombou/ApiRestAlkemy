package com.alkemy.ong.domain.organizations;

import java.util.List;

public interface OrganizationRepository {

    List<OrganizationModel> findAll();

    void updateContactInfo(OrganizationModel organizationModel, int id);
}
