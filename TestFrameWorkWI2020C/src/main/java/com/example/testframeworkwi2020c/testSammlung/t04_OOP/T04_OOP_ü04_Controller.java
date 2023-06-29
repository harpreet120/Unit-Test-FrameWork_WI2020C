package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü04.MobileTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü04.SmartphoneTester;

public class T04_OOP_ü04_Controller {
    public String testSmartphone(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Smartphone Tests";
        SmartphoneTester smartphoneTester = new SmartphoneTester(jarFilePath);
        if (smartphoneTester.testClick()){
            textAnUser += "\nclick() erfolgreich getestet :)";
        } else {
            textAnUser += "\nclick() hat noch Fehler. Bitte achte darauf, dass \"Klick\" in System.out.println() geschrieben wird ";
        }
        return textAnUser;
    }

    public String testMobile(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Mobile Tests";
        MobileTester mobileTester = new MobileTester(jarFilePath);
        if (mobileTester.testDial()) {
            textAnUser += "\ndial() erfolgreich getestet :)";
        } else {
            textAnUser += "\ndial() hat noch Fehler. Bitte achte darauf, dass \"Piep\" in System.out.println() geschrieben wird ";
        }
        if (mobileTester.testRing()) {
            textAnUser += "\nring() erfolgreich getestet :)";
        } else {
            textAnUser += "\nring() hat noch Fehler. Bitte achte darauf, dass \"Ding Dong\" in System.out.println() geschrieben wird ";
        }
        return textAnUser;
    }
}
