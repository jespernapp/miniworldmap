package com.miniworldmap;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MiniWorldMapOverlay extends Overlay
{
    private static final int SIZE = 200;

    @Inject
    MiniWorldMapOverlay()
    {
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        BufferedImage mapImage = renderWorldMapImage(SIZE, SIZE);

        if (mapImage != null)
        {
            graphics.drawImage(mapImage, 0, 0, null);
        }

        return new Dimension(SIZE, SIZE);
    }

    private BufferedImage renderWorldMapImage(int w, int h)
    {
        // Create an empty image
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();

        // Background
        g2.setColor(new Color(0, 0, 0, 200));
        g2.fillRect(0, 0, w, h);

        // Grid
        g2.setColor(Color.GRAY);
        for (int x = 0; x < w; x += 8)
        {
            g2.drawLine(x, 0, x, h);
        }
        for (int y = 0; y < h; y += 8)
        {
            g2.drawLine(0, y, w, y);
        }

        // Label
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 12f));
        g2.drawString("World Map", 6, 14);

        g2.dispose();
        return img;
    }
}