package ConversionApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.lang.Math;

public class ConversionAppController implements Initializable {
    @FXML
    private Button dollarButton, euroButton, yenButton, poundButton, binButton,
            decButton, octButton, hexButton, kgButton, lbButton, litreButton, gallonButton,
            yardButton, meterButton, footButton, clearButton;

    @FXML
    private Label litreOutput, gallonOutput, binOutput, octOutput, decOutput, hexOutput,
            yenOutput, dollarOutput, euroOutput, poundOutput, kgOutput,
            lbOutput, yardOutput, meterOutput, footOutput, tipOutput;

    @FXML
    private TextField currencyInput, numericInput, weightInput, volumeInput, distanceInput;

    private static int convertBinarytoOctal(int binaryNumber) {
        int octalNumber = 0, decimalNumber = 0, i = 0;

        while (binaryNumber != 0) {
            decimalNumber += (binaryNumber % 10) * Math.pow(2, i);
            ++i;
            binaryNumber /= 10;
        }

        i = 1;

        while (decimalNumber != 0) {
            octalNumber += (decimalNumber % 8) * i;
            decimalNumber /= 8;
            i *= 10;
        }

        return octalNumber;
    }

    public static int convertBinarytoDecimal(int binaryNumber) {
        int decimal = 0;
        int n = 0;
        while (true) {
            if (binaryNumber == 0) {
                break;
            } else {
                int temp = binaryNumber % 10;
                decimal += temp * Math.pow(2, n);
                binaryNumber = binaryNumber / 10;
                n++;
            }
        }
        return decimal;
    }

    private void conversionMethod() {

        {// conversion from currencies
        currencyInput.textProperty().addListener((observable, oldValue, newValue) -> {
            double input = Double.parseDouble(newValue);
            euroButton.setOnAction(euroEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Ευρώ");
                    dollarOutput.setText(String.format("%.2f", (input * 1.09)) + " $");
                    yenOutput.setText(String.format("%.2f", (input * 170.18)) + " ¥");
                    poundOutput.setText(String.format("%.2f", (input * 0.85)) + " £");
                    euroOutput.setText(newValue + " €");
                } catch (NumberFormatException e) {
                    dollarOutput.setText("Μη έγκυρη τιμή");
                    euroOutput.setText("Μη έγκυρη τιμή");
                    yenOutput.setText("Μη έγκυρη τιμή");
                    poundOutput.setText("Μη έγκυρη τιμή");
                }
            });
            dollarButton.setOnAction(dollarEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Δολλάρια");
                    dollarOutput.setText(newValue + " $");
                    yenOutput.setText(String.format("%.2f", (input * 157)) + " ¥");
                    poundOutput.setText(String.format("%.2f", (input * 0.79)) + " £");
                    euroOutput.setText(String.format("%.2f", (input * 0.92)) + " €");
                } catch (NumberFormatException e) {
                    dollarOutput.setText("Μη έγκυρη τιμή");
                    euroOutput.setText("Μη έγκυρη τιμή");
                    yenOutput.setText("Μη έγκυρη τιμή");
                    poundOutput.setText("Μη έγκυρη τιμή");
                }
            });
            yenButton.setOnAction(yenEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Yen");
                    dollarOutput.setText(String.format("%.2f", (input * 0.0064)) + " $");
                    yenOutput.setText(newValue + " ¥");
                    poundOutput.setText(String.format("%.2f", (input * 0.0050)) + " £");
                    euroOutput.setText(String.format("%.2f", (input * 0.0059)) + " €");
                } catch (NumberFormatException e) {
                    dollarOutput.setText("Μη έγκυρη τιμή");
                    euroOutput.setText("Μη έγκυρη τιμή");
                    yenOutput.setText("Μη έγκυρη τιμή");
                    poundOutput.setText("Μη έγκυρη τιμή");
                }
            });
            poundButton.setOnAction(poundEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Λίρες");
                    dollarOutput.setText(String.format("%.2f", (input * 1.27)) + " $");
                    yenOutput.setText(String.format("%.2f", (input * 199.68)) + " $");
                    poundOutput.setText(newValue + " £");
                    euroOutput.setText(String.format("%.2f", (input * 1.17)) + " €");
                } catch (NumberFormatException e) {
                    dollarOutput.setText("Μη έγκυρη τιμή");
                    euroOutput.setText("Μη έγκυρη τιμή");
                    yenOutput.setText("Μη έγκυρη τιμή");
                    poundOutput.setText("Μη έγκυρη τιμή");
                }
            });
        });
    }
        {// converting weights
        weightInput.textProperty().addListener((observable, oldValue, newValue) -> {
            double input = Double.parseDouble(newValue);
            kgButton.setOnAction(kiloEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Κιλά");
                    kgOutput.setText(newValue + " Kgs");
                    lbOutput.setText(String.format("%.2f", (input * 2.20462)) + " Lbs");

                } catch (NumberFormatException e) {
                    kgOutput.setText("Μη έγκυρη τιμή");
                    lbOutput.setText("Μη έγκυρη τιμή");
                }
            });
            lbButton.setOnAction(lbsEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Λίβρες");
                    kgOutput.setText(String.format("%.2f", (input * 0.453)) + " Kgs");
                    lbOutput.setText(newValue + " Lbs");

                } catch (NumberFormatException e) {
                    kgOutput.setText("Μη έγκυρη τιμή");
                    lbOutput.setText("Μη έγκυρη τιμή");
                }
            });
        });
    }
        {// converting distances
        distanceInput.textProperty().addListener((observable, oldValue, newValue) -> {
            double input = Double.parseDouble(newValue);
            meterButton.setOnAction(meterEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Μέτρα");
                    meterOutput.setText(newValue + " m");
                    yardOutput.setText(String.format("%.2f", (input * 1.093)) + " yds");
                    footOutput.setText(String.format("%.2f", (input * 3.2808)) + " ft");
                } catch (NumberFormatException e) {
                    meterOutput.setText("Μη έγκυρη τιμή");
                    footOutput.setText("Μη έγκυρη τιμή");
                    yardOutput.setText("Μη έγκυρη τιμή");
                }
            });
            yardButton.setOnAction(yardEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Γιάρδες");
                    meterOutput.setText(String.format("%.2f", (input * 0.914)) + " m");
                    yardOutput.setText(newValue + " yds");
                    footOutput.setText(String.format("%.2f", (input * 3)) + " ft");
                } catch (NumberFormatException e) {
                    meterOutput.setText("Μη έγκυρη τιμή");
                    footOutput.setText("Μη έγκυρη τιμή");
                    yardOutput.setText("Μη έγκυρη τιμή");
                }
            });
            footButton.setOnAction(feetEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Πόδια");
                    meterOutput.setText(String.format("%.2f", (input * 0.304)) + " m");
                    yardOutput.setText(String.format("%.2f", (input * 0.333)) + " yds");
                    footOutput.setText(newValue + " ft");
                } catch (NumberFormatException e) {
                    meterOutput.setText("Μη έγκυρη τιμή");
                    footOutput.setText("Μη έγκυρη τιμή");
                    yardOutput.setText("Μη έγκυρη τιμή");
                }
            });
        });
    }
        {// converting volumes
        volumeInput.textProperty().addListener((observable, oldValue, newValue) -> {
            double input = Double.parseDouble(newValue);
            litreButton.setOnAction(litreEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Λίτρα");
                    litreOutput.setText(newValue + " L");
                    gallonOutput.setText(String.format("%.2f", (input * 0.2641)) + " gal");
                } catch (NumberFormatException e) {
                    litreOutput.setText("Μη έγκυρη τιμή");
                    gallonOutput.setText("Μη έγκυρη τιμή");
                }
            });
            gallonButton.setOnAction(gallonEvent -> {
                try {
                    tipOutput.setText("Επιλέξατε Γαλόνια");
                    litreOutput.setText(String.format("%.2f", (input * 3.785)) + " L");
                    gallonOutput.setText(newValue + " gal");
                } catch (NumberFormatException e) {
                    litreOutput.setText("Μη έγκυρη τιμή");
                    gallonOutput.setText("Μη έγκυρη τιμή");
                }
            });
        });
    }
        {// conversion from numeric types
        numericInput.textProperty().addListener((observable, oldValue, newValue) -> {
            binButton.setOnAction(binEvent -> {
                int binaryInput = Integer.parseInt(newValue);
                String binout = String.valueOf(binaryInput);
                String octout = String.valueOf(convertBinarytoOctal(binaryInput));
                int decout = convertBinarytoDecimal(binaryInput);
                String hexout = Integer.toHexString(decout);
                tipOutput.setText("Επιλέξατε Δυαδικό Σύστημα Αρίθμισης");
                // binary check
                if (binout.matches("[01]+")) {
                    try {
                        binOutput.setText(binout + " bin");
                        octOutput.setText(octout + " oct");
                        decOutput.setText(String.valueOf(decout) + " dec");
                        hexOutput.setText(hexout + " hex");
                    } catch (NumberFormatException e) {
                        binOutput.setText("Μη έγκυρη τιμή");
                        octOutput.setText("Μη έγκυρη τιμή");
                        decOutput.setText("Μη έγκυρη τιμή");
                        hexOutput.setText("Μη έγκυρη τιμή");
                    }
                } else {
                    binOutput.setText("Μη έγκυρη τιμή");
                    octOutput.setText("Μη έγκυρη τιμή");
                    decOutput.setText("Μη έγκυρη τιμή");
                    hexOutput.setText("Μη έγκυρη τιμή");
                }
            });
            decButton.setOnAction(decEvent -> {
                int input = Integer.parseInt(newValue);
                String binout = Integer.toBinaryString(input);
                String hexout = Integer.toHexString(input);
                String octout = Integer.toOctalString(input);
                try {
                    tipOutput.setText("Επιλέξατε Δεκαδικό Σύστημα Αρίθμισης");
                    binOutput.setText(binout + " bin");
                    octOutput.setText(octout + " oct");
                    decOutput.setText(newValue + " dec");
                    hexOutput.setText(hexout + " hex");
                } catch (NumberFormatException e) {
                    binOutput.setText("Μη έγκυρη τιμή");
                    octOutput.setText("Μη έγκυρη τιμή");
                    decOutput.setText("Μη έγκυρη τιμή");
                    hexOutput.setText("Μη έγκυρη τιμή");
                }

            });
            hexButton.setOnAction(hexEvent -> {
                int decout = Integer.parseInt(newValue, 16);
                String octout = Integer.toOctalString(decout);
                String binout = Integer.toBinaryString(decout);
                try {
                    tipOutput.setText("Επιλέξατε Δεκαεξαδικό Σύστημα Αρίθμισης");
                    binOutput.setText(binout + " bin");
                    octOutput.setText(octout + " oct");
                    decOutput.setText(decout + " dec");
                    hexOutput.setText(newValue + " hex");
                } catch (NumberFormatException e) {
                    binOutput.setText("Μη έγκυρη τιμή");
                    octOutput.setText("Μη έγκυρη τιμή");
                    decOutput.setText("Μη έγκυρη τιμή");
                    hexOutput.setText("Μη έγκυρη τιμή");
                }

            });

            octButton.setOnAction(octEvent -> {
                int decout = Integer.parseInt(newValue, 8);

                String binout = Integer.toBinaryString(decout);
                String hexout = Integer.toHexString(decout);
                try {
                    tipOutput.setText("Επιλέξατε Οκταδικό Σύστημα Αρίθμισης");
                    binOutput.setText(binout + " bin");
                    octOutput.setText(newValue + " oct");
                    decOutput.setText(decout + " dec");
                    hexOutput.setText(hexout + " hex");
                } catch (NumberFormatException e) {
                    binOutput.setText("Μη έγκυρη τιμή");
                    octOutput.setText("Μη έγκυρη τιμή");
                    decOutput.setText("Μη έγκυρη τιμή");
                    hexOutput.setText("Μη έγκυρη τιμή");
                }

            });

        });

    }
}

    private void clearAll() {
        clearButton.setOnAction(clearEvent -> {
            dollarOutput.setText("$");
            euroOutput.setText("€");
            yenOutput.setText("¥");
            poundOutput.setText("£");
            binOutput.setText("base2");
            decOutput.setText("base10");
            hexOutput.setText("base16");
            octOutput.setText("base8");
            kgOutput.setText("Kgs");
            lbOutput.setText("Lbs");
            yardOutput.setText("Yards");
            meterOutput.setText("Meters");
            footOutput.setText("Feet");
            tipOutput.setText("Πληκτρολογήστε το ποσό και στη συνέχεια πιέστε το κουμπί που αντιστοιχεί στο είδος του.");
            litreOutput.setText("Litres");
            gallonOutput.setText("Gallons");
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        conversionMethod();

        clearAll();
    }

}
