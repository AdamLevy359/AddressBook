package com.adamwlevy.addressbook.ViewController;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.adamwlevy.addressbook.Model.AddressBook;
import com.adamwlevy.addressbook.Model.Contact;
import com.adamwlevy.addressbook.R;

import java.util.ArrayList;

/**
 * The ContactActivity is the activity shown to the user
 * displaying the contact details when they select an
 * individual contact from the address book.
 */
public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //Hiding the action bar for consistency with MainActivity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent i = getIntent();
        int index = i.getIntExtra("index", 0);
        AddressBook addressBook = (AddressBook)i.getSerializableExtra("addressBook");
        ArrayList<Contact> contacts = addressBook.getContacts();
        if(contacts.size() > 0) {
            Contact contact = contacts.get(index);

            TextView textView = (TextView)findViewById(R.id.FirstLabel);
            textView.setText("First:" + contact.getFirstName());

            textView = (TextView)findViewById(R.id.LastLabel);
            textView.setText("Last: " + contact.getLastName());

            textView = (TextView)findViewById(R.id.PhoneLabel);
            textView.setText("Phone: " + contact.getPhoneNumber());

            textView = (TextView)findViewById(R.id.EmailLabel);
            textView.setText("Email: " + contact.getEmail());

            textView = (TextView)findViewById(R.id.AddressLabel);
            textView.setText("Address: " + contact.getStreet() + ", " + contact.getCity());
        }

    }
}
