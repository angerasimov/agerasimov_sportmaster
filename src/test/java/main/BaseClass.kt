package main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.util.concurrent.TimeUnit

class BaseClass {

    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    fun setupDriver(){

        val url = URL("http://127.0.0.1:4723/wd/hub")
        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android") // название платформы
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11") // версия ОС
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 5") // имя устройства
        caps.setCapability(MobileCapabilityType.NO_RESET,false) // не сбрасывать приложение в 0 перед новым запуском
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"7200")
        caps.setCapability(MobileCapabilityType.APP,"/Users/andreygerasimov/Downloads/sportmaster-4.0.13.5605_dev_beta.apk") // путь к файлу
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"ru.sportmaster.app.handh.dev") // имя пакета
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"ru.sportmaster.app.presentation.start.StartActivity") // название активити
        //caps.setCapability(MobileCapabilityType.UDID,"")

        driver = AndroidDriver(url, caps) // установка драйвера и приложения на андроид устройство

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) // будет искать элемент в течение 5 секунд

    }

    @AfterSuite
    fun end(){
        driver.quit()
    }

    @Test
    fun testOne(){
        TimeUnit.SECONDS.sleep(1)

        try {
            lateinit var element: MobileElement // создаем элемент MobileElement
            element = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton\n")) // производим поиск элемента по локатору
            element.click()
            println("клик прошел успешно")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, тест продолжается")
        }

        // Ввод текста в поле
        lateinit var element2: MobileElement //создаем элемент MobileElement
        element2 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/editTextPhone")) // поиск элемента по локатору
        element2.sendKeys("9999999905") // ввод текста в поле

        //
        lateinit var element3: MobileElement //создаем элемент MobileElement
        element3 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonGetCode")) //поиск элемента по локатору
        element3.click() // клик по кнопке

        TimeUnit.SECONDS.sleep(5)
    }
}