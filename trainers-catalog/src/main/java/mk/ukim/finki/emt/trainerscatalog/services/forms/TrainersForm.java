package mk.ukim.finki.emt.trainerscatalog.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.trainerscatalog.domain.valueObjects.Size;
import mk.ukim.finki.emt.trainerscatalog.domain.valueObjects.Stock;

@Data
public class TrainersForm {

    private String trainersName;

    private Stock trainersStock;

    private String trainersColor;

    private Size trainersSize;

    private Money trainersPrice;
}
