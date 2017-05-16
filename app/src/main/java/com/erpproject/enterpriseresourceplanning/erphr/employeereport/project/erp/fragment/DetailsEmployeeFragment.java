package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erpproject.enterpriseresourceplanning.erphr.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsEmployeeFragment extends Fragment {

    TextView txtdisplayfirstname;
    TextView txtdisplaysceondname;
    TextView txtdisplaythirdname;
    TextView txtdisplayfourthname;
    TextView txtdisplayF_PK_SSN;


    public DetailsEmployeeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_details_employee, container, false);
        txtdisplayfirstname=(TextView)view.findViewById(R.id.txtdisplayfirstname);
        txtdisplaysceondname=(TextView)view.findViewById(R.id.txtdisplaysceondname);
        txtdisplaythirdname=(TextView)view.findViewById(R.id.txtdisplaythirdname);
        txtdisplayfourthname=(TextView)view.findViewById(R.id.txtdisplayfourthname);
        txtdisplayF_PK_SSN=(TextView)view.findViewById(R.id.txtdisplayF_PK_SSN);

        Intent intent = getActivity().getIntent();
        if(intent!=null){
            String firstname= intent.getStringExtra("firstname");
            String secondname= intent.getStringExtra("secondname");
            String thirdname= intent.getStringExtra("thirdname");
            String fourthname= intent.getStringExtra("fourthname");
            String F_PK_SSN= intent.getStringExtra("F_PK_SSN");

            txtdisplayfirstname.setText(firstname);
            txtdisplaysceondname.setText(secondname);
            txtdisplaythirdname.setText(thirdname);
            txtdisplayfourthname.setText(fourthname);
            txtdisplayF_PK_SSN.setText(F_PK_SSN);

        }
        return view;
    }



}
