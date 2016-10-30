package com.adamwlevy.addressbook.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The AddressBook class is essentially "The Model" in this model view controller design.
 * It stores all the contacts.  It currently has no data persistence so every time the app
 * is restarted all the data is erased.
 */
//TODO Add data persistence via SQL
public class AddressBook implements Serializable {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    /**
     * Add a contact to the address book
     * @param contact
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
        sortContactsByLastName();
    }

    /**
     * Get a list of all the contacts in the address book.
     * @return
     */
    public ArrayList<Contact> getContacts(){
        return contacts;
    }

    /**
     * Sorts the contacts in alphabetical order by last name.
     */
    public void sortContactsByLastName(){
        Collections.sort(contacts, new Comparator<Contact>(){
            public int compare(Contact a, Contact b){
                return a.getLastName().compareToIgnoreCase(b.getLastName());
            }
        });
    }
}

