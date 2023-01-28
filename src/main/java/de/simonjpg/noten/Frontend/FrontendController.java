package de.simonjpg.noten.Frontend;

import de.simonjpg.noten.Backend.BackendController;
import de.simonjpg.noten.Backend.LoginControllerImplementation;

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

    public FrontendController(BackendController backendController, LoginControllerImplementation loginControllerImplementation) {
        this.backendController = backendController;
        this.loginControllerImplementation = loginControllerImplementation;
    }

    public BackendController getBackendController() {
        return backendController;
    }

    public LoginControllerImplementation getLoginControllerImplementation() {
        return loginControllerImplementation;
    }
}
