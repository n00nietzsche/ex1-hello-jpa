package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        // 간단하게 entityManager는 DB 커넥션 1개를 받았다고 생각하면 쉽다.
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 실제 코드가 들어가는 부분
        try {
            Movie myMovie = new Movie();
            myMovie.setPrice(10000);
            myMovie.setName("바람");
            myMovie.setActor("배우");
            myMovie.setDirector("감독");
            entityManager.persist(myMovie);

            Movie movie = entityManager.find(Movie.class, 1L);
            System.out.println("movie = " + movie);

            transaction.commit();
        }
        catch(Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}
