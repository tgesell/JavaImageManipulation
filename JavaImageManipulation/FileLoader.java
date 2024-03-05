/**
 * A JPanel component for choosing an image file to be loaded into the SnapShop ImagePanel
 * user can choose with a JFileChooser, or type into a text field
 * ImagePanel loadImage is called by button action
 * 
 * @author Richard Dunn modified by Tim Gesell
 * @version April 28th 2021
 */
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class FileLoader extends JPanel implements ActionListener {
    private JTextArea filenameBox;
    private JButton loadButton;
    private JButton browseButton;
    private JFileChooser fileChooser;
    private JLabel label;
    private SnapShop s;

    public FileLoader(SnapShop s) {
        super(new FlowLayout()); //Call superclass JPanel's constructor

        this.s = s;

        label = new JLabel("Enter file name: ");
        add(label); //calling superclass JPanel's add method

        filenameBox = new JTextArea(1, 50);
        filenameBox.setText(SnapShopConfiguration.getDefaultFilename());
        add(filenameBox); //calling superclass JPanel's add method

        loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        add(loadButton); //calling superclass JPanel's add method

        browseButton = new JButton("Browse");
        browseButton.addActionListener(this);
        add(browseButton); //calling superclass JPanel's add method

        fileChooser = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image","jpg","jpeg","png","gif");
        fileChooser.addChoosableFileFilter(imageFilter);
        fileChooser.setFileFilter(imageFilter);     
    }

    public void actionPerformed(ActionEvent e) {
        File file;
        if (e.getSource() == browseButton)
        {
            int returnVal = fileChooser.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                try{
                    filenameBox.setText(file.getCanonicalPath());
                }catch(IOException ex)
                {
                   filenameBox.setText(SnapShopConfiguration.getDefaultFilename()); 
                }
            } 
            else return;
        }
        else //if the source of the event was the load button
        {
            String filename = filenameBox.getText();
            file = new File(filename);
        }
        try {
            ImagePanel ip = s.getImagePanel();
            ip.loadImage(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(s,
                "Could not open file",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}