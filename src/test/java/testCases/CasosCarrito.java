package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CasosCarrito extends Base{
    @BeforeSuite
    public void AbrirNavegador() {
        navegador.get("https://thetestingstore.com/");
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void elegirArticulosAzarCarritoCompras() {
        Assert.assertEquals(navegador.getTitle(), "The Testing Store");

        //Sellecionar  articulos al azar
        //1.- llamar lista de webelements - se crea en la base
        WebElement contenedorDeProductos = navegador.findElement(By.id("Featured")); //Indicar a la lista de donde consigue los elementos
        listaDeProductos = contenedorDeProductos.findElements(By.tagName("a")); // Indicar a la lista que elementos elegir
        //System.out.println(listaDeProductos.size()); //traer el numero de elementos de la sección indicada

        if (listaDeProductos.size()<4) {
            cantidadLista = listaDeProductos.size();
        } else {
            cantidadLista = 3;
        }

        for (int i = 0; i<cantidadLista; i++){
            numeroAlAzar = (int) (Math.random() * listaDeProductos.size() +1);
            if (productosAlAzar.contains(numeroAlAzar)){
                i--;
            } else {
                productosAlAzar.add(numeroAlAzar);
            }
        }
        productosAlAzar.forEach(System.out::println);
    }

    @Test(dependsOnMethods = {"elegirArticulosAzarCarritoCompras"})
    public void anadirProductosAlCarrito() {
        for (int i=0; i<cantidadLista; i++){

        }
    }

    @AfterSuite
    public void CerrarNavegador () {
        navegador.close();
    }
}
