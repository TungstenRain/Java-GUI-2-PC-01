package ch13pc01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Frank
 */
public class TaxCalculator extends JFrame {
    //fields
    private final int width = 350;
    private final int height = 200;
    private JPanel mainPanel, sliderPanel, taxPanel;
    private JLabel lblPurchase, lblTax;
    private JTextField txtPurchase, txtTax;
    private JSlider sldrTax;
    private JButton btnCalculate;
        
    //constructors
    public TaxCalculator() {
        this.setTitle("Tax Calculator");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildMainPanel();
        buildSliderPanel();
        buildTaxPanel();
        this.add(mainPanel, BorderLayout.PAGE_START);
        this.add(sliderPanel);
        this.add(taxPanel, BorderLayout.PAGE_END);
        this.setVisible(true);
    }
    
    //methods
    private void buildMainPanel() {
        mainPanel = new JPanel();
        lblPurchase = new JLabel("Enter the purchase amount: ");
        txtPurchase = new JTextField(5);
        
        mainPanel.add(lblPurchase);
        mainPanel.add(txtPurchase);
    }
    
    private void buildSliderPanel() {
        sliderPanel = new JPanel();
        sldrTax = new JSlider(JSlider.HORIZONTAL, 0, 10, 6);
        sldrTax.setMajorTickSpacing(1);
        sldrTax.setPaintTicks(true);
        sldrTax.setPaintLabels(true);
        sldrTax.setVisible(true);
        
        btnCalculate = new JButton("Calculate Sales Tax");
        
        btnCalculate.addActionListener(new btnCalculateListener());
                
        sliderPanel.add(sldrTax);
        sliderPanel.add(btnCalculate);
    }
    
    private void buildTaxPanel() {
        taxPanel = new JPanel();
        
        lblTax = new JLabel("The sales tax is: ");
        txtTax = new JTextField(15);
        txtTax.setEditable(false);
        
        taxPanel.add(lblTax);
        taxPanel.add(txtTax);
    }
    
    
    /**
     * inner class to handle events
     */
    private class btnCalculateListener implements ActionListener {
        
        @Override
        public void actionPerformed (ActionEvent e) {
            double purchase = Double.parseDouble(txtPurchase.getText());
            double tax, salesTax;
            tax = sldrTax.getValue();
            tax /= 100;
            salesTax = purchase * tax;
            txtTax.setText(Double.toString(salesTax));
        }
    }
}
