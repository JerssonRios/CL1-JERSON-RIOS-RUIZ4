package domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Buscar {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Long empleadoId = 1L; // Reemplaza 1L con el ID del empleado que deseas buscar

        TypedQuery<Empleado> query = manager.createQuery("SELECT e FROM Empleado e WHERE e.id = :id", Empleado.class);
        query.setParameter("id", empleadoId);

        Empleado empleadoEncontrado = query.getSingleResult();

        tx.commit();

        if (empleadoEncontrado != null) {
            System.out.println("Empleado encontrado: " + empleadoEncontrado);
        } else {
            System.out.println("Empleado no encontrado.");
        }

        factory.close();
		

	}

}
