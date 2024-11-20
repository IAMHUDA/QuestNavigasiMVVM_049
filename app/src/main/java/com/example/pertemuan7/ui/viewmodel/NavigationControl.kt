package com.example.pertemuan7.ui.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

enum class Halaman{
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: navHostController = rememberNavController()
) {

}
