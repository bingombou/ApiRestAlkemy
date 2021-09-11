package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.contacts.ContactModel;
import com.alkemy.ong.domain.contacts.ContactService;
import com.alkemy.ong.web.dto.ContactDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

   @PostMapping("/contacts")
   public ResponseEntity<Object> createContact(@Valid @RequestBody ContactDto contactDto) {

        return new ResponseEntity<>(contactService.createContact(contactDto), HttpStatus.CREATED);
    }

}