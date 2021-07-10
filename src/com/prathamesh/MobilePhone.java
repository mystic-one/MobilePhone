package com.prathamesh;

import java.util.ArrayList;

public class MobilePhone {

    ArrayList<Contact> contacts;
    private String myNumber;

    public MobilePhone(String myNumber) {
        contacts = new ArrayList<>();
        this.myNumber = myNumber;
    }

    public void addContact(Contact contact) {
        if(!searchContact(contact))
            contacts.add(contact);
        else
            System.out.println("Contact already exists");
    }


    public void modifyContact(Contact oldContact, Contact newContact){
        int index = searchContactIndex(oldContact);
        if(index >= 0){
            contacts.remove(oldContact);
            contacts.add(newContact);
        }else {
            System.out.println("Contact " + oldContact.getName() + " does not exist");
        }
    }

    public void removeContact(String name) {
        int index = searchContactIndex(name);
        if(index >= 0){
            contacts.remove(index);
        }else {
            System.out.println("Contact does not exist");
        }
    }

    public void getContactDetails(String name) {
        int index = searchContactIndex(name);
        if(index >= 0) {
            System.out.println(contacts.get(index).toString());
        } else {
            System.out.println("Contact does not exist");
        }
    }

    private int searchContactIndex(Contact contact){
        return contacts.indexOf(contact);
    }

    private int searchContactIndex(String name) {
        for(int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    private boolean searchContact(Contact contact) {
        return contacts.contains(contact);
    }
}
