package com.example.cs4550sp20filmpagesserver.services;
import com.example.cs4550sp20filmpagesserver.models.Critic;
import com.example.cs4550sp20filmpagesserver.repositories.CriticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CriticService {

  @Autowired
  CriticRepository criticRepo;

  public List<Critic> findAllCritics() {
    return criticRepo.findAllCritics();
  }

  public Critic createCritic(Critic critic) {
    return criticRepo.save(critic);
  }

  public int deleteCritic(Integer criticId) {
    criticRepo.deleteById(criticId);
    return 1;
  }

  public int updateCritic(Integer criticId, Critic updatedCritic) {
    if (criticRepo.existsById(criticId)) {
      updatedCritic.fillBlanks(criticRepo.findCriticById(criticId));
      updatedCritic.setId(criticId);
      criticRepo.save(updatedCritic);
      return 1;
    } else {
      return 0;
    }
//    criticRepo.updateCritic(updatedCritic, criticId);
//    return 1;
  }

  public Critic findCriticById(Integer criticId) {
    return criticRepo.findCriticById(criticId);
  }

}
