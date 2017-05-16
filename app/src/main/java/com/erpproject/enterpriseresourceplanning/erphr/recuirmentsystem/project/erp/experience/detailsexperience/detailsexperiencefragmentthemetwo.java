package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.experience.detailsexperience;

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
 * Created by abotaleb on 12/14/2016.
 */

public class detailsexperiencefragmentthemetwo  extends RecyclerView.Adapter<detailsexperiencefragmentthemetwo.Holder> {


    @Bind(R.id.textin)
    EditText textIn;
    @OnClick(R.id.add)
    public void insertitemsinpdffile(){

        if(textIn.getText().toString().isEmpty()){
            Toast.makeText(context.getApplicationContext(),R.string.MustBeInsertData,Toast.LENGTH_SHORT).show();
        }else {

            layout.setVisibility(View.VISIBLE);

            N = Integer.parseInt(textIn.getText().toString());
            final EditText[] texts = new EditText[N];

            for (i = 0; i < N; i++) {
                text = new EditText(context.getApplicationContext());


                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                addView = layoutInflater.inflate(R.layout.row, null);
                container.addView(text);
                text.setBackgroundColor(Color.WHITE);
                text.setHintTextColor(Color.BLACK);
                text.setTextColor(Color.BLACK);
                text.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.style2));

                text.setHint(R.string.inserttextasyoulike);
                text.setPadding(20, 30, 20, 5);

                LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                buttonLayoutParams.setMargins(2, 25, 12, 0);


                text.setLayoutParams(buttonLayoutParams);

                texts[i] = textIn;


            }

            container.addView(addView);
            textIn.setText("");
        }
    }
    @OnClick(R.id.createpdf)
    public void createpdffile(){

        Document document = new Document(PageSize.LETTER, -20, 50, -15, 0);

        String outpath = Environment.getExternalStorageDirectory()+"/experience.pdf";

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

            paragraph.add("Experience:"+ Chunk.NEWLINE+ Chunk.NEWLINE );


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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Bind(R.id.container)
    LinearLayout container;
    @Bind(R.id.lin)
    LinearLayout layout;
    Context context;
    EditText text;
    View addView;
    int N;
    int i;
    public detailsexperiencefragmentthemetwo( Context context){
        this.context = context;

    }
    @Override
    public Holder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailsexperiencethemetwo,parent,false);

        ButterKnife.bind(this,view);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public class Holder extends RecyclerView.ViewHolder{

        public Holder(View itemView) {
            super(itemView);


        }
    }


    private void setBackground(Document document) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.thetwo);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        Image img;
        try {
            img = Image.getInstance(stream.toByteArray());
            img.setAbsolutePosition(-20, 0);

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




