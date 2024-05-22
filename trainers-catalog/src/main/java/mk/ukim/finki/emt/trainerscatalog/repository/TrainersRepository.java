package mk.ukim.finki.emt.trainerscatalog.repository;

import mk.ukim.finki.emt.trainerscatalog.domain.models.Trainers;
import mk.ukim.finki.emt.trainerscatalog.domain.models.TrainersId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainersRepository extends JpaRepository<Trainers, TrainersId> {
}
