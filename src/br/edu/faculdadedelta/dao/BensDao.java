package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.modelo.BensWilliam;
import br.edu.faculdadedelta.util.Conexao;

public class BensDao {
	public void incluir(BensWilliam bens) throws SQLException, ClassNotFoundException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "INSERT INTO bens (desc_bem, codigo_bem, classificacao_bem, valor_bem, data_aquisicao_bem) "
				+ " VALUES (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bens.getDesc_bem());
		ps.setString(2, bens.getCodigo_bem());
		ps.setString(3, bens.getClassificacao_bem());
		ps.setDouble(4, bens.getValor_bem());
		ps.setDate(5, new java.sql.Date(bens.getData_aquisicao_bem().getTime()));		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void alterar(BensWilliam bens) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "UPDATE bens SET "
				+ " desc_bem = ?, "
				+ " codigo_bem = ?, "
				+ " classificacao_bem  = ?, "
				+ " valor_bem  = ? ,"
				+ " data_aquisicao_bem  = ? "
				+ " WHERE id_bem = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bens.getDesc_bem());
		ps.setString(2, bens.getCodigo_bem());
		ps.setString(3, bens.getClassificacao_bem());
		ps.setDouble(4, bens.getValor_bem());
		ps.setDate(5, new java.sql.Date(bens.getData_aquisicao_bem().getTime()));
		ps.setDouble(6, bens.getId_bem());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}

	public List<BensWilliam> listar() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "SELECT id_bem, desc_bem, codigo_bem, "
				+ " classificacao_bem , valor_bem,data_aquisicao_bem  FROM bens";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<BensWilliam> listaRetorno = new ArrayList<BensWilliam>();
 		
		while (rs.next()) {
			BensWilliam bens = new BensWilliam();
			bens.setId_bem(rs.getLong("id_bem"));
			bens.setDesc_bem(rs.getString("desc_bem").trim());
			bens.setCodigo_bem(rs.getString("codigo_bem"));
			bens.setClassificacao_bem(rs.getString("classificacao_bem"));
			bens.setValor_bem(rs.getDouble("valor_bem"));
			bens.setData_aquisicao_bem(rs.getDate("data_aquisicao_bem"));
			listaRetorno.add(bens);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return listaRetorno;
	}

	
	public void excluir(BensWilliam bens) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "DELETE FROM bens WHERE id_bem = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, bens.getId_bem());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
}
// setId_bem
// setDesc_bem
// setCodigo_bem
// setClassificacao_bem
// setValor_bem
// setData_aquisicao_bem