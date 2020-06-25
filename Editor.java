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
        String s = e.getActionCommand();
        if(s.equals("Cut")) textArea.cut();
        else if(s.equals("Copy")) textArea.copy();
        else if(s.equals("Paste")) textArea.paste();
        else if(s.equals("Save")) this.save();
             
        else if(s.equals("Print")) this.print();
        else if(s.equals("Open")) this.open();
        else if(s.equals("New")) textArea.setText(""); 
        else if(s.equals("Close")) frame.setVisible(false);
        
    }
   
    public void print()
    {
        try
        {
            this.textArea.print();

        }
        catch( Exception e) { JOptionPane.showMessageDialog(this.frame, e.getMessage()); };

       
    }
    public void save()  
    {
        JFileChooser explorer = new JFileChooser("f:");
        int r = explorer.showSaveDialog(null);
        if( r == JFileChooser.APPROVE_OPTION)
        {
            File fi = new File( explorer.getSelectedFile().getAbsolutePath() );
            try
            {
                FileWriter wr = new FileWriter(fi, false);
                BufferedWriter w = new BufferedWriter(wr);
                w.write(this.textArea.getText());
                w.flush();
                w.close();
                
            }
            catch( Exception e) { JOptionPane.showMessageDialog(this.frame, e.getMessage()); }
        }
        else JOptionPane.showMessageDialog(this.frame, "the user cancelled the operation");

    }
    // open function is still remaining
    public void open()
    {

    }
    /*
    public void open()
    {
        JFileChooser explorer = new JFileChooser("f:");
        int r = explorer.showSaveDialog(null);
        	// If the user selects a file 
        if (r == JFileChooser.APPROVE_OPTION) { 
            // Set the label to the path of the selected directory 
            File fi = new File(j.getSelectedFile().getAbsolutePath()); 
            try
            {
                String s1 = "";
                FileReader fr = new FileReader(fi);
                BufferedReader br = new BufferedReader(fr);
                
            }
        }
            
            
    }
    */
    public static void main(String []args)
    {
        new Editor();
    }
}

