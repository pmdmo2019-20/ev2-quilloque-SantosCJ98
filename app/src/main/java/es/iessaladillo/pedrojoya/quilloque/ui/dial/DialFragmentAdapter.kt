package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.dial_fragment_item.view.*


typealias OnItemCLickListener = (position: Int) -> Unit

class DialFragmentAdapter : RecyclerView.Adapter<DialFragmentAdapter.ViewHolder>() {

    private var data: List<Call> = emptyList()

    private var OnItemCLickListener: OnItemCLickListener? = null

    fun setOnItemCLickListener(OnItemCLickListener: OnItemCLickListener) {

        this.OnItemCLickListener = OnItemCLickListener

    }

    fun getItem(position: Int) = data.get(position)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        val itemView = layoutInflater.inflate(R.layout.dial_fragment_item, parent, false)

        return ViewHolder(itemView, OnItemCLickListener)

    }

    fun submitList(newData: List<Call>) {

        data = newData

        notifyDataSetChanged()

    }

    init {

        setHasStableIds(true);

    }


    override fun getItemId(position: Int): Long = data[position].idCall

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ViewHolder(override val containerView: View,  OnItemCLickListener: OnItemCLickListener?) :

        RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {

            itemView.setOnClickListener {

                val position = adapterPosition

                if (position != RecyclerView.NO_POSITION) {

                    OnItemCLickListener?.invoke(position)

                }

            }

        }

        fun bind(call: Call) {

            containerView.lblPhoneNumber.text = call.numero

            containerView.lblContactName.text = call.nombre

        }


    }

}