package com.alkemy.ong.domain.contacts;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultContactService implements ContactService {

    private ContactRepo contactRepo;

    public DefaultContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public List<ContactModel> getContacts() {
        return contactRepo.getContacts();
    }
}
