package hu.furediblog.dao.db;

import org.hibernate.Session;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hu.furediblog.dao.entity.Authors;
//import hu.furediblog.dao.entity.Entry;
import hu.furediblog.dao.entity.Entries;

import java.util.Properties;

public class DatabaseSessionProvider {

    private static DatabaseSessionProvider instance = null;

    private static Session sessionObj;

    private DatabaseSessionProvider() {
        configDatabase();
    }

    public static DatabaseSessionProvider getInstance() {
        if (instance == null) {
            instance = new DatabaseSessionProvider();
        }
        return instance;
    }

    public Session getSessionObj() {
        return sessionObj;
    }

    private void configDatabase() {
        Configuration configObj = new Configuration();
        
        configObj.addAnnotatedClass(Authors.class);
        configObj.addAnnotatedClass(Entries.class);
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/furedi_blog");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "");
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(properties).build();
        sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
    }
}