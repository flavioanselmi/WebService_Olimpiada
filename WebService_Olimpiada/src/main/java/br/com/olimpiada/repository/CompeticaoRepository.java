package br.com.olimpiada.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.olimpiada.repository.entity.CompeticaoEntity;


public class CompeticaoRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	public CompeticaoRepository(){
		
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_competicao");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void Salvar(CompeticaoEntity competicaoEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(competicaoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(CompeticaoEntity competicaoEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(competicaoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**
	 * RETORNA TODAS AS COMPETIÇÕES CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<CompeticaoEntity> Consulta(){
		
		return this.entityManager.createQuery("SELECT p FROM CompeticaoEntity p ORDER BY p.Data_Hora_Inicio").getResultList();
	}
	
	/**
	 * CONSULTA UMA COMPETIÇÃO CADASTRA PELO ID
	 * */
	public CompeticaoEntity GetCompeticao(Integer id){
		
		return this.entityManager.find(CompeticaoEntity.class, id);
	}
	
	/**
	 * EXCLUINDO UM REGISTRO PELO ID
	**/
	public void Excluir(Integer id){
		
		CompeticaoEntity competicao = this.GetCompeticao(id);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(competicao);
		this.entityManager.getTransaction().commit();
		
	}
}
