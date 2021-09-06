package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.ContactEntity;
import com.alkemy.ong.database.jparepositories.ContactRepository;
import com.alkemy.ong.domain.contacts.ContactModel;
import com.alkemy.ong.domain.contacts.ContactRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultContactRepo implements ContactRepo {

    ContactRepository contactRepository;

    public DefaultContactRepo(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactModel> getContacts() {
        ContactModel contactModel = new ContactModel();
        List<ContactModel> contacts = new ArrayList<>();
        for (ContactEntity ce : contactRepository.findAll()) {

            contactModel.setId(ce.getId());
            contactModel.setDeleted(ce.isDeleted());
            contactModel.setCreatedAt(ce.getCreatedAt());
            contactModel.setUpdatedAt(ce.getUpdatedAt());
            contactModel.setEmail(ce.getEmail());
            contactModel.setMessage(ce.getMessage());
            contactModel.setName(ce.getName());
            contactModel.setPhone(ce.getPhone());

            contacts.add(contactModel);
        }
        return contacts;
    }
}
