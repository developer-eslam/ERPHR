package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.persinalapptheme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.detailspersnalapp.detailsfragmentthree_rececleeview;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.model.personalappliactionmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abotaleb on 12/8/2016.
 */

public class personalappthemethree   extends AppCompatActivity {


    RecyclerView recyclerView;
    com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.detailspersnalapp.detailsfragmentthree_rececleeview detailsfragmentthree_rececleeview;


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewthemethree);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        detailsfragmentthree_rececleeview = new detailsfragmentthree_rececleeview(getApplicationContext(),detailsthemeonefragment_receclerviews(1));

        recyclerView.setAdapter(detailsfragmentthree_rececleeview);



    }


    public List<personalappliactionmodel> detailsthemeonefragment_receclerviews(int size){
        List<personalappliactionmodel>personalappliactionmodellist = new ArrayList<personalappliactionmodel>(

        );

        for(int i=0;i<size;i++){
            personalappliactionmodel personalappliactionmodel = new personalappliactionmodel();

            personalappliactionmodel.fname = personalappliactionmodel.FIRST_NAME;
            personalappliactionmodel.mname = personalappliactionmodel.MIDDLE_NAME;
            personalappliactionmodel.lname = personalappliactionmodel.LAST_NAME;
            personalappliactionmodel.address = personalappliactionmodel.ADDRESS;
            personalappliactionmodel.phone = personalappliactionmodel.PHONE;
            personalappliactionmodel.city = personalappliactionmodel.CITY;
            personalappliactionmodel.date = personalappliactionmodel.DATE;




            personalappliactionmodellist.add(personalappliactionmodel);


        }

        return personalappliactionmodellist;
    }



}
