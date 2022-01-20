package main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import utils.PlatformTouchAction
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit

class BaseClass {

    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    fun setupDriver(){

        val url = URL("http://127.0.0.1:4723/wd/hub")
        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android") // название платформы
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11") // версия ОС
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nokia 1.3") // имя устройства
        caps.setCapability(MobileCapabilityType.NO_RESET,false) // не сбрасывать приложение в 0 перед новым запуском
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"7200")
        caps.setCapability(MobileCapabilityType.APP,"/Users/andreygerasimov/Downloads/sportmaster-4.0.13.5605_dev_beta.apk") // путь к файлу
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"ru.sportmaster.app.handh.dev") // имя пакета
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"ru.sportmaster.app.presentation.start.StartActivity") // название активити
        caps.setCapability(MobileCapabilityType.UDID,"PT89572AA1A60800280")
        //caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)

        driver = AndroidDriver(url, caps) // установка драйвера и приложения на андроид устройство

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) // будет искать элемент в течение 15 секунд

    }

    @AfterSuite
    fun end(){
        driver.quit()
    }

    @Test
    fun testOne(){
        TimeUnit.SECONDS.sleep(2)

        try {
            lateinit var element: MobileElement // создаем элемент MobileElement
            element = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")) // производим поиск элемента по локатору
            element.click()
            println("Клик по крестику прошел успешно")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, тест продолжается")
        }

        // Ввод текста в поле
        lateinit var element2: MobileElement //создаем элемент MobileElement
        element2 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/editTextPhone")) // поиск элемента по локатору
        element2.sendKeys("9999999969") // ввод текста в поле
        println("Номер телефона введен")

        // Клик по кнопке
        lateinit var element3: MobileElement //создаем элемент MobileElement
        element3 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonGetCode")) //поиск элемента по локатору
        element3.click() // клик по кнопке
        println("Клик по кнопке прошел успешно")

        // Ввод кода
        lateinit var element4: MobileElement //создаем элемент MobileElement
        element4 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/pinCodeEditText")) //поиск элемента по локатору
        element4.sendKeys("1111") //ввод кода в поле
        println("Код введен")

        // Даем добро на местоположение
        lateinit var element5: MobileElement //создаем элемент MobileElement
        element5 = driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")) //поиск элемента по локатору
        element5.click() //клик по кнопке

        // Подтверждение города
        lateinit var element6: MobileElement //создаем элемент MobileElement
        element6 = driver.findElement(MobileBy.id("android:id/button1")) //поиск элемента по локатору
        element6.click() //клик по кнопке Да
        println("Подтверждение города прошло успешно")

        // Переход по табу в профиль
        lateinit var element7: MobileElement //создаем элемент MobileElement
        element7 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/profile_graph")) //поиск элемента по локатору
        element7.click() //тап по табу Профиль
        println("Переход по табу в профиль прошел успешно")

        // Переход в редактирование профиля
        lateinit var element8: MobileElement //создаем элемент MobileElement
        element8 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonEditProfile")) //поиск элемента по локатору
        element8.click() //тап по иконке

        PlatformTouchAction(driver)
            .longPress(PointOption.point(10, 1000))
            .moveTo(PointOption.point(10, 100))
            .release()
            .perform()

//        lateinit var element9: MobileElement //создаем элемент MobileElement
//        element9 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonLogout"))
//        element9.click()



        TimeUnit.SECONDS.sleep(5)
    }
}