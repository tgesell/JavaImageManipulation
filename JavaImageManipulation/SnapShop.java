/**
 * An application for filtering/transforming images
 * It contains a FilterButtons JPanel to display Buttons to trigger different Filters, 
 * a FileLoader JPanel to choose the image file, and 
 * an ImagePanel to display the image.
 * 
 * @author Richard Dunn modified by Tim Gesell
 * @version April 28th 2021
 */
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class SnapShop extends JFrame
{
    private FileLoader fl;
    private FilterButtons fb;
    private ImagePanel ip;

    /**
     * Constructor for objects of class SnapShop
     */
    public SnapShop()
    {
        super("SnapShop Image Manipulator"); //JFrame Constructor

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ip = new ImagePanel(this);
        this.getContentPane().add(ip, BorderLayout.CENTER);

        fl = new FileLoader(this);
        this.getContentPane().add(fl, BorderLayout.NORTH);

        fb = new FilterButtons(this);
        this.getContentPane().add(fb, BorderLayout.WEST);

        SnapShopConfiguration.configure(this);

        this.pack();
        this.setVisible(true);
    }

    /**
     * Add a filter to the SnapShop interface.  
     * Creates a button and links it to the filter.
     * @param f The filter to apply
     * @param description English description of the filter
     */
    public void addFilter(Filter f, String description) {
        fb.addFilter(f, description);
    }

    /**
     * accessor for ImagePanel
     */
    protected ImagePanel getImagePanel() {
        return ip;
    }

    public static void main(String[] args)
    {
        /* Create and display the JFrame */
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SnapShop().setVisible(true);
                }
            });
    }
}