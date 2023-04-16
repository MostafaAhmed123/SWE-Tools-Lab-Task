package service;
import javax.persistence.*;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import java.util.List;
import model.Calculation;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class Service{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculation");
	EntityManager em = emf.createEntityManager();  
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("calc")
	public double calc(Calculation calculation) {
		double res = 0;
		if(calculation.getOperation().equals("+"))
			res = calculation.getNumber1() + calculation.getNumber2();
		else if(calculation.getOperation().equals("-"))
			res = calculation.getNumber1() - calculation.getNumber2();
		else if(calculation.getOperation().equals("*"))
			res = calculation.getNumber1() * calculation.getNumber2();
		else if(calculation.getOperation().equals("/")) {
			if (calculation.getNumber2() == 0)
                throw new IllegalArgumentException("Cannot divide by zero");
			res = calculation.getNumber1() / calculation.getNumber2();
			}
		calculation.setResult(res);
		em.persist(calculation);
		return res;
	}
	
	
    @GET
    @Path("calculations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calculation> getCalculation() {
		return em.createQuery("select c from Calculation c", Calculation.class).getResultList();
    }
}