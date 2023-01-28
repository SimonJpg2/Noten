package de.simonjpg.noten;

import de.simonjpg.noten.Backend.BackendController;
import de.simonjpg.noten.Backend.LoginControllerImplementation;
import de.simonjpg.noten.Frontend.FrontendController;
import de.simonjpg.noten.Frontend.windows.LoginFrame;
import de.simonjpg.noten.Frontend.windows.RegisterFrame;

/**
 * Class NotenApp.
 *
 * <p>
 *     Main of NotenApp.
 *     Application to display college marks and store them in a DB.
 * </p>
 * @author SimonJpg
 * @version 1.0
 * @since 28.12.2022
 */

public class NotenApp {

    public static void main(String[] args) {
        // Controller
        FrontendController frontendController = new FrontendController(
                new BackendController(),
                new LoginControllerImplementation());

        // Frames
        RegisterFrame registerFrame = new RegisterFrame(frontendController);
        LoginFrame loginFrame = new LoginFrame(frontendController, registerFrame);

        registerFrame.setLoginFrame(loginFrame);
        registerFrame.setVisible(true);
        loginFrame.setVisible(false);
    }
}
