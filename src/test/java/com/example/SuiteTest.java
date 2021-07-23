package com.example;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class) // Es una suite que debe ejecutarse

@SelectPackages("com.example") // filtrar por un paquete

// 3. filtro por etiquetas (tiene que estar también uno de los filtros
// anteriores)

@SuiteDisplayName("Suite de testing") // Nombre a mostrar de la suite
public class SuiteTest {

}
