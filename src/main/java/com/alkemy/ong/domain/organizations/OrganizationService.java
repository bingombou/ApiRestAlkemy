package com.alkemy.ong.domain.organizations;

import java.util.List;

public interface OrganizationService {

    List<OrganizationModel> getAllOrganization();

    void updateUrls(OrganizationModel organizationModel, int id);
}
