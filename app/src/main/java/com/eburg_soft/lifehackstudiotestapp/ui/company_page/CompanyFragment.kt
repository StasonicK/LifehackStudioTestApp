package com.eburg_soft.lifehackstudiotestapp.ui.company_page

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.ui.MainActivity
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.Company
import kotlinx.android.synthetic.main.fragment_company.tv_id
import kotlinx.android.synthetic.main.fragment_company.tv_image
import kotlinx.android.synthetic.main.fragment_company.tv_name

class CompanyFragment() : Fragment(R.layout.fragment_company) {

    private var company: Company? = null

    companion object {
        const val TAG = "CompanyFragment"

        private const val COMPANY = "Company"

        @JvmStatic
        fun getNewInstance(company: Company) = CompanyFragment().apply {
            arguments = Bundle().apply { putParcelable(COMPANY, company) }
        }
    }

    override fun onStart() {
        super.onStart()
        setupToolbar()
        bindViews()
    }

    private fun setupToolbar() {
        val actionBar: ActionBar? = (activity as MainActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.title = ""
    }

    private fun bindViews() {
        tv_id.text = company?.id ?: ""
        tv_name.text = company?.name ?: ""
        tv_image.text = company?.image ?: ""
    }
}