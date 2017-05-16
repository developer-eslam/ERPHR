package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.model.employees;



public class DetailsEmployeeData extends RecyclerView.Adapter<DetailsEmployeeData.DetailsViewHolder> {

    List<employees> employeesList = new ArrayList<>();
    Context context;
    private LayoutInflater layoutInflater;

    public DetailsEmployeeData(Context context,List<employees>employees){

        this.employeesList=employees;
        this.context=context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public DetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.details_employee_data,null);

        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsViewHolder holder, int position) {

        employees employees = employeesList.get(position);
        holder.txtdisplayfirstname.setText(employees.getF_FirstName());
        holder.txtdisplaysceondname.setText(employees.getF_SecondName());
        holder.txtdisplaythirdname.setText(employees.getF_ThirdName());
        holder.txtdisplayfourthname.setText(employees.getF_FourthName());
        holder.txtdisplayF_PK_SSN.setText(employees.getF_PK_SSN());
        holder.txtF_StreetAndBuilding.setText(employees.getF_StreetAndBuilding());
        holder.txtF_DateOfStopingSSN.setText(employees.getF_DateOfStopingSSN());
        holder.txtF_Passport_Expired_Date.setText(employees.getF_Passport_Expired_Date());
        holder.txtF_Status.setText(employees.getF_Status());
        holder.txtF_Religion.setText(employees.getF_Religion());
        holder.txtF_Nationality.setText(employees.getF_Nationality());
    }

    @Override
    public int getItemCount() {

        if(employeesList!=null)
            return employeesList.size();
        else
            return  0;
    }


    public static class DetailsViewHolder extends RecyclerView.ViewHolder{

        TextView txtdisplayfirstname;
        TextView txtdisplaysceondname;
        TextView txtdisplaythirdname;
        TextView txtdisplayfourthname;
        TextView txtdisplayF_PK_SSN;

        TextView txtF_StreetAndBuilding;
        TextView txtF_DateOfStopingSSN;
        TextView txtF_Passport_Expired_Date;
        TextView txtF_Status;
        TextView txtF_Religion;
        TextView txtF_Nationality;

        public DetailsViewHolder(View itemView) {
            super(itemView);
            txtdisplayfirstname=(TextView)itemView.findViewById(R.id.txtdisplayfirstname);
            txtdisplaysceondname=(TextView)itemView.findViewById(R.id.txtdisplaysceondname);
            txtdisplaythirdname=(TextView)itemView.findViewById(R.id.txtdisplaythirdname);
            txtdisplayfourthname=(TextView)itemView.findViewById(R.id.txtdisplayfourthname);
            txtdisplayF_PK_SSN=(TextView)itemView.findViewById(R.id.txtdisplayF_PK_SSN);
            txtF_DateOfStopingSSN=(TextView)itemView.findViewById(R.id.txtdisplayF_DateOfStopingSSN);
            txtF_Nationality=(TextView)itemView.findViewById(R.id.txtdisplayF_Nationality);
            txtF_Passport_Expired_Date=(TextView)itemView.findViewById(R.id.txtdisplayF_Passport_Expired_Date);
            txtF_Religion=(TextView)itemView.findViewById(R.id.txtdisplayF_Religion);
            txtF_Status=(TextView)itemView.findViewById(R.id.txtdisplayF_Status);
            txtF_StreetAndBuilding=(TextView)itemView.findViewById(R.id.txtdisplayF_StreetAndBuilding);
        }
    }
}

