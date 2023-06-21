package de.simonjpg.noten;

import de.simonjpg.noten.Backend.Controller.BackendController;
import de.simonjpg.noten.Backend.Controller.LoginControllerImplementation;
import de.simonjpg.noten.Frontend.FrontendController;

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
        // Initialize Frontend and Backend.
        new FrontendController();
    }
}
