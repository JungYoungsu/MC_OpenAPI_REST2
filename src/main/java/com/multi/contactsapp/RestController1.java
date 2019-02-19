package com.multi.contactsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.multi.contactsapp.domain.ContactList;
import com.multi.contactsapp.service.ContactService;

@RestController
@RequestMapping(value = "/contacts")
public class RestController1 {

	@Autowired
	private ContactService contactService;

	// http://localhost:8000/MC_OpenAPI_REST2/contacts?output=xml
	// http://localhost:8000/MC_OpenAPI_REST2/contacts?output=json
	@RequestMapping(method = RequestMethod.GET)
	public ContactList getContactList() {
		return contactService.getContactList();
	}

}
