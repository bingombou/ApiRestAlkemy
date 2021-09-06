package com.alkemy.ong.domain.organizations;


import com.alkemy.ong.domain.organizations.OrganizationModel;

import java.util.List;

public interface OrganizationRepository {

    List<OrganizationModel> findAll();

}
