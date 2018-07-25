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

    @Override
    List<Vote> findAll();

//    @Query("SELECT v FROM Vote v WHERE v.date >= CURRENT_DATE AND v.restaurant.id=:id")
//    List<Vote> getAllForTodayByRestaurantId(Integer id);

    @Query("SELECT COUNT(v.id) FROM Vote v WHERE v.date>=CURRENT_DATE AND v.restaurant.id=:id")
    Integer getRatingForTodayByRestaurantId(@Param("id") Integer id);

    @Query("SELECT COUNT(v.id) FROM Vote v WHERE v.restaurant.id=:id")
    Integer getRatingOverallByRestaurantId(@Param("id") Integer id);

    @Query("SELECT COUNT(v.id) FROM Vote v WHERE v.user.id=:id AND v.date>=CURRENT_DATE")
    Integer getVotesCountForTodayByUserId(@Param("id") Integer id);
}
