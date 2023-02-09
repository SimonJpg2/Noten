package de.simonjpg.noten.Backend.Images;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ImageHandlerTest {
    @Test
    void testGetImageFromResource() {
        // given
        ImageHandler handler = new ImageHandler();
        // when
        Image given = handler.getImageFromResource("FrameImageIcon.jpg");
        // then
        assertNotNull(given);
    }
}