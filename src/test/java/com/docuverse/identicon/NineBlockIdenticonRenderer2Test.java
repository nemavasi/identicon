package com.docuverse.identicon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.security.MessageDigest;

/**
 * Utility methods useful for implementing identicon functionality. Methods are
 * class methods for convenience.
 * <p>
 * Key method of interest is {@link getIdenticonCode} which converts IP address
 * into identicon code.<br>
 * <strong>IMPORTANT</strong>: <code>inetSalt</code> value must be set to
 * reasonably long random string prior to invoking this method.
 * </p>
 * 
 * @author don
 */

public class NineBlockIdenticonRenderer2Test {

    private static final String IDENTICON_IMAGE_FORMAT = "PNG";

    private NineBlockIdenticonRenderer2 renderer2 = new NineBlockIdenticonRenderer2();

    @Test
    public void testRender(){

        BufferedImage image = renderer2.render(42, 80);

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, IDENTICON_IMAGE_FORMAT, byteOut);
            byte[] imageBytes = byteOut.toByteArray();
            FileOutputStream fos = new FileOutputStream("tstamage.png");
            fos.write(imageBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
