package com.sonup.class8;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.CustomHlder> {

    Context context ;
    String[] title ;
    String []htmlFile ;

    public CustomAdapter1(Context context, String[] title, String[] htmlfile) {
        this.context = context;
        this.title = title;
        this.htmlFile = htmlfile;
    }

    @NonNull
    @Override
    public CustomHlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_layout , parent , false);

        return new CustomHlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHlder holder, int position) {
        final String htmlfile = htmlFile[position];

        holder.textView.setText(title[position]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , Study1Activity.class );
                intent.putExtra("file" , htmlfile);
                context.startActivity(intent);
//          ((CategorynActivity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class CustomHlder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout ;
        TextView textView;


        public CustomHlder(@NonNull View itemView) {
            super(itemView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.Linear);
            textView = (TextView)itemView.findViewById(R.id.title);
        }
    }
}
