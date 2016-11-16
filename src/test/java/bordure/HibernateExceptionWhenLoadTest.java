package bordure;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4002.atm.application.jpa.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.atm.domain.accounts.Account;
import ca.ulaval.glo4002.atm.domain.accounts.StandardAccount;
import ca.ulaval.glo4002.atm.infrastructure.persistence.HibernateAccountRepository;



public class HibernateExceptionWhenLoadTest {
    
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private HibernateAccountRepository hibernateAccountRepository;
    private final static int NUMBER_ACCOUNT = 2;
    private final static double BALANCE_ACCOUNT = 123.456;
    
    @Before
    public void initHibernate(){
        entityManagerFactory = EntityManagerFactoryProvider.getFactory();
        entityManager = entityManagerFactory.createEntityManager();
        hibernateAccountRepository = new HibernateAccountRepository();
    }

    @Test
    public void CreateEntityManagerFactory() {
        EntityManagerFactory entityManagerFactory = EntityManagerFactoryProvider.getFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        assertNotNull(entityManager);
    }
    
    @Test
    public void CreateHibernateAccountRepository(){
        HibernateAccountRepository hibernateAccountRepository = new HibernateAccountRepository();
        assertNotNull(hibernateAccountRepository);
    }
    
    @Test
    public void Call_persist_method(){
        Account account = new StandardAccount(NUMBER_ACCOUNT,BALANCE_ACCOUNT);
        entityManager.persist(account);
    }

}
