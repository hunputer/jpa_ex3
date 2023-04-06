package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain11 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Locker locker = new Locker();
            locker.setName("jihun_locker");
            em.persist(locker);

            //영속성 컨텍스트 값변경
            Member member = new Member();
            member.setId(1L);
            member.setUsername("member1");
            member.setUsername("jihun");
            member.setLocker(locker);
            em.persist(member);

            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
