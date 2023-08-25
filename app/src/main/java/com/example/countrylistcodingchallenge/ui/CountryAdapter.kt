package com.example.countrylistcodingchallenge.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.chandracodingchallenge.R
import com.example.countrylistcodingchallenge.data.model.CountryItemModel

class CountryAdapter(private val countries: List<CountryItemModel>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.countryName.text = "${country.name}, ${country.region}"
        holder.capital.text = "Capital  ::   ${country.capital}"
        holder.code.text =  "Country Code  ::   ${country.code}"
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.country_name)
        val capital: TextView = itemView.findViewById(R.id.country_capital)
        val code: TextView = itemView.findViewById(R.id.country_code)
    }
}