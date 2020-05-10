package calculodeidade;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.control.MenuItem;

public class CalculoDeIdadeController implements Initializable {
    
    @FXML private Label label1, label2, label3, label4, label5, label6, label7, label8;
    @FXML private Label label9, label10, label11, label12, label13, label14, label15;
    @FXML private Label label16, label17, label18, label19, label20, label21, label22;
    @FXML private Button b1;
    @FXML private DatePicker datePicker;
    @FXML private Pane tela;
    @FXML private MenuItem menuItem;
    @FXML private Button clickedButton;
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws ParseException {
        
        LocalDate localDate1 = datePicker.getValue();
        Date dataInicial = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        long dataInicialMilli = dataInicial.getTime();
        
        LocalDate localDate2 = LocalDate.now();
        Date dataFinal = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        long dataFinalMilli = dataFinal.getTime();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicial);
        String diaDaSemana = "";
        switch(calendar.get(calendar.DAY_OF_WEEK)){
            case 1:
                diaDaSemana = "DOMINGO";
                break;
            case 2:
                diaDaSemana = "SEGUNDA-FEIRA";
                break;
            case 3:
                diaDaSemana = "TERÇA-FEIRA";
                break;
            case 4:
                diaDaSemana = "QUARTA-FEIRA";
                break;
            case 5:
                diaDaSemana = "QUINTA-FEIRA";
                break;
            case 6:
                diaDaSemana = "SEXTA-FEIRA";
                break;
            case 7:
                diaDaSemana = "SÁBADO";
                break;
        }
        long idadeEmSegundos = ((dataFinalMilli - dataInicialMilli) / 1000);
        label13.setText(Long.toString(idadeEmSegundos));
        long idadeEmMinutos = idadeEmSegundos / 60;
        label11.setText(Long.toString(idadeEmMinutos));
        long idadeEmHoras = idadeEmSegundos / 60 / 60;
        label9.setText(Long.toString(idadeEmHoras));
        long idadeEmDias = idadeEmSegundos / 60 / 60 / 24;
        label7.setText(Long.toString(idadeEmDias));
        Math.ceil(idadeEmDias);
        long idadeEmMeses = idadeEmDias / 30;
        label5.setText(Long.toString(idadeEmMeses));
        long idadeEmAnos = idadeEmDias / 365;
        label3.setText(Long.toString(idadeEmAnos));
        
        long anos = idadeEmDias / 365;
        label15.setText(Long.toString(anos));
        long resto = idadeEmDias % 365;
        long meses = resto / 30;
        label17.setText(Long.toString(meses));
        long dias = resto % 30;
        label19.setText(Long.toString(dias));
        
        label22.setText(diaDaSemana);
    }
    
    @FXML
    public void handleMenuAction(ActionEvent event) {
        MenuItem clickedMenu = (MenuItem) event.getTarget();
        String menuLabel = clickedMenu.getText();
        if("Limpar".equals(menuLabel)){
            label3.setText("");
            label5.setText("");
            label7.setText("");
            label9.setText("");
            label11.setText("");
            label13.setText("");
            label15.setText("");
            label17.setText("");
            label19.setText("");
            label22.setText("");
        }
        else if("Fechar".equals(menuLabel)){
            System.exit(0);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
