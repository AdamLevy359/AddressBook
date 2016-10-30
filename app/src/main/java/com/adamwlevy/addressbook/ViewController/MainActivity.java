package com.adamwlevy.addressbook.ViewController;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adamwlevy.addressbook.Model.AddressBook;
import com.adamwlevy.addressbook.Model.Contact;
import com.adamwlevy.addressbook.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;


/**
 * This is the main activity with most of the view and controller logic.
 * Given the simplicity of the application, I chose to combine the
 * view and controller into a single class.
 */
//TODO separate view and controller.
public class MainActivity extends ListActivity {

    AddressBook addressBook = new AddressBook();
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_book);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);

        //TODO these calls to get the random users should be run on an async task.
        for(int i = 0; i<10; i++){
            getRandomUser();
        }
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id){
        String item = ((TextView)view).getText().toString();
        Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

        Intent i = new Intent(getApplicationContext(), ContactActivity.class);
        i.putExtra("index", position);
        i.putExtra("addressBook", addressBook);
        startActivity(i);
    }

    /**
     * Uses the Volley library to connect to the randomuser service via http,
     * and retreives a single random user.
     */
    private void getRandomUser(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="https://randomuser.me/api";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("RandomUser", response);
                        Contact contact = new Contact(response);
                        addressBook.addContact(contact);
                        updateContactsList();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listItems.clear();
                listItems.add("Error: Could not connect to randomuser.me!");
                adapter.notifyDataSetChanged();
            }
        });

        queue.add(stringRequest);
    }

    /**
     * Updates the list of strings in the listView to match the address book.
     * We could get rid of this method, which would improve performance
     * if we implemented an ArrayAdapter for the AddressBook class.
     */
    //TODO implement array adapter for AddressBook class.
    private void updateContactsList(){
        listItems.clear();
        ArrayList<Contact> contacts = addressBook.getContacts();
        for (Contact contact : contacts) {
            listItems.add(contact.getLastName() + ", " + contact.getFirstName());
        }
        adapter.notifyDataSetChanged();
    }
}
