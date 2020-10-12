package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;


@RunWith(SpringRunner.class)
@DataJpaTest

//o spring por padrão usa um banco de dados em memória para fazer os testes
//essa anotacao é necessaria para usar o banco de dados configurado no application.properties
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

//é uma boa pratica usar um banco de dados dedicado somente para teste
//essa anotacao é para forçar o uso de um profile de teste
@ActiveProfiles("test")
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		
		
		
		String nomeCurso = "HTML 5";
		
		/*
		 * neste caso, o teste está sendo feito em um banco de dados vazio,
		 * para tal, é preciso fazer antes do teste a povoação do banco
		 * em uma classe de teste o ideal é colocar isso como configuração global usando @Before
		 */
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		em.persist(html5);
		
		Curso curso = repository.findByNome(nomeCurso);
		
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		
		String nomeCurso = "JPA";
		Curso curso = repository.findByNome(nomeCurso);
		
		Assert.assertNull(curso);
	}
}
