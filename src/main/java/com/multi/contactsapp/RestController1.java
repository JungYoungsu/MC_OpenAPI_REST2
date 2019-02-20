package com.multi.contactsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.multi.contactsapp.domain.Contact;
import com.multi.contactsapp.domain.ContactList;
import com.multi.contactsapp.domain.Result;
import com.multi.contactsapp.service.ContactService;

@CrossOrigin(origins="localhost:8000")
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

	@RequestMapping(method = RequestMethod.POST)
	public Result insertContact(@RequestBody Contact c) {
		return contactService.insertContact(c);
	}

	@RequestMapping(value = "{no}", method = RequestMethod.DELETE)
	public Result deleteContact(@PathVariable("no") int no, @RequestBody Contact c) {
		c.setNo(no);
		return contactService.deleteContact(c);
	}

	@RequestMapping(value = "{no}", method = RequestMethod.PUT)
	public Result updateContact(@PathVariable("no") int no, @RequestBody Contact c) {
		c.setNo(no);
		return contactService.updateContact(c);
	}
}
