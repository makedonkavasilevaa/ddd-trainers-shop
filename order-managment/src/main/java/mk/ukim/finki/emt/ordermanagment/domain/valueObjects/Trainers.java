package mk.ukim.finki.emt.ordermanagment.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Trainers implements ValueObject {
    private final TrainersId trainersId;
    private final String trainersName;
    private final Money trainersPrice;

    @JsonCreator
    public Trainers(TrainersId trainersId, String trainersName, Money trainersPrice) {
        this.trainersId = trainersId;
        this.trainersName = trainersName;
        this.trainersPrice = trainersPrice;
    }

    public Trainers() {
        this.trainersId=TrainersId.randomId(TrainersId.class);
        this.trainersName = "";
        this.trainersPrice = Money.valueOf(Currency.DEN,0);
    }
}
