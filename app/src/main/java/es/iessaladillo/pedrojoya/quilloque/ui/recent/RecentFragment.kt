package es.iessaladillo.pedrojoya.quilloque.ui.dial

import DialViewModelFactory
import RecentViewModelFactory
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.entity.Call
import es.iessaladillo.pedrojoya.quilloque.ui.recent.RecentFragmentAdapter
import es.iessaladillo.pedrojoya.quilloque.ui.recent.RecentViewModel
import es.iessaladillo.pedrojoya.stroop.data.AppDatabase
import kotlinx.android.synthetic.main.dial_fragment.*
import kotlinx.android.synthetic.main.recent_fragment.*

class RecentFragment : Fragment(R.layout.recent_fragment) {

    val viewModel: RecentViewModel by viewModels{

        RecentViewModelFactory(AppDatabase.getInstance(requireContext()).callDao, requireActivity().application)

    }

    private val listAdapter: RecentFragmentAdapter = RecentFragmentAdapter()
        .apply {



        }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {

        observeViewModel()

        setupRecyclerView()

    }

    private fun observeViewModel() {

        viewModel.run {

            recents.observe(viewLifecycleOwner) {

                if (it.isEmpty()) {

                    emptyView.visibility = View.VISIBLE

                }

                else {

                    emptyView.visibility = View.GONE

                }

                listAdapter.submitList(it)

            }

        }

    }

    private fun setupRecyclerView() {

        lstCalls.run {

            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            itemAnimator = DefaultItemAnimator()

            adapter = listAdapter

        }


    }

}