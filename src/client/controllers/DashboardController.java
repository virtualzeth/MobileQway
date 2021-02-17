package client.controllers;

import client.views.DashboardView;
import client.views.LoginView;
import handlers.ErrorHandler;

public class DashboardController extends Controller {
    DashboardView dashboardView = new DashboardView();

    public void dashboard() {
        // TODO
        switch (dashboardView.dashboard()) {
            case 0 -> exit();
            case 1 -> System.out.println("qwe");
            case 2, 3, 4 -> System.out.println("Comming soon...");
            default -> ErrorHandler.invalidInputError();
        }
    }
}
