import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GenerationDoc {

	Configuration config = new Configuration();
	
	//première méthode
	SessionFactory sessionFactory = config.buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	//deuxième méthode
	SessionFactory sessonFactory = new Configuration().configure().buildSessionFactory();
}
