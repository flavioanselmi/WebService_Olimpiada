package br.com.olimpiada.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.olimpiada.http.Competicao;
import br.com.olimpiada.repository.CompeticaoRepository;
import br.com.olimpiada.repository.entity.CompeticaoEntity;

/**
* Essa classe vai expor os métodos por http
*
* @Path - Caminho para a chamada da classe que vai representar o serviço
* */
@Path("/service")
public class ServiceController {

	private final  CompeticaoRepository repository = new CompeticaoRepository();

	/**
	 * @Consumes - determina o formato dos dados que vai postar
	 * @Produces - determina o formato dos dados que vai retornar
	 * 
	 * Método que cadastra uma nova competicao
	 * */
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Competicao competicao){
		
		CompeticaoEntity entity = new CompeticaoEntity();
				
		try {

			entity.setModalidade(competicao.getModalidade());
			entity.setLocal(competicao.getLocal());
			entity.setData_hora_inicio(competicao.getData_hora_inicio());
			entity.setData_hora_final(competicao.getData_hora_termino());
			entity.setCompetidor1(competicao.getCompetidor1());
			entity.setCompetidor2(competicao.getCompetidor2());
			entity.setEtapa(competicao.getEtapa());
						
			repository.Salvar(entity);
			
			return "Registro cadastrado com sucesso!";
			
		} catch (Exception e) {
			
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	
	}
	
	/**
	 * Método que altera uma competição já cadastrada
	 * **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String Alterar(Competicao competicao){
		
		CompeticaoEntity entity = new CompeticaoEntity();
		
		try {

			entity.setModalidade(competicao.getModalidade());
			entity.setLocal(competicao.getLocal());
			entity.setData_hora_inicio(competicao.getData_hora_inicio());
			entity.setData_hora_final(competicao.getData_hora_termino());
			entity.setCompetidor1(competicao.getCompetidor1());
			entity.setCompetidor2(competicao.getCompetidor2());
			entity.setEtapa(competicao.getEtapa());
			
			repository.Alterar(entity);
			
			return "Registro alterado com sucesso!";
			
		} catch (Exception e) {
			
			return "Erro ao alterar o registro " + e.getMessage();
			
		}

	}
	/**
	 * Método lista todas competições cadastradas na base
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consulta")
	public List<Competicao> TodasPessoas(){
		
		List<Competicao> competicao =  new ArrayList<Competicao>();
		
		List<CompeticaoEntity> listaEntityCompeticao = repository.Consulta();
		
		for (CompeticaoEntity entity : listaEntityCompeticao) {
			
			competicao.add(new Competicao( entity.getId(),
										   entity.getModalidade(), 
										   entity.getLocal(), 
										   entity.getData_hora_inicio(), 
										   entity.getData_hora_final(), 
										   entity.getCompetidor1(), 
										   entity.getCompetidor2(), 
										   entity.getEtapa() ));				
		}
		
		return competicao;
	}
	
	/**
	 * Método busca uma competição cadastrado pelo id
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getCompeticao/{id}")
	public Competicao GetCompeticao(@PathParam("id") Integer id){
		
		CompeticaoEntity entity = repository.GetCompeticao(id);
		
		if(entity != null)
			return new Competicao( entity.getId(),
					   entity.getModalidade(), 
					   entity.getLocal(), 
					   entity.getData_hora_inicio(), 
					   entity.getData_hora_final(), 
					   entity.getCompetidor1(), 
					   entity.getCompetidor2(), 
					   entity.getEtapa() );
		
		return null;
	}
	
	/**
	 * Excluindo uma competição pelo id
	 * */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")	
	public String Excluir(@PathParam("id") Integer id){
		
		try {
			
			repository.Excluir(id);
			
			return "Registro excluido com sucesso!";
			
		} catch (Exception e) {
		
			return "Erro ao excluir o registro! " + e.getMessage();
		}
		
	}
	
}
