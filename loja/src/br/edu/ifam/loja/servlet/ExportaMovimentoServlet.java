package br.edu.ifam.loja.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.edu.ifam.loja.dao.MovimentoDAO;
import br.edu.ifam.loja.model.Movimento;
import br.edu.ifam.loja.model.Movimentos;

@WebServlet(loadOnStartup = 1, urlPatterns = "/exporta/movimentos.xml")
public class ExportaMovimentoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private MovimentoDAO dao;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			JAXBContext context = JAXBContext.newInstance(Movimentos.class);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			List<Movimento> movimentos = dao.lista();

			marshaller.marshal(new Movimentos(movimentos),
					response.getOutputStream());
			response.setContentType("application/xml");

		} catch (JAXBException e) {

			response.sendError(500);
			e.printStackTrace();
		}
	}

}
