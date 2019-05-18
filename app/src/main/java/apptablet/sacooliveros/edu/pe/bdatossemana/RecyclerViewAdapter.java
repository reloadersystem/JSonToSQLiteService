package apptablet.sacooliveros.edu.pe.bdatossemana;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Model> mModelList;

    public RecyclerViewAdapter(Context mContext, List<Model> mModelList) {
        this.mContext = mContext;
        this.mModelList = mModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Model model = mModelList.get(position);

        holder.txtcodigo.setText(model.getCodigo());
        holder.txtasignatura.setText(model.getAsignatura());
        holder.txtcapitulo.setText(model.getCapitulo());
        holder.txturlpdf.setText(model.getUrlpdf());

      holder.txtssdpdf.setText(model.getSsdpdf());

      holder.imagendb.setImageResource(R.drawable.ambiente_2);


        boolean habilita = model.isHabilitar();

        holder.txt_deshabilitardb.setText(String.valueOf(habilita));

        String materia = model.getAsignatura();

//        if (habilita) {
//            holder.txtcodigo.setEnabled(false);
//            holder.cardview_id.setBackgroundColor(Color.GRAY);
//            holder.txtcodigo.setTextColor(Color.WHITE);
//            }
//        else {
//            holder.cardview_id.setEnabled(true);
//            }

        if (materia.equalsIgnoreCase("Biologia")&& habilita) {
            holder.imagendb.setImageResource(R.drawable.grisbiologia);
            holder.txtcodigo.setEnabled(false);
            holder.txtasignatura.setEnabled(false);
            holder.txtcapitulo.setEnabled(false);
            holder.txturlpdf.setEnabled(false);
            holder.txtssdpdf.setEnabled(false);
            holder.txt_deshabilitardb.setEnabled(false);


            holder.cardview_id.setBackgroundColor(Color.GRAY);
            holder.txtcodigo.setTextColor(Color.BLUE);
        }

        if (materia.equalsIgnoreCase("Quimica")) {
            holder.imagendb.setImageResource(R.drawable.ambiente_3);
            holder.txtcodigo.setTextColor(Color.BLUE);
        }


        holder.txtcodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return mModelList == null ? 0 : mModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView txtcodigo;
        private TextView txtasignatura;
        private TextView txtcapitulo;
        private TextView txturlpdf;
        private TextView txtssdpdf;
        private TextView txt_deshabilitardb;

        private CardView cardview_id;

        private ImageView imagendb;




        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtcodigo = itemView.findViewById(R.id.txt_codigodb);
            txt_deshabilitardb= itemView.findViewById(R.id.txt_deshabilitardb);
            txtasignatura = itemView.findViewById(R.id.txt_asiganturadb);
            txtcapitulo = itemView.findViewById(R.id.txt_capitulodb);
            txturlpdf = itemView.findViewById(R.id.txt_urlpdfdb);
            txtssdpdf = itemView.findViewById(R.id.txt_ssdpdfdb);
            cardview_id = itemView.findViewById(R.id.cardview_id);
            imagendb = itemView.findViewById(R.id.imagendb);

        }
    }
}
