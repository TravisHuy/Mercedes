package com.nhathuy.mercedes.data

import com.nhathuy.mercedes.R

object DataSource {
    val mercedes_type= listOf(R.string.sendans,R.string.suvs,R.string.convertibles,R.string.additional,R.string.electric)
    val sendans_list= listOf(R.string.a_class_sedan,R.string.c_class_sedan,R.string.e_class_sedan,R.string.s_class_sedan,
    R.string.cla_coupe,R.string.cls_coupe)
    val suvs_list= listOf(R.string.gla_suv,R.string.glb_suv,R.string.glc_suv,R.string.gle_suv,R.string.gls_suv,R.string.g_class_suv)
    val coupes_list= listOf(R.string.c_class_sedan,R.string.e_class_sedan,R.string.s_class_coupe)
    val convertibles_list= listOf(R.string.c_class_cabriolet,R.string.e_class_cabriolet,
    R.string.s_class_cabriolet,R.string.sl_roadster,R.string.slc_roadster)

    val electric_list= listOf(R.string.eqa,R.string.eqb,R.string.eqc,R.string.eqe,R.string.eqs)

    val additional_list= listOf(R.string.maybach,R.string.amg)

    val quantityOptions= listOf(Pair(R.string.one_mercedes,1),Pair(R.string.ten_mercedes,10),Pair(R.string.one_hundred,100))


}