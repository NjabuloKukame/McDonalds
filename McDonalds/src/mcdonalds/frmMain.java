/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mcdonalds;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tikkun
 */
public class frmMain extends javax.swing.JFrame {

    BurgerDAO burgerDAO = new BurgerDAO();
    SideDAO sideDAO = new SideDAO();
    DessertDAO dessertDAO = new DessertDAO();
    DrinkDAO drinkDAO = new DrinkDAO();
    Date obj = new Date();
    String date = obj.toString();
    private double totalAmount = 0.0;

    List<Side> sideItems = sideDAO.getSideItems();
    List<Burger> burgerItems = burgerDAO.getBurgerItems();
    List<Dessert> dessertItems = dessertDAO.getDessertItems();
    List<Drink> drinkItems = drinkDAO.getDrinkItems();

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        scaleImage();

        populateBurgerComboBox();
        populateSideComboBox();
        populateDessertComboBox();
        populateDrinkComboBox();

        cbBurger.addActionListener(e -> {
            updateBurgerPrice();
            updateTotalAmount();
        });
        cbSides.addActionListener(e -> {
            updateSidePrice();
            updateTotalAmount();
        });
        cbDesserts.addActionListener(e -> {
            updateDessertPrice();
            updateTotalAmount();
        });
        cbDrinks.addActionListener(e -> {
            updateDrinkPrice();
            updateTotalAmount();
        });
        //btnNext.addActionListener(e -> btnNextActionPerformed(e));
    }

    public void scaleImage() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Tikkun\\Documents\\NetBeansProjects\\McDonalds\\src\\mcdonalds\\img\\McD.png");
        ImageIcon iconTwo = new ImageIcon("C:\\Users\\Tikkun\\Documents\\NetBeansProjects\\McDonalds\\src\\mcdonalds\\img\\Burger.jpg");
        ImageIcon iconThree = new ImageIcon("C:\\Users\\Tikkun\\Documents\\NetBeansProjects\\McDonalds\\src\\mcdonalds\\img\\MCD Sides.png");
        ImageIcon iconFour = new ImageIcon("C:\\Users\\Tikkun\\Documents\\NetBeansProjects\\McDonalds\\src\\mcdonalds\\img\\Watermelon-McFizz.png");
        ImageIcon iconFive = new ImageIcon("C:\\Users\\Tikkun\\Documents\\NetBeansProjects\\McDonalds\\src\\mcdonalds\\img\\MCD_Desserts.png");

        Image img = icon.getImage();
        Image imgTwo = iconTwo.getImage();
        Image imgThree = iconThree.getImage();
        Image imgFour = iconFour.getImage();
        Image imgFive = iconFive.getImage();

        Image imgScale = img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
        Image imgScaleTwo = imgTwo.getScaledInstance(lblMeal.getWidth(), lblMeal.getHeight(), Image.SCALE_SMOOTH);
        Image imgScaleThree = imgThree.getScaledInstance(lblSides.getWidth(), lblSides.getHeight(), Image.SCALE_SMOOTH);
        Image imgScaleFour = imgFour.getScaledInstance(lblDrinks.getWidth(), lblDrinks.getHeight(), Image.SCALE_SMOOTH);
        Image imgScaleFive = imgFive.getScaledInstance(lblDesert.getWidth(), lblDesert.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(imgScale);
        ImageIcon scaledIconTwo = new ImageIcon(imgScaleTwo);
        ImageIcon scaledIconThree = new ImageIcon(imgScaleThree);
        ImageIcon scaledIconFour = new ImageIcon(imgScaleFour);
        ImageIcon scaledIconFive = new ImageIcon(imgScaleFive);

        lblLogo.setIcon(scaledIcon);
        lblMeal.setIcon(scaledIconTwo);
        lblSides.setIcon(scaledIconThree);
        lblDrinks.setIcon(scaledIconFour);
        lblDesert.setIcon(scaledIconFive);
    }

    private void populateBurgerComboBox() {
        for (Burger burger : burgerItems) {
            cbBurger.addItem(burger.toString());
        }
    }

    private void populateSideComboBox() {
        for (Side side : sideItems) {
            cbSides.addItem(side.toString());
        }
    }

    private void populateDessertComboBox() {
        for (Dessert dessert : dessertItems) {
            cbDesserts.addItem(dessert.toString());
        }
    }

    private void populateDrinkComboBox() {
        for (Drink drink : drinkItems) {
            cbDrinks.addItem(drink.toString());
        }
    }

    private Burger findBurgerByName(String burgerName) {
        for (Burger burger : burgerItems) {
            if (burger.getName().equals(burgerName)) {
                return burger;
            }
        }
        return null;
    }

    private Side findSideByName(String sideName) {
        for (Side side : sideItems) {
            if (side.getName().equals(sideName)) {
                return side;
            }
        }
        return null;
    }

    private Dessert findDessertByName(String dessertName) {
        for (Dessert dessert : dessertItems) {
            if (dessert.getName().equals(dessertName)) {
                return dessert;
            }
        }
        return null;
    }

    private Drink findDrinkByName(String drinkName) {
        for (Drink drink : drinkItems) {
            if (drink.getName().equals(drinkName)) {
                return drink;
            }
        }
        return null;
    }

    private void updateBurgerPrice() {
        String selectedBurgerName = (String) cbBurger.getSelectedItem();
        if (selectedBurgerName != null) {
            for (Burger burger : burgerItems) {
                if (burger.getName().equals(selectedBurgerName)) {
                    lblBurgerPrice.setText("Price: R" + burger.getPrice()); // Update price label
                    return;
                }
            }
        }
    }

    private void updateSidePrice() {
        String selectedSideName = (String) cbSides.getSelectedItem();
        if (selectedSideName != null) {
            Side selectedSide = findSideByName(selectedSideName);
            if (selectedSide != null) {
                lblSidesPrice.setText("Price: R" + selectedSide.getPrice());
            }
        }
    }

    private void updateDessertPrice() {
        String selectedDessertName = (String) cbDesserts.getSelectedItem();
        if (selectedDessertName != null) {
            Dessert selectedDessert = findDessertByName(selectedDessertName);
            if (selectedDessert != null) {
                lblDessertPrice.setText("Price: R" + selectedDessert.getPrice());
            }
        }
    }

    private void updateDrinkPrice() {
        String selectedDrinkName = (String) cbDrinks.getSelectedItem();
        if (selectedDrinkName != null) {
            Drink selectedDrink = findDrinkByName(selectedDrinkName);
            if (selectedDrink != null) {
                lblDrinkPrice.setText("Price: R" + selectedDrink.getPrice());
            }
        }
    }

    private void updateTotalAmount() {
        totalAmount = 0.0;
        
        String selectedBurgerName = (String) cbBurger.getSelectedItem();
        if (selectedBurgerName != null) {
            Burger selectedBurger = findBurgerByName(selectedBurgerName);
            if (selectedBurger != null) {
                totalAmount += selectedBurger.getPrice();
            }
        }

        String selectedSideName = (String) cbSides.getSelectedItem();
        if (selectedSideName != null) {
            Side selectedSide = findSideByName(selectedSideName);
            if (selectedSide != null) {
                totalAmount += selectedSide.getPrice();
            }
        }

        String selectedDessertName = (String) cbDesserts.getSelectedItem();
        if (selectedDessertName != null) {
            Dessert selectedDessert = findDessertByName(selectedDessertName);
            if (selectedDessert != null) {
                totalAmount += selectedDessert.getPrice();
            }
        }

        String selectedDrinkName = (String) cbDrinks.getSelectedItem();
        if (selectedDrinkName != null) {
            Drink selectedDrink = findDrinkByName(selectedDrinkName);
            if (selectedDrink != null) {
                totalAmount += selectedDrink.getPrice();
            }
        }

        lblTotalAmount.setText("Total Amount: R" + totalAmount);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblClose2 = new javax.swing.JLabel();
        jPanelBurger = new javax.swing.JPanel();
        lblMeal = new javax.swing.JLabel();
        lblBurgerPrice = new javax.swing.JLabel();
        cbBurger = new javax.swing.JComboBox<>();
        lblClose3 = new javax.swing.JLabel();
        jPanelSides = new javax.swing.JPanel();
        lblSides = new javax.swing.JLabel();
        lblSidesPrice = new javax.swing.JLabel();
        cbSides = new javax.swing.JComboBox<>();
        lblClose4 = new javax.swing.JLabel();
        jPanelDrinks = new javax.swing.JPanel();
        lblDrinks = new javax.swing.JLabel();
        lblDrinkPrice = new javax.swing.JLabel();
        cbDrinks = new javax.swing.JComboBox<>();
        lblClose5 = new javax.swing.JLabel();
        jPanelDesert = new javax.swing.JPanel();
        lblDesert = new javax.swing.JLabel();
        lblDessertPrice = new javax.swing.JLabel();
        cbDesserts = new javax.swing.JComboBox<>();
        lblClose6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblTotalAmount = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();
        lblClose7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkOutArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setBackground(new java.awt.Color(220, 30, 40));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(220, 30, 40));

        lblClose.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 255, 255));
        lblClose.setText("X");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        lblClose.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblCloseKeyPressed(evt);
            }
        });

        lblClose2.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        lblClose2.setForeground(new java.awt.Color(255, 255, 255));
        lblClose2.setText("Home");

        jPanelBurger.setBackground(new java.awt.Color(253, 253, 253));

        lblBurgerPrice.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblBurgerPrice.setForeground(new java.awt.Color(220, 30, 40));

        cbBurger.setBackground(new java.awt.Color(220, 30, 40));
        cbBurger.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        cbBurger.setForeground(new java.awt.Color(253, 253, 253));

        lblClose3.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblClose3.setForeground(new java.awt.Color(220, 30, 40));
        lblClose3.setText("Burger");

        javax.swing.GroupLayout jPanelBurgerLayout = new javax.swing.GroupLayout(jPanelBurger);
        jPanelBurger.setLayout(jPanelBurgerLayout);
        jPanelBurgerLayout.setHorizontalGroup(
            jPanelBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBurgerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMeal, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblClose3)
                        .addComponent(cbBurger, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBurgerPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelBurgerLayout.setVerticalGroup(
            jPanelBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBurgerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelBurgerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblClose3)
                        .addGap(18, 18, 18)
                        .addComponent(cbBurger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBurgerPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelSides.setBackground(new java.awt.Color(253, 253, 253));
        jPanelSides.setMinimumSize(new java.awt.Dimension(100, 100));

        lblSidesPrice.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblSidesPrice.setForeground(new java.awt.Color(220, 30, 40));

        cbSides.setBackground(new java.awt.Color(220, 30, 40));
        cbSides.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        cbSides.setForeground(new java.awt.Color(253, 253, 253));

        lblClose4.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblClose4.setForeground(new java.awt.Color(220, 30, 40));
        lblClose4.setText("Sides");

        javax.swing.GroupLayout jPanelSidesLayout = new javax.swing.GroupLayout(jPanelSides);
        jPanelSides.setLayout(jPanelSidesLayout);
        jPanelSidesLayout.setHorizontalGroup(
            jPanelSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSidesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSides, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblClose4)
                        .addComponent(cbSides, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSidesPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelSidesLayout.setVerticalGroup(
            jPanelSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSidesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSides, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSidesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblClose4)
                        .addGap(18, 18, 18)
                        .addComponent(cbSides, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSidesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelDrinks.setBackground(new java.awt.Color(253, 253, 253));

        lblDrinkPrice.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblDrinkPrice.setForeground(new java.awt.Color(220, 30, 40));

        cbDrinks.setBackground(new java.awt.Color(220, 30, 40));
        cbDrinks.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        cbDrinks.setForeground(new java.awt.Color(253, 253, 253));

        lblClose5.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblClose5.setForeground(new java.awt.Color(220, 30, 40));
        lblClose5.setText("Drinks");

        javax.swing.GroupLayout jPanelDrinksLayout = new javax.swing.GroupLayout(jPanelDrinks);
        jPanelDrinks.setLayout(jPanelDrinksLayout);
        jPanelDrinksLayout.setHorizontalGroup(
            jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDrinks, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDrinkPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClose5)
                    .addComponent(cbDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelDrinksLayout.setVerticalGroup(
            jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDrinks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDrinksLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(lblClose5)
                        .addGap(18, 18, 18)
                        .addComponent(cbDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDrinkPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelDesert.setBackground(new java.awt.Color(253, 253, 253));
        jPanelDesert.setMinimumSize(new java.awt.Dimension(100, 100));

        lblDessertPrice.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        lblDessertPrice.setForeground(new java.awt.Color(220, 30, 40));

        cbDesserts.setBackground(new java.awt.Color(220, 30, 40));
        cbDesserts.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        cbDesserts.setForeground(new java.awt.Color(253, 253, 253));

        lblClose6.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblClose6.setForeground(new java.awt.Color(220, 30, 40));
        lblClose6.setText("Dessert");

        javax.swing.GroupLayout jPanelDesertLayout = new javax.swing.GroupLayout(jPanelDesert);
        jPanelDesert.setLayout(jPanelDesertLayout);
        jPanelDesertLayout.setHorizontalGroup(
            jPanelDesertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDesertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDesert, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDesertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDessertPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClose6)
                    .addComponent(cbDesserts, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelDesertLayout.setVerticalGroup(
            jPanelDesertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDesertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDesertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDesert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDesertLayout.createSequentialGroup()
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addComponent(lblClose6)
                        .addGap(18, 18, 18)
                        .addComponent(cbDesserts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDessertPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(253, 253, 253));

        btnNext.setBackground(new java.awt.Color(220, 30, 40));
        btnNext.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next");
        btnNext.setToolTipText("");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(220, 30, 40));
        btnClear.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(253, 253, 253));

        lblTotalAmount.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblTotalAmount.setForeground(new java.awt.Color(220, 30, 40));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblClose))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(443, 443, 443)
                                .addComponent(lblClose2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanelBurger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelSides, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelDesert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelDrinks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClose))
                .addGap(18, 18, 18)
                .addComponent(lblClose2)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDrinks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBurger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDesert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSides, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Order Meal", jPanel1);

        jPanel2.setBackground(new java.awt.Color(220, 30, 40));

        lblExit.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setText("X");
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        lblExit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblExitKeyPressed(evt);
            }
        });

        lblClose7.setFont(new java.awt.Font("Leelawadee", 1, 30)); // NOI18N
        lblClose7.setForeground(new java.awt.Color(255, 255, 255));
        lblClose7.setText("Check Out");

        checkOutArea.setBackground(new java.awt.Color(255, 255, 255));
        checkOutArea.setColumns(20);
        checkOutArea.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        checkOutArea.setForeground(new java.awt.Color(220, 30, 40));
        checkOutArea.setRows(5);
        checkOutArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(220, 30, 40)));
        jScrollPane1.setViewportView(checkOutArea);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setBackground(new java.awt.Color(220, 30, 40));
        btnBack.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.setToolTipText("");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(220, 30, 40));
        btnPrint.setFont(new java.awt.Font("Leelawadee", 1, 16)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print");
        btnPrint.setToolTipText("");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(lblClose7)
                        .addGap(0, 407, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblExit)
                .addGap(38, 38, 38)
                .addComponent(lblClose7)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Checkout", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblCloseKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCloseKeyPressed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm If You Want To Exit", "McDonalds", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm If You Want To Exit", "McDonalds", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblExitKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblExitKeyPressed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        cbDrinks.setSelectedIndex(23);
        cbDesserts.setSelectedIndex(7);
        cbSides.setSelectedIndex(16);
        cbBurger.setSelectedIndex(58);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        checkOutArea.setText("******************************************\n");
        checkOutArea.setText(checkOutArea.getText() + "**              McDonald's Receipt              **\n");
        checkOutArea.setText(checkOutArea.getText() + "******************************************\n");
        checkOutArea.setText(checkOutArea.getText() + "\n       " + date + "\n\n");
        checkOutArea.setText(checkOutArea.getText() + "******************************************\n");
        checkOutArea.setText(checkOutArea.getText() + "Burger:   " + cbBurger.getSelectedItem() + "\n\n");
        checkOutArea.setText(checkOutArea.getText() + "Drink:    " + cbDrinks.getSelectedItem() + "\n\n");
        checkOutArea.setText(checkOutArea.getText() + "Desserts: " + cbDesserts.getSelectedItem() + "\n\n");
        checkOutArea.setText(checkOutArea.getText() + "Sides:    " + cbSides.getSelectedItem() + "\n\n");
        checkOutArea.setText(checkOutArea.getText() + "Total:    R" +  totalAmount + "\n\n");
        checkOutArea.setText(checkOutArea.getText() + "******************************************");
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try {
            checkOutArea.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getClass());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox<String> cbBurger;
    private javax.swing.JComboBox<String> cbDesserts;
    private javax.swing.JComboBox<String> cbDrinks;
    private javax.swing.JComboBox<String> cbSides;
    private javax.swing.JTextArea checkOutArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelBurger;
    private javax.swing.JPanel jPanelDesert;
    private javax.swing.JPanel jPanelDrinks;
    private javax.swing.JPanel jPanelSides;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBurgerPrice;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblClose2;
    private javax.swing.JLabel lblClose3;
    private javax.swing.JLabel lblClose4;
    private javax.swing.JLabel lblClose5;
    private javax.swing.JLabel lblClose6;
    private javax.swing.JLabel lblClose7;
    private javax.swing.JLabel lblDesert;
    private javax.swing.JLabel lblDessertPrice;
    private javax.swing.JLabel lblDrinkPrice;
    private javax.swing.JLabel lblDrinks;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMeal;
    private javax.swing.JLabel lblSides;
    private javax.swing.JLabel lblSidesPrice;
    private javax.swing.JLabel lblTotalAmount;
    // End of variables declaration//GEN-END:variables
}
