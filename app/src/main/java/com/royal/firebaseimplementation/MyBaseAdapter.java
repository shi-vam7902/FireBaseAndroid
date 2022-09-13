package com.royal.firebaseimplementation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.royal.firebaseimplementation.ContactModel;
import com.royal.firebaseimplementation.R;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {



    Context context;
    ArrayList<ContactModel> contactModelsArrayList;
    public MyBaseAdapter(Context context, ArrayList<ContactModel> contactModelsArrayList) {
        this.context = context;
        this.contactModelsArrayList=contactModelsArrayList;
    }


    @Override
    public int getCount() {
        return contactModelsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactModelsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = layoutInflater.inflate(R.layout.raw_list, null);
        final  ContactModel contactModel = (ContactModel) getItem(i);
        TextView tvName =  convertView.findViewById(R.id.edt_fn);
        tvName.setText(contactModelsArrayList.get(i).getFname()+"   "+contactModelsArrayList.get(i).getLname());
        return convertView;
    }
}
