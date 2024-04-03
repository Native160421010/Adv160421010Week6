package com.wildfire.adv160421010week6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.wildfire.adv160421010week6.databinding.LegionnaireListItemBinding
import com.wildfire.adv160421010week6.model.Legionnaire

class LegionnaireListAdapter(val legionnaireList:ArrayList<Legionnaire>)
    :RecyclerView.Adapter<LegionnaireListAdapter.LegionnaireViewHolder>(){
    class LegionnaireViewHolder(var binding: LegionnaireListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegionnaireViewHolder {
        val binding = LegionnaireListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return LegionnaireViewHolder(binding)

    }

    override fun onBindViewHolder(holder: LegionnaireViewHolder, position: Int) {
        holder.binding.txtID.text = legionnaireList[position].id
        holder.binding.txtCodename.text = legionnaireList[position].name

        holder.binding.btnDetail.setOnClickListener {
            val action = LegionnaireListFragmentDirections.actionLegionnaireDetail()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return legionnaireList.size
    }

    fun updateLegionnaireList(newLegionnaireList: ArrayList<Legionnaire>) {
        legionnaireList.clear()
        legionnaireList.addAll(newLegionnaireList)
        notifyDataSetChanged()
    }
}