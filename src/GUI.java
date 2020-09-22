
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @Name : GUI.java
 * @Description : This is the main user interface class used for designing and interaction with the user
 *
 *
 */
public final class GUI extends javax.swing.JFrame {
    
    final String DEGREE  = "\u00b0"; //Use to print the degrees with temperature
    //Instance variables
    public static long stime;
    public static long etime;
    public static long totalTime;
    public static int totalItems=0;
    public static ArrayList<String> names;
    public Items myitems;
    public String[] availableItems = new String[4]; //items array
    FileHandling fileIO = FileHandling.getFileObject(); //singleton Patterns
    Refrigerator rf;
    public GUI() {
        initComponents();
        //settemp.setFocusable(false);
        //Initialization
        hideFields();
        loadImages();
        availableItems[0] ="Milk";
        availableItems[1]= "Banana";
        availableItems[2]="Burger";
        availableItems[3]= "Bottle";
        rf = new Refrigerator();
        temp.setText("5"+DEGREE);
        rf.setTemperature(temp.getText());
        names = new ArrayList<>();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        settemp = new javax.swing.JTextField();
        temp = new javax.swing.JLabel();
        Open = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        empty1 = new javax.swing.JLabel();
        empty2 = new javax.swing.JLabel();
        empty3 = new javax.swing.JLabel();
        bottom = new javax.swing.JLabel();
        items = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        close = new javax.swing.JButton();
        fridgeapp = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Refrigerator");
        setResizable(false);
        
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/close.PNG")));
        
        settemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settempActionPerformed(evt);
            }
        });
        
        temp.setFont(new java.awt.Font("Tahoma", 1, 14));
        
        Open.setText("OPEN");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
                                        panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(empty3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(empty2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                                  .addComponent(empty1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                                  .addContainerGap())
                                        );
        panel2Layout.setVerticalGroup(
                                      panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                      .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(empty1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(empty2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(empty3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bottom, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(17, Short.MAX_VALUE))
                                      );
        
        items.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Items", "Banana", "Burger", "Bottle", "Milk" }));
        
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        
        Remove.setText("Remove");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        
        fridgeapp.setText("Fridge App");
        fridgeapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fridgeappActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                   .addGap(38, 38, 38)
                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                             .addComponent(settemp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                       .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                       .addComponent(Open)))
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                   .addComponent(jLabel2)
                                                   .addGap(58, 58, 58)
                                                   .addComponent(fridgeapp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                   .addGap(46, 46, 46)
                                                   .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                                       .addGap(35, 35, 35)
                                                                       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                           .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                           .addGap(46, 46, 46)
                                                                                           .addComponent(Remove))
                                                                                 .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                                       .addGap(70, 70, 70)
                                                                       .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                   .addGap(48, 48, 48))
                                         );
        jPanel1Layout.setVerticalGroup(
                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                     .addGap(83, 83, 83)
                                                                     .addComponent(settemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                     .addGap(33, 33, 33)
                                                                     .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addComponent(Open, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                     .addContainerGap(40, Short.MAX_VALUE)
                                                                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                         .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                         .addGap(42, 42, 42)
                                                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                   .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                   .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                         .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                               .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                 .addGap(30, 30, 30))
                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                 .addContainerGap()
                                                 .addComponent(fridgeapp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                          .addContainerGap(48, Short.MAX_VALUE))
                                );
        
        pack();
    }
    
    
    //Open Refrigerator
    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {
        
        //Open Fridge
        showFields();
        //Calculate time
        stime = System.nanoTime();
        rf.setIsOpen(true);
        try {
            calculateTime();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Show open fridge GUI
        if(checkItems(empty1).equalsIgnoreCase("milk1.png") ){
            
            empty1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/milk1.PNG")));
        }
        else
        {
            empty1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty1.PNG"))); // NOI18N
        }
        if(checkItems(empty2).equalsIgnoreCase("banana2.png") ){
            
            empty2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/banana2.PNG")));
        }
        else{
            empty2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty2.PNG")));
        }
        
        if(checkItems(empty3).equalsIgnoreCase("burger3.png") ){
            
            empty3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/burger3.PNG")));
        }
        else{
            empty3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty3.PNG")));
        }
        
        if(checkItems(bottom).equalsIgnoreCase("bottle4.png") ){
            
            bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/bottle4.PNG")));
        }
        else{
            bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/bottom.PNG")));
        }
        
        
    }
    
    //Add items into Fridge
    private void addActionPerformed(java.awt.event.ActionEvent evt) {
        //Items Listener
        
        
        String selected_text = items.getItemAt(items.getSelectedIndex()); //get Combobox text
        //System.out.println(selected_text);
        
        
        
        
        //Check all items. If selected then add into fridge.
        if(selected_text.equals("Items")){
            
            JOptionPane.showMessageDialog(null, "Please select items!!!");
            
        }
        
        if(selected_text.equals(availableItems[1])){
            
            
            if(checkItems(empty2).equalsIgnoreCase("banana2.png")){ //validation
                JOptionPane.showMessageDialog(null,"Item already added!!!");
            }
            else{
                empty2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/banana2.PNG")));
                names.add(availableItems[1]);
                ++totalItems;
            }
            
        }
        if(selected_text.equals(availableItems[2])){
            
            if(checkItems(empty3).equalsIgnoreCase("burger3.png")){
                JOptionPane.showMessageDialog(null,"Item already added!!!");
            }
            else{
                empty3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/burger3.PNG")));
                ++totalItems;
                names.add(availableItems[2]);
            }
        }
        if(selected_text.equals(availableItems[0])){
            if(checkItems(empty1).equalsIgnoreCase("milk1.png")){
                JOptionPane.showMessageDialog(null,"Item already added!!!");
            }
            else{
                empty1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/milk1.PNG")));
                ++totalItems;
                names.add(availableItems[0]);
            }
        }
        if(selected_text.equals(availableItems[3])){
            if(checkItems(bottom).equalsIgnoreCase("bottle4.png")){
                JOptionPane.showMessageDialog(null,"Item already added!!!");
            }
            else{
                bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/bottle4.PNG")));
                ++totalItems;
                names.add(availableItems[3]);
            }
        }
        
        
    }
    
    
    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {
        //Remove items
        String selected_text = items.getItemAt(items.getSelectedIndex());
        //System.out.println(selected_text);
        
        if(selected_text.equals("Milk")){
            
            if(checkItems(empty1).equalsIgnoreCase("empty1.png")){
                JOptionPane.showMessageDialog(null,"No such item in fridge");
            }
            else{
                empty1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty1.PNG")));
                names.remove("Milk");
                --totalItems;
                
            }
        }
        
        if(selected_text.equals("Banana")){
            
            if(checkItems(empty2).equalsIgnoreCase("empty2.png")){
                JOptionPane.showMessageDialog(null,"No such item in fridge");
            }
            else{
                empty2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty2.PNG")));
                names.remove("Banana");
                --totalItems;
            }
            
        }
        
        if(selected_text.equals("Bottle")){
            
            
            if(checkItems(bottom).equalsIgnoreCase("bottom.png")){
                JOptionPane.showMessageDialog(null,"No such item in fridge");
            }
            else{
                bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/bottom.PNG")));
                --totalItems;
                names.remove("Bottle");
                
            }
        }
        
        if(selected_text.equals("Burger")){
            
            if(checkItems(empty3).equalsIgnoreCase("empty3.png")){
                JOptionPane.showMessageDialog(null,"No such item in fridge");
            }
            else{
                empty3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty3.PNG")));
                --totalItems;
                names.remove("Burger");
            }
            
        }
        
        
        
        
    }
    
    //Close the fridge
    private void closeActionPerformed(java.awt.event.ActionEvent evt) {
        
        //Calculate time
        etime = System.nanoTime();
        totalTime = (etime - stime)/1000000 ;
        rf.setTotalTime(TimeUnit.MILLISECONDS.toSeconds(totalTime) % 60);
        hideFields();
        rf.setIsOpen(false);
        rf.setTotalItems(totalItems);
        
        myitems = new Items(names,rf);
        System.out.println(myitems.toString());
        System.out.println(" ");
        
        
        
        //Reflection Invoke
        
        Class myClass = fileIO.getClass();
        Method getBalance;
        try {
            getBalance = myClass.getMethod("getFileObject", new Class[] {});
            
            fileIO = (FileHandling) getBalance.invoke(fileIO, new Object[] {});
        }
        catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
        
        fileIO.insertRecords(myitems);
        //System.out.println(myitems.toString());
    }
    
    //Update the temperature
    private void settempActionPerformed(java.awt.event.ActionEvent evt) {
        temp.setText(settemp.getText() + DEGREE);
        rf.setTemperature(temp.getText());
    }
    
    //Open the Fridge App window
    private void fridgeappActionPerformed(java.awt.event.ActionEvent evt) {
        
        
        FridgeApp fa = new FridgeApp();
        fa.setVisible(true);
        
        
    }
    
    //Method used to show GUI when user clicks on open button
    public static void showFields(){
        
        Remove.setVisible(true);
        items.setVisible(true);
        add.setVisible(true);
        panel2.setVisible(true);
        close.setVisible(true);
        
    }
    
    //Call when closing fridge
    public static void hideFields(){
        
        Remove.setVisible(false);
        items.setVisible(false);
        add.setVisible(false);
        close.setVisible(false);
        panel2.setVisible(false);
        
        
    }
    
    //Check if the fridge is full or not
    public boolean isFridgeFull(){
        
        if(checkItems(empty1).equalsIgnoreCase("milk1.png") 
           && checkItems(empty2).equalsIgnoreCase("banana2.png")
           && checkItems(empty3).equalsIgnoreCase("burger3.png")
           && checkItems(bottom).equalsIgnoreCase("bottle4.png")){
            
            return true;
        }
        return false;
    }
    
    //Check which item is added into the fridge
    
    public String checkItems(JLabel label){
        
        String iconfilename = label.getIcon().toString();
        
        String fileName = iconfilename.substring(iconfilename.lastIndexOf("/"  ) + 1);
        //System.out.println("f : "  +fileName);
        return fileName;
    }
    
    //Load images to make the fridge GUI
    
    public void loadImages(){
        
        empty1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty1.PNG")));
        empty2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty2.PNG")));
        empty3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty3.PNG")));
        bottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/bottom.PNG")));
    }
    
    //Thread used for time calculation
    private static void calculateTime() throws InterruptedException {
        
        
        TimeUnit.SECONDS.sleep(2);
        
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    // Variables: 
    private javax.swing.JButton Open;
    private static javax.swing.JButton Remove;
    private static javax.swing.JButton add;
    private static javax.swing.JLabel bottom;
    private static javax.swing.JButton close;
    private static javax.swing.JLabel empty1;
    private static javax.swing.JLabel empty2;
    private static javax.swing.JLabel empty3;
    private static javax.swing.JButton fridgeapp;
    private static javax.swing.JComboBox<String> items;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel panel2;
    private javax.swing.JTextField settemp;
    private javax.swing.JLabel temp;
    
}
