
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GUI {

    private JFrame appWindow;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.appWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     *
     * @throws IOException
     */
    public GUI() throws IOException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     *
     * @throws IOException
     */
    private void initialize() throws IOException {
        appWindow = new JFrame();
        appWindow.setTitle("Ascent Of The Alps");
        appWindow.setResizable(false);
        appWindow.setBounds(100, 100, 450, 300);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appWindow.setSize(800, 800);

        JPanel AnimationWindow = new JPanel();
        AnimationWindow.setBounds(0, 0, 785, 215);
        AnimationWindow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

        final InventoryPanel invPanel = new InventoryPanel();
        invPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        invPanel.setBounds(352, 336, 432, 150);

        JLabel lblNewLabel = new JLabel("Inventory");
        lblNewLabel.setBounds(352, 316, 87, 14);
        lblNewLabel.setLabelFor(invPanel);

        final PlayerStats playerStats = new PlayerStats();
        playerStats.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        playerStats.setBounds(352, 510, 432, 150);

        JLabel lblPlayerStats = new JLabel("Player Stats");
        lblPlayerStats.setBounds(352, 490, 87, 14);
        lblPlayerStats.setLabelFor(playerStats);

        final JButton btnMap = new JButton("Map");
        btnMap.setBounds(352, 241, 87, 23);

        final JButton btnNewButton = new JButton("Move");
        btnNewButton.setBounds(352, 270, 87, 23);



        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (arg0.getSource() == btnNewButton) {
                    AscentoftheAlps.day();
                    invPanel.SetLblFood(Inventory.foodSupply.toString());


                }
            }
        });

        btnMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (arg0.getSource() == btnMap) {
                    ImageIcon g = new ImageIcon("/europe-map.png");
               JOptionPane.showMessageDialog(invPanel,null , "Map",JOptionPane.INFORMATION_MESSAGE,g );
                            
                }
            }
        });

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(449, 241, 87, 23);

        JButton btnLoad = new JButton("Load");
        btnLoad.setBounds(449, 270, 87, 23);
        appWindow.getContentPane().setLayout(null);
        appWindow.getContentPane().add(AnimationWindow);
        AnimationWindow.setLayout(null);
        appWindow.getContentPane().add(lblNewLabel);
        appWindow.getContentPane().add(invPanel);
        invPanel.setLayout(null);
        appWindow.getContentPane().add(lblPlayerStats);
        appWindow.getContentPane().add(playerStats);
        playerStats.setLayout(null);
        appWindow.getContentPane().add(btnNewButton);
        appWindow.getContentPane().add(btnMap);
        appWindow.getContentPane().add(btnLoad);
        appWindow.getContentPane().add(btnSave);

        CharPanel charPanel = new CharPanel();
        charPanel.setBounds(10, 235, 299, 110);
        appWindow.getContentPane().add(charPanel);

        CharPanel charPanel_1 = new CharPanel();
        charPanel_1.setBounds(10, 355, 299, 110);
        appWindow.getContentPane().add(charPanel_1);

        CharPanel charPanel_2 = new CharPanel();
        charPanel_2.setBounds(10, 476, 299, 110);
        appWindow.getContentPane().add(charPanel_2);

        CharPanel charPanel_3 = new CharPanel();
        charPanel_3.setBounds(10, 597, 299, 110);
        appWindow.getContentPane().add(charPanel_3);
    }
}
