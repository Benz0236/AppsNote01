package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable
import sample.Device

public class Common {
	@Keyword
	def startAppliucation() {
		//		String appPath = RunConfiguration.getProjectDir() + '/App/Coffee Timer.ipa'
		Mobile.startExistingApplication(GlobalVariable.App_ID_iOS)
	}

	/**
	 * PressBack Button
	 * @param Back Button Text On iOS, android mobile uses pressBack function	 
	 * @return void
	 */
	@Keyword
	def PressBack(String iosBackWord){

		Device device = new Device()
		if(device.isIOS()) {
			Mobile.tap(findTestObject('Object Repository/Common/Utils/FindByText',[('text'): iosBackWord]), 10)
		}
		else if(device.isAndroid()) {
			Mobile.pressBack()
		}
	}


	/**
	 * PressBack Button
	 * @param Back Button Text On iOS, android mobile uses pressBack function
	 * @return void
	 */
	@Keyword
	def GetRepositoryByOS(String path){

		Device device = new Device()
		String os = ''
		if(device.isIOS()) {
			os = 'iOS'
		}
		else if(device.isAndroid()) {
			os = 'Android'
		}

		return findTestObject('Object Repository/Common/OS/'+ os + '/' + path)
	}
}
