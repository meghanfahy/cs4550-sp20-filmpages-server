package com.example.cs4550sp20filmpagesserver.repositories;

import com.example.cs4550sp20filmpagesserver.models.Critic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CriticRepository extends CrudRepository<Critic, Integer> {
    @Query("SELECT critic FROM Critic critic")
    public List<Critic> findAllCritics();

    @Query("SELECT critic FROM Critic critic WHERE critic.id=:criticId")
    public Critic findCriticById(@Param("criticId") Integer topicId);

//  @Modifying
//  @Query("UPDATE Critic critic SET critic=:critic WHERE critic.id=:criticId")
//  public int updateCritic(@Param("critic") Critic critic, @Param("criticId") Integer criticId);
}
