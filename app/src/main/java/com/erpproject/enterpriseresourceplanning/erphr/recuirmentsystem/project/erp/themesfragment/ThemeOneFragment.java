package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.themesfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.educations.educationtheme.educationthemeone;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.experience.experiencetheme.experiencethemeone;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.other.othertheme.otherthemeone;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.personalapplcation.persinalapptheme.PersoanlApp;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.skills.themeskills.skillsthemeone;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ThemeOneFragment extends Fragment {

    Button personalappliaction;
    Button educations;
    Button experience;
    Button skills;
    Button other;
    Button compine;
    public ThemeOneFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_theme_one, container, false);
        personalappliaction=(Button)view.findViewById(R.id.personalapp);
        educations=(Button)view.findViewById(R.id.educations);
        experience=(Button)view.findViewById(R.id.experience);
        skills=(Button)view.findViewById(R.id.skills);
        other=(Button)view.findViewById(R.id.other);
        compine=(Button)view.findViewById(R.id.compine);

        personalappliaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getActivity(),PersoanlApp.class));
            }
        });
        educations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),educationthemeone.class));
            }
        });
        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),experiencethemeone.class));
            }
        });
        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),skillsthemeone.class));
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),otherthemeone.class));

            }
        });
        compine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<InputStream> pdfs = new ArrayList<InputStream>();


                    try {
                        pdfs.add(new FileInputStream(("/storage/emulated/0/application.pdf")));
                        pdfs.add(new FileInputStream("/storage/emulated/0/educations.pdf"));
                        pdfs.add(new FileInputStream("/storage/emulated/0/experience.pdf"));
                        pdfs.add(new FileInputStream("/storage/emulated/0/skill.pdf"));
                        pdfs.add(new FileInputStream("/storage/emulated/0/other.pdf"));
                        OutputStream output = new FileOutputStream("/storage/emulated/0/RecruitmentApplication.pdf");
                        Toast.makeText(getContext(),"Done Compine",Toast.LENGTH_LONG).show();

                        concatnatpdffiles(pdfs,output);

                    } catch (FileNotFoundException e) {
                        Toast.makeText(getContext(),"Must be insert data in all file to compine ",Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    public  void concatnatpdffiles(List<InputStream> list, OutputStream outputStream) {
        Document document = new Document(PageSize.LETTER, -40, -15, -15, 5);

                 try {
                     PdfWriter  writer = PdfWriter.getInstance(document, outputStream);
                     document.open();
                     PdfContentByte pdfContentByte = writer.getDirectContent();
                     for (InputStream in : list) {
                         PdfReader reader = new PdfReader(in);
                         for (int i = 1; i <=reader.getNumberOfPages(); i++) {
                             document.newPage();
                             PdfImportedPage page = writer.getImportedPage(reader, i);
                             pdfContentByte.addTemplate(page, 0, 0);
                         }
                     }
                     outputStream.flush();
                     document.close();
                     outputStream.close();
                 } catch (DocumentException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
}


