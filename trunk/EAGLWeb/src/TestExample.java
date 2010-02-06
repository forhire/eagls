import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.eagl.hibernate.bean.Test;
import com.eagl.util.HibernateUtil;


public class TestExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Test forestTest = new Test();
	    
	    forestTest.setFirstName("Krishnan");
	    forestTest.setLastName("iYER");
	    forestTest.setEmailId("dipikam@gmail.com");
	    forestTest.setLoginId("dipikam");
	    forestTest.setPassword("dipikam");
	    createTest(forestTest);
	    forestTest.setFirstName("Dipika");
	    forestTest.setLastName("Mulchandani");
	    forestTest.setEmailId("dipikam@gmail.com");
	    forestTest.setLoginId("dipikam");
	    forestTest.setPassword("dipikam");
	    createTest(forestTest);
	    listTest();
	  }

	  private static void listTest() {
	    Transaction tx = null;
	    Session session = HibernateUtil.getInstance().getCurrentSession();
	    try {
	      tx = session.beginTransaction();
	      List Tests = session.createQuery("select h from Test as h")
	              .list();
	      for (Iterator iter = Tests.iterator(); iter.hasNext();) {
	        Test element = (Test) iter.next();
	       // logger.debug("{}", element);
	        System.out.println("{}" + element);
	      }
	      tx.commit();
	    } catch (RuntimeException e) {
	      if (tx != null && tx.isActive()) {
	        try {
	// Second try catch as the rollback could fail as well
	          tx.rollback();
	        } catch (HibernateException e1) {
	          //logger.debug("Error rolling back transaction");
	        }
	// throw again the first exception
	        throw e;
	      }


	    }
	  }

	  private static void deleteTest(Test Test) {
	    Transaction tx = null;
	    Session session = HibernateUtil.getInstance().getCurrentSession();
	    try {
	      tx = session.beginTransaction();
	      session.delete(Test);
	      tx.commit();
	    } catch (RuntimeException e) {
	      if (tx != null && tx.isActive()) {
	        try {
	// Second try catch as the rollback could fail as well
	          tx.rollback();
	        } catch (HibernateException e1) {
	          //logger.debug("Error rolling back transaction");
	        }
	// throw again the first exception
	        throw e;
	      }
	    }
	  }

	  private static void createTest(Test test) {
	    Transaction tx = null;
	    Session session = HibernateUtil.getCurrentSession();
	    try {
	      tx = session.beginTransaction();
	      session.save(test);
	      tx.commit();
	    } catch (RuntimeException e) {
	      if (tx != null && tx.isActive()) {
	        try {
	// Second try catch as the rollback could fail as well
	          tx.rollback();
	        } catch (HibernateException e1) {
	         // logger.debug("Error rolling back transaction");
	        }
	// throw again the first exception
	        throw e;
	      }
	    }
	  }

	   private static void updateTest(Test Test) {
	    Transaction tx = null;
	    Session session = HibernateUtil.getInstance().getCurrentSession();
	    try {
	      tx = session.beginTransaction();
	      session.update(Test);
	      tx.commit();
	    } catch (RuntimeException e) {
	      if (tx != null && tx.isActive()) {
	        try {
	// Second try catch as the rollback could fail as well
	          tx.rollback();
	        } catch (HibernateException e1) {
	          //logger.debug("Error rolling back transaction");
	        }
	// throw again the first exception
	        throw e;
	      }
	    }
	   }
	   
	  }
	    

