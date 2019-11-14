package edu.ncsu.csc.controller.StaffPages;

import edu.ncsu.csc.model.CheckIn;

public class TreatPatient {
    public static boolean checkPrivilege(CheckIn checkin){
         return false;
    }
    public static boolean treating(CheckIn checkin){
        return false;
    }
}
