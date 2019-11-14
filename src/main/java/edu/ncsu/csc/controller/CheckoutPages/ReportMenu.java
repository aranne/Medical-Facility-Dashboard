package edu.ncsu.csc.controller.CheckoutPages;

import edu.ncsu.csc.view.CheckoutPages.UpdateDischarge;
import edu.ncsu.csc.view.CheckoutPages.UpdateReferral;
import edu.ncsu.csc.view.CheckoutPages.UpdateNegative;
import edu.ncsu.csc.view.CheckoutPages.ReportConfirm;



public class ReportMenu {
    public static void updateDischarge() {
        UpdateDischarge.display();
    }

    public static void updateReferral() {

        UpdateReferral.display();
    }

    public static void treatDescription() {

        TreatDescription.display();
    }

    public static void updateNegative() {

        UpdateNegative.display();
    }

    public static void reportConfirm() {

        ReportConfirm.display();
    }


    public static void exit() {
    }

}

