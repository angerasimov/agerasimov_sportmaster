package main

import constructor_classes.locatorsTypes
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.testng.AssertJUnit
import utils.PlatformTouchAction
import java.time.Duration
import java.util.concurrent.TimeUnit

open class TestMethods: BaseClass() {

    // Тап по элементу
    fun clickToElement(locatorType: String, locator: String) {
        lateinit var element: MobileElement
        when (locatorType) {
            locatorsTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorsTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
            locatorsTypes.iOSClassChain -> element = driver.findElement(MobileBy.iOSClassChain(locator))
        }
        element.click()
        TimeUnit.SECONDS.sleep(1)
    }

    // Ввод текста в поле
    fun inputTextInField(locatorType: String, locator: String, inputText: String) {
        lateinit var element: MobileElement
        when (locatorType) {
            locatorsTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorsTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
            locatorsTypes.iOSClassChain -> element = driver.findElement(MobileBy.iOSClassChain(locator))
        }
        element.sendKeys(inputText)
        TimeUnit.SECONDS.sleep(1)
    }

    // Свайп
    fun swipeOnScreen(startCordX: Int, startCordY: Int, moveCordX: Int, moveCordY: Int){
        PlatformTouchAction(driver)
        .longPress(PointOption.point(startCordX, startCordY))
            .moveTo(PointOption.point(moveCordX, moveCordY))
            .release()
            .perform()
    }

    // Скролл до определенного элемента
    fun scrollToElement(locator: String){
        driver.findElement(MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector()" +
                    ".scrollable(true)).scrollIntoView(new UiSelector()" +
                    ".resourceIdMatches(\".*$locator.*\"))")
        )
    }

    // Тап по координатам на экране
    fun tapByCoordinates(
        cordX: Int,
        cordY: Int,
    ) {
        PlatformTouchAction(driver)
            .tap(PointOption.point(cordX, cordY))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
            .perform()
    }

    // Очистка поля ввода
    fun clearField(locatorType: String, locator: String){
        lateinit var element: MobileElement
        when (locatorType) {
            locatorsTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorsTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
            locatorsTypes.iOSClassChain -> element = driver.findElement(MobileBy.iOSClassChain(locator))
        }
        element.clear()
    }

    // Проверка доступности элемента на экране
    fun checkAvailableElement(locatorType: String, locator: String){
        var checkAvailableElement = false
        when (locatorType) {
            locatorsTypes.id -> checkAvailableElement = driver.findElement(MobileBy.id(locator)).isEnabled
            locatorsTypes.xpath -> checkAvailableElement = driver.findElement(MobileBy.xpath(locator)).isEnabled
            locatorsTypes.iOSClassChain -> checkAvailableElement = driver.findElement(MobileBy.iOSClassChain(locator)).isEnabled
        }
        AssertJUnit.assertTrue(checkAvailableElement)
    }

    // Проверка текста в элементе
    fun checkTextInElement(locatorType: String, locator: String, text: String, name: String){
        lateinit var element: MobileElement
        var elementAttribute = ""
        when (locatorType) {
            locatorsTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorsTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
            locatorsTypes.iOSClassChain -> element = driver.findElement(MobileBy.iOSClassChain(locator))
        }
        elementAttribute = element.getAttribute("text")
        var paramPlatformName = ""
        when (paramPlatformName) {
            "iOS" -> {
                AssertJUnit.assertEquals(elementAttribute, name)
            }
            "Android" -> {
                AssertJUnit.assertEquals(elementAttribute, text)
            }
        }
    }

}