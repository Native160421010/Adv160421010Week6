package com.wildfire.adv160421010week6.view

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wildfire.adv160421010week6.databinding.LegionnaireListItemBinding
import com.wildfire.adv160421010week6.model.Features
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
        Picasso.get().load(legionnaireList[position].images).into(holder.binding.imageView)

        holder.binding.txtID.text = legionnaireList[position].id
        holder.binding.txtCodename.text = legionnaireList[position].codename
        holder.binding.txtName.text = legionnaireList[position].name + " of " + legionnaireList[position].planet
        holder.binding.txtPower.text = legionnaireList[position].power
        holder.binding.txtJoined.text = legionnaireList[position].joined

        holder.binding.txtBirthday.text = legionnaireList[position].birthday

        val features: Features? = legionnaireList[position].features
        if (features != null) {
            holder.binding.txtHair.text = features.hair
            holder.binding.txtEye.text = features.eyes
            holder.binding.txtHeight.text = features.height
            holder.binding.txtWeight.text = features.weight  + " lbs"
        }

        val hobby = legionnaireList[position].hobbies
        val formattedHobbies = hobby?.joinToString(separator = "\n\u2022 ") { it }
        holder.binding.txtHobby.text = "\u2022 $formattedHobbies"

        holder.binding.txtAmbition.text = legionnaireList[position].ambition
        holder.binding.txtTree.text = legionnaireList[position].tree
        holder.binding.txtChange.text = legionnaireList[position].change

//        holder.binding.btnDetail.setOnClickListener {
//            val action = LegionnaireListFragmentDirections.actionLegionnaireDetail()
//            Navigation.findNavController(it).navigate(action)
//        }

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