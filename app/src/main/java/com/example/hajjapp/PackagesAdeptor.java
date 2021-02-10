package com.example.hajjapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PackagesAdeptor extends RecyclerView<RecyclerView.ViewHolder> {
    public interface PackageSelected
    {
        void onPackageSelected(int index);
    }
    PackageSelected packageSelected;
    public PackagesAdeptor(@NonNull PackagesActivity context, List<Packages> packagesList) {
       packageSelected= (PackageSelected) context;
       this.packagesList=packagesList;
    }
    private  List<Packages> packagesList;

   ride
   public  PackagesAdeptor.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.package_show,parent,false);
        return  new ViewHolder(view);

    }

    public  void onBindViewHolder(RecyclerView.ViewHolder holder,int position)
    {
        holder.itemView.setTag(packagesList.get(position));
    }
}
