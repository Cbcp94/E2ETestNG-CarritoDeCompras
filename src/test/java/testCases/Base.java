package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Base {
    //Colocamos los elementos que son comunes para todos los casos de pruebas
    WebDriver navegador = new ChromeDriver();

    //1.- crear lista de webelements
    List<WebElement> listaDeProductos = new ArrayList<WebElement>();
    int cantidadLista;
    int numeroAlAzar;
    List<Integer> productosAlAzar = new ArrayList<Integer>();

}
