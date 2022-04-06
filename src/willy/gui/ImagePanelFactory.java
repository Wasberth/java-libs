/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.gui;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Willy
 */
public class ImagePanelFactory {

    public static JPanel prepareImage(final String root, final int w, final int h) {
        return new JPanel() {
            @Override
            public void paint(Graphics g) {
                ImageIcon Img = new ImageIcon(getClass().getResource(root));
                g.drawImage(Img.getImage(), 0, 0, w, h, null);

                setOpaque(false);
                super.paintComponent(g);
            }
        };
    }

}
