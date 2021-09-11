package com.alkemy.ong.domain.organizations;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultOrganizationService implements OrganizationService {

    private OrganizationRepository organizationRepository;

    public DefaultOrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<OrganizationModel> getAllOrganization() {
        return organizationRepository.findAll();
    }

    @Override
    public void updateUrls(OrganizationModel organizationModel, int id) {
        organizationRepository.updateContactInfo(organizationModel, id);
    }


}
