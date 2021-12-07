import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SauceLabs {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                .concat("\\src\\test\\resources\\drivers\\chromedriver.exe"));
        /**
         *Precondicion: Se debe contar con acceso a la pagina web
         */
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        /**
         * Postcondiciones, acciones necesarias para dejar la aplicacion en el estado original
         * o de acciones de limpieza post prueba
         */
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void deberiaRegistrarse() throws InterruptedException {

    WebElement botonInicioSesion = driver.findElement(By.xpath("//a[@class='login']"));
    botonInicioSesion.click();

    WebElement textIngresarEmail = driver.findElement(By.id("email_create"));
    textIngresarEmail.sendKeys("linadaniela.salazaxr@utp.edu.co");

    WebElement botonCrearCuenta = driver.findElement(By.id("SubmitCreate"));
    botonCrearCuenta.click();

        Thread.sleep(5000);

    WebElement textTipoGenero = driver.findElement(By.id("id_gender1"));
    textTipoGenero.click();

    WebElement IngresarPrimerNombre = driver.findElement(By.id("customer_firstname"));
    IngresarPrimerNombre.sendKeys("Daniela");

    WebElement IngresarPrimerApellido = driver.findElement(By.id("customer_lastname"));
    IngresarPrimerApellido.sendKeys("Luna");

    WebElement IngresarPassword = driver.findElement(By.id("passwd"));
    IngresarPassword.sendKeys("1234Dany@");

    WebElement IngresarDia = driver.findElement(By.id("days"));
    IngresarDia.sendKeys("17");

    WebElement IngresarMes = driver.findElement(By.id("months"));
    IngresarMes.sendKeys("March");

    WebElement IngresarAno = driver.findElement(By.id("years"));
    IngresarAno.sendKeys("1998");

    WebElement IngresarEmpresa = driver.findElement(By.id("company"));
    IngresarEmpresa.sendKeys("Indra");

    WebElement IngresarDireccion = driver.findElement(By.id("address1"));
    IngresarDireccion.sendKeys("Calle 30 A #29-53");

    WebElement IngresarDireccion2 = driver.findElement(By.id("address2"));
    IngresarDireccion2.sendKeys("Calle 30 A #29-53");

    WebElement IngresarCiudad = driver.findElement(By.id("city"));
    IngresarCiudad.sendKeys("Pereira");

    Select IngresarEstado = new Select(driver.findElement(By.id("id_state")));
    IngresarEstado.selectByVisibleText("California");

    WebElement IngresarCodigoPostal = driver.findElement(By.id("postcode"));
    IngresarCodigoPostal.sendKeys("27001");

    Select IngresarPais = new Select(driver.findElement(By.id("id_country")));
    IngresarPais.selectByVisibleText("United States");

    WebElement AdicionarInformacion = driver.findElement(By.id("other"));
    AdicionarInformacion.sendKeys("No hay informacion");

    WebElement AdicionarTelefonoFijo = driver.findElement(By.id("phone"));
    AdicionarTelefonoFijo.sendKeys("355656");

    WebElement AdicionarTelefonoMovil = driver.findElement(By.id("phone_mobile"));
    AdicionarTelefonoMovil.sendKeys("32135645");

    WebElement AdicionarDireccionFutura = driver.findElement(By.id("alias"));
    AdicionarDireccionFutura.sendKeys("Calle 30 A #29-53");

    WebElement botonRegistrar = driver.findElement(By.id("submitAccount"));
    botonRegistrar.click();

    WebElement NombreUsuario = driver.findElement(By.xpath("//span[contains(.,'Daniela Luna')]"));

        Assertions.assertEquals("Daniela Luna", NombreUsuario.getText());
    }

    @Test
    public void deberiaIniciarSesionCuandoEnviamosCredencialesValidas() throws InterruptedException {

        WebElement botonInicioSesion = driver.findElement(By.xpath("//a[@class='login']"));
        botonInicioSesion.click();

        WebElement cajaEmail = driver.findElement(By.id("email"));
        cajaEmail.sendKeys("ingedanielaluna@gmail.com");

        WebElement cajaPassword = driver.findElement(By.id("passwd"));
        cajaPassword.sendKeys("108817Dany");

        WebElement botonIngresar = driver.findElement(By.id("SubmitLogin"));
        botonIngresar.click();

        //Assertions.assertEquals("My account - My Stores", driver.getTitle());

        WebElement NombreUsuario = driver.findElement(By.xpath("//span[contains(.,'Daniela luna')]"));

        Assertions.assertEquals("Daniela luna", NombreUsuario.getText());

    }

    @Test
    public void deberiaCoincidirElTitulo() throws InterruptedException {
        Assertions.assertEquals("Swag Labs", driver.getTitle());
    }
}
