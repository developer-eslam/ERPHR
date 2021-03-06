package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.persinalapptheme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.detailspersnalapp.detailsthemefour_receclerview;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.model.personalappliactionmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abotaleb on 12/8/2016.
 */

public class personalappthemefour  extends AppCompatActivity {


    RecyclerView recyclerView;
    com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.detailspersnalapp.detailsthemefour_receclerview detailsthemefour_receclerview;


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
        setContentView(R.layout.receclerviewthemefour);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        detailsthemefour_receclerview = new detailsthemefour_receclerview(getApplicationContext(),detailsthemeonefragment_receclerviews(1));

        recyclerView.setAdapter(detailsthemefour_receclerview);



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

