package br.edu.faculdadedelta.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.BensDao;
import br.edu.faculdadedelta.modelo.BensWilliam;

@ManagedBean
@SessionScoped
public class BensControllerWilliam {
	
	private BensDao dao = new BensDao();
	private BensWilliam bens = new BensWilliam();
	
	public BensWilliam getBens() {
		return bens;
	}
	public void setBens(BensWilliam bens) {
		this.bens = bens;
	}

	public void limparCampos() {
		bens = new BensWilliam();
	}
	
	
	private void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String salvar() {
		try {	
			Calendar c = Calendar.getInstance();
			c.set(2000, Calendar.JANUARY, 1);
			Date dataLimite = c.getTime();
			
			if (bens.getData_aquisicao_bem().after(dataLimite) && bens.getData_aquisicao_bem().before(new Date())) {

				if (bens.getId_bem() == null) {
					// incluir
					dao.incluir(bens);
					FacesMessage mensagem = new FacesMessage("Inclusão realizada com sucesso!");
					FacesContext.getCurrentInstance().addMessage(null, mensagem);
					limparCampos();
				} else {
					// alterar
					dao.alterar(bens);
					FacesMessage mensagem = new FacesMessage("Alteração realizada com sucesso!");
					FacesContext.getCurrentInstance().addMessage(null, mensagem);
					limparCampos();
				}
			} else  {
				DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);

				exibirMensagem("A data de atuação deve ser maior que "+f.format(dataLimite)+" e menor que "+f.format(new Date())+"!");
			}
			

		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "cadastro.xhtml";
	}
	
	public List<BensWilliam> getLista() {
		List<BensWilliam> listaRetorno = new ArrayList<BensWilliam>();
		try {
			listaRetorno = dao.listar();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public String editar() {
		return "cadastro.xhtml";
	}

	
	public String excluir() {
		try {
			dao.excluir(bens);
			FacesMessage mensagem = new FacesMessage("Exclusão realizada com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			limparCampos();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "lista.xhtml";
	}

}
