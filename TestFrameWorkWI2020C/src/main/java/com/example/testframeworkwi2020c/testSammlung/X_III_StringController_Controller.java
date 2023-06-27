package com.example.testframeworkwi2020c.testSammlung;

import com.example.testframeworkwi2020c.testSammlung.x_III_StringController.StringControllerTester;

public class X_III_StringController_Controller {

    public String testStringController(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Stringcontroller Tests";
        StringControllerTester tester = new StringControllerTester(jarFilePath);
        //TestAddString
        if (tester.testAddString()) {
            textAnUser += "\naddString() erfolgreich getestet :)";
        } else {
            textAnUser += "\naddString() hat noch Fehler :(";
        }
        //TestReplaceStringWithIndices
//        if (tester.testReplaceStringWithIndices()) {
//            textAnUser += "\nreplaceStringWithIndices() erfolgreich getestet :)";
//        } else {
//            textAnUser += "\nreplaceStringWithIndices() hat noch Fehler :(";
//        }
        //TestReplaceStringWithStartIndex
//        if (tester.testReplaceStringWithStartIndex()) {
//            textAnUser += "\nreplaceStringWithStartIndex() erfolgreich getestet :)";
//        } else {
//            textAnUser += "\nreplaceStringWithStartIndex() hat noch Fehler :(";
//        }
        //TestGetString
        if (tester.testGetString()) {
            textAnUser += "\ngetString() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetString() hat noch Fehler :(";
        }
        //TestSetString
        if (tester.testSetString()) {
            textAnUser += "\nsetString() erfolgreich getestet :)";
        } else {
            textAnUser += "\nsetString() hat noch Fehler :(";
        }
        //TestGetLength
        if (tester.testGetLength()) {
            textAnUser += "\ngetLength() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetLength() hat noch Fehler :(";
        }
        //TestGetCapacity
        if (tester.testGetCapacity()) {
            textAnUser += "\ngetCapacity() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetCapacity() hat noch Fehler :(";
        }
        return textAnUser;
    }
}
