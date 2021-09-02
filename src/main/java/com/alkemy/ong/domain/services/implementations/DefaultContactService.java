package com.alkemy.ong.domain.services.implementations;

import com.alkemy.ong.database.repositories.ContactRepository;
import com.alkemy.ong.domain.services.ContactService;
import org.springframework.stereotype.Service;

@Service
public class DefaultContactService implements ContactService {

    private ContactRepository contactRepository;

    public DefaultContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

}
