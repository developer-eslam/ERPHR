package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.educations.educationtheme;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.educations.detailseducation.detailseducationfragmentthemethere;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.educations.model.educationmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abotaleb on 12/14/2016.
 */

public class educationthemethree extends Activity {

    RecyclerView recyclerView;
    com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.educations.detailseducation.detailseducationfragmentthemethere detailseducationfragmentthemethere;


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

        detailseducationfragmentthemethere = new detailseducationfragmentthemethere(getApplicationContext(),educationmodelList(1));

        recyclerView.setAdapter(detailseducationfragmentthemethere);



    }
    public List<educationmodel> educationmodelList(int size){
        List<educationmodel>educationmodel = new ArrayList<educationmodel>(

        );

        for(int i=0;i<size;i++){
            educationmodel educationmodels = new educationmodel();

            educationmodels.high_school = educationmodels.HIGH_SCHOOL;
            educationmodels.degree_major = educationmodels.DEGREE_MAJOR;
            educationmodels.undergraduate_collage = educationmodels.Undergraduate_COLLAGE;





            educationmodel.add(educationmodels);


        }

        return educationmodel;
    }







}



