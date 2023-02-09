package de.simonjpg.noten.Backend.Images;

import de.simonjpg.noten.NotenApp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Class ImageHandler.
 *
 * <p>
 *     Class to handle images for swing/awt components.
 * </p>
 * @since 9.2.2023
 * @version 1.0
 * @author SimonJpg
 */

public class ImageHandler {
    /**
     * Method getImageFromResource.
     *
     * <p>
     *     Loads images from resource.
     * </p>
     * @param imageName {@link java.lang.String} the filename.
     * @return {@link java.awt.Image}
     * @throws java.lang.RuntimeException if the file hasn't been found.
     */
    public Image getImageFromResource(String imageName) {
        try {
            return ImageIO.read(
                    Objects.requireNonNull(
                            NotenApp.class.getClassLoader()
                                    .getResourceAsStream(imageName)));
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
