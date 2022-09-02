package com.merttoptas.jetpack_compose_component_box.navigation

sealed class NavScreen(val route: String) {
    object DashBoard : NavScreen("dashboard")
    object Buttons : NavScreen("buttons")
    object Otp : NavScreen("otp")
    object Loading : NavScreen("loading")
    object ExpandableCard : NavScreen("expandableCard")
    object BasicCards : NavScreen("basicCards")
    object ProgressDialog : NavScreen("progressDialog")
    object SearchBar : NavScreen("searchBar")
}