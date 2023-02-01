package de.simonjpg.noten.Frontend.windows;

import de.simonjpg.noten.Backend.Controller.BackendController;
import de.simonjpg.noten.Backend.Controller.LoginControllerImplementation;
import de.simonjpg.noten.Backend.Repository.Fach;
import de.simonjpg.noten.Frontend.FrontendController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataFrameTest {
    @Test
    void sort() {
        //given
        List<Fach> given = new ArrayList<>();
        List<Fach> expected = new ArrayList<>();

        given.add(new Fach("Z", 2));
        given.add(new Fach("Programmieren", 15));
        given.add(new Fach("A", 1));
        given.add(new Fach("Mathe", 15));

        expected.add(new Fach("A", 1));
        expected.add(new Fach("Mathe", 15));
        expected.add(new Fach("Programmieren", 15));
        expected.add(new Fach("Z", 2));

        DataFrame dataFrame = new DataFrame(new FrontendController(new BackendController("jdbc:mysql://localhost:3306/test"), new LoginControllerImplementation("jdbc:mysql://localhost:3306/test")));
        dataFrame.sort(given, 0, given.size() - 1);

        for (int i = 0; i < given.size(); i++) {
            assertEquals(given.get(i).getName(), expected.get(i).getName());
        }
    }
}