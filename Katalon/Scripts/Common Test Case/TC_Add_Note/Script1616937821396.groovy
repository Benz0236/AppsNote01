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

String NoteTime = AddTime

Mobile.comment('Note_Time =' + NoteTime)

Mobile.tap(findTestObject('Object Repository/Pages/NotePage/AddBTN2'), GlobalVariable.G_Timeout)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Common/Utils/FindByText', [('text') : 'Enter your note']), GlobalVariable.G_Timeout)

Mobile.setText(findTestObject('Object Repository/Pages/NoteEntryPage/NoteEditor'), NoteTime, GlobalVariable.G_Timeout)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Common/Utils/FindByText', [('text') : NoteTime]), GlobalVariable.G_Timeout)

Mobile.tap(findTestObject('Object Repository/Pages/NoteEntryPage/SaveBTN'), GlobalVariable.G_Timeout)

Mobile.tap(findTestObject('Object Repository/Pages/NoteEntryPage/Label - OK'), GlobalVariable.G_Timeout)

Mobile.verifyElementExist(findTestObject('Object Repository/Common/Utils/FindByText', [('text') : NoteTime]), GlobalVariable.G_Timeout)

return NoteTime

