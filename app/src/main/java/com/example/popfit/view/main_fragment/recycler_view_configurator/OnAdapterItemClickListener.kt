package com.example.popfit.view.main_fragment.recycler_view_configurator

import com.example.popfit.domain.Exercise

interface OnAdapterItemClickListener {

    fun onClick(exercise: Exercise)

}