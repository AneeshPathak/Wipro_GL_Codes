package com.contactmanager.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.contactmanager.model.Contact;

/**
 * Very simple in-memory DAO implementation for Sprint‑2.
 * NOTE: Data is kept only while the JVM is running.
 */
public class ContactDao {

    // In-memory list to store contacts (shared for all servlets)
    private static final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if (contact != null) {
            contacts.add(contact);
        }
    }

    public List<Contact> getAllContacts() {
        return Collections.unmodifiableList(contacts);
    }

    public Contact getContact(int index) {
        if (index < 0 || index >= contacts.size()) {
            return null;
        }
        return contacts.get(index);
    }

    public boolean updateContact(int index, Contact updated) {
        if (index < 0 || index >= contacts.size() || updated == null) {
            return false;
        }
        contacts.set(index, updated);
        return true;
    }

    public boolean deleteContact(int index) {
        if (index < 0 || index >= contacts.size()) {
            return false;
        }
        contacts.remove(index);
        return true;
    }
}
