import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

class Editor extends JFrame implements ActionListener
{
    JTextArea textArea;
    JFrame frame;

    Editor()
    {
        frame = new JFrame("Editor");
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch( Exception e)
        {
            
        }
        textArea = new JTextArea();
        JMenuBar menuBar = new JMenuBar();
        // menu 
        JMenu menuFile = new JMenu("File");
        // Menu Items
        JMenuItem menuItemNew = new JMenuItem("New");
        JMenuItem menuItemOpen = new JMenuItem("Open");
        JMenuItem menuItemSave = new JMenuItem("Save");
        JMenuItem menuItemPrint = new JMenuItem("Print");
        
        menuItemNew.addActionListener(this);
        menuItemOpen.addActionListener(this); 
        menuItemSave.addActionListener(this); 
        menuItemPrint.addActionListener(this); 
        
        menuFile.add(menuItemNew);
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemPrint); 

        JMenu menuEdit = new JMenu("Edit");

        JMenuItem menuItemCut = new JMenuItem("Cut");
        JMenuItem menuItemCopy = new JMenuItem("Copy");
        JMenuItem menuItemPaste = new JMenuItem("Paste");
        
        menuItemCut.addActionListener(this);
        menuItemCopy.addActionListener(this);
        menuItemPaste.addActionListener(this);
        
        menuEdit.add(menuItemCut);
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemPaste);

        JMenuItem menuClose = new JMenuItem("Close");
        menuClose.addActionListener(this);
        
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuClose); 
        frame.setJMenuBar(menuBar);
        frame.add(textArea);
        frame.setSize(500 ,500); 
        frame.show();
        
    }
    public void actionPerformed(ActionEvent e)
    {
   
    }
    public static void main(String []args)
    {
        new Editor();
    }
}

