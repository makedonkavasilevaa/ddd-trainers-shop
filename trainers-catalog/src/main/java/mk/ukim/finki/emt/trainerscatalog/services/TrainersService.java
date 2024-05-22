package mk.ukim.finki.emt.trainerscatalog.services;

import mk.ukim.finki.emt.trainerscatalog.domain.models.Trainers;
import mk.ukim.finki.emt.trainerscatalog.domain.models.TrainersId;
import mk.ukim.finki.emt.trainerscatalog.services.forms.TrainersForm;

import java.util.List;

public interface TrainersService {

    Trainers findById(TrainersId id);
    Trainers createProduct(TrainersForm form);
    List<Trainers> getAll();
}
