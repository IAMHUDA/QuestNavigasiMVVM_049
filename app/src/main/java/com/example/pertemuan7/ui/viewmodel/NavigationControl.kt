package com.example.pertemuan7.ui.viewmodel

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan7.model.ListGender
import com.example.pertemuan7.ui.view.DetailMahasiswaView
import com.example.pertemuan7.ui.view.FormMahasiswaView

enum class Halaman{
    Form,
    Data
}

@Composable
fun NavigatorControl(
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController(),
    modifier: Any
) {
    val uiState by viewModel.dataModel.collectAsState()
    NavHost(
        navController = navHost,
        startDestination = Halaman.Form.name
        ) {
            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listGender = ListGender.listGender.map { isi ->
                        konteks.resources.getString(isi)
                    },
                    onSubmitClick = {
                        viewModel.saveDataMhs(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }

        composable(route = Halaman.Data.name) {
            DetailMahasiswaView(
                dataMhs = uiState,
                modifier = Modifier,
                onBackButton = { navHost.popBackStack() }
            )
        }


    }
    }
}
