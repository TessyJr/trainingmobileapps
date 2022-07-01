package com.example.tugaspertemuan3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import RoomDatabase.Person;
import RoomDatabase.PersonDataBase;

public class FriendsFragment extends Fragment {
    Button save, update, delete;
    EditText nameSave, addressSave, nameUpdate, idUpdate, idDelete;
    PersonDataBase personDataBase;
    ListView friendList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friend, container, false);

        save = rootView.findViewById(R.id.btn_FriendSave);
        delete = rootView.findViewById(R.id.btn_FriendDelete);
        update = rootView.findViewById(R.id.btn_FriendUpdate);

        nameSave = rootView.findViewById(R.id.et_FriendNameSave);
        addressSave = rootView.findViewById(R.id.et_FriendAddressSave);
        nameUpdate = rootView.findViewById(R.id.et_FriendNameUpdate);
        idUpdate = rootView.findViewById(R.id.et_FriendIdUpdate);
        idDelete = rootView.findViewById(R.id.et_FriendIdDelete);

       friendList = rootView.findViewById(R.id.lv_FriendList);

        personDataBase = PersonDataBase.getInstance(getActivity());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personDataBase.personDao()
                        .insertPerson(new Person(nameSave.getText().toString(), addressSave.getText().toString()));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personDataBase.personDao().deletePerson(new Person(Integer.parseInt(idDelete.getText().toString())));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personDataBase.personDao().updatePerson(nameUpdate.getText().toString(), Integer.parseInt( idUpdate.getText().toString()));
            }
        });

        personDataBase.personDao().getPersons().observe(getActivity(), new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                if(people==null){
                    Toast.makeText(getActivity(), "No Data", Toast.LENGTH_LONG).show();
                }
                else{
                    ArrayList<String> personNames = new ArrayList<>();
                    for(Person person : people){
                        personNames.add(person.getId() +" : "+person.getName());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
                    friendList.setAdapter(adapter);
                }
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}