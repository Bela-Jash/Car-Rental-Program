package services;

import models.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    protected List<Admin> admins = new ArrayList<>();

    protected void initializeAdminsList() {
        // ToDo: Read all admins from file and add them to the admins List
    }

    public List<Admin> getAdmins() {
        initializeAdminsList();
        return admins;
    }
}
