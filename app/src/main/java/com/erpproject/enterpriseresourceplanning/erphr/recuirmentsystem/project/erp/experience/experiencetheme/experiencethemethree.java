package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.experience.experiencetheme;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.experience.detailsexperience.detailsexperiencefragmentthemethree;

/**
 * Created by abotaleb on 12/14/2016.
 */

public class experiencethemethree extends Activity {

    RecyclerView recyclerView;
    com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.experience.detailsexperience.detailsexperiencefragmentthemethree detailsexperiencefragmentthemethree;


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

        detailsexperiencefragmentthemethree = new detailsexperiencefragmentthemethree(getApplicationContext());

        recyclerView.setAdapter(detailsexperiencefragmentthemethree);



    }








}

