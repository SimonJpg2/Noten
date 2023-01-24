package de.simonjpg.noten;

import de.simonjpg.noten.Backend.BackendController;
import de.simonjpg.noten.Frontend.FrontendController;
import de.simonjpg.noten.Frontend.NewJFrame;

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
        new NewJFrame(new FrontendController(new BackendController())).setVisible(true);
    }
}
