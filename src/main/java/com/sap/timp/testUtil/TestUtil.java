package com.sap.timp.testUtil;

	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.Random;

	import javax.imageio.ImageIO;


	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebElement;

import com.sap.timp.base.TestBaseSteven;


	public class TestUtil extends TestBaseSteven {

		public static long PAGE_LOAD_TIMEOUT = 300;
		public static long IMPLICIT_WAIT = 30;

		public static final String ACCOUNTS_SAVE_CHANGES_SUCCESS_MSG = "undefined was successfully Updated! click 'OK' Button to continue";
		public static final String CREATE_APP_KEY_DISCLAIMER = "*Disclaimer: Once the dialog is closed you will not be able to see the SECRET, to display it again you will need to regenerate the App Key*.";
		public static final String SEND_SMS_SELECT_ORIGIN_NUMBER_DESCRIPTION="Select the LiveLink Number you will send a message from. You can use one default number from Live Link or select a number from the list.";
		public static final String SEND_SMS_SELECT_DESTINATION_NUMBER_DESCRIPTION="Enter the number you will send a message to";
		public static final String SEND_SMS_MESSAGE_BODY_DESCRIPTION="Type in the body of the message you would like to send";
		public static final String LANGUAGE_CODE_SAMPLE_DESCRIPTION="Here is the code needed to send your message in several languages. You can copy and paste this code into your application to send a message. See our Tutorial section for more detailed examples and explanations.";
		public static final String SEND_SMS_SAMPLE_CODE_API_URL="\"https://livelink.sapmobileservices.com/api/v2/sms\"";
		public static final String REVIEW_AND_SEND_SMS_DESCRIPTION="Test your Number by sending your first SMS message with Live Link 365. You can edit your Account Setting or Manage your Numbers anytime from the left panel.";
		public static final String SEND_SMS_SUCCESS_MSG="The SMS was successfully sent from Live Link";
		public static final String GENERATE_2FA_TOKEN_SUCCESS_MSG="The SMS containing the Token was successfully sent. This is your OTP";
		public static final String VALIDATE_2FA_TOKEN_SUCCESS_MSG="Token Validated Successfully";
		public static final String REGISTER_EMAIL_SOFTTOKEN_SUCCESS_MSG="Your user has been registered successfully.";
		public static final String SCAN_QR_CODE_DESCRIPTION="Scan the following QR Code with the Google Authenticator app in order to retrieve soft tokens for the previously registered account.";
		public static final String VALIDATE_QR_CODE_SUCCESS_MSG="Code Validated Successfully.";
		public static final String SEND_EMAIL_DESCRIPTION="Enter an email address and a message you wish to send. Your email will be sent from an SAP Digital Interconnect demo account. If you do not receive the email, please check your spam folder. This tool supports text-only email. The Live Link email API will additionally support emails with an HTML template.";
		public static final String SEND_EMAIL_SUCCESS_MSG="The email was successfully sent from Live Link.";
		
		

		@SuppressWarnings("deprecation")
		public static String randomf() {
			Random r = new Random();
			int num = r.nextInt(300);
			Date d = new Date();
			return String.valueOf(num) + "_" + d.getDate() + d.getYear();
		}

		public static String randomSAPUserID() {
			Random r = new Random();
			int num = r.nextInt(899999) + 100000;
			String sapUserID = "T" + String.valueOf(num);
			System.out.println("random SAP User ID is: " + sapUserID);
			return sapUserID;
		}
		
		public static String randomSmallNumber() {
			Random r = new Random();
			int num = r.nextInt(899) + 100;
			String sapUserID = String.valueOf(num);
			return sapUserID;
		}

		public static String randomName() {
			Random r = new Random(); // just create one and keep it around
			String alphabet = "abcdefghijklmnopqrstuvwxyz";

			final int N = 7;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
			}
			String randomName = sb.toString();
			System.out.println(randomName);
			return randomName;
		}
		/*
		public static String getAbsoluteXPath(WebElement element){
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			   return (String) (js).executeScript(
			    	"function absoluteXPath(element) {"+
					  "var comp, comps = [];"+
						"var parent = null;"+
						"var xpath = '';"+
						"var getPos = function(element) {"+
						"var position = 1, curNode;"+
						"if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
						"return null;"+
						"}"+
						"for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"+
							"if (curNode.nodeName == element.nodeName) {"+
								"++position;"+
							"}"+
						"}"+
						"return position;"+
						"};"+

						"if (element instanceof Document) {"+
							"return '/';"+
						"}"+

						"for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
						"comp = comps[comps.length] = {};"+
						"switch (element.nodeType) {"+
						"case Node.TEXT_NODE:"+
							"comp.name = 'text()';"+
							"break;"+
						"case Node.ATTRIBUTE_NODE:"+
							"comp.name = '@' + element.nodeName;"+
							"break;"+
						"case Node.PROCESSING_INSTRUCTION_NODE:"+
							"comp.name = 'processing-instruction()';"+
							"break;"+
						"case Node.COMMENT_NODE:"+
							"comp.name = 'comment()';"+
							"break;"+
						"case Node.ELEMENT_NODE:"+
							"comp.name = element.nodeName;"+
							"break;"+
						"}"+
						"comp.position = getPos(element);"+
						"}"+

						"for (var i = comps.length - 1; i >= 0; i--) {"+
							"comp = comps[i];"+
							"xpath += '/' + comp.name.toLowerCase();"+
							"if (comp.position !== null) {"+
							"xpath += '[' + comp.position + ']';"+
							"}"+
						"}"+
						"return xpath;"+

					"} return absoluteXPath(arguments[0]);", element);
				}
		*/
		public static String extractTRNumberXpath(String fullString) {
			String partialString = fullString.substring(fullString.indexOf("tr["), fullString.length());
			String number = partialString.substring(partialString.lastIndexOf("tr[") + 3, partialString.indexOf("]"));
			return number;
		}


		public static String getContractEffectiveDate() {
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			System.out.println("today: " + today);
			calendar.add(Calendar.DAY_OF_YEAR, 2);
			Date tomo = calendar.getTime();
			SimpleDateFormat formater = new SimpleDateFormat("MMM dd, yyyy");
			String tomorrow = formater.format(tomo);
			System.out.println("Tommorow is : " + tomorrow);
			return tomorrow;
		}
		/*
		public static String getEnvironment() throws MalformedURLException {
			URL url = new URL(prop.getProperty("url"));
			String hostname = url.getHost();
			String env = null;
			if (hostname.equals("livelink.sapmobileservices.com")) {
				env = "PROD";
			} else if (hostname.equals("demo-livelink.sapmobileservices.com")) {
				env = "DEMO";
			} else if (hostname.equals("llbpal55.pal.sap.corp")) {
				env = "QAS";
			} else {
				System.out.println("Please specify the correct environment");
			}
			return env;

		}
		
	*/
		


}



