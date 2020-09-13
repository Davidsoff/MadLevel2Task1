package nl.soffware.madlevel2task1

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nl.soffware.madlevel2task1.databinding.PlaceBinding

class PlaceAdapter(private val places: List<Place>): RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = PlaceBinding.bind(itemView)

        fun databind(place: Place) {
            val image = itemView.resources.getDrawable(place.imageResId, null)

            binding.tvName.text = place.name
            binding.ivImage.setImageDrawable(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout._place, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(places[position])
    }

    override fun getItemCount(): Int {
        return places.size
    }
}