package com.example.hppav.sqllitetest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends BaseAdapter {
    Activity activity;
    List<Person> lstPerson;
    LayoutInflater inflater;
    EditText edtid,edtName,edtEmail;

    public PersonAdapter(Activity activity, List<Person> lstPerson, EditText edtid, EditText edtName, EditText edtEmail) {
        this.activity = activity;
        this.lstPerson = lstPerson;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.edtid = edtid;
        this.edtName = edtName;
        this.edtEmail = edtEmail;
    }

    @Override
    public int getCount() {
        return  lstPerson.size();
    }

    @Override
    public Object getItem(int position) {
        return lstPerson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lstPerson.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView=inflater.inflate(R.layout.row,null);
        final TextView txtRowId,txtRowName,txtRowEmail;
        txtRowId = (TextView) rowView.findViewById(R.id.txtRowId);
        txtRowName = (TextView) rowView.findViewById(R.id.txtRowName);
        txtRowEmail = (TextView) rowView.findViewById(R.id.txtRowEmail);

        txtRowId.setText(""+lstPerson.get(position).getId());
        txtRowName.setText(""+lstPerson.get(position).getName());
        txtRowEmail.setText(""+lstPerson.get(position).getEmail());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtid.setText(""+txtRowId.getText());
                edtName.setText(""+txtRowName.getText());
                edtEmail.setText(""+txtRowEmail.getText());
            }
        });
        return rowView;
    }
}
