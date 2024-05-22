package mk.ukim.finki.emt.trainerscatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.trainerscatalog.domain.valueObjects.Size;
import mk.ukim.finki.emt.trainerscatalog.domain.valueObjects.Stock;

@Entity
@Table(name = "trainers")
public class Trainers extends AbstractEntity<TrainersId> {

    private String trainersName;

    private Stock trainersStock;

    private String trainersColor;

    private Size trainersSize;

    private Money trainersPrice;

    private Trainers() {
        super(TrainersId.randomId(TrainersId.class));
    }


    public static Trainers build(String trainersName, Stock trainersStock, String trainersColor, Size trainersSize, Money trainersPrice) {
        Trainers trainers = new Trainers();
        trainers.trainersName = trainersName;
        trainers.trainersColor = trainersColor;
        trainers.trainersPrice = trainersPrice;
        trainers.trainersStock = trainersStock;
        trainers.trainersSize = trainersSize;
        return trainers;
    }

}
