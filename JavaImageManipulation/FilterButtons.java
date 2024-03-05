/**
 * A JPanel component with methods to add Filter buttons, each
 * associated with a particular Filter subclass
 * 
 * @author Richard Dunn modified by Tim Gesell
 * @version April 28th 2021
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FilterButtons extends JPanel {
    private SnapShop s;
    private ImagePanel ip;

    public FilterButtons(SnapShop s) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.s = s;
        this.ip = s.getImagePanel();
    }

    public void addFilter(Filter f, String description) {
        JButton filterButton = new JButton(description);//create button with description
        filterButton.addActionListener(new FilterButtonListener(ip, f));
        add(filterButton);//add button to this JPanel
        s.pack();
    }
    
    //When a given button, associated with a filter, is clicked,
    //tell the ImagePanel to apply the given filter.
    private class FilterButtonListener implements ActionListener {
        private ImagePanel ip;
        private Filter f;

        public FilterButtonListener(ImagePanel ip, Filter f) {
            this.ip = ip;
            this.f = f;
        }

        public void actionPerformed(ActionEvent e) {
            ip.applyFilter(f);
        }
    }                
}