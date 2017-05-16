package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity.DetailsEmployeeActivity;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.fragment.DetailsEmployeeFragment;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.model.employees;

/**
 * Created by Eslam on 3/25/2017.
 */

public class RecyclerViewApdaterEmployeeReports
        extends RecyclerView.Adapter<RecyclerViewApdaterEmployeeReports.ViewHolder>  {





    List<employees> employeesList;


    Context context;

    public RecyclerViewApdaterEmployeeReports(Context context,List<employees>employees){
        this.employeesList=employees;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        employees employees = employeesList.get(position);

        holder.txtfirstname.setText(employees.getF_FirstName());
        holder.txtsecondname.setText(employees.getF_SecondName());
        holder.txtthirdname.setText(employees.getF_ThirdName());
        holder.txtfourthname.setText(employees.getF_FourthName());
        holder.txtF_PK_SSN.setText(employees.getF_PK_SSN());


        holder.txtF_Nationality.setText(employees.getF_Nationality());
        holder.txtF_StreetAndBuilding.setText(employees.getF_StreetAndBuilding());
        holder.txtF_Religion.setText(employees.getF_Religion());
        holder.txtF_Status.setText(employees.getF_Status());
        holder.txtF_Passport_Expired_Date.setText(employees.getF_Passport_Expired_Date());
        holder.txtF_DateOfStopingSSN.setText(employees.getF_DateOfStopingSSN());


    }

    @Override
    public int getItemCount() {
        if(employeesList!=null) {
            return employeesList.size();
        }

        return  0;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtfirstname;
        TextView txtsecondname;
        TextView txtthirdname;
        TextView txtfourthname;
        TextView txtF_PK_SSN;


        TextView txtF_StreetAndBuilding;
        TextView txtF_DateOfStopingSSN;
        TextView txtF_Passport_Expired_Date;
        TextView txtF_Status;
        TextView txtF_Religion;
        TextView txtF_Nationality;


        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);



            txtfirstname=(TextView)itemView.findViewById(R.id.txtfirstname);
            txtsecondname=(TextView)itemView.findViewById(R.id.txtsceondname);
            txtthirdname=(TextView)itemView.findViewById(R.id.txtthirdname);
            txtfourthname=(TextView)itemView.findViewById(R.id.txtfourthname);
            txtF_PK_SSN=(TextView)itemView.findViewById(R.id.txtF_PK_SSN);



            txtF_DateOfStopingSSN=(TextView)itemView.findViewById(R.id.txtF_DateOfStopingSSN);
            txtF_Nationality=(TextView)itemView.findViewById(R.id.txtF_Nationality);
            txtF_Passport_Expired_Date=(TextView)itemView.findViewById(R.id.txtF_Passport_Expired_Date);
            txtF_Religion=(TextView)itemView.findViewById(R.id.txtF_Religion);
            txtF_Status=(TextView)itemView.findViewById(R.id.txtF_Status);
            txtF_StreetAndBuilding=(TextView)itemView.findViewById(R.id.txtF_StreetAndBuilding);

            cardView=(CardView)itemView.findViewById(R.id.cardview);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {

                    context = v.getContext();
                    Intent intent = new Intent(context.getApplicationContext(), DetailsEmployeeActivity.class);

                    String fname = txtfirstname.getText().toString();
                    String sname = txtsecondname.getText().toString();
                    String tname = txtthirdname.getText().toString();
                    String foname = txtfourthname.getText().toString();
                    String F_PK_SSN = txtF_PK_SSN.getText().toString();

                    String F_StreetAndBuilding = txtF_StreetAndBuilding.getText().toString();
                    String F_DateOfStopingSSN = txtF_DateOfStopingSSN.getText().toString();
                    String F_Passport_Expired_Date = txtF_Passport_Expired_Date.getText().toString();
                    String F_Status = txtF_Status.getText().toString();
                    String F_Religion = txtF_Religion.getText().toString();
                    String F_Nationality = txtF_Nationality.getText().toString();

                    intent.putExtra("firstname",fname);
                    intent.putExtra("secondname",sname);
                    intent.putExtra("thirdname",tname);
                    intent.putExtra("fourthname",foname);
                    intent.putExtra("F_PK_SSN",F_PK_SSN);

                    intent.putExtra("F_StreetAndBuilding",F_StreetAndBuilding);
                    intent.putExtra("F_DateOfStopingSSN",F_DateOfStopingSSN);
                    intent.putExtra("F_Passport_Expired_Date",F_Passport_Expired_Date);
                    intent.putExtra("F_Status",F_Status);
                    intent.putExtra("F_Nationality",F_Nationality);
                    intent.putExtra("F_Religion",F_Religion);

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);
                }
            });
        }



    }
}

