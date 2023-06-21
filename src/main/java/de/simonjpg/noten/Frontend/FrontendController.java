package de.simonjpg.noten.Frontend;

import de.simonjpg.noten.Backend.Controller.BackendController;
import de.simonjpg.noten.Backend.Controller.LoginControllerImplementation;
import de.simonjpg.noten.Frontend.windows.LoginFrame;
import de.simonjpg.noten.Frontend.windows.RegisterFrame;

/**
 * Class FrontendController.
 *
 * <p>
 *     Creates interface between Frontend and Backend.
 * </p>
 * @author SimonJpg
 * @version 1.2
 * @since 30.12.2022
 */
public class FrontendController {
    private final BackendController backendController;
    private final LoginControllerImplementation loginControllerImplementation;

    /**
     * Constructor FrontendController.
     *
     * <p>
     *     Used for testing purposes only.
     * </p>
     * @param backendController is connected with test database.
     * @param loginControllerImplementation is connected with test database.
     */
    public FrontendController(BackendController backendController, LoginControllerImplementation loginControllerImplementation) {
        this.backendController = backendController;
        this.loginControllerImplementation = loginControllerImplementation;

        // Frames
        var registerFrame = new RegisterFrame(this);
        var loginFrame = new LoginFrame(this, registerFrame);

        // Default visibility.
        registerFrame.setLoginFrame(loginFrame);
        registerFrame.setVisible(true);
        loginFrame.setVisible(false);
    }

    /**
     * Constructor FrontendController.
     * <p>
     *     Default constructor.
     * </p>
     */
    public FrontendController() {
        this.backendController = new BackendController();
        this.loginControllerImplementation = new LoginControllerImplementation();

        // Frames
        var registerFrame = new RegisterFrame(this);
        var loginFrame = new LoginFrame(this, registerFrame);

        // Default visibility.
        registerFrame.setLoginFrame(loginFrame);
        registerFrame.setVisible(true);
        loginFrame.setVisible(false);
    }

    public BackendController getBackendController() {
        return backendController;
    }

    public LoginControllerImplementation getLoginControllerImplementation() {
        return loginControllerImplementation;
    }
}
