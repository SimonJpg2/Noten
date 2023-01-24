package de.simonjpg.noten.Frontend;

import de.simonjpg.noten.Backend.BackendController;

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

    public FrontendController(BackendController backendController) {
        this.backendController = backendController;
    }

    public BackendController getBackendController() {
        return backendController;
    }
}
