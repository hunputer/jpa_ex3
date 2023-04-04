package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JapMain9 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //영속성 컨텍스트 값변경
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setId(1L);
            member.setUsername("member1");
            member.setTeam(team);
            member.setUsername("jihun");
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

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
