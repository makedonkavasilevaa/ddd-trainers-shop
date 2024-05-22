package mk.ukim.finki.emt.trainerscatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.trainerscatalog.domain.TrainersNotFoundException;
import mk.ukim.finki.emt.trainerscatalog.domain.exceptions.TrainersIdNotFoundException;
import mk.ukim.finki.emt.trainerscatalog.domain.models.Trainers;
import mk.ukim.finki.emt.trainerscatalog.domain.models.TrainersId;
import mk.ukim.finki.emt.trainerscatalog.repository.TrainersRepository;
import mk.ukim.finki.emt.trainerscatalog.services.TrainersService;
import mk.ukim.finki.emt.trainerscatalog.services.forms.TrainersForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@AllArgsConstructor
public class TrainersServiceImpl implements TrainersService {

    private final TrainersRepository trainersRepository;

    @Override
    public Trainers findById(TrainersId id) {
        return trainersRepository.findById(id).orElseThrow(TrainersNotFoundException::new);
    }

    @Override
    public Trainers createProduct(TrainersForm form) {
        Trainers t = Trainers.build(form.getTrainersName(),form.getTrainersStock(), form.getTrainersColor(), form.getTrainersSize(), form.getTrainersPrice());
        trainersRepository.save(t);
        return t;
    }

    @Override
    public List<Trainers> getAll() {
        return trainersRepository.findAll();
    }
}
