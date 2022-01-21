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
import utils.appPath
import java.net.URL
import java.util.concurrent.TimeUnit


open class BaseClass {

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
        caps.setCapability(MobileCapabilityType.APP,"/Users/andreygerasimov/Downloads/sportmaster-4.0.13.5736_dev_beta.apk") //appPath.fullAppLocalPathAndroid  путь к файлу
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"ru.sportmaster.app.handh.dev") // имя пакета
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"ru.sportmaster.app.presentation.start.StartActivity") // название активити
        caps.setCapability(MobileCapabilityType.UDID,"PT89572AA1A60800280")
        //caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)

        driver = AndroidDriver(url, caps) // установка драйвера и приложения на андроид устройство

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) // будет искать элемент в течение 15 секунд

    }

    @AfterSuite
    fun end(){
        driver.quit()
    }

}