
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @Name : FridgeApp.java
 * @Description : This class extends parent class JFrame, it's used to print all items in the refrigerator
 *
 *
 */
public class FridgeApp extends javax.swing.JFrame {
    
    /**
     * Creates new form FridgeApp
     */
    Items item = new Items();
    public FridgeApp() {
        initComponents();
        display.setEditable(false);
        close(); //Close frame
        try {
            showItems(item);
        } catch (IOException ex) {
            Logger.getLogger(FridgeApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FridgeApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //This method is called from within the constructor to initialize the form.
    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fridge App");
        setResizable(false);
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Fridge App");
        
        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                   .addGap(109, 109, 109)
                                                   .addComponent(jLabel1)
                                                   .addContainerGap(123, Short.MAX_VALUE))
                                         .addComponent(jScrollPane1)
                                         );
        jPanel1Layout.setVerticalGroup(
                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                 .addContainerGap()
                                                 .addComponent(jLabel1)
                                                 .addGap(18, 18, 18)
                                                 .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                                       );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                  );
        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(0, 0, Short.MAX_VALUE))
                                );
        
        pack();
    }
    
    
    //Show items function
    public static void showItems(Items item) throws IOException, FileNotFoundException, ClassNotFoundException{
        FileHandling fileIO = FileHandling.getFileObject();
        display.setText(" ");
        display.setText(fileIO.readRecords(item));
        
    }
    
    //Close window listener
    public void close() {
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
            }
        });
    }
    
    
    
    // args the command line arguments
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FridgeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FridgeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FridgeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FridgeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FridgeApp().setVisible(true);
            }
        });
    }
    
    // Variables:
    private static javax.swing.JTextArea display;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    
}
