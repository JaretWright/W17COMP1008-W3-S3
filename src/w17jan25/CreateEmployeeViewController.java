/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17jan25;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class CreateEmployeeViewController implements Initializable {

    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField socialInsuranceNumberTextField;
    @FXML private TextField hourlyRateTextField;
    
    @FXML private DatePicker dobDatePicker;
    @FXML private Button createEmployeeButton;
    
    @FXML private Label errorMessageLabel;
    @FXML private Label payTypeLabel;
    
    @FXML private RadioButton hourlyRadioButton;
    @FXML private RadioButton commissionRadioButton;
    
    
    
    /**
     * This method will create a new employee when the new employee button is 
     * pushed
     */
    public void createNewEmployeeButtonPushed()
    {
        if (this.hourlyRadioButton.isSelected())
        {
            try
            {
                HourlyEmployee newEmpl = new HourlyEmployee(firstNameTextField.getText(),
                                                    lastNameTextField.getText(),
                                                    Integer.parseInt(socialInsuranceNumberTextField.getText()),
                                                    dobDatePicker.getValue(),
                                                    Double.parseDouble(hourlyRateTextField.getText()));

                System.out.printf("Employee: %s, class: %s%n", newEmpl, newEmpl.getClass());    
            }
            catch (IllegalArgumentException e)
            {
                this.errorMessageLabel.setText(e.getMessage());
                this.errorMessageLabel.setVisible(true);
            }
        }
        else if (this.commissionRadioButton.isSelected())
        {
            try
            {
                CommissionEmployee newEmpl = new CommissionEmployee(firstNameTextField.getText(),
                                                    lastNameTextField.getText(),
                                                    Integer.parseInt(socialInsuranceNumberTextField.getText()),
                                                    dobDatePicker.getValue(),
                                                    Double.parseDouble(hourlyRateTextField.getText()));

                System.out.printf("Employee: %s, class: %s%n", newEmpl, newEmpl.getClass());    
            }
            catch (IllegalArgumentException e)
            {
                this.errorMessageLabel.setText(e.getMessage());
                this.errorMessageLabel.setVisible(true);
            }
        }
        
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.errorMessageLabel.setVisible(false);
        
        //This sets up a toggle group so only 1 radio button can be selected
        //at a time
        ToggleGroup employeeTypeToggleGroup = new ToggleGroup();
        this.commissionRadioButton.setToggleGroup(employeeTypeToggleGroup);
        this.hourlyRadioButton.setToggleGroup(employeeTypeToggleGroup);
        
        this.hourlyRadioButton.setSelected(true);
        
        employeeTypeToggleGroup.selectedToggleProperty().addListener(e -> radioButtonChanged());
    }    
    
    
    /**
     * This method will update the view after a radio button is pushed
     */
    public void radioButtonChanged()
    {
        if (this.hourlyRadioButton.isSelected())
        {
            this.hourlyRateTextField.setPromptText("Hourly Rate");
            this.payTypeLabel.setText("Hourly Rate");
        }
        else if (this.commissionRadioButton.isSelected())
        {
            this.hourlyRateTextField.setPromptText("Commission Rate");
            this.payTypeLabel.setText("Commission Rate"); 
        }
    }
}
