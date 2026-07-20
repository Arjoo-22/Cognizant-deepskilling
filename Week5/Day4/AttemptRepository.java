
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ormlearn.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("""
        SELECT a
        FROM Attempt a
        JOIN FETCH a.user
        JOIN FETCH a.attemptQuestions aq
        JOIN FETCH aq.question q
        JOIN FETCH aq.attemptOptions ao
        JOIN FETCH ao.option
        WHERE a.user.id = :userId
        AND a.id = :attemptId
        """)
    Attempt getAttempt(@Param("userId") int userId,
                       @Param("attemptId") int attemptId);
}