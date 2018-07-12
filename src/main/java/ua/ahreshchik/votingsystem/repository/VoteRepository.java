package ua.ahreshchik.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ahreshchik.votingsystem.model.Vote;
import ua.ahreshchik.votingsystem.util.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {


    @Override
    @Transactional
    Vote save(Vote vote);

    @Override
    Optional<Vote> findById(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    void delete(@Param("id") int id) throws NotFoundException;

    //get with restaurant?
    //get by date?

    @Override
    List<Vote> findAll();

    List<Vote> getAllByRestaurantId(Integer id);


}
