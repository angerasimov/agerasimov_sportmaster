package main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.AutomationName
import io.appium.java_client.remote.IOSMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.*
import utils.appPath
import java.net.URL
import java.util.concurrent.TimeUnit


open class BaseClass {

    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    @Parameters(
        value = ["paramPlatformName", "paramDeviceName",
            "paramPlatformVersion", "paramTimeToDelay", "paramUDID"]
    )
    fun setupDriver(paramPlatformName: String, paramDeviceName: String, paramPlatformVersion: String,
                    paramTimeToDelay: Long, paramUDID: String){

        val url = URL("http://127.0.0.1:4723/wd/hub")
        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, paramPlatformName) // название платформы
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, paramPlatformVersion) // версия ОС
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, paramDeviceName) // имя устройства
        caps.setCapability(MobileCapabilityType.NO_RESET,true) // не сбрасывать приложение в 0 перед новым запуском
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"7200")
        caps.setCapability(MobileCapabilityType.UDID, paramUDID)
         //appPath.fullAppLocalPathAndroid  путь к файлу
        caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true)

        when(paramPlatformName){
            "Android" -> {
                caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.sportmaster.app.handh.dev")
                caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ru.sportmaster.app.presentation.start.StartActivity")
                caps.setCapability(MobileCapabilityType.APP,"/Users/andreygerasimov/Desktop/apps/Sportmaster-android/.sportmaster-4.0.13.5736_dev_beta.apk")
                driver = AndroidDriver(url, caps)
            }
            "iOS" -> {
                caps.setCapability(MobileCapabilityType.APP,"/Users/andreygerasimov/Desktop/apps/Sportmaster-ios/sportmaster.app")
                driver = IOSDriver(url, caps)
            }
        }

        driver.manage().timeouts().implicitlyWait(paramTimeToDelay, TimeUnit.SECONDS) // будет искать элемент в течение 20 секунд

        //проверка наличия онбординга + прохождение до главного экрана, минуя авторизацию, если онбординг найден
        driver.closeApp() // ios 15+ это не сраобтает
        driver.resetApp() // для айос 15+

    }

    @AfterSuite
    fun end(){
        driver.quit()
    }

    @BeforeClass
    fun beforeClass(){
        //заново инициализировать драйвер (подсказка - написать отдельную функцию для инициализации драйвера и переиспользовать ее)
        //закрыть приложение
    }

    @AfterClass
    fun afterClass(){
        //закрыть сессию драйвера
        driver.quit()
    }

    @BeforeMethod
    fun beforeMethod(){
        driver.launchApp() //запустить приложение
        TimeUnit.SECONDS.sleep(5)
    }

    @AfterMethod
    fun afterMethod(){
        //закрыть приложение
    }

}