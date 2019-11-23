package cu.edu.uo.informatizacion.contraloria;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.support.annotation.RawRes;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.*;

public class AbrirPDF {

    AppCompatActivity actividad;
    File  pdfFolder;

    public AbrirPDF(AppCompatActivity act) {
        actividad = act;
         pdfFolder = new File(Environment.getExternalStorageDirectory() + File.separator + "Contraloria" + File.separator + "PDFS");

        if (!pdfFolder.exists())
        {

         //   AsyncTask.execute(new Runnable() {
               // @Override
            //    public void run() {
                    pdfFolder.mkdirs();
                    copyAssets();
              //  }
            //});

        }
    }

    public void PdfOpen(String filename)
    {
      //  synchronized (pdfFolder){
            Intent pdfViewIntent = new Intent(Intent.ACTION_VIEW);

            Uri archivoparaintent;
            File pdfFile = new File(pdfFolder, filename);
           if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
           {
               try {
                   archivoparaintent = Uri.fromFile(pdfFile);
                   pdfViewIntent.setDataAndType(archivoparaintent,"application/pdf");
                   pdfViewIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                   Intent intent = Intent.createChooser(pdfViewIntent, "Open File");

                   actividad.startActivity(intent);
               } catch (Exception e) {
                   Toast.makeText(actividad,"Su telefono no soporta esta acción, puede ver los PDF´S en ´Memoria Interna/Contraloria/PDFS´ " ,Toast.LENGTH_LONG).show();
               }
           }
           else
           {
               try {
           /*    final Uri data = FileProvider.getUriForFile(actividad, "myprovider", pdfFile);
               actividad.grantUriPermission(actividad.getPackageName(), data, Intent.FLAG_GRANT_READ_URI_PERMISSION);
               final Intent intent = new Intent(Intent.ACTION_VIEW)
                       .setDataAndType(data, "application/pdf")
                       .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
               actividad.startActivity(intent);*/

                   final Uri data = FileProvider.getUriForFile(actividad, "cu.edu.uo.informatizacion.contraloria.myprovider", new File(pdfFile.getAbsolutePath()));
                   actividad.grantUriPermission(actividad.getPackageName(), data, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                   final Intent intent = new Intent(Intent.ACTION_VIEW)
                           .setDataAndType(data, "application/pdf")
                           .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                   actividad.startActivity(intent);

                /*   Uri uri = Uri.parse(pdfFile.getAbsolutePath());
                   File file = new File(uri.getPath());
                   if (file.exists()){
                       uri = FileProvider.getUriForFile(actividad, actividad.getPackageName() + ".myprovider", file);
                       pdfViewIntent.setDataAndType(uri, "application/pdf");
                       pdfViewIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                       pdfViewIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                       actividad.startActivity(pdfViewIntent);
                    }*/
               }
               catch (Exception e) {
                   Toast.makeText(actividad,"Su telefono no soporta esta acción, por la versión android, puede ver los PDF´S en ´Memoria Interna/Contraloria/PDFS´ " ,Toast.LENGTH_LONG).show();
               }

           }
      //  }

    }


    private void copyAssets() {
        AssetManager assetManager = actividad.getAssets();
        File outFile = null ;
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
        }
        if (files != null) for (String filename : files) {
            if(filename.endsWith(".pdf"))
            {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                //  outFile = new File(actividad.getExternalFilesDir(null), filename);
                //File outFile = new File(mapsFolder, filename);
                outFile = new File(pdfFolder, filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);

            } catch(IOException e) {
                Toast.makeText(actividad,"Failed to copy asset file: - " + e.getMessage(),Toast.LENGTH_LONG).show();
              //  Log.e("tag", "Failed to copy asset file: " + filename, e);
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
                if (out != null && outFile!=null) {
                    try {
                        out.close();

                    } catch (IOException e) {
                        // NOOP
                    }
                }
             }
            }
        }
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
  /*  void Metodo(){
      //  File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/"+ "eventos.pdf"); // Here you declare your pdf path
        File file = new File("android.resource://"+actividad.getPackageName() +"/"+ R.raw.eventos); // Here you declare your pdf path
        Intent pdfViewIntent = new Intent(Intent.ACTION_VIEW);
        pdfViewIntent.setDataAndType(Uri.fromFile(file),"application/pdf");
        pdfViewIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(pdfViewIntent, "Open File");
        try {
            actividad.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Instruct the user to install a PDF reader here, or something
        }
    }

    void openPdfFromRaw(ImageView imageView, int pageNumber) throws IOException {

        // Copy sample.pdf from 'res/raw' folder into cache so PdfRenderer can handle it
        File fileCopy = new File(actividad.getCacheDir(), "eventos.pdf");
        copyToCache(fileCopy, R.raw.eventos);

        // We get a page from the PDF doc by calling 'open'
        ParcelFileDescriptor fileDescriptor =
                ParcelFileDescriptor.open(fileCopy,
                        ParcelFileDescriptor.MODE_READ_ONLY);
        PdfRenderer mPdfRenderer = new PdfRenderer(fileDescriptor);
       PdfRenderer.Page mPdfPage = mPdfRenderer.openPage(pageNumber);

        // Create a new bitmap and render the page contents into it
        Bitmap bitmap = Bitmap.createBitmap(mPdfPage.getWidth(),
                mPdfPage.getHeight(),
                Bitmap.Config.ARGB_8888);
        mPdfPage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

        // Set the bitmap in the ImageView
        imageView.setImageBitmap(bitmap);
    }

    void copyToCache(File file, @RawRes int pdfResource) throws IOException {

        if (!file.exists()) {
            //Get input stream object to read the pdf
            InputStream input = actividad.getResources().openRawResource(pdfResource);
            FileOutputStream output = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int size;
            // Copy the entire contents of the file
            while ((size = input.read(buffer)) != -1) {
                output.write(buffer, 0, size);
            }
            //Close the buffer
            input.close();
            output.close();
        }
    }


    public void fAbrir(String pdf){
        File fileBrochure = new File(Environment.getExternalStorageDirectory() + "/temp/" + pdf);
        if (!fileBrochure.exists())
        {
            CopyAssetsbrochure(pdf);
        }

        /** PDF reader code */
       // File file = new File(Environment.getExternalStorageDirectory() + "/" + pdf);
     /*   Uri path = Uri.parse("android.resource://"+actividad.getPackageName()+"/raw/eventos.pdf");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(path,"application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try
        {
            actividad.startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {
            Toast.makeText(actividad, "No se encontro una aplicación de pdf", Toast.LENGTH_SHORT).show();
        }
    }

    //method to write the PDFs file to sd card
    private void CopyAssetsbrochure(String pdf) {
        AssetManager assetManager = actividad.getAssets();
        String[] files = null;
        try
        {
            files = assetManager.list("");
        }
        catch (IOException e)
        {
            Log.e("tag", e.getMessage());
        }
        for(int i=0; i<files.length; i++)
        {
            String fStr = files[i];
            if(fStr.equalsIgnoreCase(pdf))
            {
                InputStream in = null;
                OutputStream out = null;
                try
                {
                    in = assetManager.open(files[i]);
                    out = new FileOutputStream(Environment.getExternalStorageDirectory() + "/temp/" + files[i]);
                    copyFile(in, out);
                    in.close();
                    in = null;
                    out.flush();
                    out.close();
                    out = null;
                    break;
                }
                catch(Exception e)
                {
                    Log.e("tag", e.getMessage());
                }
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }*/
}
