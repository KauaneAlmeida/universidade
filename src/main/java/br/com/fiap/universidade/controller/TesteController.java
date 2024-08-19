package br.com.fiap.universidade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.universidade.model.Discente;
import br.com.fiap.universidade.model.OpcoesNivel;
import br.com.fiap.universidade.model.OpcoesPaises;
import br.com.fiap.universidade.model.OpcoesStatus;
import br.com.fiap.universidade.model.Pessoa;
import br.com.fiap.universidade.repository.DiscenteRepository;
import br.com.fiap.universidade.repository.PessoaRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class TesteController {

	@Autowired
	private DiscenteRepository rep;

	@Autowired
	private PessoaRepository repP;

	@GetMapping("/teste")
	public String retornarPagina() {
		return "pagina";
	}

	@GetMapping("/transfinfo1")
	public String transfInfo(HttpServletRequest req) {
		req.setAttribute("var", "World");
		return "pagina";
	}

	@GetMapping("/transfinfo2")
	public String transfInfo2(Model model) {
		model.addAttribute("var", "Brazil");
		return "pagina";
	}

	@GetMapping("/transfinfo3")
	public ModelAndView transfInfo3() {

		Pessoa p1 = new Pessoa(1L, "Fulano", "111.222.333-45", OpcoesPaises.BRASIL, 19);
		Discente d1 = new Discente(1L, "RM1234", p1, OpcoesStatus.ATIVO, OpcoesNivel.GRADUACAO);

		ModelAndView mv = new ModelAndView("pagina");
		mv.addObject("var", d1);

		return mv;

	}

	@GetMapping("/index1")
	public ModelAndView transfIndex() {

		/*
		 * Pessoa p1 = new Pessoa(1L, "Fulano", "111.222.333-45", OpcoesPaises.BRASIL,
		 * 19); Pessoa p2 = new Pessoa(2L, "Beltrano", "111.222.333-45",
		 * OpcoesPaises.BRASIL, 19); Pessoa p3 = new Pessoa(3L, "Joao",
		 * "111.222.333-45", OpcoesPaises.BRASIL, 19); Discente d1 = new Discente(1L,
		 * "RM1234", p1, OpcoesStatus.ATIVO, OpcoesNivel.GRADUACAO); Discente d2 = new
		 * Discente(2L, "RM4567", p2, OpcoesStatus.ATIVO, OpcoesNivel.GRADUACAO);
		 * Discente d3 = new Discente(3L, "RM8910", p3, OpcoesStatus.ATIVO,
		 * OpcoesNivel.GRADUACAO);
		 * 
		 * List<Discente> lista = new ArrayList<Discente>(); lista.add(d1);
		 * lista.add(d2); lista.add(d3);
		 */

		List<Discente> lista = rep.findAll();

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("var", lista);
		return mv;

	}

	@GetMapping("/nova_pessoa")
	public String novaPessoa() {
		return "nova_pessoa";
	}
	
	@GetMapping("/msg_erro_cad_pessoa")
	public String retornaMsgErroCadPessoa() {
		return "erro_cadastro_pessoa";
	}

	@PostMapping("/insere_pessoa")
	public String inserePessoa(@Valid Pessoa pessoa, BindingResult bd) {

		if (bd.hasErrors()) {
			System.out.println("Tem erros");
			return "redirect:/msg_erro_cad_pessoa";

		} else {
			Pessoa pes = new Pessoa();
			pes.setCpf(pessoa.getCpf());
			pes.setIdade(pessoa.getIdade());
			pes.setNome(pessoa.getNome());
			pes.setPais_origem(pessoa.getPais_origem());

			repP.save(pes);

			Discente dis = new Discente();
			dis.setNivel(OpcoesNivel.MBA);
			dis.setRm("RM4321");
			dis.setStatus(OpcoesStatus.FORMADO);
			dis.setPessoa(pes);

			rep.save(dis);

			return "redirect:/index1";

		}

	}

}
