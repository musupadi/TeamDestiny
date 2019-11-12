package com.destiny.destinyteam.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.destiny.destinyteam.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewerActivity extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);
        pdfView = findViewById(R.id.pdfView);
        Intent data = getIntent();
        String PDFData = data.getStringExtra("PDF");
        pdfView.fromAsset(PDFData).load();
    }
}
