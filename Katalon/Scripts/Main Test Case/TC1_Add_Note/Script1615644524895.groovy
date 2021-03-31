import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver

if (CustomKeywords.'sample.Device.isIOS'()) {
    Mobile.startExistingApplication(GlobalVariable.App_ID_iOS)
} else if (CustomKeywords.'sample.Device.isAndroid'()) {
    Mobile.startExistingApplication(GlobalVariable.App_ID_Android)
}


String Time1 = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date())

Mobile.comment('Time =' + Time1)

String newTime1 = Mobile.callTestCase(findTestCase('Common Test Case/TC_Add_Note'), [('guid') : Time1], FailureHandling.STOP_ON_FAILURE)

Mobile.comment('newTime =' + newTime1)

Mobile.verifyElementExist(findTestObject('Object Repository/Pages/NotePage/ListID', [('text') : newTime1]), GlobalVariable.G_Timeout)

Mobile.tap(findTestObject('Pages/NotePage/listID', [('text') : newTime1]), 0)

Mobile.tap(findTestObject('Pages/NoteEntryPage/android.widget.Button - DELETE'), 0)

'Close application'
Mobile.closeApplication()

