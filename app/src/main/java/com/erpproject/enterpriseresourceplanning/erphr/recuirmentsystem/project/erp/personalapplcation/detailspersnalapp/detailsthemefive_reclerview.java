package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.detailspersnalapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.model.personalappliactionmodel;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abotaleb on 12/8/2016.
 */

public class detailsthemefive_reclerview   extends RecyclerView.Adapter<detailsthemefive_reclerview.Holder> {

    @Bind(R.id.textin)
    EditText textIn;
    @OnClick(R.id.add)
    public void insertitemsinpdffile(){



        if(textIn.getText().toString().isEmpty()){
            Toast.makeText(context.getApplicationContext(),R.string.MustBeInsertData,Toast.LENGTH_SHORT).show();
        }
        else{
            layout.setVisibility(View.VISIBLE);

            N = Integer.parseInt(textIn.getText().toString());
            final EditText[] texts = new EditText[N];

            for( i=0;i<N;i++){
                text= new EditText(context.getApplicationContext());



                LayoutInflater layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                addView = layoutInflater.inflate(R.layout.row, null);
                container.addView(text);
                text.setBackgroundColor(Color.WHITE);
                text.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.style5));
                text.setHintTextColor(Color.BLACK);
                text.setTextColor(Color.BLACK);
                text.setHint(R.string.inserttextasyoulike);
                text.setPadding(20, 30, 20, 5);

                LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                buttonLayoutParams.setMargins(2, 25, 12, 0);






                text.setLayoutParams(buttonLayoutParams);

                texts[i]=textIn;


            }

            container.addView(addView);
            textIn.setText("");

        }
    }
    @OnClick(R.id.createpdf)
    public void createpdffile(){
        Document document = new Document(PageSize.LETTER, -20, 50, -15, 0);

        String outpath = Environment.getExternalStorageDirectory()+"/application.pdf";


        Toast.makeText(context.getApplicationContext(),outpath,Toast.LENGTH_LONG).show();

        try {



            PdfWriter.getInstance(document,new FileOutputStream(outpath));


            List<EditText>editTextList=new ArrayList<EditText>();

            document.open();

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(30);
            paragraph.setSpacingBefore(30);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            paragraph.add(personalappliactionmodel.PERSONAL_DETAILS + Chunk.NEWLINE+ Chunk.NEWLINE);



            paragraph.add(personalappliactionmodel.FIRST_NAME + " " + " " + " " + " "  + " " + " "
                    + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " ");


            paragraph.add(personalappliactionmodel.MIDDLE_NAME + " " + " " + " " + " "  + " " + " "
                    + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " ");


            paragraph.add(personalappliactionmodel.LAST_NAME + Chunk.NEWLINE+ Chunk.NEWLINE);


            paragraph.add(personalappliactionmodel.ADDRESS + Chunk.NEWLINE+ Chunk.NEWLINE);


            paragraph.add(personalappliactionmodel.DATE + " " + " " + " " + " "  + " " + " "
                    + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " "+ " " + " " + " " + " "+ " " );


            paragraph.add( personalappliactionmodel.PHONE + Chunk.NEWLINE+ Chunk.NEWLINE);



            paragraph.add(personalappliactionmodel.CITY + " " + " " + " " + " "  + " " + " "
                    + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " "+ " " + " " + " " + " "+ " " + " " + " "
            );





            paragraph.add(personalappliactionmodel.Gender + " " + " " + " " + " "  + " " + " "
                    + " " + " " + " "
            );



            paragraph.add(personalappliactionmodel.MALE + " " + " " + " " + " "  + " " + " "
                    + " " + " " + " " + " " + " " + " "
                    + " " + " " + " " + " " );



            paragraph.add(personalappliactionmodel.FEMALE);




            document.add(paragraph);

            setBackground(document);


            for (int m = 0; m <= N; m++) {


                text = (EditText) container.getChildAt(m);
                editTextList.add((text));

                setBackground(document);


                document.add(new Paragraph(Chunk.NEWLINE +
                        " " + " " + " " + " " + " " + " " + " " +

                        " " + " " +

                        editTextList.get(m).getText().toString()+ Chunk.NEWLINE));

            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        document.close();

    }
    public List<personalappliactionmodel>personalappliactionmodels;
    @Bind(R.id.container)
    LinearLayout container;
    @Bind(R.id.lin)
    LinearLayout layout;
    Context context;
    EditText text;
    View addView;
    int N;
    int i;

    public detailsthemefive_reclerview( Context context,List<personalappliactionmodel>personalappliactionmodels){
        this.personalappliactionmodels=personalappliactionmodels;
        this.context = context;

    }
    @Override
    public Holder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_fragment_five,parent,false);

        ButterKnife.bind(this,view);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {


        holder.fname.setText(R.string.firstname);
        holder.mname.setText(R.string.middlename);
        holder.lname.setText(R.string.lastname);
        holder.address.setText(R.string.Address);
        holder.phone.setText(R.string.Phone);
        holder.date.setText(R.string.Date);
        holder.city.setText(R.string.City);

    }

    @Override
    public int getItemCount() {
        return personalappliactionmodels.size();
    }


    public class Holder extends RecyclerView.ViewHolder{

        TextView fname,mname,lname,address,date,phone,city;
        public Holder(View itemView) {
            super(itemView);

            fname=(TextView)itemView.findViewById(R.id.fname);
            mname=(TextView)itemView.findViewById(R.id.mname);
            lname=(TextView)itemView.findViewById(R.id.lname);
            address=(TextView)itemView.findViewById(R.id.address);
            date=(TextView)itemView.findViewById(R.id.date);
            phone=(TextView)itemView.findViewById(R.id.phone);
            city=(TextView)itemView.findViewById(R.id.city);


        }
    }


    private void setBackground(Document document) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ugugu);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        Image img;
        try {
            img = Image.getInstance(stream.toByteArray());
            img.setAbsolutePosition(-20, 195);

            document.add(img);


        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
