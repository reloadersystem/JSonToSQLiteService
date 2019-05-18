package apptablet.sacooliveros.edu.pe.bdatossemana;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import apptablet.sacooliveros.edu.pe.bdatossemana.Fragment.FragmentA;

public class MainActivity extends AppCompatActivity {

    FragmentA fragmentA;
    FrameLayout contenedor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        if (findViewById(R.id.contenedorFragments) != null) {
            if (savedInstanceState != null) {
                return;
            }


            fragmentA = new FragmentA();
            fragmentA.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedorFragments, fragmentA).commit();


        }

    }


}
