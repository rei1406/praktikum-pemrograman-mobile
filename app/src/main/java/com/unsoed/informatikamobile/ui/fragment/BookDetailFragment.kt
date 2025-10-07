package com.unsoed.informatikamobile.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.GenericLifecycleObserver
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.unsoed.informatikamobile.R
import com.unsoed.informatikamobile.databinding.FragmentBookDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailFragment(
    private val title: String,
    private val author: String,
    private val year: String,
    private val coverId: Int
) : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters

    private var _binding: FragmentBookDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        Toast.makeText(context, "$coverId", Toast.LENGTH_SHORT).show()
        binding.textViewTitle.text = title
        binding.textViewAuthor.text = author
        binding.textViewYear.text = year

        if(coverId != 0) {
            val url = "https://covers.openlibrary.org/b/id/$coverId-M.jpg"
            Glide.with(this)
                .load(url)
                .into(binding.imageViewCover)
        } else {
            binding.imageViewCover.setImageResource(
                R.drawable.book_not_found
            )
        }
    }
}