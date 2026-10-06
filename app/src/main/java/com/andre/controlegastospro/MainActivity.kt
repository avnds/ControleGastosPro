package com.andre.controlegastospro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andre.controlegastospro.ui.CadastroGastoScreen
import com.andre.controlegastospro.ui.ListaGastosScreen
import com.andre.controlegastospro.viewmodel.GastoViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ControleGastosApp()
        }
    }
}

@Composable
fun ControleGastosApp() {

    val navController = rememberNavController()

    val viewModel: GastoViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {

        composable("lista") {
            ListaGastosScreen(
                viewModel = viewModel,
                onAdicionarClick = {
                    navController.navigate("cadastro")
                }
            )
        }

        composable("cadastro") {
            CadastroGastoScreen(
                viewModel = viewModel,
                onVoltar = {
                    navController.popBackStack()
                }
            )
        }
    }
}