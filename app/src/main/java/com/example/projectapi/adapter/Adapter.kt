package com.example.projectapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectapi.R
import com.example.projectapi.SuratResponse

class Adapter(private val suratResponse: List<SuratResponse>) : RecyclerView.Adapter<Adapter.SuratViewHolder>() {

    inner class SuratViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNamaSurat: TextView = itemView.findViewById(R.id.tvNamaSurat)
        private val tvNamaLatin: TextView = itemView.findViewById(R.id.tvNamaLatin)
        private val tvJumlahAyat: TextView = itemView.findViewById(R.id.tvJumlahAyat)
        private val tvTempatTurun: TextView = itemView.findViewById(R.id.tvTempatTurun)
        private val tvArti: TextView = itemView.findViewById(R.id.tvArti)
        private val tvDeskripsi: TextView = itemView.findViewById(R.id.tvDeskripsi)


        fun bind(currentItem: SuratResponse) {
            tvNamaSurat.text = "Nama Surat: ${currentItem.nama}"
            tvNamaLatin.text = "Nama Latin: ${currentItem.namaLatin}"
            tvJumlahAyat.text = "Jumlah Ayat: ${currentItem.jumlahAyat}"
            tvTempatTurun.text = "Tempat Turun: ${currentItem.tempatTurun}"
            tvArti.text = "Arti: ${currentItem.arti}"
            tvDeskripsi.text = "Deskripsi: ${currentItem.deskripsi}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuratViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return SuratViewHolder(view)
    }

    override fun getItemCount(): Int {
        return suratResponse.size
    }

    override fun onBindViewHolder(holder: SuratViewHolder, position: Int) {
        val currentItem = suratResponse[position]
        holder.bind(currentItem)
    }
}
