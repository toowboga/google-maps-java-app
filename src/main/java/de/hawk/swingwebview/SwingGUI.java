package de.hawk.swingwebview;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jannis Thomae
 */
public class SwingGUI {

    private static final String HOME = "https://www.google.com/maps";
    private static final String HAWK_GOETTINGEN_ING = "https://goo.gl/maps/3ggsJ9ZH1JCFBXqw7";
    private JFXPanel jfxPanel;
    private WebView webView;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create instance of SwingGUI
        SwingGUI gui = new SwingGUI();
        // causes Swing to be executed asynchronously on the AWT event dispatching thread
        // recommended because Swing objects are not thread safe
        SwingUtilities.invokeLater(gui::createSwingGUI);
    }

    public void createSwingGUI() {
        // create Java Swing JFrame component with title
        JFrame frame = new JFrame("Google Maps App");

        // create JFXPanel for showing JavaFX components and add to Swing JFrame
        jfxPanel = new JFXPanel();
        frame.getContentPane().add(jfxPanel);

        // create button and add listener to show HAWK location in the WebView component
        JButton hawk = new JButton("HAWK Göttingen - Fakultät Ingenieurwissenschaften und Gesundheit");
        hawk.addActionListener(e -> buttonListener());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hawk);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        // creation of the WebView component
        // it is important that this one is executed on the JavaFX Application Thread
        Platform.runLater(this::createWebView);

        // Swing frame config
        frame.setMinimumSize(new Dimension(1200, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // display Swing frame
        frame.pack();
        frame.setVisible(true);
    }

    private void buttonListener() {
        // execute method on the JavaFX Application Thread
        Platform.runLater(this::showHAWK);
    }

    private void createWebView() {
        // create JavaFX WebView component
        webView = new WebView();
        // load home page
        webView.getEngine().load(HOME);
        // add webView on jfxPanel
        jfxPanel.setScene(new Scene(webView));
    }

    private void showHAWK() {
        // load HAWK location if webView is initialized
        if (webView != null) {
            webView.getEngine().load(HAWK_GOETTINGEN_ING);
        }
    }
}