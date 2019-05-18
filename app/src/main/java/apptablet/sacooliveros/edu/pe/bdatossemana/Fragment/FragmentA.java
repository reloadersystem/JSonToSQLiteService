package apptablet.sacooliveros.edu.pe.bdatossemana.Fragment;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import apptablet.sacooliveros.edu.pe.bdatossemana.DataBaseHelper.AdminSQLiteOpenHelper;
import apptablet.sacooliveros.edu.pe.bdatossemana.DataBaseHelper.Utilidades;
import apptablet.sacooliveros.edu.pe.bdatossemana.Model;
import apptablet.sacooliveros.edu.pe.bdatossemana.R;
import apptablet.sacooliveros.edu.pe.bdatossemana.RecyclerViewAdapter;
import apptablet.sacooliveros.edu.pe.bdatossemana.WebServices.MicrosoftWSConsult;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    View  rootview;

    ArrayList<Model> listacursos;

    RecyclerView recyclerViewCursos;

    AdminSQLiteOpenHelper conn;

    Button btLetsGet;

    RelativeLayout relativeLayout;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_a, container, false);

        conn= new AdminSQLiteOpenHelper(rootview.getContext(), "administraciones", null, 1);

        listacursos= new ArrayList<>();

        recyclerViewCursos= rootview.findViewById(R.id.recycler_view);

        relativeLayout = rootview.findViewById(R.id.lnMainFragment);

        MicrosoftWSConsult consult = new MicrosoftWSConsult();
        consult.setCurrentContext(getContext());
        consult.setCurrentLayout(relativeLayout);
        consult.execute();


        btLetsGet=  rootview.findViewById(R.id.btLetsGet);

        recyclerViewCursos.setLayoutManager(new LinearLayoutManager(rootview.getContext()));

        consultarlistaAsiganturas();

        RecyclerViewAdapter  adapter= new RecyclerViewAdapter(rootview.getContext(), listacursos);
        GridLayoutManager manager= new GridLayoutManager(rootview.getContext(),1);

        recyclerViewCursos.setHasFixedSize(true);
        recyclerViewCursos.setLayoutManager(manager);

        recyclerViewCursos.setAdapter(adapter);


        return rootview;
    }

    private void consultarlistaAsiganturas() {

        SQLiteDatabase db= conn.getReadableDatabase();
        Model model=null;

        Cursor cursor= db.rawQuery("SELECT * FROM " + Utilidades.TABLA_VIDEOSEMINARIO, null);

        while(cursor.moveToNext())
        {
            model=new Model();
            model.setCodigo(cursor.getString(0));
            model.setAsignatura(cursor.getString(1));
            model.setHabilitar(Boolean.parseBoolean(cursor.getString(2)));
            model.setCapitulo(cursor.getString(3));
            model.setUrlpdf(cursor.getString(4));
            model.setSsdpdf(cursor.getString(5));

            listacursos.add(model);
        }
    }

}
