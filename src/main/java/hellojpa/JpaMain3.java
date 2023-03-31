package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain3 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
           //Member findMember = em.find(Member.class, 1L);
           List<Member> result = em.createQuery("select m from Member as m where m.name = :name", Member.class)
                   .setParameter("name", "HelloJPA")
                   .getResultList();

           for(Member member : result){
               System.out.println("member.name = " + member.getName());
           }

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
