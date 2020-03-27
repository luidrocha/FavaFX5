package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable {

	@FXML
	private TextField txtNumero1;
	@FXML
	private TextField txtNumero2;
	@FXML
	private Label lblResultado;

	@FXML
	private Button btSoma;

	@FXML
	public void onBtActionSoma() {

		Locale.setDefault(Locale.US);

		try {

			double numero1 = Double.parseDouble(txtNumero1.getText());
			double numero2 = Double.parseDouble(txtNumero2.getText());

			double soma = numero1 + numero2;

			lblResultado.setText(String.format("%.2f", soma));

		} catch (NumberFormatException e) {

			Alerts.showAlert("Error", "ParseError", e.getMessage(), AlertType.ERROR);

		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		// Metodo Statico que executa as limitacoes baseado no metodo addListener.
		
		Constraints.setTextFieldDouble(txtNumero1);
		Constraints.setTextFieldDouble(txtNumero2);
		
		Constraints.setTextFieldMaxLength(txtNumero1, 12);
		Constraints.setTextFieldMaxLength(txtNumero2, 12);

	}
}
