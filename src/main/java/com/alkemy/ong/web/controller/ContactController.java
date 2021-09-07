package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.contacts.ContactModel;
import com.alkemy.ong.domain.contacts.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public List<ContactModel> getContacts(){
        return contactService.getContacts();
    }

}
