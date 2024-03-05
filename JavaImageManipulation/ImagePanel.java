/**
 * A JPanel component for displaying a buffered image, and for
 * applying filters to the buffered image by generating a PixelImage,
 * applying filters, and getting a new buffered image to display from the PixelImage
 * 
 * @author Richard Dunn modified by Tim Gesell
 * @version April 28th 2021
 */
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Graphics;

public class ImagePanel extends JPanel {
    private BufferedImage bi;
    private SnapShop s;

    public ImagePanel(SnapShop s) {
        bi = null;
        this.s = s;
    }

    public void loadImage(File imageFile) {  
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(imageFile);
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
            return;
        }
        int width = img.getWidth(this);
        int height = img.getHeight(this);
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D biContext = bi.createGraphics();
        biContext.drawImage(img, 0, 0, null);
        setPreferredSize(new Dimension(bi.getWidth(), bi.getHeight()));
        revalidate();
        s.pack();//resizes SnapShop JFrame to fit the new picture
        s.repaint();//repaints SnapShopJFrame to show the new picture
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (bi != null) {
            g.drawImage(bi, 0, 0, this);
        }
    }

    public void applyFilter(Filter f) {
        if (bi == null) {
            return;
        }
        PixelImage newImage = new PixelImage(bi);
        f.filter(newImage);
        bi = newImage.getImage();
        repaint();
    }
}