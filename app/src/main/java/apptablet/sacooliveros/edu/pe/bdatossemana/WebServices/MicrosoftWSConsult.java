package apptablet.sacooliveros.edu.pe.bdatossemana.WebServices;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import apptablet.sacooliveros.edu.pe.bdatossemana.DataBaseHelper.AdminSQLiteOpenHelper;
import apptablet.sacooliveros.edu.pe.bdatossemana.DataBaseHelper.Utilidades;

public class MicrosoftWSConsult extends AsyncTask<String, Integer, String> {
    private RelativeLayout currentLayout;
    private Context currentContext;
    private final ArrayList<JSONObject> dataResult = new ArrayList<>();
    private ProgressBar progressBar;

    JSONObject valVMotivadores;

    //SETTER AND GETTER
    private RelativeLayout getCurrentLayout() {
        return currentLayout;
    }

    public void setCurrentLayout(RelativeLayout currentLayout) {
        this.currentLayout = currentLayout;
    }

    private Context getCurrentContext() {
        return currentContext;
    }

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        progressBar = getCurrentLayout().findViewById(R.id.progressBar);
//        if (progressBar != null) {
//            progressBar.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    protected void onCancelled(String arrayList) {
        super.onCancelled(arrayList);
//        if (progressBar != null) {
//            progressBar.setVisibility(View.GONE);
//        }
    }

    protected String doInBackground(String... strings) {

        WebServiceTools wstools = new WebServiceTools();

        String rString = WebServiceTools.requestFromWebService("http://tablet.sacooliveros.edu.pe/", 8080, "", strings);

        Log.d("RESPONSE Servidor Saco", rString);

        ArrayList<JSONObject> resValues = new ArrayList<>();

        if (WebServiceTools.isValidResponse(rString)) {
            try {
                JSONArray resArraydata2 = new JSONArray(rString);

                for (int idx = 0; idx < resArraydata2.length(); idx++) {
                    JSONObject arrayItem = resArraydata2.getJSONObject(idx);

                    valVMotivadores = new JSONObject();
                    valVMotivadores.put("codigo", arrayItem.getString("codigo"));
                    valVMotivadores.put("asignatura", arrayItem.getString("asignatura"));
                    valVMotivadores.put("habilitar", arrayItem.getString("habilitar"));
                    valVMotivadores.put("capitulo", arrayItem.getString("capitulo"));
                    valVMotivadores.put("urlpdf", arrayItem.getString("urlpdf"));
                    valVMotivadores.put("ssdpdf", arrayItem.getString("ssdpdf"));
                    valVMotivadores.put("tomopdf", arrayItem.getString("tomopdf"));
                    valVMotivadores.put("gradopdf", arrayItem.getString("gradopdf"));

                    resValues.add(valVMotivadores);


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return rString;
    }

    @Override
    protected void onPostExecute(String rString) {
        super.onPostExecute(rString);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getCurrentContext(), "administraciones", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        final String MNU_CODIGO = "codigo";
        final String MNU_ASIGNATURA = "asignatura";
        final String MNU_HABILITAR = "habilitar";
        final String MNU_CAPITULO = "capitulo";
        final String MNU_URLPDF = "urlpdf";
        final String MNU_SSDPDF = "ssdpdf";
        final String MNU_TOMOPDF = "tomopdf";
        final String MNU_GRADOPDF = "gradopdf";

        try {
            JSONArray menuItemsJsonArray = new JSONArray(rString);

            for (int i = 0; i < menuItemsJsonArray.length(); ++i) {

                String codigo;
                String asignatura;
                String habilitar;
                String capitulo;
                String urlpdf;
                String ssdpdf;
                String tomopdf;
                String gradopdf;

                JSONObject menuItemObject = menuItemsJsonArray.getJSONObject(i);

                codigo = menuItemObject.getString(MNU_CODIGO);
                asignatura = menuItemObject.getString(MNU_ASIGNATURA);
                habilitar = menuItemObject.getString(MNU_HABILITAR);
                capitulo = menuItemObject.getString(MNU_CAPITULO);
                urlpdf = menuItemObject.getString(MNU_URLPDF);
                ssdpdf = menuItemObject.getString(MNU_SSDPDF);
                tomopdf = menuItemObject.getString(MNU_TOMOPDF);
                gradopdf = menuItemObject.getString(MNU_GRADOPDF);

                ContentValues registro = new ContentValues();
                registro.put(Utilidades.CAMPO_CODIGO, codigo);
                registro.put(Utilidades.CAMPO_ASIGNATURA, asignatura);
                registro.put(Utilidades.CAMPO_HABILITAR, habilitar);
                registro.put(Utilidades.CAMPO_CAPITULO, capitulo);
                registro.put(Utilidades.CAMPO_URLPDF, urlpdf);
                registro.put(Utilidades.CAMPO_SSDPDF, ssdpdf);
                registro.put(Utilidades.CAMPO_TOMOPDF, tomopdf);
                registro.put(Utilidades.CAMPO_GRADOPDF, gradopdf);

                BaseDeDatos.insert("videoseminario", null, registro);
                BaseDeDatos.close();


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
