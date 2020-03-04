package es.iessaladillo.pedrojoya.quilloque.ui.dial

import DialViewModelFactory
import android.os.Bundle
import android.view.View
import android.view.View.OnLongClickListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.CALL_TYPE_MADE
import es.iessaladillo.pedrojoya.quilloque.data.CALL_TYPE_VIDEO
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import es.iessaladillo.pedrojoya.stroop.data.AppDatabase
import kotlinx.android.synthetic.main.dial_fragment.*
import kotlinx.android.synthetic.main.recent_fragment.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread


class DialFragment : Fragment(R.layout.dial_fragment) {

    val viewModel: DialViewModel by viewModels{

        DialViewModelFactory(AppDatabase.getInstance(requireContext()).callDao, requireActivity().application)

    }

    private val listAdapter: DialFragmentAdapter = DialFragmentAdapter()
        .apply {

            setOnItemCLickListener { marcarNúmero(getItem(it)) }



        }

    private fun marcarNúmero(item: Call) {

        lblNumber.text = item.numero

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {

        viewModel.calls.value = lblNumber.text.toString()

        botones()

        observeViewModel()

        setupRecyclerView()

        registrarLlamadas()

    }

    private fun registrarLlamadas() {

        val sdt = SimpleDateFormat("dd/MM/yyyy")

        val timeFormat = SimpleDateFormat("HH:mm")

        val call = Call(0, lblNumber.text.toString(), lblNumber.text.toString(), sdt.format(Date()), timeFormat.format(Date()), CALL_TYPE_MADE)

        viewModel.insertCall(call)

    }

    private fun registrarVideoLlamadas() {

        val sdt = SimpleDateFormat("dd/MM/yyyy")

        val timeFormat = SimpleDateFormat("HH:mm")

        val call = Call(0, lblNumber.text.toString(), lblNumber.text.toString(), sdt.format(Date()), timeFormat.format(Date()), CALL_TYPE_VIDEO)

        viewModel.insertCall(call)

    }

    private fun setupRecyclerView() {

        lstSuggestions.run {

            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            itemAnimator = DefaultItemAnimator()

            adapter = listAdapter

        }


    }

    private fun observeViewModel() {

        viewModel.run {

            calls.observe(viewLifecycleOwner) {

                    var lista: List<Call> = queryCalls(it.plus("%"))

                if (it == "") {

                    lista = emptyList()


                }

                if (lista.isEmpty() && it != "") {

                    lblCreateContact.visibility = View.VISIBLE

                }

                else {

                    lblCreateContact.visibility = View.GONE

                }

                if (it.isEmpty()) {

                    imgVideo.visibility = View.GONE

                    fabCall.visibility = View.GONE

                }

                else {

                        imgVideo.visibility = View.VISIBLE

                        fabCall.visibility = View.VISIBLE


                }

                    listAdapter.submitList(lista)



                }


            

        }



    }



    private fun botones() {
        lblOne.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("1")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblTwo.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("2")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblThree.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("3")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblFour.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("4")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblFive.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("5")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblSix.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("6")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblSeven.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("7")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblEight.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("8")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblNine.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("9")

            viewModel.calls.value = lblNumber.text.toString()


        }

        lblZero.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("0")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblAstherisc.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("*")

            viewModel.calls.value = lblNumber.text.toString()

        }

        lblPound.setOnClickListener{lblNumber.text = lblNumber.text.toString().plus("#")

            viewModel.calls.value = lblNumber.text.toString()

        }

        imgBackspace.setOnClickListener{

            if (lblNumber.text.isNotEmpty()) {

                lblNumber.text = lblNumber.text.toString().substring(0, lblNumber.text.length - 1)

            }

            viewModel.calls.value = lblNumber.text.toString()

        }

        imgBackspace.setOnLongClickListener(OnLongClickListener {
            lblNumber.text = ""
            viewModel.calls.value = lblNumber.text.toString()
            true
        })

        fabCall.setOnClickListener {

            if (lblNumber.text.toString().isNotEmpty()) {

                registrarLlamadas()

            }

        }

        imgVideo.setOnClickListener {

            if (lblNumber.text.toString().isNotEmpty()) {

                registrarVideoLlamadas()

            }

        }


    }

}

