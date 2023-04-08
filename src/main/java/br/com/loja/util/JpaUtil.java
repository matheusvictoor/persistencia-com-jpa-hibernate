package br.com.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    // Preciso passar o nome do <persistence-unit name="loja"...> que tá lá mo arquivo persistence.xml
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("dbloja");


    // Para fazer qualquer operação (deletar, salvar...) no bd precisará desse método
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }

}
