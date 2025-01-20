package org.example.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public MobilePhone(ArrayList<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    public MobilePhone(String myNumber, ArrayList<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if(!myContacts.contains(contact)) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = myContacts.indexOf(oldContact);  // Eski kişiyi bulmak için indexOf kullanıyoruz
        if (index != -1) {  // Eğer eski kişi listede varsa
            myContacts.set(index, newContact);  // Eski kişiyi yeni kişiyle değiştir
            return true;  // true döndür
        }
        return false;  // Eğer eski kişi listede yoksa false döndür
    }

    public boolean removeContact(Contact contact) {
        // Kişi listede varsa
        if (myContacts.contains(contact)) {
            myContacts.remove(contact);  // Kişiyi sil
            System.out.println(contact.getName() + " kişisi başarıyla silindi.");
            return true;  // Kişi silindiğinde true döndür
        }
        // Kişi listede bulunmazsa
        System.out.println(contact.getName() + " kişisi listede bulunamadı.");
        return false;  // Kişi listede bulunamazsa false döndür
    }

    // Contact objesinin indeksini bulma (Contact türünde parametre alır)
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);  // Contact nesnesinin listede bulunduğu indeks
    }
    // String parametre ile Contact objesinin indeksini bulma (String türünde parametre alır)
    public int findContact(String nameOrPhoneNumber) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            // Eğer kişi ismi ya da telefon numarası ile eşleşiyorsa
            if (contact.getName().equals(nameOrPhoneNumber) || contact.getPhoneNumber().equals(nameOrPhoneNumber)) {
                return i;  // Eşleşen kişinin indeksi döndürülür
            }
        }
        return -1;  // Eğer kişi bulunamazsa -1 döndürülür
    }

    public Contact queryContact(String name) {
        for(Contact contact: myContacts) {
            if(contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void printContact() {
        if(myContacts.isEmpty()) {
            System.out.println("Kişi listesi boş.");
        } else {
            for(Contact contact: myContacts) {
                System.out.println(contact.getName() + "->" + contact.getPhoneNumber());
            }
        }
    }
}
