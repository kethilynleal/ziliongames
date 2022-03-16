package paginas;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Metodos {

    WebDriver driver;

    /**
     * Abrir navegador e site
     *
     * @author Kethilyn A Leal
     *
     */
    public void abrirNavegador(String site, String navegador, String descricaoPasso) throws IOException {

        try {
            if (navegador == "Chrome" || navegador == "Firefox") {
                if (navegador == "Chrome") {
                    System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(false);
                    driver = new ChromeDriver(options);
                    driver.get(site);
                    driver.manage().window().maximize();
                } else if (navegador == "Firefox") {
                    System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
                    FirefoxProfile profile = new FirefoxProfile();

                    FirefoxOptions options = new FirefoxOptions();
                    options.setHeadless(false);
                    driver = new FirefoxDriver(options);
                    driver.get(site);
                    driver.manage().window().maximize();
                }
            } else {
                System.out.println("Opcao invalida escolha Chrome ou Firefox");
            }
        } catch (Exception e) {
            printScreenErros("Erro ao tentar -- " + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "  --  Erro ao tentar " + descricaoPasso);
        }
    }

    /**
     * Escrever
     *
     * @author Kethilyn A Leal
     *
     */
    public void escrever(By elemento, String texto, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).sendKeys(texto);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Clicar
     *
     * @author Kethilyn A Leal
     *
     */
    public void clicar(By elemento, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).click();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Submit
     *
     * @author Kethilyn A Leal
     *
     */
    public void submit(By elemento, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).submit();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Print Screen
     *
     * @author Kethilyn A Leal
     *
     */
    public void printScreen(String nomePrint) throws IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy");
        SimpleDateFormat formater1 = new SimpleDateFormat("dd_MM_yyyy");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File("./evidencias/" + formater1.format(calendar.getTime()) + "/" + nomePrint + ".png");
            FileUtils.copyFile(screenshotFile, targetFile);
    }

    /**
     * Print Screen de Erros
     *
     * @author Kethilyn A Leal
     *
     */
    public void printScreenErros(String descricaoPasso) throws IOException {
        TakesScreenshot print = ((TakesScreenshot) driver);
        if (print == null) {
            System.out.println("**** No driver ****");
            return;
        }
        File SrcFile = print.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./evidencias/Erros/" + descricaoPasso + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

    /**
     * Fechar Navegador
     *
     * @author Kethilyn A Leal
     *
     */
    public void fecharNavegador(String descricaoPasso) throws IOException {
        try {
            driver.quit();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Super Click
     *
     * @author Kethilyn A Leal
     *
     */
    public void superClick(By elemento, String descricaoPasso) throws IOException {
        try {
            superClick((By) driver.findElement(elemento), descricaoPasso);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Duplo Click
     *
     * @author Kethilyn A Leal
     *
     */
    public void duploCliqueNoElemento(By elemento, String descricaoPasso) throws IOException {
        long TIMEOUT = 60;
        Actions action = new Actions(driver);
        try {
            driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
            action.doubleClick(
                    new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(elemento)));
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Selecionar Combo na Posicao
     *
     * @author Kethilyn A Leal
     *
     */
    public void selecionarComboPosicao(By elemento, int posicao, String descricaoPasso) throws IOException {
        try {
            WebElement webElement = driver.findElement(elemento);
            Select combo = new Select(webElement);
            combo.selectByIndex(posicao);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Selecionar Combo no Texto
     *
     * @author Kethilyn A Leal
     *
     */
    public void selecionarComboTexto(By elemento, String texto, String descricaoPasso) throws IOException {
        try {
            WebElement webElement = driver.findElement(elemento);
            Select combo = new Select(webElement);
            combo.selectByVisibleText(texto);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Esperar ser clicavel
     *
     * @author Kethilyn A Leal
     *
     */
    public void esperarClicavel(By elemento, String descricaoPasso) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Validar Pagina
     *
     * @author Kethilyn A Leal
     *
     */
    public void validarPagina(String pagina, String descricaoPasso) throws IOException {
        try {
            String pag = driver.getTitle();
            assertEquals(pagina, pag);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Validar Texto
     *
     * @author Kethilyn A Leal
     *
     */
    public void validarTexto(By elemento, String texto, String descricaoPasso) throws IOException {
        try {
            String msg = driver.findElement(elemento).getText();
            assertEquals(texto, msg);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Pausa
     *
     * @author Kethilyn A Leal
     *
     */
    public void pausa(int tempo, String descricaoPasso) throws InterruptedException, IOException {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Esperar Alert na Tela
     *
     * @author Kethilyn A Leal
     *
     */
    public void esperarAlert(int tempo, String descricaoPasso) throws IOException {
        try {
            new WebDriverWait(driver, tempo).until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    public void switcPage() {
        driver.switchTo().alert().accept();
    }

    /**
     * Passar o Mouse no Elemento Sem Clicar
     *
     * @author Kethilyn A Leal
     *
     */
    public void passarMouse(By elemento, String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            WebElement passarMouse = driver.findElement(elemento);
            action.moveToElement(passarMouse).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Pressionar tecla Enter
     *
     * @author Kethilyn A Leal
     *
     */
    public void teclaEnter(String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Clicar e segurar, mover e soltar com mouse
     *
     * @author Kethilyn A Leal
     *
     */
    public void moverElemento(By elementoOrigem, By elementoDestino, String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            WebElement origem = driver.findElement(elementoOrigem);
            WebElement destino = driver.findElement(elementoDestino);
            action.dragAndDrop(origem, destino).build().perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * teclaPageUp
     *
     * @author Kethilyn A Leal
     *
     */
    public void teclaPageUp(String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_UP).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * teclaPageDw
     *
     * @author Kethilyn A Leal
     *
     */
    public void teclaPageDw(String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_DOWN).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * botaoVoltar
     *
     * @author Kethilyn A Leal
     *
     */
    public void botaoVoltar(String descricaoPasso) throws IOException {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * botaoAtualizar
     *
     * @author Kethilyn A Leal
     *
     */
    public void botaoAtualizar(String descricaoPasso) throws IOException {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * teclaBackSpace
     *
     * @author Kethilyn A Leal
     *
     */
    public void teclaBackSpace(String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.BACK_SPACE).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * limparTexto
     *
     * @author Kethilyn A Leal
     *
     */
    public void limparTexto(By elemento, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).clear();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * limparTextoAlternativo
     *
     * @author Kethilyn A Leal
     *
     */
    public void limparTextoAlternativo(By elemento, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    public void validarTexto(By validarTextoCadastro, String área_do_cliente) {
    }
}
